package com.test.po;

import java.io.Serializable;

public class TestSerializablePo3 implements Serializable {

    private String a;
    private static String b;
    private transient String c;
    private final transient String d;

    public TestSerializablePo3() {
        d = "asd";
    }

    public TestSerializablePo3(String a, String c, String d) {
        this.a = a;
        this.c = c;
        this.d = d;
    }

    static {
        b = "qq";
        assert "qq".equals(b);
    }

    @MyTestAnnotation
    public static void setB(String b) {
        TestSerializablePo3.b = b;
    }

    public Long start() {
        System.out.println("asd");
        return 0L;
    }

    @Override
    public String toString() {
        return "TestSerializablePo{" +
                "a='" + a + '\'' +
                "b='" + TestSerializablePo3.b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}