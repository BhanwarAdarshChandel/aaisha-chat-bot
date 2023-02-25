package com.aaisha.chatbot.service.fee;
/**
 * 
 */

import java.util.List;

import com.aaisha.chatbot.entity.Fee;
import com.aaisha.chatbot.entity.TimeTable;

/**
 * @author Bhanwar
 *
 */
public interface FeeService {
	public List<Fee> getAllFee();
	public List<Fee> getFeeByStream(String stream);
}
