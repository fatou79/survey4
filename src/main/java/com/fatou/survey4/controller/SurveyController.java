package com.fatou.survey4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fatou.survey4.Survey;
import com.fatou.survey4.model.Question;
import com.fatou.survey4.service.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService fatou;
	
	@GetMapping("/surveys")
	public List<Survey> retrieveAllSurvey(){
		return fatou.retrieveAllSurveys();
	}
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllQuestions(@PathVariable String surveyId){
		return fatou.retrieveQuestions(surveyId);
	}
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveoneQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		return fatou.retrieveQuestion(surveyId,questionId);
	}
	
}