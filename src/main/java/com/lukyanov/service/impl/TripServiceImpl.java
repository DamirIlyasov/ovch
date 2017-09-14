package com.lukyanov.service.impl;

import com.lukyanov.model.Trip;
import com.lukyanov.model.User;
import com.lukyanov.repository.TripRepository;
import com.lukyanov.service.TripService;
import com.lukyanov.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Override
    public List<Trip> getAllTrips(User user) {
        return tripRepository.findAll();
    }

    @Override
    public void save(Trip trip) {
        tripRepository.save(trip);
    }

//    @Override
//    public List<Trip> getTripsByDate() {
//        return tripRepository.getTripsInDate();
//    }
}
