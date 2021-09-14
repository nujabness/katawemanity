package com.nujabness.katawemanity.services.configuration;


import com.nujabness.katawemanity.services.authentification.AuthenticationProvider;
import com.nujabness.katawemanity.services.authentification.CustomUserDetailsService;
import com.nujabness.katawemanity.services.authentification.provider.JwtTokenProvider;
import com.nujabness.katawemanity.services.filter.HttpAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired JwtTokenProvider tokenService;
	@Autowired private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Configure DB authentication provider for user accounts
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		HttpAuthorizationFilter customFilter = new HttpAuthorizationFilter(tokenService);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers("/auth/**").permitAll()
				.anyRequest()
				.authenticated()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

}
