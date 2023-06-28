package com.example.fqcomics;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.fqcomics.utils.MyPrintStream;

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
			System.setOut(new MyPrintStream(System.out));
			System.out.println("EMPEZANDO");
			
		}
		
	}
	
	@Configuration
	public class WebConfiguration implements WebMvcConfigurer {

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }
	}
	

	
//	@Bean
//	public CookieSerializer cookieSerializer() {
//	    DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//	    serializer.setCookieName("SESSIONID");
//	    serializer.setCookiePath("/");
//	    serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
//	    return serializer;
//	}
}
