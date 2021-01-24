package com.school.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * Configures security for the app.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,
    jsr250Enabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  public SecurityConfiguration() {

    // propagate security context to new threads
    SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // CORS configured by CorsConfiguration
    http.cors();

    // Disable CSRF support
    http.csrf().disable();

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

    // Require authentication for any request besides login, logout and sockets communication with terminals
    http.authorizeRequests()
        .anyRequest().permitAll();

    // Disable http basic authentication
    http.httpBasic().disable();

    // Disable any login forms
    http.formLogin().disable();

    // Configures authentication entry point which
    // returns 401 unauthorized when there is no authenticated user
    http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
  }
}
