/**
 * 
 */
package com.aaisha.chatbot.controller.admin.fee;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.Fee;
import com.aaisha.chatbot.service.admin.AdminService;
import com.aaisha.chatbot.service.fee.FeeService;
import com.aaisha.chatbot.util.ChatBotUtil;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path="/v1/admin/fee")
public class AdminFeeController {
	private static final Logger LOG =LoggerFactory.getLogger(AdminFeeController.class);
	@Autowired
	private AdminService adminServiceImpl;
	
	@Autowired
	private FeeService feeServiceImpl;
	
	@GetMapping(path="/{timestamp}")
	public String getAdminFeePage(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		LOG.info("ADMIN "+email+" fetching admin fee page");
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("fee", new Fee());
		return "admin/feehome";
	}
	
	@PostMapping(path="/add/{timestamp}")
	public String addFee(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal,@Valid @ModelAttribute("fee")Fee fee) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" adding fee in record");
		ChatBotUser user = adminServiceImpl.findById(email);
		feeServiceImpl.aadFee(fee);
		return "redirect:/v1/admin/fee/"+timestamp+"?success";
	}
	
	@GetMapping(path="/all/{timestamp}")
	public String getAllFeeRecord(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" fetching all fee records");
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("fee", feeServiceImpl.getAllFee());
		return "admin/alllistoffee";	
		}
	
	@GetMapping(path = "/delete/{timestamp}/{id}")
	public String deleteTimeTableById(
			@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id, Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" deleting fee record");
		ChatBotUser user = adminServiceImpl.findById(email);
		feeServiceImpl.deleteFeeRecordById(id);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/fee/all/" + timestamp + "?delete";
	}
	
	@GetMapping(path = "/update/{timestamp}/{id}")
	public String getUpdateFormById(
			@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id, Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" fetching fee record by id for update");
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("fee", feeServiceImpl.getFeeById(id));
		model.addAttribute("id", id);
		model.addAttribute("streams", ChatBotUtil.getStream());
		return "admin/updatefee";
	}
	
	@PostMapping(path = "/update/{timestamp}/{id}")
	public String updateFeeById(@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id, Model model, Principal principal,
			@Valid @ModelAttribute("fees") Fee fees) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		LOG.info("ADMIN "+email+" updating fee record by id");
		feeServiceImpl.aadFee(fees);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/fee/all/" + timestamp + "?update";
	}
}
