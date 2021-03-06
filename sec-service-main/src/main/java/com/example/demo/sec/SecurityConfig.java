package com.example.demo.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpl detailsService; // il va injecter l'implementation de l'interface UserDetailsService
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailsService).passwordEncoder(bCryptPasswordEncoder);
		//auth.userDetailsService(detailsService): il fait appel à loadUserByUsername de la classe impl et il va encoder le mdp avec bcrypt
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/*
		 * http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
		http.authorizeRequests().antMatchers("/appUsers/**","/appRoles/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		 */
		
		http.authorizeRequests().antMatchers("/login/**").permitAll()
		 .antMatchers("/register/**").permitAll()
		 .antMatchers("/appUsers/**").hasAuthority("ADMIN")
		.antMatchers("/appRoles/**").hasAuthority("ADMIN")
		 .anyRequest().authenticated();
		
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
