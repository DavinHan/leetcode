package com.test;

import com.test.po.TestSerializablePo;
import com.test.po.TestSerializablePo2;
import com.test.po.TestSerializablePo3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.data.type.classreading.MethodsMetadataReader;
import org.springframework.data.type.classreading.MethodsMetadataReaderFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author yanhanf
 */
public class HttpTest {

    @Test
    public void test2() {
        test22();
        System.gc();
        System.out.println("exit");
    }

    @Test
    public void test4() throws ClassNotFoundException, IOException {
        Class<?> aClass = Class.forName("com.test.po.TestSerializablePo", false, Thread.currentThread().getContextClassLoader());
        System.out.println(aClass.getCanonicalName());


        ResourceLoader resourceLoader = new DefaultResourceLoader(Thread.currentThread().getContextClassLoader());
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory(resourceLoader);
        MetadataReader reader = metadataReaderFactory.getMetadataReader("com.test.po.TestSerializablePo");
        System.out.println(reader.getClassMetadata().getClassName());


        MethodsMetadataReaderFactory scanMetaReader = new MethodsMetadataReaderFactory(resourceLoader);
        MethodsMetadataReader metadataReader = scanMetaReader.getMetadataReader("com.test.po.TestSerializablePo");
        System.out.println(metadataReader.getResource().getDescription());
        System.out.println(metadataReader.getClassMetadata().getClassName());

        SimpleMetadataReaderFactory simpleFactory = new SimpleMetadataReaderFactory(resourceLoader);
        MetadataReader reader1 = simpleFactory.getMetadataReader("com.test.po.TestSerializablePo");
        System.out.println(reader1.getClassMetadata().getClassName());

        ResourceLoader resourceLoader2 = new DefaultResourceLoader(Thread.currentThread().getContextClassLoader());
        SimpleMetadataReaderFactory metadataReaderFactory2 = new SimpleMetadataReaderFactory(resourceLoader2);
        MetadataReader reader2 = metadataReaderFactory2.getMetadataReader("com.test.po.TestSerializablePo2");
        System.out.println(reader2.getClassMetadata().getClassName());


        MethodsMetadataReaderFactory scanMetaReader2 = new MethodsMetadataReaderFactory(resourceLoader2);
        MethodsMetadataReader metadataReader2 = scanMetaReader2.getMetadataReader("com.test.po.TestSerializablePo2");
        System.out.println(metadataReader2.getResource().getDescription());
        System.out.println(metadataReader2.getClassMetadata().getClassName());


        SimpleMetadataReaderFactory simpleFactory2 = new SimpleMetadataReaderFactory(resourceLoader);
        MetadataReader reader21 = simpleFactory2.getMetadataReader("com.test.po.TestSerializablePo");
        System.out.println(reader21.getClassMetadata().getClassName());
    }

    public void test22() {
        new TestDestroy();
    }

    @Test
    public void test444() {
        Constructor<TestSerializablePo> constructor = BeanUtils.getResolvableConstructor(TestSerializablePo.class);
        System.out.println(constructor.toString());
        Constructor<TestSerializablePo2> constructor2 = BeanUtils.getResolvableConstructor(TestSerializablePo2.class);
        System.out.println(constructor2.toString());
    }

    @Test
    public void test55() {
        List<String> a = new ArrayList<>();
        a.add("asd");
        a.add("qwe");
//        a.add("zxc");
        System.out.println(a.stream().anyMatch("asd"::equals));
        System.out.println(a.stream().noneMatch("asd"::equals));
    }

    @Test
    public void test64() {
        try {
            Thread.currentThread().getContextClassLoader().loadClass("com.test.po.TestSerializablePo3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        TestSerializablePo3 p = new TestSerializablePo3();
        try {
            Thread.currentThread().getContextClassLoader().loadClass("com.test.po.TestSerializablePo3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Set<String> set = new LinkedHashSet<>();
        set.add("qwe");
        set.add("123");
        set.add("zxc");
        System.out.println(set);
    }

    @Test
    public void test56() {
        String a = "a";
        if (a.equalsIgnoreCase(null)) {
            System.out.println("bb:");
        }
    }

    @Test
    public void test99() {
        System.out.println(123121231L*12313212312L*223L);
    }
}
