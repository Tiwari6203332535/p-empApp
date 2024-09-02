package com.empapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee") // this help us to keep db and class name diiferent
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this will automatically increase the id number
	private long id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "email_id", nullable = false, unique = true) // if we dont give length default length will be 250
	private String email;

	@Column(name = "mobile", nullable = false, unique = true, length = 10)
	private String mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
