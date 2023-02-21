/**
 * 
 */
package com.aaisha.chatbot.controller.chatbot;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.ChatBotUserQuestion;
import com.aaisha.chatbot.service.registration.RegistrationService;
import com.aaisha.chatbot.service.timetable.TimeTableService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path = "/v1/home/chatbot/timetable")
public class TimeTableChatBotController {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private TimeTableService timeTableService;
	
	@GetMapping("/bca/{timestamp}")
	public String getBCAFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("BCA"));
		return "/user/chatbot"; 
	}
	
	@GetMapping("/mca/{timestamp}")
	public String getMCAFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("mca"));
		return "/user/chatbot"; 
	}
	
	@GetMapping("/msc/{timestamp}")
	public String getMScFee(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("msc"));
		return "/user/chatbot"; 
	}

}
