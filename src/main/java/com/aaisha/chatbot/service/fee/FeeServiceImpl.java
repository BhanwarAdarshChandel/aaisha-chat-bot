/**
 * 
 */
package com.aaisha.chatbot.service.fee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.Fee;
import com.aaisha.chatbot.repository.FeeRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class FeeServiceImpl implements FeeService {

	@Autowired
	private FeeRepository feeRepository;

	@Override
	public List<Fee> getAllFee() {
		List<Fee> listFee = feeRepository.findAll();
		if (listFee.isEmpty()) {
			return null;
		} else {
			return listFee;
		}
	}

	@Override
	public List<Fee> getFeeByStream(String stream) {
		List<Fee> listFee = feeRepository.findByStreamIgnoreCase(stream);
		if (listFee.isEmpty()) {
			return null;
		} else {
			return listFee;
		}
	}

}
