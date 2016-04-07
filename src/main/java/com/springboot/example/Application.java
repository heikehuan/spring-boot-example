package com.springboot.example;

import com.springboot.example.common.config.AbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * The main Java based Spring configuration
 * <p>
 * Unwanted existing @Configuration class can be excluded like this:
 * <p>
 * //@EnableAutoConfiguration(exclude = TraceWebFilterAutoConfiguration.class)
 *
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 25/08/15 - 11:21
 */
@Configuration
@ComponentScan("com.springboot.example")
public class Application extends AbstractApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        abstractMain(app, args);
    }
}
