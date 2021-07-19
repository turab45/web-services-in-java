package com.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.sql.Update;

import com.dao.ProductDao;
import com.daoimpl.ProductDaoImpl;
import com.entities.ProductEntity;

@Path("product")
public class ProductController {
	
	ProductDao productDaoImpl = new ProductDaoImpl();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public ProductEntity create(ProductEntity productEntity) {
		productDaoImpl.addProduct(productEntity);
		return productEntity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public ProductEntity update(ProductEntity productEntity) {
		ProductEntity p = productDaoImpl.getProductById(productEntity.getId());
		p.setTitle(productEntity.getTitle());
		p.setPrice(productEntity.getPrice());
		p.setStatus(productEntity.getStatus());
		
		productDaoImpl.updateProduct(p);
		
		return p;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public String delete(@PathParam("id") Integer id) {
		ProductEntity p = productDaoImpl.getProductById(id);
		if (p != null) {
			Integer result = productDaoImpl.deleteProduct(p);
			if (result > 0) {
				return "Record deleted successfully";
				
			}
			return "Error";
		}
	
		return "Record not found!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getById/{id}")
	public ProductEntity getById(@PathParam("id") Integer id) {
		
		return productDaoImpl.getProductById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public List<ProductEntity> getAll(){
		return productDaoImpl.getAllProducts();
	}
}
