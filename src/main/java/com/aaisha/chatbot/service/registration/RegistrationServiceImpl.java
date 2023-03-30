/**
 * 
 */
package com.aaisha.chatbot.service.registration;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.repository.ChatBotUserRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class RegistrationServiceImpl implements RegistrationService{
	private static final Logger LOG =LoggerFactory.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ChatBotUserRepository chatBotUserRepository;
	
	@Override
	public boolean registerUser(ChatBotUser chatBotUser) {
		LOG.info("Register user : "+chatBotUser.getUsername());
		Optional<ChatBotUser> user=chatBotUserRepository.findById(chatBotUser.getUsername());
		if(user.isPresent()) {
			LOG.info("User : "+chatBotUser.getUsername()+" already registered");
			return false;
		}else {
			LOG.info("User : "+chatBotUser.getUsername()+" registered successfully");
			chatBotUser.setAccountNonExpired(true);
			chatBotUser.setAccountNonLocked(true);
			chatBotUser.setAuthorities("STUDENT");
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
		LOG.info("find user by id : "+userEmail);
		Optional<ChatBotUser> user= chatBotUserRepository.findById(userEmail);
		if(user.isPresent()) {
			LOG.info("user : "+userEmail+" available");
			return user.get();
		}
		LOG.info("user : "+userEmail+" not found");
		return null;
	}

	
}
