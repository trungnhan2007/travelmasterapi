package com.example.ProjectTravelMaster.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ProjectTravelMaster.Model.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
    // @Query("SELECT b FROM Booking b LEFT JOIN OrderHotel o ON b.boId = o.boId WHERE b.enId = ?1 and o.hsId =?2")
	// Booking findBookinglByRoom(int enId,int hsId);
}
