/**
 * 
 */
package com.aaisha.chatbot.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.ChatBotUser;
import com.aaisha.chatbot.entity.QuestionAndAnswer;
import com.aaisha.chatbot.entity.TimeTable;
import com.aaisha.chatbot.entity.UnknownQuestion;
import com.aaisha.chatbot.repository.ChatBotQuestionAndAnswerRepository;
import com.aaisha.chatbot.repository.TimeTableRepository;
import com.aaisha.chatbot.repository.UnknownQuestionRepository;
import com.aaisha.chatbot.service.registration.RegistrationService;

/**
 * @author Bhanwar
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private ChatBotQuestionAndAnswerRepository chatBotQuestionAndAnswerRepository;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private UnknownQuestionRepository unknownQuestionRepository;
	@Autowired
	private TimeTableRepository timeTableRepository;

	@Override
	public List<UnknownQuestion> getUnansweredQuestion() {
		List<UnknownQuestion> unknownQuestions = unknownQuestionRepository
				.findAll();
		if (!unknownQuestions.isEmpty()) {
			return unknownQuestions;
		}
		return null;
	}

	@Override
	public ChatBotUser findById(String email) {
		return registrationService.findById(email);
	}
	@Override
	public UnknownQuestion findUnansweredQuestionById(Integer id) {
		return unknownQuestionRepository.findById(id).get();
	}
	@Override
	public void deleteUnansweredQuestionById(Integer id) {
		unknownQuestionRepository.deleteById(id);
	}

	@Override
	public void saveAnswer(QuestionAndAnswer questionAndAnswer) {
		chatBotQuestionAndAnswerRepository.save(questionAndAnswer);
	}

	@Override
	public void saveTimeTable(TimeTable timeTable) {
		timeTableRepository.save(timeTable);
	}

	@Override
	public List<TimeTable> getAllTimeTable() {
		List<TimeTable> timeTables=  timeTableRepository.findAll();
		if(timeTables.isEmpty()) {
			return null;
		}else {
			return timeTables;
		}
	}

	@Override
	public void deleteTimeTableById(Integer id) {
		timeTableRepository.deleteById(id);
	}

	@Override
	public TimeTable getTimeTableById(Integer id) {
		return timeTableRepository.findById(id).get();
	}
}
