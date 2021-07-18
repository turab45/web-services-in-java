package com.dao;

import java.util.List;

import com.entities.ProductEntity;

public interface ProductDao {
	public Integer addProduct(ProductEntity productEntity);
	public Integer updateProduct(ProductEntity productEntity);
	public Integer deleteProduct(ProductEntity productEntity);
	public ProductEntity getProductById(Integer id);
	public List<ProductEntity> getAllProducts();

}
