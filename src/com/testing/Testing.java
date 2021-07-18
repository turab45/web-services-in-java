package com.testing;

import com.dao.ProductDao;
import com.daoimpl.ProductDaoImpl;
import com.entities.ProductEntity;

public class Testing {
	public static void main(String args[]) {
		
		ProductDao productDaoImpl = new ProductDaoImpl();
		
		ProductEntity productEntity = new ProductEntity();
		productEntity.setTitle("Oppo");
		productEntity.setPrice(12000);
		productEntity.setStatus("Available");
		
		
		productDaoImpl.addProduct(productEntity);
	}
}
