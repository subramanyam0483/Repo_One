package com.globomart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.model.ProductModel;
import com.globomart.service.IProductService;

@RestController
public class WelcomeController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	IProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		List<ProductModel> product = productService.findAll();
		System.out.println(product);
		model.addAttribute("user", product);
		return "welcome";
	}

}