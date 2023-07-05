/**
 * 
 */
package com.aaisha.chatbot.controller.fee;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.ChatBotUserQuestion;
import com.aaisha.chatbot.entity.Fee;
import com.aaisha.chatbot.service.fee.FeeService;
import com.aaisha.chatbot.service.registration.RegistrationService;

/**
 * @author Bhanwar
 *
 */
@Controller
@RequestMapping(path="/v1/home/chatbot/fee")
public class FeeController {
	private static final Logger LOG =LoggerFactory.getLogger(FeeController.class);
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private FeeService feeServiceImpl;
	
	@GetMapping("/{stream}/{timestamp}")
	public String getBCAFee(@PathVariable String stream,@PathVariable("timestamp") Integer timestamp,
	Model model, Principal principal) {
		String page="";
		String email = principal.getName();
		ChatBotUser user = registrationService.findById(email);
		List<Fee> fees =feeServiceImpl.getFeeByStream(stream.toUpperCase());
		model.addAttribute("user", user);
		model.addAttribute("question", new ChatBotUserQuestion());
		model.addAttribute("fee", fees);
		if(user.getAuthorities().contains("STUDENT")) {
			LOG.info("STUDENT "+email+" fetching BCA fee records");
			page= "/user/chatbot";
		}else if(user.getAuthorities().contains("ADMIN")){
			LOG.info("ADMIN "+email+" fetching BCA fee records");
			page= "/admin/adminchatbot";
		}
		return page; 
	}
}
