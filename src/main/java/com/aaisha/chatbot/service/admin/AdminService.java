/**
 * 
 */
package com.aaisha.chatbot.service.admin;

import java.util.List;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.QuestionAndAnswer;
import com.aaisha.chatbot.entity.TimeTable;
import com.aaisha.chatbot.entity.UnknownQuestion;

/**
 * @author Bhanwar
 *
 */
public interface AdminService {
public List<UnknownQuestion> getUnansweredQuestion();
public ChatBotUser findById(String email);
public void deleteUnansweredQuestionById(Integer id);
public UnknownQuestion findUnansweredQuestionById(Integer id);
public void saveAnswer(QuestionAndAnswer questionAndAnswer);
public void saveTimeTable(TimeTable timeTable);
public List<TimeTable> getAllTimeTable();
public void deleteTimeTableById(Integer id);
public TimeTable getTimeTableById(Integer id);
}
