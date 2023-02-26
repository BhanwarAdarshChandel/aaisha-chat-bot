/**
 * 
 */
package com.aaisha.chatbot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aaisha.chatbot.entity.Fee;

/**
 * @author Bhanwar
 *
 */
public interface FeeRepository extends JpaRepository<Fee, Integer> {
	public List<Fee> findByStreamIgnoreCase(String stream);
}
