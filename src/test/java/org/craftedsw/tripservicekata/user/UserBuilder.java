package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

public class UserBuilder {

	private final User user = new User();

	public static UserBuilder newUser() {
		return new UserBuilder();
	}

	public UserBuilder withTrips(Trip... trips) {
		for (Trip trip : trips) {
			user.addTrip(trip);
		}
		return this;
	}

	public UserBuilder friendWith(User... friends) {
		for (User friend : friends) {
			user.addFriend(friend);
		}
		return this;
	}

	public User asUser() {
		return user;
	}
}
