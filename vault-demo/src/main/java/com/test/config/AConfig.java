package com.test.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
//@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
//@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
//@AutoConfigureAfter(BConfig.class)
public class AConfig implements Cloneable {

    @Value("${a.bean.name}")
    public void setBeanName(String beanName) {
        AConfig.beanName = beanName;
    }

//    @Value("${a.bean.name}")
    private static String beanName;

    @PostConstruct
    public void init() {
        System.out.println("AConfig init " + beanName);
    }

    @Bean("${a.bean.name}")
    @ConditionalOnMissingBean(RealBean.class)
    public RealBean realBean() {
        return new RealBean(beanName);
    }
//
//    @Bean
//    public SecondBean secondBean(RealBean r) {
//        return new SecondBean(r);
//    }


    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
