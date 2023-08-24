package com.app.service;

import java.util.List;

import com.app.dto.FeedbackDTO;

public interface FeedbackService {
	FeedbackDTO createFeedback(FeedbackDTO feedback);
	
	List<FeedbackDTO> getAllFeedback();

}
