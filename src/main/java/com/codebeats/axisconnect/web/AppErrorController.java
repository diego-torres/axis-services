/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dtorresf
 *
 */
@Controller
public class AppErrorController implements ErrorController {

	@RequestMapping("/error")
	public String handleError() {
		return "public/error";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.web.servlet.error.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
