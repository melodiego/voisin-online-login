package br.com.voisinonline.login.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper defaultModelMapper() {
        return new ModelMapper();
    }

}