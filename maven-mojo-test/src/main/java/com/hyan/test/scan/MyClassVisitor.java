package com.hyan.test.scan;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.AnnotationNode;

import java.util.ArrayList;
import java.util.List;

public class MyClassVisitor extends ClassVisitor {

    public List<AnnotationNode> visibleAnnotations;

    public List<AnnotationNode> invisibleAnnotations;

    public MyClassVisitor(int api) {
        super(api);
    }

    public MyClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    public List<AnnotationNode> getVisibleAnnotations() {
        return visibleAnnotations;
    }

    public List<AnnotationNode> getInvisibleAnnotations() {
        return invisibleAnnotations;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
    }

    @Override
    public void visitSource(String source, String debug) {
    }

    @Override
    public ModuleVisitor visitModule(String name, int access, String version) {
        return null;
    }

    @Override
    public void visitNestHost(String nestHost) {
    }

    @Override
    public void visitOuterClass(String owner, String name, String descriptor) {
    }

    @Override
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationNode an = new AnnotationNode(descriptor);
        if (visible) {
            if (visibleAnnotations == null) {
                visibleAnnotations = new ArrayList<>(1);
            }
            visibleAnnotations.add(an);
        } else {
            if (invisibleAnnotations == null) {
                invisibleAnnotations = new ArrayList<>(1);
            }
            invisibleAnnotations.add(an);
        }
        return an;
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        return null;
    }

    @Override
    public void visitAttribute(Attribute attribute) {
    }

    @Override
    public void visitNestMember(String nestMember) {
    }

    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        return null;
    }

    @Override
    public void visitEnd() {
    }
}
