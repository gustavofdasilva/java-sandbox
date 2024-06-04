package com.gustavofdasilva.sandbox;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {
    @Bean
    public FirstClass secondFirstClass() {
        return new FirstClass("Harold");
    }

    @Bean
    public FirstClass firstClass() {
        return new FirstClass("Joulie");
    }

}
