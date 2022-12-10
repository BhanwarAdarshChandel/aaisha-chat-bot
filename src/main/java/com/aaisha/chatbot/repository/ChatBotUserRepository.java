/**
 * 
 */
package com.aaisha.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.ChatBotUser;

/**
 * @author Bhanwar
 *
 */
public interface ChatBotUserRepository extends JpaRepository<ChatBotUser, String> {

}
