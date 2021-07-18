package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.ProductDao;
import com.daoimpl.ProductDaoImpl;
import com.entities.ProductEntity;

@Path("product")
public class ProductController {
	
	ProductDao productDaoImpl = new ProductDaoImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public List<ProductEntity> getAll(){
		return productDaoImpl.getAllProducts();
	}
}
