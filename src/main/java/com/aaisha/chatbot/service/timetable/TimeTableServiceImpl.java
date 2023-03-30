/**
 * 
 */
package com.aaisha.chatbot.service.timetable;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOG =LoggerFactory.getLogger(TimeTableServiceImpl.class);
	@Autowired
	private TimeTableRepository timeTableRepository;

	@Override
	public List<TimeTable> getAllTimeTable() {
		LOG.info("fetch all time table record");
		List<TimeTable> listTimeTable =timeTableRepository.findAll();
		if(listTimeTable.isEmpty()) {
			return null;
		}else {
			return listTimeTable;
		}
	}

	@Override
	public List<TimeTable> getTimeTableByStream(String stream) {
		LOG.info("fetch time table record by stream :"+ stream);
		List<TimeTable> listTimeTable = timeTableRepository.findByStreamIgnoreCase(stream);
		if(listTimeTable.isEmpty()) {
			return null;
		}else {
			return listTimeTable;
		}
	}

}
