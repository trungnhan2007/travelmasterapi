package com.example.ProjectTravelMaster.Model.Service;

import java.io.IOException;
import java.util.List;

import com.example.ProjectTravelMaster.Model.Entity.User;

public interface UserService {
	List<User> getAllUser(String user_id , String user_name) throws IOException;

	User createUser(User emp) throws IOException;

	User updateUser(int id, User emp) throws IOException;

	String deleteUser(int id) throws IOException;
}
