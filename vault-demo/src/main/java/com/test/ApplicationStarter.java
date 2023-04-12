package com.test;

import com.test.listener.FileLocalListener;
import com.test.listener.FileLocalMonitor;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author yanhanf
 */
@SpringBootApplication
@EnableScheduling
public class ApplicationStarter extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);


        try {
//            WatchFileService service = new WatchFileService();
//            service.watch("C:\\Users\\han66\\Desktop\\test");

            FileLocalMonitor monitor = new FileLocalMonitor(1000);
            monitor.monitor("C:\\Users\\han66\\Desktop\\test", new FileLocalListener());
            monitor.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String appCode) {
        return registry -> registry.config().commonTags("application", appCode);
    }

}
