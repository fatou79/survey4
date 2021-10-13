package com.fatou.survey4.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fatou.survey4.Survey;
import com.fatou.survey4.model.Question;

@Component
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question2 = new Question("Question2",
				"Most Populus Country in the World", "China", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question3 = new Question("Question3",
				"Highest GDP in the World", "United States", Arrays.asList(
						"India", "Russia", "United States", "China"));
		Question question4 = new Question("Question4",
				"Second largest english speaking country", "India", Arrays
						.asList("India", "Russia", "United States", "China"));
	
	List<Question> questions = new ArrayList<>(Arrays.asList(question1,
			question2, question3, question4));

	Survey survey1 = new Survey("Survey1", "My Favorite Survey",
			"Description of the Survey", questions);
	Survey survey2 = new Survey("Survey2", "My Favorite Survey",
			"Description of the Survey", questions);
	Survey survey3 = new Survey("Survey3", "My Favorite Survey",
			"Description of the Survey", questions);
	Survey survey4 = new Survey("Survey4", "My Favorite Survey",
			"Description of the Survey", questions);
	
	surveys.add(survey1);
	surveys.add(survey2);
	surveys.add(survey3);
	surveys.add(survey4);
}

public List<Survey> retrieveAllSurveys() {
	return surveys;
}
public Survey retrieveSurvey(String surveyId) {
	for (Survey survey : surveys) {
		if (survey.getId().equals(surveyId)) {
			return survey;
		}
	}
	return null;

}
public List<Question> retrieveQuestions(String surveyId) {
	Survey survey = retrieveSurvey(surveyId);

	if (survey == null) {
		return null;
	}

	return survey.getQuestions();
}
public Question retrieveQuestion(String surveyId, String questionId) {
	Survey survey = retrieveSurvey(surveyId);

	if (survey == null) {
		return null;
	}

	for (Question question : survey.getQuestions()) {
		if (question.getId().equals(questionId)) {
			return question;
		}
	}

	return null;
}
}