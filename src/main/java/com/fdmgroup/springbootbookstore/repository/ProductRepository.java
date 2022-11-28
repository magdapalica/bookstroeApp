package com.fdmgroup.springbootbookstore.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fdmgroup.springbootbookstore.model.User;
import com.fdmgroup.springbootbookstore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("""
			SELECT p
			FROM Product p
			WHERE (UPPER(TITLE) LIKE '%' || UPPER(?1) || '%'
			       OR UPPER(description) LIKE '%' || UPPER(?1) || '%'
			       OR UPPER(author) LIKE '%' || UPPER(?1) || '%'
			       OR UPPER(category) LIKE '%' || UPPER(?1) || '%')

			  """)
	
	public List<Product> findProducts(String text, String title, String category,String author, double maxPrice);

			@Query("SELECT DISTINCT title FROM Product p")
			public List<String> allTitle();
			
			@Query("SELECT DISTINCT author FROM Product p")
			public List<String> allAuthor();

			@Query("SELECT DISTINCT category FROM Product p")
			public List<String> allCategories();
		
	


}
