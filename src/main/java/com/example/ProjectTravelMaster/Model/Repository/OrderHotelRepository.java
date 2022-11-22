package com.example.ProjectTravelMaster.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;

public interface OrderHotelRepository extends JpaRepository<OrderHotel,Integer>{
    List<OrderHotel> findByRoomId(Integer id);

    @Query("SELECT h FROM OrderHotel h WHERE h.ohStatus = true and h.roomId = ?1")
    OrderHotel findOrderHotelByIdRoom(int roomId);

}
