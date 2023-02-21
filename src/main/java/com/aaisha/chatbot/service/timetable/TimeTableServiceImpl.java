/**
 * 
 */
package com.aaisha.chatbot.service.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaisha.chatbot.entity.TimeTable;
import com.aaisha.chatbot.repository.TimeTableRepository;

/**
 * @author Bhanwar
 *
 */
@Service
public class TimeTableServiceImpl implements TimeTableService {
	
	@Autowired
	private TimeTableRepository timeTableRepository;

	@Override
	public List<TimeTable> getAllTimeTable() {
		return timeTableRepository.findAll();
	}

	@Override
	public List<TimeTable> getTimeTableByStream(String stream) {
		return timeTableRepository.findByStream(stream);
	}

}
