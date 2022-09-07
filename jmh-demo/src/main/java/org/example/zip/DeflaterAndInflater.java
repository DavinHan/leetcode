package org.example.zip;

import org.example.utils.FileIOUtil;
import org.openjdk.jmh.annotations.*;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class DeflaterAndInflater {
    private static String str1 = "";
    private static String str2 = "";
    private static String str3 = "";
    private static String str4 = "";
    private static String str5 = "";

    private static byte[] byte1;
    private static byte[] byte2;
    private static byte[] byte3;
    private static byte[] byte4;
    private static byte[] byte5;



    static {
        String fileName1 = "yms_config.json";
        String fileName2 = "antisamy-esapi.xml";
        String fileName3 = "extend.min.js";
        String fileName4 = "logback-spring.xml";
        String fileName5 = "Version.php";

//        String zipFileName1 = "yms_config_zipData.txt";
//        String zipFileName2 = "antisamy-esapi_zipData.txt";
//        String zipFileName3 = "extend.min_zipData.txt";
//        String zipFileName4 = "logback-spring_zipData.txt";
//        String zipFileName5 = "Version_zipData.txt";
        try {
            str1 = FileIOUtil.read(fileName1);
            str2 = FileIOUtil.read(fileName2);
            str3 = FileIOUtil.read(fileName3);
            str4 = FileIOUtil.read(fileName4);
            str5 = FileIOUtil.read(fileName5);
//
//            byte1 = FileIOUtil.readBytes(zipFileName1);
//            byte2 = FileIOUtil.readBytes(zipFileName2);
//            byte3 = FileIOUtil.readBytes(zipFileName3);
//            byte4 = FileIOUtil.readBytes(zipFileName4);
//            byte5 = FileIOUtil.readBytes(zipFileName5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    final byte[] bytes = new byte[1024];


    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater1() throws Exception {
        byte1 = deflater(str1.getBytes(), 1);
        //FileIOUtil.saveBytes(byte1, getFileName1());
        // 压缩前：974,511 字节 压缩后：93,242 字节    9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：97,875 字节    5  89.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：113,376 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：974,511 字节 压缩后：131,252 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte2 = deflater(str2.getBytes(), 1);
        //FileIOUtil.saveBytes(byte2, getFileName2());
        // 压缩前：31,816 字节 压缩后：7,256 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：7,370 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：8,324 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：31,816 字节 压缩后：10,074 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte3 = deflater(str3.getBytes(), 1);
        //FileIOUtil.saveBytes(byte3, getFileName3());
        // 压缩前：2,580,477 字节 压缩后：462,140 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：479,447 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：602,951 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,580,477 字节 压缩后：639,090 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte4 = deflater(str4.getBytes(), 1);
        //FileIOUtil.saveBytes(byte4, getFileName4());
        // 压缩前：2,698,802 字节 压缩后：136,313 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：153,960 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：206,543 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,698,802 字节 压缩后：196,534 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte5 = deflater(str5.getBytes(), 1);
        //FileIOUtil.saveBytes(byte5, getFileName5());
        // 压缩前：25,553 字节 压缩后：4,286 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,360 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,719 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：25,553 字节 压缩后：5,910 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater2() throws Exception {
        byte1 = deflater(str1.getBytes(), 2);
        byte2 = deflater(str2.getBytes(), 2);
        byte3 = deflater(str3.getBytes(), 2);
        byte4 = deflater(str4.getBytes(), 2);
        byte5 = deflater(str5.getBytes(), 2);
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater3() throws Exception {
        byte1 = deflater(str1.getBytes(), 3);
        byte2 = deflater(str2.getBytes(), 3);
        byte3 = deflater(str3.getBytes(), 3);
        byte4 = deflater(str4.getBytes(), 3);
        byte5 = deflater(str5.getBytes(), 3);
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater4() throws Exception {
        byte1 = deflater(str1.getBytes(), 4);
        byte2 = deflater(str2.getBytes(), 4);
        byte3 = deflater(str3.getBytes(), 4);
        byte4 = deflater(str4.getBytes(), 4);
        byte5 = deflater(str5.getBytes(), 4);
    }

    /**
     * 方法1 解压缩
     */
//    @Benchmark
    public void unzipInflater1() throws Exception {
        byte[] inflater1 = inflater(byte1);
        //System.out.println(str1.equals(new String(inflater1)));

        byte[] inflater2 = inflater(byte2);
        //System.out.println(str2.equals(new String(inflater2)));

        byte[] inflater3 = inflater(byte3);
        //System.out.println(str3.equals(new String(inflater3)));

        byte[] inflater4 = inflater(byte4);
        //System.out.println(str4.equals(new String(inflater4)));

        byte[] inflater5 = inflater(byte5);
        //System.out.println(str5.equals(new String(inflater5)));
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater5() throws Exception {
        byte1 = deflater(str1.getBytes(), 5);
        //FileIOUtil.saveBytes(byte1, getFileName1());
        // 压缩前：974,511 字节 压缩后：93,242 字节    9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：97,875 字节    5  89.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：113,376 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：974,511 字节 压缩后：131,252 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte2 = deflater(str2.getBytes(), 5);
        //FileIOUtil.saveBytes(byte2, getFileName2());
        // 压缩前：31,816 字节 压缩后：7,256 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：7,370 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：8,324 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：31,816 字节 压缩后：10,074 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte3 = deflater(str3.getBytes(), 5);
        //FileIOUtil.saveBytes(byte3, getFileName3());
        // 压缩前：2,580,477 字节 压缩后：462,140 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：479,447 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：602,951 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,580,477 字节 压缩后：639,090 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte4 = deflater(str4.getBytes(), 5);
        //FileIOUtil.saveBytes(byte4, getFileName4());
        // 压缩前：2,698,802 字节 压缩后：136,313 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：153,960 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：206,543 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,698,802 字节 压缩后：196,534 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte5 = deflater(str5.getBytes(), 5);
        //FileIOUtil.saveBytes(byte5, getFileName5());
        // 压缩前：25,553 字节 压缩后：4,286 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,360 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,719 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：25,553 字节 压缩后：5,910 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater6() throws Exception {
        byte1 = deflater(str1.getBytes(), 6);
        byte2 = deflater(str2.getBytes(), 6);
        byte3 = deflater(str3.getBytes(), 6);
        byte4 = deflater(str4.getBytes(), 6);
        byte5 = deflater(str5.getBytes(), 6);
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater7() throws Exception {
        byte1 = deflater(str1.getBytes(), 7);
        byte2 = deflater(str2.getBytes(), 7);
        byte3 = deflater(str3.getBytes(), 7);
        byte4 = deflater(str4.getBytes(), 7);
        byte5 = deflater(str5.getBytes(), 7);
    }

    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater8() throws Exception {
        byte1 = deflater(str1.getBytes(), 8);
        byte2 = deflater(str2.getBytes(), 8);
        byte3 = deflater(str3.getBytes(), 8);
        byte4 = deflater(str4.getBytes(), 8);
        byte5 = deflater(str5.getBytes(), 8);
    }

    /**
     * 方法1 解压缩
     */
//    @Benchmark
    public void unzipInflater5() throws Exception {
        byte[] inflater1 = inflater(byte1);
        //System.out.println(str1.equals(new String(inflater1)));

        byte[] inflater2 = inflater(byte2);
        //System.out.println(str2.equals(new String(inflater2)));

        byte[] inflater3 = inflater(byte3);
        //System.out.println(str3.equals(new String(inflater3)));

        byte[] inflater4 = inflater(byte4);
        //System.out.println(str4.equals(new String(inflater4)));

        byte[] inflater5 = inflater(byte5);
        //System.out.println(str5.equals(new String(inflater5)));
    }


    /**
     * 方法1 压缩
     */
    @Benchmark
    public void zipDeflater9() throws Exception {
        byte1 = deflater(str1.getBytes(), 9);
        //FileIOUtil.saveBytes(byte1, getFileName1());
        // 压缩前：974,511 字节 压缩后：93,242 字节    9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：97,875 字节    5  89.571 ± 2.565  ms/op
        // 压缩前：974,511 字节 压缩后：113,376 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：974,511 字节 压缩后：131,252 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte2 = deflater(str2.getBytes(), 9);
        //FileIOUtil.saveBytes(byte2, getFileName2());
        // 压缩前：31,816 字节 压缩后：7,256 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：7,370 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：31,816 字节 压缩后：8,324 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：31,816 字节 压缩后：10,074 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte3 = deflater(str3.getBytes(), 9);
        //FileIOUtil.saveBytes(byte3, getFileName3());
        // 压缩前：2,580,477 字节 压缩后：462,140 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：479,447 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,580,477 字节 压缩后：602,951 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,580,477 字节 压缩后：639,090 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte4 = deflater(str4.getBytes(), 9);
        //FileIOUtil.saveBytes(byte4, getFileName4());
        // 压缩前：2,698,802 字节 压缩后：136,313 字节  9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：153,960 字节  5  89.571 ± 2.565  ms/op
        // 压缩前：2,698,802 字节 压缩后：206,543 字节  1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：2,698,802 字节 压缩后：196,534 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op

        byte5 = deflater(str5.getBytes(), 9);
        //FileIOUtil.saveBytes(byte5, getFileName5());
        // 压缩前：25,553 字节 压缩后：4,286 字节   9 BEST_COMPRESSION压缩策略 389.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,360 字节   5  89.571 ± 2.565  ms/op
        // 压缩前：25,553 字节 压缩后：4,719 字节   1 BEST_SPEED压缩策略 46.008 ± 3.661  ms/op
        // 压缩前：25,553 字节 压缩后：5,910 字节   zip  97.758 ± 3.780  ms/op  24.143 ± 0.291  ms/op
    }

    /**
     * 方法1 解压缩
     */
//    @Benchmark
    public void unzipInflater9() throws Exception {
        byte[] inflater1 = inflater(byte1);
        //System.out.println(str1.equals(new String(inflater1)));

        byte[] inflater2 = inflater(byte2);
        //System.out.println(str2.equals(new String(inflater2)));

        byte[] inflater3 = inflater(byte3);
        //System.out.println(str3.equals(new String(inflater3)));

        byte[] inflater4 = inflater(byte4);
        //System.out.println(str4.equals(new String(inflater4)));

        byte[] inflater5 = inflater(byte5);
        //System.out.println(str5.equals(new String(inflater5)));
    }

    public byte[] deflater(byte[] str, int level) throws Exception {

        //使用指定的压缩级别创建一个新的压缩器。
        Deflater deflater = new Deflater(level);
        //设置压缩输入数据。
        deflater.setInput(str);
        //当被调用时，表示压缩应该以输入缓冲区的当前内容结束。
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        deflater.finish();
        while (!deflater.finished()) {
            //压缩输入数据并用压缩数据填充指定的缓冲区。
            int length = deflater.deflate(bytes);
            outputStream.write(bytes, 0, length);
        }
        //关闭压缩器并丢弃任何未处理的输入。
        deflater.end();
        return outputStream.toByteArray();
    }

    public byte[] inflater(byte[] str) throws Exception {

        Inflater inflater = new Inflater();
        //设置解压缩的输入数据。
        inflater.setInput(str);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            //finished() 如果已到达压缩数据流的末尾，则返回true。
            while (!inflater.finished()) {
                //将字节解压缩到指定的缓冲区中。
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
        } finally {
            //关闭解压缩器并丢弃任何未处理的输入。
            inflater.end();
        }
        return outputStream.toByteArray();
    }



    public String getFileName1() {
        return "yms_config_zipData.txt";
    }

    public String getFileName2() {
        return "antisamy-esapi_zipData.txt";
    }

    public String getFileName3() {
        return "extend.min_zipData.txt";
    }

    public String getFileName4() {
        return "logback-spring_zipData.txt";
    }

    public String getFileName5() {
        return "Version_zipData.txt";
    }
}
