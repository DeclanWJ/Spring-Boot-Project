package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/*
	@SpringBootApplication is a convinience annotation that adds all of the following:
		- @Configuration: Tags the class as a source of bean definitions for the app context
		- @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath
			settings, other beans, and various property settings. EX: if spring-webmvc is
			on the classpath, this annotation flags the app as a web app and activates key behaviors
			such as setting up a DispatcherServlet.
		- @ComponentScan: Tells Spring to look for other components configurations, and services in
			the com/example package, letting it find the controllers
*/
@SpringBootApplication
public class DemoApplication {

	/*
		The main() method uses Spring Boot's SpringApplication.run() method to launch an APP
		This web app is 100% pure Java, no XML setup nor web.xml file
	*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
		Runs on startup, retrives all the beans that were created by the app or
		were auto created by Spring Boot. Sorts them, and prints them out.
		@Bean : explicitly declare a Java object as a Spring Bean, which means its
			instansiation , configuration, and lifecycle will be managed entirely by 
			the Spring IoC (Inversion of Control) Container
	*/
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args ->{

			System.out.println("Let's inspect the beans provided by Spring Boot: ");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for(String beanName : beanNames){
				System.out.println(beanName);
			}
		};
	}

}
