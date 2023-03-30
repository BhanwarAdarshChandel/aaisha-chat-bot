/**
 * 
 */
package com.aaisha.chatbot.service.user.detail;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.repository.ChatBotUserRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger LOG =LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private ChatBotUserRepository chatBotUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		LOG.info("find user by username : "+username);
		Optional<ChatBotUser> users=chatBotUserRepository.findById(username);
		if(users.isPresent()) {
			LOG.info("user result found by username : "+username);
			ChatBotUser user =users.get();
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getAuthorities());
			return new User(user.getUsername(), 
					user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), 
					Arrays.asList(simpleGrantedAuthority));
		}else {
			LOG.error("user result not found by username : "+username);
			 throw new UsernameNotFoundException(username +"not found");
		}
	}

}
