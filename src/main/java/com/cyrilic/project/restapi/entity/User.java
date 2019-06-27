package com.cyrilic.project.restapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
    @Column(unique = true)
    @NotBlank
	private String email;
	
    @NotBlank
	private String password;

	public Long getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 */
	public User( String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User () {
		super();
	}

}