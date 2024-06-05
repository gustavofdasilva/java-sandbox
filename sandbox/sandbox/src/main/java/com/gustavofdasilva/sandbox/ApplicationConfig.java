package com.gustavofdasilva.sandbox;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean("coolBean")
    @Profile("prod")
    public FirstClass coolBean() {
        return new FirstClass("PRODUCTION");
    }

    @Bean("coolBean")
    @Profile("dev")
    public FirstClass coolBeanDev() {
        return new FirstClass("Uknown");
    }

    @Bean
    public FirstClass secondFirstClass() {
        return new FirstClass("Harold");
    }

    @Bean
    public FirstClass firstClass() {
        return new FirstClass("Joulie");
    }

}
