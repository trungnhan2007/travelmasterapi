package com.example.ProjectTravelMaster.Model.Service.Impl;

import java.awt.desktop.UserSessionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.ProjectTravelMaster.Model.Entity.User;
import com.example.ProjectTravelMaster.Model.Repository.UserRepository;
import com.example.ProjectTravelMaster.Model.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository urep;
	
	
	//get user
	@Override
	public List<User> getAllUser(String user_id , String user_name)throws IOException {
		try {
        	List<User> user = new ArrayList<User>();

	        if (user_id != null && user_name == null ) {
	    		int iduser = Integer.valueOf(user_id);
	    		urep.findByUserId(iduser).forEach(user::add);
			}if(user_name != null && user_id == null) {
				urep.findByUserName(user_name).forEach(user::add);
			}if(user_name == null && user_id == null) {
				urep.findAll().forEach(user::add);
			}if(user.isEmpty()) {
				return null;
			}
        	return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public User createUser(User emp) throws IOException{
		try {
	    	if (emp == null) {
	    		return null;
			} else {
				User _emp = urep.save(emp);
				return _emp;
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}
	
	@Override
	public User updateUser(int id,User emp) throws IOException{
		try {
	    	if (emp == null || id == 0) {
	    		return null;
			} else {    			
				Optional<User> empdata = urep.findById(id);				
				User _emp = empdata.get();
				_emp.setUser_name(emp.getUser_name());
				_emp.setUser_email(emp.getUser_email());
				_emp.setUser_phone(emp.getUser_phone());
				_emp.setUser_avatar(emp.getUser_avatar());
				_emp.setUser_username(emp.getUser_name());
				_emp.setUser_password(emp.getUser_password());							
				return urep.save(_emp);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@Override
	public String deleteUser(int id) throws IOException
	{
		try {
	    	if (id==0) {
	    		return null;
			} else {    			
	    		urep.deleteById(id);
	    		return "OK";
			}			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
