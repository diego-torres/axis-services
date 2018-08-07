/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.stereotype.Controller;
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
	public String admin() {
		return "admin/index.html";
	}
	
	@GetMapping(path = "/dashboard")
	public String dashboard() {
		return "admin/pages/index.html";
	}
}
