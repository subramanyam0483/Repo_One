package com.globomart.service;

import java.util.List;

import com.globomart.model.ProductModel;

public interface IProductService {

	public abstract void addProduct(ProductModel productVo);

	public abstract List<ProductModel> getProductsByTypeAndName(String modelType, String name);

	public abstract List<ProductModel> getProductsByType(String modelType);

	public abstract List<ProductModel> getProducts();

	public abstract void deleteProduct(Long id);

	public abstract List<ProductModel> findAll();

}
