/**
 * 
 */
package com.codebeats.axisconnect.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.codebeats.axisconnect.web.serviceOrders.ServiceOrderService;

/**
 * 
 * @author dtorresf
 *
 */
@Controller
@RequestMapping(path = "orders")
public class OrdersWebController {

	@Value("${ServiceOrders.uploadDirectory}")
	private String uploadDirectory;

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

	/**
	 * 
	 * @param ordersFile
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("ordersFile") MultipartFile[] ordersFiles) throws IOException {
		System.out.println("Uploading!");
		for (MultipartFile f : ordersFiles) {
			File file = new File(uploadDirectory + nowToFileName(FilenameUtils.getExtension(f.getOriginalFilename())));
			f.transferTo(file);
		}
		return "redirect:/orders/";
	}

	private String nowToFileName(String extension) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "." + extension;
	}
}
