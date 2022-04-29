package com.hotel.project.hotelproject.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


//@Getter
//@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
	
	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1 )
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence" )
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@Enumerated( EnumType.STRING )
	private UserRole userRole;
	//private String userRole;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    
	
    private Set<Role> roles = new HashSet<>();
	

	private Boolean locked = false;
	private Boolean enabled = false;
	
	public User(Long id, String firstName, String lastName, String email, String password, Boolean locked,
			Boolean enabled) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.locked = locked;
		this.enabled = enabled;
	}

	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		//this.userRole = userRole;
		//this.locked = locked;
		//this.enabled = enabled;
	}

	public User() {
		super();
	}
	/*
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority( userRole.name() );
		return Collections.singletonList( authority );
	}
	*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+getRoles()));
//		System.out.println("inside details impl "+grantedAuthorities.get(0).getAuthority());
		return grantedAuthorities;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole( Role role ) {
		this.roles.add(role);
	}
	/*

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	*/
	

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstName;
	}
	
	
	public String getLastname() {
		return lastName;
	}
	public String getEmail() {
		return email;
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", locked=" + locked + ", enabled=" + enabled
				+ "]";
	}


	
	
	

}
