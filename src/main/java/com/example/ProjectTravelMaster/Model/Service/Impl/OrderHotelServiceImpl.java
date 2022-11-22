package com.example.ProjectTravelMaster.Model.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Repository.OrderHotelRepository;
import com.example.ProjectTravelMaster.Model.Service.OrderHotelService;

@Service
public class OrderHotelServiceImpl implements OrderHotelService {

    @Autowired
    OrderHotelRepository orderHotelRepository;

    public OrderHotel createOrderHotel(OrderHotel orderHotel) {
        try {
            orderHotel.setOhStatus(false);
            return orderHotelRepository.save(orderHotel);
        } catch (Exception e) {
            return null;
        }

    }

    public OrderHotel findOrderHotelByIdRoom(int roomId) {
        try {
            return orderHotelRepository.findOrderHotelByIdRoom(roomId);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
