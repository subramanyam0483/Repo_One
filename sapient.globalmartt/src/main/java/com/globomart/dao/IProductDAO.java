package com.globomart.dao;

import java.util.List;

import com.globomart.model.ProductModel;

public interface IProductDAO {

	public abstract void save(ProductModel productModel);

	public abstract List<ProductModel> findAll();

	public abstract void delete(Long id);

	public abstract List<ProductModel> findByTypeAndName(String modelType, String name);

	public abstract List<ProductModel> findByType(String modelType);

}
