package com.test.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor, EnvironmentAware, ApplicationContextAware {

    private ApplicationContext context;

    private Environment environment;

    private final BeanNameGenerator beanNameGenerator = AnnotationBeanNameGenerator.INSTANCE;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String ok = environment.getProperty("ok", "ok");
        if (!"ok".equals(ok)) {
            return;
        }
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
        ClassLoader classLoader = context.getClassLoader();
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents("com.test");
        for (BeanDefinition definition : beanDefinitions) {
            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) definition;

            try {
                Class<?> beanClass = classLoader.loadClass(scannedGenericBeanDefinition.getBeanClassName());
                if (AnnotatedElementUtils.isAnnotated(beanClass,
                        "com.mangofactory.swagger.plugin.EnableSwagger") ||
                        AnnotatedElementUtils.isAnnotated(beanClass,
                                "springfox.documentation.swagger2.annotations.EnableSwagger2")) {
                    String beanName = beanNameGenerator.generateBeanName(definition, registry);
                    registry.removeBeanDefinition(beanName);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
