package com.blockQueue;

/**
 * @author yanhanf
 * @ClassName MyQueueImpl
 * @Description 队列，FIFO
 * @Date 2021/11/8
 */
public class MyQueueImpl implements MyQueue{

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

    MyQueueImpl(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(null, null);
        tail = head;
    }

    @Override
    public boolean offer(Object obj) {
        if(size < capacity) {
            Node node = new Node(obj, null);
            tail.next = node;
            size++;
            tail = node;
            return true;
        }
        return false;
    }

    @Override
    public Object poll() {
        if(size > 0 || head.next != null) {
            Object result = head.next.val;
            head.next = head.next.next;
            size--;
            return result;
        }
        return null;
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
