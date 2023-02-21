/**
 * 
 */
package com.aaisha.chatbot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author Bhanwar
 *
 */
@Table
@Entity(name = "QUESTION_AND_ANSWER")
public class QuestionAndAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "ANSWER")
	@NotEmpty(message = "answer should not empty")
	private String answer;

	/**
	 * @param id
	 * @param question
	 * @param answer
	 */
	public QuestionAndAnswer(Integer id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	/**
	 * @param question
	 * @param answer
	 */
	public QuestionAndAnswer(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	/**
	 * 
	 */
	public QuestionAndAnswer() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
