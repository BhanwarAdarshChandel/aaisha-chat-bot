/**
 * 
 */
package com.aaisha.chatbot.controller.admin.timetable;

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
import com.aaisha.chatbot.entity.TimeTable;
import com.aaisha.chatbot.service.admin.AdminService;
import com.aaisha.chatbot.util.ChatBotUtil;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path = "/v1/admin")
public class AdminTimeTableController {
	private static final Logger LOG =LoggerFactory.getLogger(AdminTimeTableController.class);
	@Autowired
	private AdminService adminServiceImpl;

	@GetMapping(path = "/timetable/{timestamp}")
	public String getTimeTablePage(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" time table page");
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("timeTable", new TimeTable());
		return "admin/timetable";
	}

	@PostMapping(path = "/add/timetable/{timestamp}")
	public String saveTimeTablePage(
			@PathVariable("timestamp") Integer timestamp, Model model,
			Principal principal,
			@Valid @ModelAttribute("timeTable") TimeTable timeTable) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" adding time table record");
		ChatBotUser user = adminServiceImpl.findById(email);
		adminServiceImpl.saveTimeTable(timeTable);
		return "redirect:/v1/admin/timetable/" + timestamp + "?success";
	}

	@GetMapping(path = "all/timetable/{timestamp}")
	public String getAllTimeTable(@PathVariable("timestamp") Integer timestamp,
			Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" fetching all time table records");
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("timeTables", adminServiceImpl.getAllTimeTable());
		return "admin/alllistoftimetable";
	}

	@GetMapping(path = "delete/timetable/{timestamp}/{id}")
	public String deleteTimeTableById(
			@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id, Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" deleting time table record by id");
		ChatBotUser user = adminServiceImpl.findById(email);
		adminServiceImpl.deleteTimeTableById(id);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/all/timetable/" + timestamp + "?delete";
	}

	@GetMapping(path = "/update/timetable/{timestamp}/{id}")
	public String getUpdateFormById(
			@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id, Model model, Principal principal) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" fetching time table record by id for update");
		ChatBotUser user = adminServiceImpl.findById(email);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("user", user);
		model.addAttribute("id", id);
		model.addAttribute("streams", ChatBotUtil.getStream());
		model.addAttribute("timeTable", adminServiceImpl.getTimeTableById(id));
		return "admin/updatetimetable";
	}

	@PostMapping(path = "/update/timetable/{timestamp}/{id}")
	public String updateTimeTable(@PathVariable("timestamp") Integer timestamp,
			@PathVariable("id") Integer id,
			 Model model, Principal principal,
			@Valid @ModelAttribute("timeTable") TimeTable timeTable) {
		String email = principal.getName();
		LOG.info("ADMIN "+email+" updating time table record by id");
		ChatBotUser user = adminServiceImpl.findById(email);
		adminServiceImpl.saveTimeTable(timeTable);
		model.addAttribute("user", user);
		return "redirect:/v1/admin/all/timetable/" + timestamp + "?update";
	}
}
