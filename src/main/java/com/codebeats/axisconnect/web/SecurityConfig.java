/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.filter.KeycloakAuthenticationProcessingFilter;
import org.keycloak.adapters.springsecurity.filter.KeycloakPreAuthActionsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * @author dtorresf
 *
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(keycloakAuthenticationProvider());
	}

	//@Autowired
	//public KeycloakClientRequestFactory keycloakClientRequestFactory;

	/*@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public KeycloakRestTemplate keycloakRestTemplate() {
		return new KeycloakRestTemplate(keycloakClientRequestFactory);
	}*/

	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	}

	@Bean
	public FilterRegistrationBean<KeycloakAuthenticationProcessingFilter> keycloakAuthenticationProcessingFilterRegistrationBean(
			KeycloakAuthenticationProcessingFilter filter) {
		FilterRegistrationBean<KeycloakAuthenticationProcessingFilter> registrationBean = new FilterRegistrationBean<KeycloakAuthenticationProcessingFilter>(
				filter);
		registrationBean.setEnabled(true);
		return registrationBean;
	}

	@Bean
	@ConditionalOnClass(SpringBootApplication.class)
	public FilterRegistrationBean<KeycloakPreAuthActionsFilter> keycloakPreAuthActionsFilterRegistrationBean(
			KeycloakPreAuthActionsFilter filter) {
		FilterRegistrationBean<KeycloakPreAuthActionsFilter> registrationBean = new FilterRegistrationBean<KeycloakPreAuthActionsFilter>(
				filter);
		registrationBean.setEnabled(true);
		return registrationBean;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/admin/*").hasAuthority("user")
		.anyRequest().permitAll();
	}

}
