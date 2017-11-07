package com.rubenjg.vm.messaging.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Adds Beans to Spring's Application Context
 *
 * @author Rubén Jiménez
 */
@Configuration
public class BeanConfiguration {

    /**
     * New RestTemplate object.
     *
     * @return RestTemplate object
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
