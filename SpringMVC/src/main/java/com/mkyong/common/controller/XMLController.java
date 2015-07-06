package com.mkyong.common.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.Position.Bias;

import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mkyong.common.model.Bill;
import com.mkyong.common.model.Coffee;

@Controller
@RequestMapping("/bill")
public class XMLController {

	@RequestMapping(value = "query/{name}", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXML(@PathVariable String name) {

		Coffee coffee = new Coffee(name, 100);

		return coffee;

	}

	// @RequestMapping(method = RequestMethod.GET)
	// public @ResponseBody Coffee get(@RequestParam("id") String id) {
	//
	// Coffee coffee = new Coffee(id, 100);
	//
	// return coffee;
	//
	// }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Coffee add(HttpServletRequest request) {

		String name = request.getParameter("json");
		

		Bill bill = new Gson().fromJson(name, Bill.class);

		Coffee coffee = new Coffee(name, 100);
		return coffee;

	}
}