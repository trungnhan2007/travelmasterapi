package com.example.ProjectTravelMaster.Model.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.Booking;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public Booking CreateBooking(Booking booking) {
        try {
            if(booking.getUserId() == 0){
                booking.setUserId(1);
                booking.setBoStatus(true);
                return bookingRepository.save(booking);
            }else{
                booking.setBoStatus(true);
                return bookingRepository.save(booking);
            }
        } catch (Exception e) {
            return null;
        }

    }

}
