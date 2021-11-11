package com.blockQueue;

/**
 * @author yanhanf
 * @ClassName MyQueue
 * @Description TODO
 * @Date 2021/11/8
 */
public interface MyQueue {

    boolean offer(Object obj) throws InterruptedException;

    Object poll() throws InterruptedException;
}
