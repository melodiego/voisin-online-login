package br.com.voisinonline.login.config;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@EqualsAndHashCode
@Configuration
public class CacheConfig {

    @Value("${cache.user.time:5}")
    private int timeDurationCachePerson;

    @Value("${cache.user.maximum-size:10000}")
    private int maximumSizeCachePerson;

}
