/**
 * 
 */
package com.aaisha.chatbot.entity;

import java.io.Serializable;

import javax.annotation.Generated;
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
@Entity(name = "CHAT_BOT_USER_QUESTION")
public class ChatBotUserQuestion {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name = "USER_TIME_STAMP")
	private Integer timestamp;
	
	@Column(name = "USER_EMAIL")
	private String useremail;
	
	@Column(name = "USER_QUESTION")
	@NotEmpty(message = "question is mandatory")
	private String userquestion;
	/**
	 * @return the timestamp
	 */
	public Integer getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the useremail
	 */
	public String getUseremail() {
		return useremail;
	}
	/**
	 * @param useremail
	 *            the useremail to set
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	/**
	 * @return the userquestion
	 */
	public String getUserquestion() {
		return userquestion;
	}
	/**
	 * @param userquestion
	 *            the userquestion to set
	 */
	public void setUserquestion(String userquestion) {
		this.userquestion = userquestion;
	}
	/**
	 * @param timestamp
	 * @param useremail
	 * @param userquestion
	 */
	public ChatBotUserQuestion(Integer timestamp, String useremail,
			String userquestion) {
		super();
		this.timestamp = timestamp;
		this.useremail = useremail;
		this.userquestion = userquestion;
	}
	/**
	 * 
	 */
	public ChatBotUserQuestion() {
		super();
	}

}
