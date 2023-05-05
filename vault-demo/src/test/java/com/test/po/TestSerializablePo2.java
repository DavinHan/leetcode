package com.test.po;

import java.io.Serializable;

public class TestSerializablePo2 implements Serializable {

    private String a;
    private static String b;
    private transient String c;
    private transient String d;

    public TestSerializablePo2(String a, String c, String d) {
        this.a = a;
        this.c = c;
        this.d = d;
    }

    public TestSerializablePo2(String a, String c) {
        this.a = a;
        this.c = c;
        this.d = "d";
    }

    private TestSerializablePo2(String a) {
        this.a = a;
        this.c = "c";
        this.d = "d";
    }

    private TestSerializablePo2() {
        d = "asd";
    }


    @MyTestAnnotation
    public static void setA(String b) {
        TestSerializablePo2.b = b;
    }

    @Override
    public String toString() {
        return "TestSerializablePo{" +
                "a='" + a + '\'' +
                "b='" + TestSerializablePo2.b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}