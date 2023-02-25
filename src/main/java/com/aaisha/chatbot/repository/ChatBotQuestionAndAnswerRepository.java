package com.aaisha.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.QuestionAndAnswer;

public interface ChatBotQuestionAndAnswerRepository extends JpaRepository<QuestionAndAnswer, Integer> {	
public List<QuestionAndAnswer> findByQuestionIgnoreCase(String question);
}
