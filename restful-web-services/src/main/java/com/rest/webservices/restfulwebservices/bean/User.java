package com.rest.webservices.restfulwebservices.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="All details about the user")

public class User {
	
	private Integer id;
	@Size(min=2, message = "Name should have atleast 2 character")
	@ApiModelProperty(notes="Name should have atleast 2 character")
	private String name;
	@Past
	@ApiModelProperty(notes="Birth date should be in past")
	private Date birthDate;
	
	private int age;
	
	
	
	
	public User() {
		super();
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;	
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	

}
