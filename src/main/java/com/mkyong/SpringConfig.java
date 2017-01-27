package com.mkyong;

import com.mkyong.user.bo.UserBo;
import com.mkyong.user.bo.impl.UserBoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.faces.bean.ManagedProperty;

/**
 * Created by maslo on 27.1.17.
 */
@Configuration
public class SpringConfig {

    @Bean
    public UserBo user() {
        return new UserBoImpl();
    }
}
