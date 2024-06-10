package com.gustavofdasilva.sandbox;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/helloworld")
    public String sayHello() {
        Student student = new Student();
        return "HELLO! from my first controller!";
    }
}
