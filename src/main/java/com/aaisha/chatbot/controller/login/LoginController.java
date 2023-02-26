/**
 * 
 */
package com.aaisha.chatbot.controller.login;

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

	@GetMapping(path = {"","/","/v1","/v1/","/v1/login"})
	public String getLoginForm(Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		return "index";
	}
}
