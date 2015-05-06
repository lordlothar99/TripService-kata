package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class TripService {

	@Autowired
	private TripDAO tripDAO;

	public List<Trip> getTripsByUser(User user, User loggedUser) {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
		return user.isFriendWith(loggedUser) ? findTripsByUser(user) : emptyTripsList();
	}

	private ArrayList<Trip> emptyTripsList() {
		return new ArrayList<Trip>();
	}

	protected List<Trip> findTripsByUser(User user) {
		return tripDAO.findTripsBy(user);
	}

}
