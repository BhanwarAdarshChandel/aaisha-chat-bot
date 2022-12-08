/**
 * 
 */
package com.aaisha.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;

/**
 * @author Bhanwar
 *
 */
@Controller
public class LoginController {
	
	@GetMapping(path="/login")
	public String getLoginForm(Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		return "login";
	}
	
	@PostMapping(path="/login")
	public String login(Model model) {
		model.addAttribute("", "");
		return "home";
	}

}
