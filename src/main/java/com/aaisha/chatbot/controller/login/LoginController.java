/**
 * 
 */
package com.aaisha.chatbot.controller.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aaisha.chatbot.entity.ChatBotUser;

/**
 * @author Bhanwar
 *
 */
@Controller
public class LoginController {
	private static final Logger LOG = LogManager.getLogger(LoginController.class);
	@GetMapping(path = {"","/","/v1","/v1/","/v1/login"})
	public String getLoginForm(Model model) {
		model.addAttribute("chatBotUser", new ChatBotUser());
		LOG.info("user fetching login page");
		return "index";
	}
}
