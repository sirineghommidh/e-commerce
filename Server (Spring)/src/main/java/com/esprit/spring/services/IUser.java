package com.esprit.spring.services;

import org.springframework.data.domain.Page;

import com.esprit.spring.entites.User;

public interface IUser {

	 public String signUpUser(User appUser);
	 public int enableAppUser(String email);
	 public User addUser(User u);
	 public void deleteUser(Long id);
	 public User UpdateUser(User u) throws Exception;
	    public Page<User> findUsers(int pageNumber,String keyword,String sortField,String SortDir);
	 public User findUserById(Long id);
}