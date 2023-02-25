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
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("BCA"));
		return "/user/chatbot"; 
	}
	
	@GetMapping("/mca/{timestamp}")
	public String getMCAFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("MCA"));
		return "/user/chatbot"; 
	}
	
	@GetMapping("/msc/{timestamp}")
	public String getMScFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", feeServiceImpl.getFeeByStream("MSc"));
		return "/user/chatbot"; 
	}
}
