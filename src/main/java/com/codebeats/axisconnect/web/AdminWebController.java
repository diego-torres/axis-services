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
 * @author dtorresf
 *
 */
@Controller
@RequestMapping(path="admin")
public class AdminWebController {
	@GetMapping(path = "/")
	public String admin(Authentication auth, Model model) {
		//System.out.println(auth.getAuthorities().);
		//auth.getAuthorities().stream().forEach( p -> {System.out.println(p.getAuthority());});
		Principal principal = (Principal)auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		return "admin/index";
	}
	
	@GetMapping(path = "/dashboard")
	public String dashboard(Authentication auth, Model model) {
		//System.out.println(auth.getAuthorities().);
		//auth.getAuthorities().stream().forEach( p -> {System.out.println(p.getAuthority());});
		Principal principal = (Principal)auth.getPrincipal();
		model.addAttribute("principal", principal.getName());
		return "admin/pages/index";
	}
}
