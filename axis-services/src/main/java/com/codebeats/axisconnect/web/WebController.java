/**
 * 
 */
package com.codebeats.axisconnect.web;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dtorresf
 *
 */
@Controller
public class WebController {

	@GetMapping(path = "/")
	public String index() {
		return "public/index";
	}

	@GetMapping(path = "/admin")
	public String admin(Authentication auth, Model model) {
		Principal principal = (Principal)auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		return "admin/pages/index";
	}

}
