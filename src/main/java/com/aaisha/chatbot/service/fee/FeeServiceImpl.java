/**
 * 
 */
package com.aaisha.chatbot.service.fee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG =LoggerFactory.getLogger(FeeServiceImpl.class);
	@Autowired
	private FeeRepository feeRepository;

	@Override
	public List<Fee> getAllFee() {
		LOG.info("fetch all fee records");
		List<Fee> listFee = feeRepository.findAll();
		if (listFee.isEmpty()) {
			return null;
		} else {
			return listFee;
		}
	}

	@Override
	public List<Fee> getFeeByStream(String stream) {
		LOG.info("get fee records by stream : "+stream);
		List<Fee> listFee = feeRepository.findByStreamIgnoreCase(stream);
		if (listFee.isEmpty()) {
			return null;
		} else {
			return listFee;
		}
	}

	@Override
	public void aadFee(Fee fee) {
		LOG.info("add fee record");
		feeRepository.save(fee);
	}

	@Override
	public void deleteFeeRecordById(Integer id) {
		LOG.info("delete fee record by id : "+id);
		feeRepository.deleteById(id);
	}

	@Override
	public Fee getFeeById(Integer id) {
		LOG.info("fetch fee record by id : "+id);
		return feeRepository.findById(id).get();
	}

}
