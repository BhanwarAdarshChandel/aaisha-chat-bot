/**
 * 
 */
package com.aaisha.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.TimeTable;

/**
 * @author Bhanwar
 *
 */
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {
public List<TimeTable> findByStream(String stream);
}
