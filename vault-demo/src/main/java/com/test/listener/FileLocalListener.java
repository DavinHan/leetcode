package com.test.listener;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileLocalListener extends FileAlterationListenerAdaptor {

    @Override
    public void onFileCreate(File file) {
        System.out.println(file.getName() + "文件被创建");
    }

    @Override
    public void onFileChange(File file) {
        System.out.println(file.getName() + "文件被修改");
        if (file.getName().equals("1.txt")) {
            try {
                String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
                System.out.println("1.txt内容变化 -> " + System.getProperty("line.separator") + content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
