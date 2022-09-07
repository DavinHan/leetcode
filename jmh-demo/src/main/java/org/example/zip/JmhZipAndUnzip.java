//package org.example.zip;
//
//import org.example.utils.FileIOUtil;
//import org.openjdk.jmh.annotations.*;
////import sun.misc.BASE64Decoder;
////import sun.misc.BASE64Encoder;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.concurrent.TimeUnit;
//import java.util.zip.GZIPInputStream;
//import java.util.zip.GZIPOutputStream;
//
//
///**
// * 基准测试 - 压缩和解压缩字符串
// *
// * @author yanhanf
// */
//@BenchmarkMode(Mode.AverageTime)
//@State(Scope.Thread)
//@Fork(1)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Warmup(iterations = 3)
//@Measurement(iterations = 5)
//public class JmhZipAndUnzip {
//
//    private static String str1 = "";
//    private static String str2 = "";
//    private static String str3 = "";
//    private static String str4 = "";
//    private static String str5 = "";
//
//    private static String zipStr1 = "";
//    private static String zipStr2 = "";
//    private static String zipStr3 = "";
//    private static String zipStr4 = "";
//    private static String zipStr5 = "";
//
//    static {
//        String fileName1 = "yms_config.json";
//        String fileName2 = "antisamy-esapi.xml";
//        String fileName3 = "extend.min.js";
//        String fileName4 = "logback-spring.xml";
//        String fileName5 = "Version.php";
//
////        String zipFileName1 = "yms_config_zipData.txt";
////        String zipFileName2 = "antisamy-esapi_zipData.txt";
////        String zipFileName3 = "extend.min_zipData.txt";
////        String zipFileName4 = "logback-spring_zipData.txt";
////        String zipFileName5 = "Version_zipData.txt";
//        try {
//            str1 = FileIOUtil.read(fileName1);
//            str2 = FileIOUtil.read(fileName2);
//            str3 = FileIOUtil.read(fileName3);
//            str4 = FileIOUtil.read(fileName4);
//            str5 = FileIOUtil.read(fileName5);
//
////            zipStr1 = FileIOUtil.read(zipFileName1);
////            zipStr2 = FileIOUtil.read(zipFileName2);
////            zipStr3 = FileIOUtil.read(zipFileName3);
////            zipStr4 = FileIOUtil.read(zipFileName4);
////            zipStr5 = FileIOUtil.read(zipFileName5);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    /**
//     * 方法1 压缩
//     */
//    @Benchmark
//    public void zipByGZIPOutputStream() throws Exception {
//        zipStr1 = zipByGZIPOutputStream(str1); // 压缩前：948,332 字节 压缩后：131,252 字节
//        //FileIOUtil.save(zipStr1, getFileName1());
//
//        zipStr2 = zipByGZIPOutputStream(str2);// 压缩前：31,324字节 压缩后：10,074 字节
//        //FileIOUtil.save(zipStr2, getFileName2());
//
//        zipStr3 = zipByGZIPOutputStream(str3);// 压缩前：2,506,338 字节 压缩后：639,090 字节
//        //FileIOUtil.save(zipStr3, getFileName3());
//
//        zipStr4 = zipByGZIPOutputStream(str4);// 压缩前：2,688,717 字节 压缩后：196,534 字节
//        //FileIOUtil.save(zipStr4, getFileName4());
//
//        zipStr5 = zipByGZIPOutputStream(str5);// 压缩前：25,273 字节 压缩后：5,910 字节
//        //FileIOUtil.save(zipStr5, getFileName5());
//    }
//
//    /**
//     * 方法1 解压缩
//     */
////    @Benchmark
//    public void unzipByGZIPInputStream() throws IOException {
//        unzipByGZIPInputStream(zipStr1);
//
//        unzipByGZIPInputStream(zipStr2);
//
//        unzipByGZIPInputStream(zipStr3);
//
//        unzipByGZIPInputStream(zipStr4);
//
//        unzipByGZIPInputStream(zipStr5);
//    }
//
//
//    private String zipByGZIPOutputStream(String str) throws IOException {
//        if(str == null || str.length() == 0) {
//            return str;
//        }
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try(GZIPOutputStream gzip = new GZIPOutputStream(baos)) {
//            gzip.write(str.getBytes(StandardCharsets.UTF_8));
//        }
//        return new BASE64Encoder().encode(baos.toByteArray());
//    }
//
//    private String unzipByGZIPInputStream(String str) throws IOException {
//        if(str == null || str.length() == 0) {
//            return str;
//        }
//        byte[] unzipStr = new BASE64Decoder().decodeBuffer(str);
//        String result = null;
//        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ByteArrayInputStream bais = new ByteArrayInputStream(unzipStr);
//            GZIPInputStream gzip = new GZIPInputStream(bais)) {
//            byte[] buffer = new byte[1024];
//            int offset = -1;
//            while((offset = gzip.read(buffer)) != -1) {
//                baos.write(buffer, 0, offset);
//            }
//            result = baos.toString();
//        }
//        return result;
//    }
//
//    public String getFileName1() {
//        return "yms_config_zipData.txt";
//    }
//
//    public String getFileName2() {
//        return "antisamy-esapi_zipData.txt";
//    }
//
//    public String getFileName3() {
//        return "extend.min_zipData.txt";
//    }
//
//    public String getFileName4() {
//        return "logback-spring_zipData.txt";
//    }
//
//    public String getFileName5() {
//        return "Version_zipData.txt";
//    }
//}
