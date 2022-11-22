package com.example.ProjectTravelMaster.Model.Service;

import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;

public interface OrderHotelService {
    OrderHotel createOrderHotel(OrderHotel orderHotel);
    OrderHotel findOrderHotelByIdRoom(int roomId);
}
