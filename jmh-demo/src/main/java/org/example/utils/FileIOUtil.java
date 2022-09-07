package org.example.utils;

import java.io.*;

/**
 * 文件读取工具
 *
 * @author yanhanf
 */
public class FileIOUtil {

    public static void save(String fileContent, String fileName) throws Exception {
        FileWriter bw = new FileWriter(fileName);
        bw.write(fileContent);
        bw.close();
    }

    public static void save(char[] fileContent, String fileName) throws Exception {
        FileWriter bw = new FileWriter(fileName);
        bw.write(fileContent);
        bw.close();
    }

    public static String read(String fileName) throws Exception {
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        isr.close();
        fis.close();
        return sb.toString();
    }


    public static void saveBytes(byte[] fileContent, String fileName) throws Exception {
        FileOutputStream bw = new FileOutputStream(fileName);
        bw.write(fileContent);
        File file = new File(fileName);
        byte[] a = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(fileName);
        fis.read(a);
        fis.close();
        bw.close();
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] a = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(a);
        fis.close();
        return a;

    }

}
