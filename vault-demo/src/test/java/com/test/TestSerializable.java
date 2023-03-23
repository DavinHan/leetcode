package com.test;

import com.test.po.TestSerializablePo;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class TestSerializable {

    @Test
    public void fun() {
        byte[] out = null;
        TestSerializablePo p = new TestSerializablePo("a", "c", "d");
        TestSerializablePo.setB("b");

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(p.toString().getBytes(StandardCharsets.UTF_8));
            out = baos.toByteArray();
        } catch (Exception ignored) {
        }

    }
}
