/**
 * 
 */
package com.aaisha.chatbot.controller.home;

import java.security.Principal;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.service.registration.RegistrationService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path = "/v1/home")
public class HomeController {
	private static final Logger LOG =LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private RegistrationService registrationService;

	@GetMapping(path = "/")
	public String getHome(Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser chatbotUser = registrationService.findById(email);
		model.addAttribute("timestamp", ZonedDateTime.now().getNano());
		model.addAttribute("user", chatbotUser);
		if(chatbotUser.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching home page");
			page= "/user/home";
		}else if(chatbotUser.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching home page");
			page= "/admin/home";
		}
		return page;
	}

}
