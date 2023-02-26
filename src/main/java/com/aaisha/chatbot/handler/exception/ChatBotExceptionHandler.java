/**
 * 
 */
package com.aaisha.chatbot.handler.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aaisha.chatbot.entity.ChatBotUser;

/**
 * @author Bhanwar
 *
 */
@ControllerAdvice
public class ChatBotExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest httpServletRequest,Exception exception,Model model) {
		exception.printStackTrace();
		System.out.println(httpServletRequest.getRequestURI());
		model.addAttribute("chatBotUser", new ChatBotUser());
		model.addAttribute("err", true);
		return "index";
	}
	
	@ExceptionHandler(BindException.class)
	public String handleBindException(HttpServletRequest httpServletRequest,Exception exception,Model model) {
		exception.printStackTrace();
		System.out.println(httpServletRequest.getRequestURI());
		if(httpServletRequest.getRequestURI().equalsIgnoreCase("/v1/register/process")) {
			return "redirect:/v1/register?error";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/admin/submitunansweredquestionsanswer")) {
			return "redirect:/v1/admin/unansweredquestion/{timestamp}?error";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/admin/add/timetable/")) {
			return "redirect:/v1/admin/timetable/{timestamp}?error";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/admin/update/timetable/")) {
			return "redirect:/v1/admin/update/timetable/{timestamp}/{id}?error";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/home/chatbot/question/")) {
			return "redirect:/v1/home/chatbot/{timestamp}?question";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/admin/fee/add/")) {
			return "redirect:/v1/admin/fee/{timestamp}?error";
		}
		if(httpServletRequest.getRequestURI().contains("/v1/admin/fee/update/")) {
			return "redirect:/v1/admin/fee/update/{timestamp}/{id}?error";
		}
		return "index";
	}

///v1/admin/update/timetable/755879100/4
}
