package com.globomart.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.globomart.dao.IProductDAO;
import com.globomart.model.ProductModel;

public class ProductDAOImpl implements IProductDAO {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void save(ProductModel productModel) {

	}

	@Override
	public List<ProductModel> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM product";
		List<ProductModel> result = namedParameterJdbcTemplate.query(sql, params, productDtoRowMapper);

		return result;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public List<ProductModel> findByTypeAndName(String type, String name) {
		return null;
	}

	@Override
	public List<ProductModel> findByType(String type) {
		return null;
	}

	private RowMapper<ProductModel> productDtoRowMapper = new RowMapper<ProductModel>() {
		@Override
		public ProductModel mapRow(ResultSet resultSet, int i) throws SQLException {
			ProductModel productModel = new ProductModel();
			productModel.setId(resultSet.getLong("id"));
			productModel.setName(resultSet.getString("name"));
			productModel.setModelType(resultSet.getString("modelType"));
			return productModel;
		}
	};

}
