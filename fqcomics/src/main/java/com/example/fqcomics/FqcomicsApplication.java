package com.example.fqcomics;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class FqcomicsApplication {

	public static void main(String[] args) {
		TomcatURLStreamHandlerFactory.disable();
		SpringApplication.run(FqcomicsApplication.class, args);
	}


	@Component
	public class MigrationLogic implements SmartInitializingSingleton {

	    @Override
	    @Transactional
	    public void afterSingletonsInstantiated() {
	        System.out.println("AQUI");
	        TomcatURLStreamHandlerFactory.disable();

	    }

	}
	
	@Component
	public class PostConstructBean implements ApplicationListener<ContextRefreshedEvent>{

		@Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			// TODO Auto-generated method stub
			System.out.println("EMPEZANDO");
		}
		
	}
}
