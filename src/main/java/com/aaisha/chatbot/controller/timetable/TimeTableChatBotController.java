/**
 * 
 */
package com.aaisha.chatbot.controller.timetable;

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
	public String getBCATimeTable(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("BCA"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page; 
	}
	
	@GetMapping("/mca/{timestamp}")
	public String getMCATimeTable(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("MCA"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}
	
	@GetMapping("/msc/{timestamp}")
	public String getMSCTimeTable(@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("timetable", timeTableService.getTimeTableByStream("MSc"));
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page; 
	}

}