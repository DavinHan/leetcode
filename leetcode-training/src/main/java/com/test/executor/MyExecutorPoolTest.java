package com.test.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池测试类
 *
 * @author yanhanf
 */
public class MyExecutorPoolTest {

    public static void main(String[] args) {
        int len = 199999999;
        int[] arr = new int[len];
        for(int i = 0;i < len;i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }

        singleThreadSum(arr);

//        try {
//            multiThreadSum(arr);
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            forkJoinPoolSum(arr);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void singleThreadSum(int[] arr) {
        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i : arr) {
            sum += (i / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
        }
        long end = System.currentTimeMillis();
        System.out.println("single Thread count sum is " + sum + ", and elapse is:" + (end - start));
    }

    static void multiThreadSum(int[] arr) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        int count = 8;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        List<Future<Long>> list = new ArrayList<>();
        for(int i = 0;i < count;i++) {
            int finalI = i;
            Future<Long> submit = executorService.submit(() -> {
                long sum = 0;
                for (int k = arr.length / count * finalI; k < (arr.length / count * (finalI + 1)); k++) {
                    sum += (arr[k] / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3);
                }
                return sum;
            });
            list.add(submit);
        }

        long sum = 0L;
        for (Future<Long> future : list) {
            sum += future.get();
        }
        executorService.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("multi Thread count sum is " + sum + ", and elapse is:" + (end - start));
    }

    static void forkJoinPoolSum(int[] arr) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors() * 5);
        long start = System.currentTimeMillis();
        AtomicLong ss = new AtomicLong(0L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(() -> {
            Arrays.stream(arr).parallel().forEach(i -> ss.set(ss.get() + (i / 3 * 3 / 3 * 3 / 3 * 3 / 3 * 3)));
            return ss.get();
        });
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        forkJoinPool.shutdown();
        System.out.println("fork join pool count sum is " + sum + ", and elapse is:" + (end - start));
    }
}
