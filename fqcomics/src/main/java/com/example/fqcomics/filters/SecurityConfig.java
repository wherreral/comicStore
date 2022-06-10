package com.example.fqcomics.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	    		http
	    		.headers().frameOptions().disable()
	    		.and()
    	 		.cors().and()
    	 		.csrf().disable().authorizeRequests()
    	 		//.headers().frameOptions().disable()
                .antMatchers(HttpMethod.GET, "/inventory/all").permitAll()
                .antMatchers(HttpMethod.GET, "/inventory/*").permitAll()
                .antMatchers(HttpMethod.POST, "/presale/save").permitAll()
                .antMatchers(HttpMethod.POST, "/presale/payed").permitAll()
                .antMatchers(HttpMethod.GET, "/ventas").permitAll()
                .antMatchers(HttpMethod.GET, "/preventas").permitAll()
                .antMatchers(HttpMethod.GET, "/func.js").permitAll()
                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

        
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }
  
}
