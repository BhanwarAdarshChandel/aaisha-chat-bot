/**
 * 
 */
package com.aaisha.chatbot.handler.exception;

import org.springframework.ui.Model;
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
	public String handleException(Exception exception,Model model) {
		System.out.println(exception.getStackTrace());
		model.addAttribute("chatBotUser", new ChatBotUser());
		model.addAttribute("err", true);
		return "index";
	}

}
