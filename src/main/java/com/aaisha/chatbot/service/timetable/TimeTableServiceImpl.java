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
		List<TimeTable> listTimeTable =timeTableRepository.findAll();
		if(listTimeTable.isEmpty()) {
			return null;
		}else {
			return listTimeTable;
		}
	}

	@Override
	public List<TimeTable> getTimeTableByStream(String stream) {
		List<TimeTable> listTimeTable = timeTableRepository.findByStreamIgnoreCase(stream);
		if(listTimeTable.isEmpty()) {
			return null;
		}else {
			return listTimeTable;
		}
	}

}
