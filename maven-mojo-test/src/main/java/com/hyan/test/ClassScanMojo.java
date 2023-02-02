package com.hyan.test;

import com.google.common.collect.Lists;
import com.hyan.test.scan.MyClassVisitor;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.shared.transfer.artifact.resolve.ArtifactResolver;
import org.apache.maven.shared.transfer.artifact.resolve.ArtifactResolverException;
import org.apache.maven.shared.transfer.artifact.resolve.ArtifactResult;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Mojo(name = "build", defaultPhase = LifecyclePhase.PACKAGE)
public class ClassScanMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Parameter(defaultValue = "${session}", required = true, readonly = true)
    private MavenSession session;

    @Component
    private ArtifactResolver artifactResolver;

    private static final int ASM7 = 7 << 16;

    private final static List<String> annotationNames = Lists.newArrayList("org.springframework.scheduling.annotation.EnableScheduling");

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        Artifact artifact = project.getArtifact();
        resolverDependency(artifact);
    }

    private void resolverDependency(Artifact artifact) {
        try {
            ProjectBuildingRequest request = new DefaultProjectBuildingRequest(session.getProjectBuildingRequest());
            ArtifactResult result = artifactResolver.resolveArtifact(request, artifact);
            File file = result.getArtifact().getFile();

            try(JarFile jarFile = new JarFile(file)) {
                Enumeration<JarEntry> entries = jarFile.entries();

                while (entries.hasMoreElements()) {
                    JarEntry jarEntry = entries.nextElement();
                    if (jarEntry.getName().endsWith(".class")) {
                        try (InputStream is = jarFile.getInputStream(jarEntry)) {
                            MyClassVisitor myClassVisitor = new MyClassVisitor(ASM7);
                            ClassReader reader = new ClassReader(is);
                            reader.accept(myClassVisitor, 0);
                            List<AnnotationNode> annotations = myClassVisitor.getVisibleAnnotations();

                            if(annotations != null) {
                                annotations.forEach(a -> {
                                    Type type = Type.getType(a.desc);
                                    String annotationName = type.getClassName();
                                    if(annotationNames.contains(annotationName)) {
                                        String className = reader.getClassName().replace('/', '.').replace('\\', '.');
                                        System.out.println(className + ", " + annotationName);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        } catch (ArtifactResolverException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
