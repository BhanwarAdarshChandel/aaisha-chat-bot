/**
 * 
 */
package com.aaisha.chatbot.service.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG =LoggerFactory.getLogger(AdminServiceImpl.class);
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
		LOG.info("Fetching unanswered questions");
		List<UnknownQuestion> unknownQuestions = unknownQuestionRepository
				.findAll();
		if (!unknownQuestions.isEmpty()) {
			return unknownQuestions;
		}
		return null;
	}

	@Override
	public ChatBotUser findById(String email) {
		LOG.info("find user by id : "+email);
		return registrationService.findById(email);
	}
	@Override
	public UnknownQuestion findUnansweredQuestionById(Integer id) {
		LOG.info("find unanswered question by id : "+id);
		return unknownQuestionRepository.findById(id).get();
	}
	@Override
	public void deleteUnansweredQuestionById(Integer id) {
		LOG.info("delete unanswered question by id : "+id);
		unknownQuestionRepository.deleteById(id);
	}

	@Override
	public void saveAnswer(QuestionAndAnswer questionAndAnswer) {
		LOG.info("save answer of question : "+questionAndAnswer.getQuestion());
		chatBotQuestionAndAnswerRepository.save(questionAndAnswer);
	}

	@Override
	public void saveTimeTable(TimeTable timeTable) {
		LOG.info("save time table record");
		timeTableRepository.save(timeTable);
	}

	@Override
	public List<TimeTable> getAllTimeTable() {
		LOG.info("fetching all time table records");
		List<TimeTable> timeTables = timeTableRepository.findAll();
		if (timeTables.isEmpty()) {
			return null;
		} else {
			return timeTables;
		}
	}

	@Override
	public void deleteTimeTableById(Integer id) {
		LOG.info("deleting time table record by id : "+id);
		timeTableRepository.deleteById(id);
	}

	@Override
	public TimeTable getTimeTableById(Integer id) {
		LOG.info("fetch time table record by id : "+id);
		return timeTableRepository.findById(id).get();
	}
}
