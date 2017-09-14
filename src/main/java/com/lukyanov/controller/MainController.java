package com.lukyanov.controller;

import com.lukyanov.dto.TripDto;
import com.lukyanov.dto.converter.TripDtoConverter;
import com.lukyanov.model.Trip;
import com.lukyanov.service.TripService;
import com.lukyanov.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    TripService tripService;
    @Autowired
    TripDtoConverter tripDtoConverter;

    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }

    @ResponseBody
    @RequestMapping("/home/trip/all")
    public List<TripDto> getAllTrips() {

        List<Trip> allTrips = tripService.getAllTrips(SecurityUtils.getCurrentUser());
        return allTrips.stream().map(trip -> tripDtoConverter.convert(trip)).collect(Collectors.toList());
    }

    @ResponseBody
    @RequestMapping(value = "/home/trip/new/", method = RequestMethod.POST)
    public TripDto saveNewTrip(@RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude,
                               @RequestParam("description") String description, @RequestParam("date") String stringDate) {

        String[] arr = stringDate.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        Trip trip = new Trip();
        trip.setLatitude(latitude);
        trip.setLongitude(longitude);
        trip.setUser(SecurityUtils.getCurrentUser());
        trip.setDescription(description);
        tripService.save(trip);
        TripDto tripDto = tripDtoConverter.convert(trip);
        tripDto.setDate(day+"."+month+"."+year);
        return tripDto;
    }

    @ResponseBody
    @RequestMapping(value = "/home/sortered_by_date", method = RequestMethod.GET)
    public String getSortedTrips(@RequestParam("from") String from, @RequestParam("to") String to){

        return from+"  "+to;
    }
}
