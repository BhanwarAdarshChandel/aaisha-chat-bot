/**
 * 
 */
package com.aaisha.chatbot.controller.chatbot;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ChatBotController {
	@Autowired
	private ChatBotUserAskedQuestionService chatBotUserAskedQuestionService;
	
	@Autowired
	private TimeTableService timeTableService;
	
	@Autowired
	private FeeService feeServiceImpl;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/chatbot/{timestamp}")
	public String getChatBot(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", false);
		model.addAttribute("answer", "");
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("user", user);
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/course/{timestamp}")
	public String getChatBotCourse(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "<h1>Hello</>");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/about/{timestamp}")
	public String getChatBotAbout(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "About");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/fee/{timestamp}")
	public String getChatBotFee(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", false);
		model.addAttribute("user", user);
		model.addAttribute("fee", feeServiceImpl.getAllFee());
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/batch/{timestamp}")
	public String getChatBotBatch(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Batch");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/exam/{timestamp}")
	public String getChatBotExam(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Exam");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/timetable/{timestamp}")
	public String getChatBotTimeTable(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", false);
		model.addAttribute("timetable", timeTableService.getAllTimeTable());
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/faculty/{timestamp}")
	public String getChatBotFaculty(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Faculty");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/address/{timestamp}")
	public String getChatBotAddress(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Address");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@GetMapping("/chatbot/contactus/{timestamp}")
	public String getChatBotContactUs(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Contact us");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

	@PostMapping("/chatbot/question/{timestamp}")
	public String getChatBotQuestion(
			@PathVariable("timestamp") Integer timestamp,
			@Valid @ModelAttribute("question") ChatBotUserQuestion question,
			Model model, Principal principal) {
		String page="";
		question.setUseremail(principal.getName());
		question.setTimestamp(timestamp);
		String answer=chatBotUserAskedQuestionService.userQuestion(question);
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", answer);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("user", user);
		if(user.getAuthorities().contains("STUDENT")) {
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			page= "/admin/adminchatbot";
		}
		return page;
	}

}
