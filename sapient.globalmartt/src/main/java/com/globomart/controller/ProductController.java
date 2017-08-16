package com.globomart.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.globomart.model.ProductModel;
import com.globomart.service.IProductService;

@RestController
public class ProductController {
		private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

		@Autowired
		IProductService productService;

		@GET
		@Path("/allProduct")
		@Produces("application/json")
		public List<ProductModel> getProducts(){
		    	 return productService.findAll();
		}
	    public void addProduct(ProductModel productVo) {
	        productService.addProduct(productVo);
	        logger.info("Product has been added");
	    }

	    public List<ProductModel> getProductsByTypeAndName(final String type, final String name) {
	        return productService.getProductsByTypeAndName(type, name);
	    }

	    public List<ProductModel> getProductsByTypeAndName(final String type) {
	        return productService.getProductsByType(type);
	    }

	    public void deleteProduct(final Long id) {
	        productService.deleteProduct(id);
	    }
	    
}
