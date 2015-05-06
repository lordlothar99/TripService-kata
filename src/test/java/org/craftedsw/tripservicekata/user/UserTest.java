package org.craftedsw.tripservicekata.user;

import junit.framework.Assert;

import org.junit.Test;

public class UserTest {

	private static final User USER1 = new User();

	@Test
	public void should_return_true_when_user_are_friends() {
		User aUser = new User();
		aUser.addFriend(USER1);
		Assert.assertTrue("Users should be friends", aUser.isFriendWith(USER1));
	}

	@Test
	public void should_return_false_when_user_are_not_friends() {
		User aUser = new User();
		Assert.assertFalse("Users should not be friends", aUser.isFriendWith(USER1));
	}
}
