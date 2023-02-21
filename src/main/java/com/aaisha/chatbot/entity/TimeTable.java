/**
 * 
 */
package com.aaisha.chatbot.entity;

import java.io.Serializable;

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
@Entity(name = "TIME_TABLE")
public class TimeTable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7586639953762645987L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "SUBJECT")
	@NotEmpty(message = "subject is mandatory")
	private String subject;
	
	@Column(name = "STREAM")
	@NotEmpty(message = "strean is mandatory")
	private String stream;
	
	@Column(name = "SEMESTER")
	@NotEmpty(message = "semester is mandatory")
	private String semester;
	
	@Column(name = "DATE")
	@NotEmpty(message = "exam date is mandatory")
	private String date;
	
	@Column(name = "TIME")
	@NotEmpty(message = "exam time is mandatory")
	private String time;
	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}
	/**
	 * @param semester the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	/**
	 * 
	 */
	public TimeTable() {
		super();
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @param id
	 * @param subject
	 * @param stream
	 * @param date
	 * @param time
	 */
	public TimeTable(Integer id, String subject, String stream, String semester, String date,
			String time) {
		super();
		this.id = id;
		this.subject = subject;
		this.stream = stream;
		this.semester=semester;
		this.date = date;
		this.time = time;
	}

}
