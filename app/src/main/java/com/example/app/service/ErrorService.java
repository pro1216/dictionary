package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.mappers.ErrorMapper;

@Service
public class ErrorService {

	@Autowired
	private ErrorMapper errorRepository;

	public String searchMessage(String keyword, String word) {
		String message = errorRepository.findMessage(keyword, word);

		return message;
	}

}
