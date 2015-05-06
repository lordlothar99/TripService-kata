package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

	private static final User GUEST = null;
	private final User LOGGED_IN_USER = new User();
	@Mock
	private TripDAO tripDAO;
	@InjectMocks
	private final TripService tripService = new TripService();

	@Test(expected = UserNotLoggedInException.class)
	public void should_throw_exception_when_user_not_logged() {
		User aUser = UserBuilder.newUser().asUser();
		tripService.getTripsByUser(aUser, GUEST);
	}

	@Test
	public void should_return_no_trip_when_tested_user_and_loggged_user_are_not_friends() {
		User aUser = UserBuilder.newUser().asUser();
		List<Trip> trips = tripService.getTripsByUser(aUser, LOGGED_IN_USER);
		Assert.assertTrue("Trips list should be empty", trips.isEmpty());
	}

	@Test
	public void should_return_a_trip_when_tested_user_and_loggged_user_are_friends() {
		Trip aTrip = new Trip();
		User aUser = UserBuilder.newUser().friendWith(LOGGED_IN_USER).withTrips(aTrip).asUser();
		Mockito.when(tripDAO.findTripsBy(aUser)).thenReturn(aUser.trips());

		List<Trip> trips = tripService.getTripsByUser(aUser, LOGGED_IN_USER);
		Assert.assertEquals(1, trips.size());
		Assert.assertEquals(aTrip, trips.get(0));
	}
}
