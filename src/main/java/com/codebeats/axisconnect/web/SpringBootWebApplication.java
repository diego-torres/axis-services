/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dtorresf
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.codebeats.axisconnect.web", "com.codebeats.axisconnect.web.serviceOrders"})
public class SpringBootWebApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
