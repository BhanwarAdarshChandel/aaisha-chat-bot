/**
 * 
 */
package com.aaisha.chatbot.service.registration;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Sets;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.repository.ChatBotUserRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ChatBotUserRepository chatBotUserRepository;
	
	@Override
	public boolean registerUser(ChatBotUser chatBotUser) {
		Optional<ChatBotUser> user=chatBotUserRepository.findById(chatBotUser.getUsername());
		if(user.isPresent()) {
			return false;
		}else {
			chatBotUser.setAccountNonExpired(true);
			chatBotUser.setAccountNonLocked(true);
			chatBotUser.setAuthorities("USER");
			chatBotUser.setCredentialsNonExpired(true);
			chatBotUser.setEnabled(true);
			chatBotUser.setPassword(bCryptPasswordEncoder.encode(chatBotUser.getPassword()));
			chatBotUser.setUsername(chatBotUser.getUsername());
			chatBotUserRepository.save(chatBotUser);
			return true;
		}
	}

	@Override
	public ChatBotUser findById(String userEmail) {
		Optional<ChatBotUser> user= chatBotUserRepository.findById(userEmail);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	
}
