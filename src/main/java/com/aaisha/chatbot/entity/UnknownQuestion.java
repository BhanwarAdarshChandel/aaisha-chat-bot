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

/**
 * @author Bhanwar
 *
 */
@Table
@Entity(name = "UNKNOWN_QUESTION")
public class UnknownQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "EMAIL")
	private String userEmail;

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
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @param id
	 * @param question
	 * @param userEmail
	 */
	public UnknownQuestion(Integer id, String question, String userEmail) {
		super();
		this.id = id;
		this.question = question;
		this.userEmail = userEmail;
	}

	/**
	 * 
	 */
	public UnknownQuestion() {
		super();
	}
}
