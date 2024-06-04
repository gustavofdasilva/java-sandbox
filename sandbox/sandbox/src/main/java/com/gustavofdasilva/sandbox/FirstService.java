package com.gustavofdasilva.sandbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class FirstService {
    private final FirstClass firstClass;
    private final Environment environment;
    @Value("${my.prop}")
    private String customProperty;

    public String getCustomProperty() {
        return customProperty;
    }

    @Autowired
    public FirstService(
        @Qualifier("secondFirstClass") FirstClass firstClass, 
        Environment environment) {
        this.firstClass = firstClass;
        this.environment = environment;
    }

    public String tellAStory() {
        return "The bean is saying: " + firstClass.sayHello();
    }

    public String getJavaVersion() {
        return "The Java version is: " + environment.getProperty("java.version");
    }

    public String getProjectName() {
        return "The project name is: "+ environment.getProperty("spring.application.name");
    }
}
