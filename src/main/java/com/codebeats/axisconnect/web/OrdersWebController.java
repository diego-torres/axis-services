/**
 * 
 */
package com.codebeats.axisconnect.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codebeats.axisconnect.web.serviceOrders.ServiceOrderService;

/**
 * 
 * @author dtorresf
 *
 */
@Controller
@RequestMapping(path = "orders")
public class OrdersWebController {

	@Autowired
	public ServiceOrderService orderService;

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
		model.addAttribute("serviceOrders", orderService.getActiveServiceOrders());
		return "admin/pages/orders/list";
	}
	
	/**
	 * 
	 * @param auth
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/closed")
	public String ordersClosedList(Authentication auth, Model model) {
		Principal principal = (Principal) auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		model.addAttribute("serviceOrders", orderService.getActiveServiceOrders());
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
