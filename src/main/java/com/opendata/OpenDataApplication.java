package com.opendata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableConfigurationProperties
public class OpenDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenDataApplication.class, args);
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
      return registry -> registry.config().commonTags("application", "MYAPPNAME");
    }
}
