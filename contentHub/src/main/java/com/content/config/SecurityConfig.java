package com.content.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.content.repostories.UserRepo;
import com.content.security.CustomeUserDetailService;

import com.content.security.JwtAuthenciationEntryPoint;
import com.content.security.JwtAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public static final String[] PUBLIC_URLS= {
			"/api/v1/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};
	@Autowired
	private JwtAuthenciationEntryPoint jwtAuthenciationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAutenticationFilter;
	
@Autowired
	private CustomeUserDetailService customeUserDetailService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	http.
	csrf().disable().
	authorizeHttpRequests()
	.antMatchers(PUBLIC_URLS).permitAll()
	.antMatchers(HttpMethod.GET).permitAll()
	
	.anyRequest().authenticated()
	.and().
	exceptionHandling().
	authenticationEntryPoint(this.jwtAuthenciationEntryPoint).
	and()
	.sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(jwtAutenticationFilter, UsernamePasswordAuthenticationFilter.class);
	  
	}
    // Your security configuration here

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customeUserDetailService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder();	
}
@SuppressWarnings("deprecation")
@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
}
