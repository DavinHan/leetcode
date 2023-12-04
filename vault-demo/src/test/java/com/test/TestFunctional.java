package com.test;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class TestFunctional {

    @Test
    public void test() {
//        processFunctional(TestInterface::printHello);
        TestFunctional t = new TestFunctional();
        TestInterface ti = new TestInterface();
        t.processFunctional2(() -> ti.printHello("ok1"));
        t.processFunctional2(() -> ti.printHello("ok2", "age1"));
        t.processFunctional2(() -> ti.printHello("ok3", "age1", "man1"));
    }

    public <R> void processFunctional2(MySupplier<R> supplier) {
        System.out.println(supplier.apply());
        System.out.println("hello");
    }

    public <T, R> void processFunctional(Function<T, R> function) {
        System.out.println("hello");
    }

    public class TestInterface {
        public String printHello(String name) {
            return name;
        }
        public String printHello(String name, String age) {
            return name + ", " + age;
        }
        public String printHello(String name, String age, String sex) {
            return name + ", " + age + ", " + sex;
        }
    }

    @FunctionalInterface
    public interface MySupplier<R> {
        R apply();
    }
}
