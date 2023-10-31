package com.hyan.test.scan;

import org.apache.commons.io.IOUtils;
import org.objectweb.asm.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class TestUtilAdapter extends ClassVisitor implements Opcodes {

    public TestUtilAdapter(int api) {
        super(api);
    }

    public TestUtilAdapter(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    public static void modifyClass(String fileName, Map<String, String> params) throws IOException {
        ClassReader classReader = new ClassReader(fileName);
        ClassWriter classWriter = new ClassWriter(classReader, 0);

        classReader.accept(new ClassVisitor(ASM4, classWriter) {
            @Override
            public void visitEnd() {
                modify(classWriter, params);
            }
        }, 0);

        try (FileWriter fw = new FileWriter(fileName)) {

        }
        IOUtils.write(classWriter.toByteArray(), new FileOutputStream(fileName));
    }
    public static byte[] dump(Map<String, String> params) {
        // 生产java文件
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "com/test/utils/TestUtil", null, "java/lang/Object", null);
        classWriter.visitSource("TestUtil.java", null);

        // 生成静态常量 map
        FieldVisitor map = classWriter.visitField(ACC_PRIVATE | ACC_FINAL | ACC_STATIC, "map", "Ljava/util/Map;", "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", null);
        map.visitEnd();

        // 生成默认构造函数
        MethodVisitor init0 = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        init0.visitCode();
        init0.visitVarInsn(ALOAD, 0);
        init0.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        init0.visitInsn(RETURN);
        init0.visitMaxs(1, 1);
        init0.visitEnd();

        // 生成静态方法getMap
        MethodVisitor getMap = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "getMap", "()Ljava/util/Map;", "()Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;", null);
        getMap.visitCode();
        getMap.visitFieldInsn(GETSTATIC, "com/test/utils/TestUtil", "map", "Ljava/util/Map;");
        getMap.visitInsn(ARETURN);
        getMap.visitMaxs(1, 0);
        getMap.visitEnd();

        // 生成static静态块，初始化map
        modify(classWriter, params);

        classWriter.visitEnd();
        return classWriter.toByteArray();
    }

    private static void modify(ClassWriter classWriter, Map<String, String> params) {
        // 生成static静态块，初始化map
        MethodVisitor clInit0 = classWriter.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
        clInit0.visitCode();
        clInit0.visitTypeInsn(NEW, "java/util/HashMap");
        clInit0.visitInsn(DUP);
        clInit0.visitMethodInsn(INVOKESPECIAL, "java/util/HashMap", "<init>", "()V", false);
        clInit0.visitFieldInsn(PUTSTATIC, "com/test/utils/TestUtil", "map", "Ljava/util/Map;");
        for (Map.Entry<String, String> e : params.entrySet()) {
            clInit0.visitFieldInsn(GETSTATIC, "com/test/utils/TestUtil", "map", "Ljava/util/Map;");
            clInit0.visitLdcInsn(e.getKey());
            clInit0.visitLdcInsn(e.getValue());
            clInit0.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", true);
            clInit0.visitInsn(POP);
        }
        clInit0.visitInsn(RETURN);
        clInit0.visitMaxs(3, 0);
        clInit0.visitEnd();
    }
}
