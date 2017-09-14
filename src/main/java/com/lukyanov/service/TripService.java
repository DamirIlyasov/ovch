package com.lukyanov.service;

import com.lukyanov.model.Trip;
import com.lukyanov.model.User;

import java.util.List;

public interface TripService {
    List<Trip> getAllTrips(User user);
    void save(Trip trip);
//    List<Trip> getTripsByDate();
}
