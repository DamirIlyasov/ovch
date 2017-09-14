package com.lukyanov.dto.converter;

import com.lukyanov.dto.TripDto;
import com.lukyanov.model.Trip;
import org.springframework.stereotype.Component;


@Component
public class TripDtoConverter {

    public TripDto convert(Trip trip) {
        TripDto tripDto = new TripDto();
        tripDto.setFirstName(trip.getUser().getFirstName());
        tripDto.setLastName(trip.getUser().getLastName());
        tripDto.setLatitude(trip.getLatitude());
        tripDto.setLongitude(trip.getLongitude());
        tripDto.setAge(trip.getUser().getAge());
        tripDto.setPhone(trip.getUser().getPhone());
        tripDto.setDescription(trip.getDescription());
        return tripDto;
    }
}
