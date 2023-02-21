/**
 * 
 */
package com.aaisha.chatbot.service.timetable;

import java.util.List;

import com.aaisha.chatbot.entity.TimeTable;

/**
 * @author Bhanwar
 *
 */
public interface TimeTableService {
public List<TimeTable> getAllTimeTable();
public List<TimeTable> getTimeTableByStream(String stream);
}
