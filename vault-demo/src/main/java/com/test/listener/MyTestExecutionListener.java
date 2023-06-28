package com.test.listener;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;

import java.util.concurrent.atomic.AtomicInteger;

public class MyTestExecutionListener implements TestExecutionListener {
    private final AtomicInteger startedPlan = new AtomicInteger(0);
    private final AtomicInteger finishedPlan = new AtomicInteger(0);
    private final AtomicInteger startedExecution = new AtomicInteger(0);
    private final AtomicInteger finishedExecution = new AtomicInteger(0);
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        System.out.println("startedPlan:" + startedPlan.getAndIncrement());
        TestExecutionListener.super.testPlanExecutionStarted(testPlan);
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        System.out.println("finishedPlan:" + finishedPlan.getAndIncrement());
        TestExecutionListener.super.testPlanExecutionFinished(testPlan);
    }

    @Override
    public void executionStarted(TestIdentifier testIdentifier) {
        System.out.println("startedExecution:" + startedExecution.getAndIncrement());
        TestExecutionListener.super.executionStarted(testIdentifier);
    }

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        System.out.println("finishedExecution:" + finishedExecution.getAndIncrement());
        TestExecutionListener.super.executionFinished(testIdentifier, testExecutionResult);
    }
}
