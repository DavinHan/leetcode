//package com.test.listener;
//
//import com.sun.nio.file.SensitivityWatchEventModifier;
//
//import java.io.IOException;
//import java.nio.file.*;
//
//public class WatchFileService {
//
//    public void watch(String watchDir) {
//        Path path = Paths.get(watchDir);
//        // 创建WatchService，它是对操作系统的文件监视器的封装，相对之前，不需要遍历文件目录，效率要高很多
//        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
//            // 注册指定目录使用的监听器，监视目录下文件的变化；
//            // PS：Path必须是目录，不能是文件；
//            // StandardWatchEventKinds.ENTRY_MODIFY，表示监视文件的修改事件
//            path.register(watchService, new WatchEvent.Kind[] {StandardWatchEventKinds.ENTRY_MODIFY}, SensitivityWatchEventModifier.HIGH);
//
//            while (true) {
//                // 获取目录的变化:
//                // take()是一个阻塞方法，会等待监视器发出的信号才返回。
//                // 还可以使用watcher.poll()方法，非阻塞方法，会立即返回当时监视器中是否有信号。
//                // 返回结果WatchKey，是一个单例对象，与前面的register方法返回的实例是同一个；
//                WatchKey register = watchService.poll();
//                // 处理文件变化事件：
//                // key.pollEvents()用于获取文件变化事件，只能获取一次，不能重复获取，类似队列的形式
//                for (WatchEvent<?> event : register.pollEvents()) {
//                    if (event.kind().equals(StandardWatchEventKinds.OVERFLOW)) {
//                        continue;
//                    }
//                    String fileName = (String) event.context();
//                    System.out.println(fileName + "文件发生变化");
//                }
//                if (!register.reset()) {
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
