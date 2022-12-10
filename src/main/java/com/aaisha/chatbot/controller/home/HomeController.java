/**
 * 
 */
package com.aaisha.chatbot.controller.home;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.repository.ChatBotUserRepository;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path="/v1/home")
public class HomeController {
	
	@Autowired
	private ChatBotUserRepository chatBotUserRepository;
	
	@ModelAttribute
	private void userDetails(Model model, Principal p) {
		String email = p.getName();
		Optional<ChatBotUser> user = chatBotUserRepository.findById(email);
		model.addAttribute("user", user.get());
	}

	@GetMapping(path="/")
	public String getHome() {
		return "/user/home";
	}

}
