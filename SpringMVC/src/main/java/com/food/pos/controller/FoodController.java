package com.food.pos.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.food.pos.dto.Status;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	private FoodParmer foodParmer = new FoodParmer();

	
	@RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
	public Status modify(@PathVariable String id, HttpServletRequest request) {
		return new Status();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Status delete(@PathVariable String id, HttpServletRequest request) {
		return new Status();
	}
	
	
	
	
}
