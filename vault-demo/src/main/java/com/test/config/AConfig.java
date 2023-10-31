package com.test.config;

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
public class AConfig {

    @Bean("aaa")
    @ConditionalOnMissingBean(RealBean.class)
    public RealBean realBean() {
        return new RealBean("A");
    }
//
//    @Bean
//    public SecondBean secondBean(RealBean r) {
//        return new SecondBean(r);
//    }
}
