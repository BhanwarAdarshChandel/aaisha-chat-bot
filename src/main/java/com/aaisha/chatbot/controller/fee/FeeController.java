/**
 * 
 */
package com.aaisha.chatbot.controller.fee;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.ChatBotUserQuestion;
import com.aaisha.chatbot.service.fee.FeeService;
import com.aaisha.chatbot.service.registration.RegistrationService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path="/v1/home/chatbot/fee")
public class FeeController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private FeeService feeServiceImpl;
	
	@GetMapping("/bca/{timestamp}")
	public String getBCAFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("BCA"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page; 
	}
	
	@GetMapping("/mca/{timestamp}")
	public String getMCAFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("MCA"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page; 
	}
	
	@GetMapping("/msc/{timestamp}")
	public String getMScFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("MSc"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page; 
	}
}