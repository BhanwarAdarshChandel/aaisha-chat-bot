/**
 * 
 */
package com.aaisha.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;

/**
 * @author Bhanwar
 *
 */
@Controller
public class RegistrationController {

	@GetMapping("/register")
	public String getRegistrationForm(Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("chatBotUser") ChatBotUser chatBotUser,Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		return "register";
	}
}
