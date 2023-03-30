/**
 * 
 */
package com.aaisha.chatbot.service.user.asked.question;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.ChatBotUserQuestion;
import com.aaisha.chatbot.entity.QuestionAndAnswer;
import com.aaisha.chatbot.entity.UnknownQuestion;
import com.aaisha.chatbot.repository.ChatBotQuestionAndAnswerRepository;
import com.aaisha.chatbot.repository.ChatBotUserQuestionRepository;
import com.aaisha.chatbot.repository.UnknownQuestionRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class ChatBotUserAskedQuestionServiceImpl implements ChatBotUserAskedQuestionService{
	private static final Logger LOG =LoggerFactory.getLogger(ChatBotUserAskedQuestionServiceImpl.class);
	@Autowired
	private ChatBotUserQuestionRepository chatBotUserQuestionRepository;
	
	@Autowired
	private ChatBotQuestionAndAnswerRepository chatBotQuestionAndAnswerRepository;
	
	@Autowired
	private UnknownQuestionRepository unknownQuestionRepository;
	
	@Override
	public String userQuestion(ChatBotUserQuestion chatBotUserQuestion) {
		LOG.info("get user asked question result, question : "+chatBotUserQuestion.getUserquestion());
		chatBotUserQuestion.setUserquestion(chatBotUserQuestion.getUserquestion().trim().toLowerCase());
		chatBotUserQuestion.setUseremail(chatBotUserQuestion.getUseremail().trim().toLowerCase());
		List<QuestionAndAnswer> answer=chatBotQuestionAndAnswerRepository.findByQuestionIgnoreCase(chatBotUserQuestion.getUserquestion());
		chatBotUserQuestionRepository.save(chatBotUserQuestion);
		if(answer.isEmpty()) {
			LOG.info("user asked question result not found, question : "+chatBotUserQuestion.getUserquestion());
			UnknownQuestion question =new UnknownQuestion();
			question.setQuestion(chatBotUserQuestion.getUserquestion());
			question.setUserEmail(chatBotUserQuestion.getUseremail());
			unknownQuestionRepository.save(question);
			return "sorry for inconvinience, currently answer is not available we"
					+ " will send you answer on your registred email once we get answer";
		}else {
			LOG.info("user asked question result not, question : "+chatBotUserQuestion.getUserquestion());
			return answer.get(0).getAnswer();
		}
	}

}
