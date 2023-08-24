package com.app.userserviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dto.FeedbackDTO;
import com.app.entities.Feedback;
import com.app.repository.FeedbackRepo;
import com.app.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public FeedbackDTO createFeedback(FeedbackDTO feedbackDto) {
		Feedback feedback = this.mapper.map(feedbackDto, Feedback.class);
		Feedback savedFeedback = this.feedbackRepo.save(feedback);
		return this.mapper.map(savedFeedback, FeedbackDTO.class);
		
	}

	@Override
	public List<FeedbackDTO> getAllFeedback() {
		List<Feedback> feedbacks = this.feedbackRepo.findAll();
		List<FeedbackDTO> feedbackDtos = feedbacks.stream().map((feedback)->this.mapper.map(feedback, FeedbackDTO.class)).collect(Collectors.toList());
		return feedbackDtos;
	}
	
	
//	public List<FeedbackDto> getAllGearShops() {
//		List<Feedback> gearShops = this.feedbackRepo.findAll();
//		List<FeedbackDto> gearShopDtos = gearShops.stream().map((gearShop)->this.modelMapper.map(gearShop, GearShopDto.class)).collect(Collectors.toList());
//		return gearShopDtos;
//		
//	}
}
