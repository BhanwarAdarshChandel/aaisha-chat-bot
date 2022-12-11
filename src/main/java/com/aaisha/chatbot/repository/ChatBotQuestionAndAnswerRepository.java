package com.aaisha.chatbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.QuestionAndAnswer;

public interface ChatBotQuestionAndAnswerRepository extends JpaRepository<QuestionAndAnswer, Integer> {	
public QuestionAndAnswer findByQuestionIgnoreCase(String question);
}
