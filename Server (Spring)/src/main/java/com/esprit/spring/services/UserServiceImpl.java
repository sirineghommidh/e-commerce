package com.esprit.spring.services;

import java.time.LocalDateTime;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.esprit.spring.entites.LoginRequest;
import com.esprit.spring.entites.User;
import com.esprit.spring.entites.Registration.ConfirmationToken;
import com.esprit.spring.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserDetailsService, IUser{

	
	private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";
	
	@Autowired
	private  UserRepository userRepository;
	

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
    			.orElseThrow(() ->
    			new UsernameNotFoundException(
    					String.format(USER_NOT_FOUND_MSG, email)));
	}
	/*
	public UserDetails login(LoginRequest loginRequest) throws Exception
	{   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();  
	  
		UserDetails user= loadUserByUsername(loginRequest.getUsername());
		
		if(!encoder.matches(user.getPassword(),loginRequest.getPassword()))
			throw new Exception("incorrect password !! ");
		else {
		
			return user; 
		}
			
		
		/*
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Incorrect username or password",e); 
		}
		 final UserDetails userDetails =loadUserByUsername(loginRequest.getUsername());
		return (User) userDetails;
		
	}*/
	
	// registration
    public String signUpUser(User appUser) {
    	boolean userExists = userRepository
    			.findByEmail(appUser.getEmail())
    			.isPresent();
    	
    	if (userExists) {
    		// TODO check of attributes are the same and
    		// TODO if email not confirmed send confirmation email.	
    		throw new IllegalStateException("email already taken");
    	}
    	
    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
    	
    	appUser.setPassword(encodedPassword);	
    	userRepository.save(appUser);

   
    	String token = UUID.randomUUID().toString();
    	
    	ConfirmationToken confirmationToken = new ConfirmationToken(
    			token,
    			LocalDateTime.now(),
    			LocalDateTime.now().plusMinutes(15),
    			appUser
    			);
    	
    	confirmationTokenService.saveConfirmationToken(
    			confirmationToken);
    	
//        TODO: SEND EMAIL
    	
    	return token;
    }
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;



    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }
    
   // Create
    public User addUser(User u)
    {
    	return userRepository.save(u);
    
    }
    
   
    
    
    //delete
    public void deleteUser(Long id)
    {
    	
    	userRepository.lockUser(id);
    }
    
    //update
    public User UpdateUser(User u) throws Exception
    {
    	if(!userRepository.existsById(u.getId()))
    		throw new Exception("User does not exist !! ");
    	
		return userRepository.save(u);
    }
    
    //read (avec pagination)
    public Page<User> findUsers(int pageNumber,String keyword,String sortField,String SortDir)
    {
    	Pageable pageable;
 
    	// the field of sorting 
    	Sort sort = Sort.by((SortDir.equals("asc") ? Direction.ASC : Direction.DESC), sortField);
    	
    	
    	pageable = PageRequest.of(pageNumber,6,sort);
    	if (keyword!=null)
    		return userRepository.findAll(keyword,pageable); // sort + pagination + filtration
        return userRepository.findAll(pageable); // sort + pagination	
    }
    
    public User getUser(Long id)
    {
        return userRepository.findById(id).orElse(null);    	
    }

	public User findUserById(Long id)
	{
		User user = userRepository.findById(id).orElse(null);
		return user;
	}
}
