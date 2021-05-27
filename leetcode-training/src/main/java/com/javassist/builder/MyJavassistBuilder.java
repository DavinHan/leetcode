package com.javassist.builder;

import javassist.*;

import java.io.IOException;

public class MyJavassistBuilder {

    /**
     * 参考https://www.cnblogs.com/rickiyang/p/11336268.html
     */
    public static void createClass() {
        ClassPool classPool = ClassPool.getDefault();

        // 1. 新建一个空类
        CtClass ctClass = classPool.makeClass("com.javassist.demo.Person");

        // 2. 新增字段
        // 字段名为name
        CtField field = null;
        try {
            field = new CtField(classPool.get("java.lang.String"), "name", ctClass);
            field.setModifiers(Modifier.PRIVATE);
            ctClass.addField(field, CtField.Initializer.constant("Mike"));
        } catch (CannotCompileException | NotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 3. 生成Setter 和 Getter
        try {
            ctClass.addMethod(CtNewMethod.setter("setName", field));
            ctClass.addMethod(CtNewMethod.getter("getName", field));
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return;
        }

        // 4. 生成无参构造方法
        CtConstructor noneConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        try {
            noneConstructor.setBody("{name = \"Jike\";}");
            ctClass.addConstructor(noneConstructor);
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return;
        }

        // 5. 生成有参构造方法
        try {
            CtConstructor allConstructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.String")}, ctClass);
            // $0=this / $1,$2,$3... 代表方法参数
            allConstructor.setBody("{$0.name = \"Army\";}");
            ctClass.addConstructor(allConstructor);
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
            return;
        }

        // 6.  创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printObject", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        try {
            ctMethod.setBody("{System.out.println($0.name);}");
            ctClass.addMethod(ctMethod);
        } catch (CannotCompileException e) {
            e.printStackTrace();
            return;
        }

        // 7. 将这个创建的类对象编译为.class文件
        try {
            ctClass.writeFile("D:\\gitProject\\test\\leetcode-training\\");
        } catch (CannotCompileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createClass();
    }
}
