package com.esprit.spring.controller;





import javax.websocket.server.PathParam;

import com.esprit.spring.repository.UserRepository;
import com.esprit.spring.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.esprit.spring.entites.User;
import com.esprit.spring.services.IUser;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	UserRepository userRepos;
	
	
	@GetMapping("/admin/ListUsers")
	public Page<User> PagingAndSortingListUsers(@RequestParam int page,@RequestParam String keyword,@RequestParam String sortField,@RequestParam String sortDir)
	{
		
		return userService.findUsers(page-1, keyword,sortField,sortDir);
	}
	
	// ok 
	@PostMapping("/admin/add")
	public User AddUser(@RequestBody User u) 
	{
		 return userService.addUser(u);
		
	}
	
	//ok
	@PutMapping("/admin/update")
	public User update(@RequestBody User u) throws Exception
	{
		return userService.UpdateUser(u);
		
	}
	
	
	// not ok 
	@DeleteMapping("/admin/delete/{id}")
	public void delete(@PathParam("id") Long id)
	{
		userService.deleteUser(id);
	}

	//one user for reclamation
	@GetMapping("/admin/get-one-user/{user-id}")
	@ResponseBody
	public User GetOneUser(@PathVariable("user-id") Long id)
	{
		User user = userService.findUserById(id);
		return user;
	}


	//statistiques clients

	@GetMapping("/admin/get-stats-profession")
	@ResponseBody
	public List<String> showStatsByProfession()
	{
		return userRepos.SpendingByProfession();
	}

	@GetMapping("/userByEmail")
     public UserDetails loadUser(@RequestParam String email)
	 {
            return userService.loadUserByUsername(email);
	 }
}