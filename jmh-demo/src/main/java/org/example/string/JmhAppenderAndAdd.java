package org.example.string;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * 基准测试 - StringBuilder下的append 和 String的+ 对比
 *
 * @author yanhanf
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class JmhAppenderAndAdd {

    String str = "";
    StringBuilder sb = new StringBuilder();

//    @Benchmark
    public String add(){
        for (int i = 0; i < 1000; i++) {
            str += i;
        }
        return str;
    }

//    @Benchmark
    public String appender() {
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
