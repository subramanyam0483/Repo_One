package com.globomart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.globomart.dao.IProductDAO;
import com.globomart.model.ProductModel;
import com.globomart.service.IProductService;

public class ProductServiceImpl implements IProductService {

	@Autowired
	IProductDAO productDao;

	public ProductServiceImpl(IProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public void addProduct(ProductModel productVo) {
		final ProductModel ProductModel = new ProductModel();
		ProductModel.setName(productVo.getName());
		ProductModel.setModelType(productVo.getModelType());
		productDao.save(ProductModel);
	}

	@Override
	public List<ProductModel> getProducts() {
		return productDao.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		productDao.delete(id);
	}

	@Override
	public List<ProductModel> getProductsByTypeAndName(String modelType, String name) {
		return productDao.findByTypeAndName(modelType, name);
	}

	@Override
	public List<ProductModel> getProductsByType(String modelType) {
		return productDao.findByType(modelType);
	}

	@Override
	public List<ProductModel> findAll() {
		return productDao.findAll();
	}

}
