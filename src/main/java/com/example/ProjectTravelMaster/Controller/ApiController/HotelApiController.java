package com.example.ProjectTravelMaster.Controller.ApiController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectTravelMaster.Model.Entity.Hotel;
import com.example.ProjectTravelMaster.Model.Repository.HotelRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class HotelApiController {

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("gethotel/{id}")
     public Optional<Hotel> GetHotelById(@PathVariable Integer id){
        
        return hotelRepository.findById(id);
    }
}
