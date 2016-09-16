package com.contractfree.framework.manager;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.contractfree.framework.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerTest {
	
	@Mock
	UserManager userManager;
	
	@Test
	public void testSaveUser(){
		User testUser = new User("teste@email.com");
		userManager.save(testUser);
		Mockito.verify(userManager).save(testUser);
	}

}
