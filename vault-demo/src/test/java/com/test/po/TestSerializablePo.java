package com.test.po;

import com.test.TestSerializable;

import java.io.Serializable;

public class TestSerializablePo implements Serializable {

    private String a;
    private static String b;
    private transient String c;
    private final transient String d;

    public TestSerializablePo() {
        d = "asd";
    }

    public TestSerializablePo(String a, String c, String d) {
        this.a = a;
        this.c = c;
        this.d = d;
    }

    @MyTestAnnotation
    public static void setB(String b) {
        TestSerializablePo.b = b;
    }

    @Override
    public String toString() {
        return "TestSerializablePo{" +
                "a='" + a + '\'' +
                "b='" + TestSerializablePo.b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}