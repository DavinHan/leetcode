package org.example;

import org.example.string.JmhIndexOfAndRegular;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 测试入口
 * 测试方法：
 *    1. mvn:repackage;
 *    2. java -jar target/jmh-demo-1.0-SNAPSHOT.jar -rf json
 * 生成chart网站：http://deepoove.com/jmh-visual-chart/
 * @author yanhanf
 */
public class JmhMain {

    public static void main(String[] args) throws Exception {
        // 基准测试 测试 StringBuilder的append 和 string直接相加的区别
        /*Options opt = new OptionsBuilder()
                .include(JmhAppenderAndAdd.class.getSimpleName())
                .build();*/

        Options opt = new OptionsBuilder()
//                .include(JmhZipAndUnzip.class.getSimpleName())
//                .include(DeflaterAndInflater.class.getSimpleName())
                .include(JmhIndexOfAndRegular.class.getSimpleName())
                .build();
//        JmhZipAndUnzip jzau = new JmhZipAndUnzip();
//        jzau.zipByGZIPOutputStream();
////
//
//
//
//
//
        new Runner(opt).run();

//        JmhZipAndUnzip jmhZipAndUnzip = new JmhZipAndUnzip();
//        jmhZipAndUnzip.zipFun1();
//        jmhZipAndUnzip.unzipFun1();
    }
}
