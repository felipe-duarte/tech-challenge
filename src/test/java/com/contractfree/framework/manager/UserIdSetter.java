package com.contractfree.framework.manager;


import org.mockito.stubbing.Answer;

import com.contractfree.framework.model.User;

import org.junit.Assert;
import org.mockito.invocation.InvocationOnMock;

public class UserIdSetter implements Answer<Void>{

	private Long userId;
	
	public UserIdSetter(Long userId) {
		this.userId = userId;
	}
	
	
	@Override
	public Void answer(InvocationOnMock invocation) throws Throwable {
		Assert.assertEquals(1, invocation.getArguments().length);
		User user = (User) invocation.getArguments()[0];
		user.setId(userId);
		return null;
	}
	

}
