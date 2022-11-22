package com.example.ProjectTravelMaster.Controller.EnterpriseController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ProjectTravelMaster.Model.Entity.Booking;
import com.example.ProjectTravelMaster.Model.Entity.Enterprise;
import com.example.ProjectTravelMaster.Model.Entity.Hotel;
import com.example.ProjectTravelMaster.Model.Entity.OrderHotel;
import com.example.ProjectTravelMaster.Model.Entity.Room;
import com.example.ProjectTravelMaster.Model.Repository.BookingRepository;
import com.example.ProjectTravelMaster.Model.Repository.OrderHotelRepository;
import com.example.ProjectTravelMaster.Model.Repository.RoomRepository;
import com.example.ProjectTravelMaster.Model.Service.BookingService;
import com.example.ProjectTravelMaster.Model.Service.EnterpriseService;
import com.example.ProjectTravelMaster.Model.Service.OrderHotelService;
import com.example.ProjectTravelMaster.Model.Service.RoomService;

@Controller
public class HotelEnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomService roomService;

    @Autowired
    BookingService bookingService;

    @Autowired
    OrderHotelService orderHotelService;

    @RequestMapping(value = "hotel_list", method = RequestMethod.GET)
    public String Enterprise_hotel_list(@CookieValue(value = "setEnterprise", defaultValue = "") String setEnterprise,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Room> roomPage = roomService.findPaginated(PageRequest.of(currentPage - 1, pageSize), setEnterprise);

        model.addAttribute("RoomHotel", roomPage);

        int totalPages = roomPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("hsId", roomService.getHsIdFormRoom(setEnterprise));
        model.addAttribute("enId", setEnterprise);

        return "enterprise_hotel_list";
    }

    @RequestMapping(value = "/hotel_search", method = RequestMethod.POST)
    public String SearchRoom(Model model, String roomNumber,String enId,String hsId) {
        int iden = Integer.valueOf(enId);
        int idhs = Integer.valueOf(hsId);
        Room room = roomRepository.findRoomByEnterprise(roomNumber,idhs,iden);
        model.addAttribute("RoomHotel", room);
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        return "enterprise_hotel_list";
    }

    @RequestMapping(value = "/hotel_add", method = RequestMethod.GET)
    public String HotelAdd_View() {

        return "enterprise_hotel_add";
    }
    @RequestMapping(value = "/hotel_room_create", method = RequestMethod.POST)
    public String HotelAdd(Room room,Model model,@RequestParam("image") MultipartFile file,HttpSession session) throws IOException{

        String namefile = roomService.UploadFileImageRoom(file,session);
        
        return "enterprise_hotel_list";
    }


    @RequestMapping(value = "/hotel_booking", method = RequestMethod.POST)
    public String HotelBooking(Model model,String enId,String hsId,String roomId){
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        model.addAttribute("RoomHotel", room);
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);
        return "enterprise_hotel_booking";
    }

    @Autowired
    OrderHotelRepository orderHotelRepository ;

    @RequestMapping(value = "/hotel_room_booking", method = RequestMethod.POST)
    public String HotelBookingRoom(Model model,Booking booking,Room room,OrderHotel orderhotel){
     
    //create booking
    Booking bo = bookingService.CreateBooking(booking);  
    //set id from booking
    orderhotel.setBoId(bo.getBoId());
    orderhotel.setRoomId(room.getRoomId());
    //create order hotel
    orderHotelService.createOrderHotel(orderhotel);
    //update status room
    roomService.UpdateBookingRoom(room);
    return "redirect:/hotel_list";
    }

    @RequestMapping(value = "/hotel_checkout", method = RequestMethod.POST)
    public String HotelCheckout(Model model,String enId,String hsId,String roomId){
        Room room = roomService.getRoomBooking(enId, hsId, roomId);
        OrderHotel orderHotel = orderHotelService.findOrderHotelByIdRoom(room.getRoomId());
        model.addAttribute("RoomHotel", room); 
        model.addAttribute("OrderHotel", orderHotel);
        model.addAttribute("BookingHotel", orderHotel.getBooking());
        model.addAttribute("hsId", hsId);
        model.addAttribute("enId", enId);
        Random random = new Random();
        int randomWithNextInt = random.nextInt();
        model.addAttribute("NumberRanDom", randomWithNextInt);
        return "enterprise_hotel_checkout";
    }


}
