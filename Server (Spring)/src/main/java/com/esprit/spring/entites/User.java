package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter
@Entity
@NoArgsConstructor
public class User implements UserDetails{
	
	 @Id
	    @GeneratedValue(
	            strategy = GenerationType.SEQUENCE,
	            generator = "student_sequence"
	    )
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    @Temporal(TemporalType.DATE)
		private Date DateNaissance;
	    private String password;
	    @Enumerated(EnumType.STRING)
	    private UserRole appUserRole;
	    private Boolean locked = false;
	    private Boolean enabled = false;
	    @Enumerated(EnumType.STRING)
		private Profession profession;
		
	    @OneToMany(cascade = CascadeType.ALL, mappedBy="u")
		private Set<Commande> commandes=new HashSet<>();

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
		private Set<Reclamation> reclamation;

		
		@OneToMany(cascade=CascadeType.ALL )
		private Set<Adresse> adresses; 

	    public User(String firstName,
	                   String lastName,
	                   String email,
					   Date dateNaissance,
					   Profession profession,
	                   String password,
	                   UserRole appUserRole) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.password = password;
	        this.appUserRole = appUserRole;
			this.profession = profession;
			this.DateNaissance = dateNaissance;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
	        return Collections.singletonList(authority);
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return email;
	    }

	   

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return !locked;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return enabled;
	    }

	public void add(Commande commande) {

		if (commande != null) {

			if (commandes == null) {
				commandes = new HashSet<>();
			}

			commandes.add(commande);
			commande.setU(this);
		}
	}

}