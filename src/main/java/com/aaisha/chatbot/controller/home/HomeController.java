/**
 * 
 */
package com.aaisha.chatbot.controller.home;

import java.security.Principal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.ChatBotUserQuestion;
import com.aaisha.chatbot.service.fee.FeeService;
import com.aaisha.chatbot.service.registration.RegistrationService;
import com.aaisha.chatbot.service.timetable.TimeTableService;
import com.aaisha.chatbot.service.user.asked.question.ChatBotUserAskedQuestionService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path = "/v1/home")
public class HomeController {

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
			page= "/user/home";
		}else if(chatbotUser.getAuthorities().contains("ADMIN")){
			page= "/admin/home";
		}
		return page;
	}

}
