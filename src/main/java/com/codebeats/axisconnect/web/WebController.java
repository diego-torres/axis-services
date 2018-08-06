/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author dtorresf
 *
 */
@Controller
public class WebController {
	@GetMapping(path = "/")
	public String index() {
		return "public/index.html";
	}
}
