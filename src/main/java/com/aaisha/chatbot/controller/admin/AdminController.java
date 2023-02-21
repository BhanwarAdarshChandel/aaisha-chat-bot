package com.aaisha.chatbot.controller.admin;

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
import com.aaisha.chatbot.entity.QuestionAndAnswer;
import com.aaisha.chatbot.entity.TimeTable;
import com.aaisha.chatbot.entity.UnknownQuestion;
import com.aaisha.chatbot.service.admin.AdminService;

@Controller
@RequestMapping(path = "/v1/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminServiceImpl;

	@GetMapping(path = "/unansweredquestion/{timestamp}")
	public String unansweredQuestion(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("unansweredQuestion",
				adminServiceImpl.getUnansweredQuestion());
		model.addAttribute("questionAndAnswer", new QuestionAndAnswer());
		model.addAttribute("user", user);
		return "/admin/unansweredquestion";
	}

	@PostMapping(path = "/submitunansweredquestionsanswer/{qid}/{timestamp}")
	public String submitUnansweredQuestionsAnswer(
			@PathVariable("qid") Integer qid,
			@PathVariable("timestamp") Integer timestamp, Model model,
			@Valid @ModelAttribute(name = "questionAndAnswer")QuestionAndAnswer questionAndAnswer,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		UnknownQuestion unknownQuestion=adminServiceImpl.findUnansweredQuestionById(qid);
		adminServiceImpl.saveAnswer(new QuestionAndAnswer(unknownQuestion.getQuestion().toLowerCase(), questionAndAnswer.getAnswer()));
		adminServiceImpl.deleteUnansweredQuestionById(qid);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/unansweredquestion/"+timestamp;
	}
	
	@GetMapping(path="/timetable/{timestamp}")
	public String getTimeTablePage(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("timeTable", new TimeTable());
		return "admin/timetable";
	}
	
	@PostMapping(path="/add/timetable/{timestamp}")
	public String saveTimeTablePage(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal,@Valid @ModelAttribute("timeTable")TimeTable timeTable) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		adminServiceImpl.saveTimeTable(timeTable);
		return "redirect:/v1/admin/timetable/"+timestamp+"?success";
	}
	
	@GetMapping(path="all/timetable/{timestamp}")
	public String getAllTimeTable(@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("timeTables", adminServiceImpl.getAllTimeTable());
		return "admin/alllistoftimetable";
	}
	
	@GetMapping(path="delete/timetable/{timestamp}/{id}")
	public String deleteTimeTableById(@PathVariable("timestamp") Integer timestamp,@PathVariable("id") Integer id, Model model,
			Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		adminServiceImpl.deleteTimeTableById(id);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/all/timetable/"+timestamp+"?delete";
	}
	@GetMapping(path="/update/timetable/{timestamp}/{id}")
public String getUpdateFormById(@PathVariable("timestamp") Integer timestamp,@PathVariable("id") Integer id, Model model,
		Principal principal) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("id", id);
		model.addAttribute("user", user);
		model.addAttribute("timeTable", adminServiceImpl.getTimeTableById(id));
		return "admin/updatetimetable";
}
	@PostMapping(path="/update/timetable/{timestamp}/{id}")
	public String updateTimeTable(@PathVariable("timestamp") Integer timestamp,@PathVariable("id") Integer id, Model model,
			Principal principal,@Valid @ModelAttribute("timeTable")TimeTable timeTable) {
		String email = principal.getName();
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/all/timetable/"+timestamp+"?update";
	}
}
