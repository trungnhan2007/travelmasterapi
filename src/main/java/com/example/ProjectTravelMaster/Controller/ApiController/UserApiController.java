 package com.example.ProjectTravelMaster.Controller.ApiController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Convert;

import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Entity.UserPost;
import com.example.ProjectTravelMaster.Model.Repository.UserPostRepository;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.Impl.UserServiceImpl;
import com.example.ProjectTravelMaster.util.Mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** @author Tran Nhan Hau **/

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class UserApiController {
	
	
	
    @Autowired
    UserRepository urep;
    
    @Autowired
    UserServiceImpl userService;

    // get all user
    @GetMapping(Mappings.API_User)
    public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String user_id , String user_name) {

    	try {
        	List<User> user = new ArrayList<User>();
        	user = userService.getAllUser(user_id, user_name);
        	if (user != null) {
        		return new ResponseEntity<> (user,HttpStatus.OK);  
			}else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}   			    		
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}             
    }
    
    // add user
    @PostMapping(Mappings.API_User)
    public ResponseEntity<User> createUser(@RequestBody(required = true) User emp) {
    	try {      	
			User _emp = userService.createUser(emp);
			if (_emp != null) {
				return new ResponseEntity<> (_emp,HttpStatus.CREATED);
			}else {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}   
    }
    
    // update user
    @PutMapping(Mappings.API_UserGetId)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody(required = true) User emp) {
    	try {       		
    		User user = userService.updateUser(id, emp);
        	if (user == null) {
        		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    		} else {    			    						
    			return new ResponseEntity<> (user,HttpStatus.OK);
    		}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}   
    }
    
    //delete user
    @DeleteMapping(Mappings.API_UserGetId)
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
    	try {      	
    		String bool = userService.deleteUser(id);
        	if (bool != null) {
        		return new ResponseEntity<> (HttpStatus.OK);
    		} else {    									
    			return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    		}
		} catch (Exception e) {
			// TODO: handle exception   
			return new ResponseEntity<> (null,HttpStatus.INTERNAL_SERVER_ERROR);
		}   
    }
    	
}
