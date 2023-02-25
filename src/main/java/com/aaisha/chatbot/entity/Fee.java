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
@Entity(name = "FEE_TABLE")
public class Fee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6924842402014834256L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "STREAM")
	@NotEmpty(message = "strean is mandatory")
	private String stream;
	
	@Column(name = "SEMESTER")
	@NotEmpty(message = "semester is mandatory")
	private String semester;
	
	@Column(name = "FEE")
	@NotEmpty(message = "fee is mandatory")
	private double fee;

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
	 * @return the fee
	 */
	public double getFee() {
		return fee;
	}

	/**
	 * @param fee the fee to set
	 */
	public void setFee(double fee) {
		this.fee = fee;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	}
