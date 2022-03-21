package com.dao;

import java.util.List;

import com.model.UserDetails;

public interface UserDetailsDao {

	public boolean addUserDetails(UserDetails userDetails) ;
	public boolean deleteUserDetails(UserDetails userDetails);
	public boolean updateUserDetails(UserDetails userDetails);
	public List<UserDetails> listUserDetails();
	public UserDetails getUserDetails(String username);
}
