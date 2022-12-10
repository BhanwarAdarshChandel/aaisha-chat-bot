/**
 * 
 */
package com.aaisha.chatbot.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.service.registration.RegistrationService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path="/v1")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		return "register";
	}
	
	@PostMapping("/register/process")
	public String register(@ModelAttribute("chatBotUser") ChatBotUser chatBotUser,RedirectAttributes attr,Model model) {
		boolean result=registrationService.registerUser(chatBotUser);
		if(result) {
			attr.addFlashAttribute("chatBotUser", new ChatBotUser());
			attr.addFlashAttribute("result", true);
			attr.addFlashAttribute("user", chatBotUser.getUsername());
			return "redirect:/v1/login";
		}else {
			attr.addFlashAttribute("chatBotUser", new ChatBotUser());
			attr.addFlashAttribute("result", true);
			attr.addFlashAttribute("user", chatBotUser.getUsername());
			return "redirect:/v1/register";
		}
	}
}
