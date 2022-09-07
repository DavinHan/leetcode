package org.example.string;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * String中的indexOf和正则表达式匹配进行JMH测试
 *
 * @author yanhanf
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class JmhIndexOfAndRegular {

    /**
     * indexOf匹配
     */
    @Benchmark
    public void indexOf() {

    }

    /**
     * 正则匹配
     */
    @Benchmark
    public void regular() {

    }
}
