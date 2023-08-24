package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.FeedbackDTO;
import com.app.service.FeedbackService;

@RestController
@RequestMapping("/api/feedback")
//@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/")
	public ResponseEntity<FeedbackDTO> createPayment(@Valid @RequestBody FeedbackDTO feedbackDto)
	{
		FeedbackDTO newFeedbackDto = this.feedbackService.createFeedback(feedbackDto);
		return new ResponseEntity<FeedbackDTO>(newFeedbackDto,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<FeedbackDTO>> getAllFeedback()
	{
		return ResponseEntity.ok(this.feedbackService.getAllFeedback());
	}
	
	
}
