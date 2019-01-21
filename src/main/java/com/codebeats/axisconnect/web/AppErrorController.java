/**
 * 
 */
package com.codebeats.axisconnect.web;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * @author dtorresf
 *
 */
@Controller
public class AppErrorController implements ErrorController {

	private final ErrorAttributes errorAttributes;

	public AppErrorController(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}

	@RequestMapping("/error")
	public String handleError(Model model, WebRequest webRequest) {
		System.out.println("Handling error");
		final Throwable error = errorAttributes.getError(webRequest);
		model.addAttribute("exception", error);
		model.addAttribute("message", error == null ? "" : error.getMessage());
		System.out.println(error);
		if(error != null) error.printStackTrace();
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
