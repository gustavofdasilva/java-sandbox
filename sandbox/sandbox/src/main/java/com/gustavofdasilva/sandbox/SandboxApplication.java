package com.gustavofdasilva.sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SandboxApplication.class, args);

		FirstService firstService = ctx.getBean(FirstService.class);
		
		
		System.out.println(firstService.tellAStory());
		System.out.println(firstService.getJavaVersion());
		System.out.println(firstService.getProjectName());
		System.out.println(firstService.getCustomProperty());
	}
}
