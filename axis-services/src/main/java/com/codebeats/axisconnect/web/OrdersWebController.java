/**
 * 
 */
package com.codebeats.axisconnect.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codebeats.axis.ServiceOrderRequest;
import com.codebeats.axisconnect.web.jbpm.sor.ServiceOrderRequestService;
import com.codebeats.axisconnect.web.serviceOrders.PartialServiceOrder;
import com.codebeats.axisconnect.web.serviceOrders.PartialServiceOrderComment;
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
	
	@Autowired
	public ServiceOrderRequestService sorService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

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
		model.addAttribute("serviceOrderRequests", sorService.getActiveSor(principal.getName()));
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
		model.addAttribute("serviceOrders", orderService.getClosedServiceOrders());
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
	@PostMapping("/create")
	public String createServiceOrder(@ModelAttribute("serviceOrderForm") ServiceOrderRequest sor, Authentication auth) {
		Principal principal = (Principal) auth.getPrincipal();
		sorService.addServiceOrderRequest(sor, principal.getName());
		return "redirect:/orders/";
	}

	/**
	 * 
	 * @param orderId
	 * @return
	 */
	@GetMapping("partial/{orderId}/comments")
	@ResponseBody
	public List<PartialServiceOrderComment> getPartialServiceOrderComments(@PathVariable("orderId") Integer orderId) {
		PartialServiceOrder pso = orderService.getPartialServiceOrderById(orderId);
		return pso.getComments();
	}

	@PostMapping("partial/comments")
	@ResponseBody
	public PartialServiceOrderComment addPartialOrderComment(@RequestBody PartialServiceOrderComment comment) {
		PartialServiceOrder pso = orderService.getPartialServiceOrderById(comment.getId());
		if (pso == null)
			return null;
		PartialServiceOrderComment psoc = new PartialServiceOrderComment();
		psoc.setComment(comment.getComment());

		psoc.setFromUser("system");
		// psoc.setFromUser(auth.getPrincipal().toString());
		pso.addComment(psoc);
		orderService.updatePartialServiceOrder(pso);
		return psoc;
	}

	/**
	 * 
	 * @param auth
	 * @param model
	 * @param sOrderId
	 * @return
	 */
	@GetMapping("/details/{sOrderId}")
	public String editServiceOrder(Authentication auth, Model model, @PathVariable String sOrderId) {
		String sId = sOrderId.substring(2);
		Integer id = Integer.parseInt(sId);
		if (sOrderId.startsWith("AX")) {
			return "admin/pages/orders/detail";
		} else {
			PartialServiceOrder pso = orderService.getPartialServiceOrderById(id);
			model.addAttribute("order", pso);
			String principal = "Anonymous";
			if (auth != null) {
				principal = auth.getPrincipal().toString();
			}
			model.addAttribute("principal", principal);

			return "admin/pages/orders/update";
		}
	}

	@PostMapping("/update")
	public String updateServiceOrder(PartialServiceOrder pso) {
		if (!pso.isStartProcessInstance()) {
			orderService.updatePartialServiceOrder(pso);
		}
		return "redirect:/orders/";
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
	@PostMapping("/upload")
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
