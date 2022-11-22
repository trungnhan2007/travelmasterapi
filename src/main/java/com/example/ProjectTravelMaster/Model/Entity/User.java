package com.example.ProjectTravelMaster.Model.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userUsername;
	private String userPassword;
	private String userAvatar;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<UserPost> user_post;

	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Booking> booking;
	
	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public User() {
		
	}
	
	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int user_id) {
		this.userId = user_id;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getUser_email() {
		return userEmail;
	}

	public void setUser_email(String user_email) {
		this.userEmail = user_email;
	}

	public String getUser_phone() {
		return userPhone;
	}

	public void setUser_phone(String user_phone) {
		this.userPhone = user_phone;
	}

	public String getUser_username() {
		return userUsername;
	}

	public void setUser_username(String user_username) {
		this.userUsername = user_username;
	}

	public String getUser_password() {
		return userPassword;
	}

	public void setUser_password(String user_password) {
		this.userPassword = user_password;
	}

	public String getUser_avatar() {
		return userAvatar;
	}

	public void setUser_avatar(String user_avatar) {
		this.userAvatar = user_avatar;
	}

	public List<UserPost> getUser_post() {
		return user_post;
	}

	public void setUser_post(List<UserPost> user_post) {
		this.user_post = user_post;
	}

	
	
	
	
}
