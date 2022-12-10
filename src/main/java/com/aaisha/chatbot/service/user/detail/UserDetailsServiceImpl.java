/**
 * 
 */
package com.aaisha.chatbot.service.user.detail;

import java.util.Arrays;
import java.util.Optional;

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
	
	@Autowired
	private ChatBotUserRepository chatBotUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<ChatBotUser> users=chatBotUserRepository.findById(username);
		if(users.isPresent()) {
			ChatBotUser user =users.get();
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getAuthorities());
			return new User(user.getUsername(), 
					user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), 
					Arrays.asList(simpleGrantedAuthority));
		}else {
			 throw new UsernameNotFoundException(username +"not found");
		}
	}

}
