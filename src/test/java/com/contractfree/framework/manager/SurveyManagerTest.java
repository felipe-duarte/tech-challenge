package com.contractfree.framework.manager;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.contractfree.framework.model.SurveyQuestion;

@RunWith(MockitoJUnitRunner.class)
public class SurveyManagerTest {
	
	@Mock
	SurveyManager surveyManager;
	
	
	@Test
	public void testSurveyQuestions(){
		List<SurveyQuestion> questions = surveyManager.findQuestions();
		assertNotNull(questions);
	}

}
