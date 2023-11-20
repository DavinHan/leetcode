package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
//@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
//@AutoConfigureAfter(AConfig.class)
public class BConfig {

//    @Bean("bbb")
//    @ConditionalOnMissingBean(RealBean.class)
//    public RealBean realBean() {
//        return new RealBean("B");
//    }
//

    @Bean("${b.bean.name}")
    public SecondBean secondBean(RealBean r) {
        return new SecondBean(r);
    }
}
