/**
 * 
 */
package com.aaisha.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.ChatBotUserQuestion;

/**
 * @author Bhanwar
 *
 */
public interface ChatBotUserQuestionRepository extends JpaRepository<ChatBotUserQuestion, Integer> {

}
