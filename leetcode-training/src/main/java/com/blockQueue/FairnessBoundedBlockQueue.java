package com.blockQueue;

/**
 * @author yanhanf
 * @ClassName FairnessBoundedBlockQueue
 * @Description TODO
 * @Date 2021/11/8
 */
public class FairnessBoundedBlockQueue implements MyQueue{
    /**
     * 当前大小
     */
    protected int size;
    /**
     * 容量
     */
    protected final int capacity;
    protected Node head;
    protected Node tail;

    FairnessBoundedBlockQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(null, null);
        tail = head;
    }

    @Override
    public synchronized boolean offer(Object obj) throws InterruptedException {
        // 通过自旋的方式，实现阻塞队列
        while(size >= capacity) {
            this.wait();
        }
        Node node = new Node(obj, null);
        tail.next = node;
        size++;
        tail = node;

        // 通知自旋线程处理
        this.notifyAll();

        return true;
    }

    @Override
    public synchronized Object poll() throws InterruptedException {
        // 通过自旋，实现阻塞队列，等待其他线程增加数量
        while(head.next == null) {
            this.wait();
        }
        Object result = head.next.val;
        head.next = head.next.next;
        size--;

        // 通过自旋线程处理
        this.notifyAll();

        return result;
    }

    class Node {
        Object val;
        Node next;
        Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
