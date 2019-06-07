package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservices.restfulwebservices.bean.FilterBean;
import com.rest.webservices.restfulwebservices.dao.UserDaoService;


@RestController
public class RestFiltering {
	

	@Autowired
	UserDaoService userService;
	
	
	//Retrieve single User
			@GetMapping("/users/filter")
			public MappingJacksonValue retrieveFilteredUser() {
				FilterBean filterBean = new FilterBean("Sachin","34","89012");
				SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");

				FilterProvider filters = new SimpleFilterProvider().addFilter("beanfilter", filter);

				MappingJacksonValue mapping = new MappingJacksonValue(filterBean);

				mapping.setFilters(filters);

				return mapping;
			
			}

}
