/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.codebeats.axisconnect.web.serviceOrders.ServiceOrderService;

/**
 * @author dtorresf
 *
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = {ServiceOrderService.class, AdminWebController.class})
public class SpringBootWebApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
