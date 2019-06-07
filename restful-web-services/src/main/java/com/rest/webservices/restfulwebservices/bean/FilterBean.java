package com.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("beanfilter")
public class FilterBean {
	
	private String name;
	private String age;
	private String id;
	
	
	public FilterBean(String name, String age, String id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
