/**
 * 
 */
package com.aaisha.chatbot.controller.chatbot;

import java.security.Principal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG =LoggerFactory.getLogger(ChatBotController.class);
	@Autowired
	private ChatBotUserAskedQuestionService chatBotUserAskedQuestionService;
	
	@Autowired
	private TimeTableService timeTableService;
	
	@Autowired
	private FeeService feeServiceImpl;
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/chatbot/course/{timestamp}")
	public String getChatBotCourse(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Bunts Sangha’s S.M.Shetty College of Science, Commerce and Management Studies were established in 2008 by Bunts Sangha, Mumbai. The college is affiliated to the University of Mumbai.\r\n"
				+ "\r\n"
				+ "Bunts Sangha, Mumbai was established in 1927 as a Charitable Trust and devoted itself to the cause of education, health care and social reforms of downtrodden and underprivileged class of people. The Sangha has been in the service of people for almost nine decades. Initially, the Sangha established two night schools mainly to cater the needs of working students during the day time. During the last decade, more emphasis was given to the education for the masses.\r\n"
				+ "\r\n"
				+ "Bunt’s Sangha’s S.M. Shetty College of Science, Commerce and Management Studies is committed to the promotion and propagation of quality education with excellence. The main focus is to impart domain specific knowledge, flexible skill mix, positive attitudes, ethically sound values and continuous learning habits through reflective thinking in a student. The objective is to unleash the human potential within students for excelling in the chosen educational field. Our earnest attempt is to see that all this should take place with a sense of purpose, pride, direction and commitment."
				+ "\r\n"
				+". For more information please visit our college website https://smshettycollege.edu.in/");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot course details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot course details");
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
		model.addAttribute("answer", "Our college provide number of Graduate Programs like BCOM, BAF, BBI, BMS, BMM/BAMMC, BSCIT, DATA SCIENCE."
				+ "\r\n"
				+ "Post Graduate Programs like MCOM in Advanced Accountancy, MSCIT, MCOM in Business Management"
				+ "\r\n"
				+ "Certificate Programmes like TALLY & ERP, FINANCIAL MARKETS, DIGITAL MARKETING, PHOTOSHOP, GRAPHIC DESIGNING, MICROSOFT CERTIFICATIONS, DIGITAL DESIGN, RUBY ON RAILS, RESEARCH METHODOLOGY"
				+ "\r\n"
				+ ". For more information please visit our college website https://smshettycollege.edu.in/");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot about details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot about details");
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
			LOG.info("STUDENT "+email+" fetching chatbot fee details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot fee details");
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
		model.addAttribute("answer", "No information available for batch. For more information please visit our college website https://smshettycollege.edu.in/");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot batch details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot batch details");
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
		model.addAttribute("answer", "No information available for exam. For more information please visit our college website https://smshettycollege.edu.in/");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot exam details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot exam details");
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
			LOG.info("STUDENT "+email+" fetching chatbot time table details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot time table details");
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
		model.addAttribute("answer", "our college have best faculty. Department of commerce faculty Dr. Sridhara Shetty(Principal and Head of Department, Commerce), Ms. Sahana Raviprasad(Coordinator, Commerce),"
				+" Dr. Vijay Vishwakarma(Assistant Professor, Commerce), Mr. John Menezes(Assistant Professor, Commerce), Ms. Niveditha Shetty(Assistant Professor, Commerce), Adv.Jyoti Sharma(Assistant Professor, Commerce)."
				+" Department of Accountancy faculty CS Sandesha Shetty(Head of Department, Accountancy), Mr.Virendra Singh(Assistant Professor, Accountancy), Ms. Komal Tiwari(Assistant Professor, Accountancy)"
				+ ". For more information please visit our college website https://smshettycollege.edu.in/"
				);
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot faculty details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot faculty details");
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
		model.addAttribute("answer", "Hiranandani Gardens, Powai,\r\n"
				+ "Mumbai- 400076, Maharashtra");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot address details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot address details");
			page= "/admin/adminchatbot";
		}
		return page;
	}
	
	@GetMapping("/chatbot/{timestamp}")
	public String getChatBot(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("result", true);
		model.addAttribute("answer", "Hi this is Black Pink. How can I help you? Please choose relevant above option or you can write your question in below input box");
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("user", user);
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot page");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot page");
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
		model.addAttribute("answer", "\r\n"
				+ "Mail Us : hrd@smshettyinstitute.org "
				+ "\r\n"
				+ "Contact Us : 02261327305 | 02261327306"
				+ "\r\n"
				+ " For more information please visit our college website https://smshettycollege.edu.in/");
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching chatbot Caontact US details");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching chatbot Contact US details");
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
			LOG.info("STUDENT "+email+" asking question");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" asking question");
			page= "/admin/adminchatbot";
		}
		return page;
	}

}
