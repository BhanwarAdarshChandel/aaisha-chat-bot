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
	public void aadFee(Fee fee);
	public void deleteFeeRecordById(Integer id);
	public Fee getFeeById(Integer id);
}
