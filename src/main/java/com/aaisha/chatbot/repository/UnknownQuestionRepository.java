/**
 * 
 */
package com.aaisha.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.UnknownQuestion;

/**
 * @author Bhanwar
 *
 */
public interface UnknownQuestionRepository extends JpaRepository<UnknownQuestion, Integer> {

}
