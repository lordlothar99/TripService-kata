package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.Before;
import org.junit.Test;

public class TripDAOTest {

	private TripDAO dao;

	@Before
	public void init() {
		dao = new TripDAO();
	}

	@Test(expected = CollaboratorCallException.class)
	public void should_throw_exception_when_finding_trips_by_user() {
		dao.findTripsBy(new User());
	}
}
