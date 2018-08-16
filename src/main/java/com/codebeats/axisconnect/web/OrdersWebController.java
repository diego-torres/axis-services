/**
 * 
 */
package com.codebeats.axisconnect.web;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author dtorresf
 *
 */
@Controller
@RequestMapping(path = "orders")
public class OrdersWebController {
	/**
	 * 
	 * @param auth
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/")
	public String ordersList(Authentication auth, Model model) {
		Principal principal = (Principal) auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		return "admin/pages/orders/list";
	}

	/**
	 * 
	 * @param auth
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/create")
	public String createOrder(Authentication auth, Model model) {
		Principal principal = (Principal) auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		return "admin/pages/orders/create";
	}

	/**
	 * 
	 * @param auth
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/upload")
	public String uploadOrder(Authentication auth, Model model) {
		return "admin/pages/orders/upload";
	}
}
