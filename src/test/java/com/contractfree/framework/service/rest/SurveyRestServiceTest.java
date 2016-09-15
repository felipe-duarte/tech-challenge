package com.contractfree.framework.service.rest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.contractfree.framework.model.SurveyQuestion;

@RunWith(MockitoJUnitRunner.class)
public class SurveyRestServiceTest {

	@Mock
	SurveyRestService service;
	
	@Test
	public void queryTest(){
		List<SurveyQuestion> questions = service.query();		
		assertNotNull(questions);
	}
}
