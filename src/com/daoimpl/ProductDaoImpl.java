package com.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.ProductDao;
import com.entities.ProductEntity;
import com.utils.Database;


public class ProductDaoImpl implements ProductDao{

	@Override
	public Integer addProduct(ProductEntity productEntity) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			row = (Integer) session.save(productEntity);
			
			transaction.commit();
			System.out.println("Successfully saved product.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer updateProduct(ProductEntity productEntity) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.update(productEntity);
			row = 1;
			
			transaction.commit();
			System.out.println("Successfully updated product.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public Integer deleteProduct(ProductEntity productEntity) {
		Integer row = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			session.remove(productEntity);
			row = 1;
			
			transaction.commit();
			System.out.println("Successfully deleted product.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return row;
	}

	@Override
	public ProductEntity getProductById(Integer id) {
		ProductEntity productEntity = null;
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			productEntity = session.get(ProductEntity.class, id);
			
			transaction.commit();
			System.out.println("Successfully fetched product by id.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return productEntity;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> allProducts = new ArrayList<ProductEntity>();
		try {
			
			SessionFactory factory = Database.getConnection();
			Session session = factory.openSession();

			Transaction transaction = session.beginTransaction();

			allProducts = session.createQuery("from ProductEntity").getResultList();
			
			transaction.commit();
			System.out.println("Successfully fetched all products.");
			
			session.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		return allProducts;
	}

}
