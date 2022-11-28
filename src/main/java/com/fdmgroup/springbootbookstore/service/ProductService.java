package com.fdmgroup.springbootbookstore.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdmgroup.springbootbookstore.exception.ProductNotFoundException;
import com.fdmgroup.springbootbookstore.model.Product;
import com.fdmgroup.springbootbookstore.model.User;
import com.fdmgroup.springbootbookstore.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> findAllProducts() {
		return repo.findAll();
	}

	public void saveProduct(Product product) {
		repo.save(product);
	}

	public List<Product> findProducts(String text, String title, String category,String author, double maxPrice) {
		return repo.findProducts(text, title, category, author, maxPrice);
	}

	public void createNewProduct(Product place) {
		repo.save(place);
	}

	public Product findProductbyId(int id) throws ProductNotFoundException {
		Optional<Product> optPlace = repo.findById(id);
		return optPlace.orElseThrow(() -> new ProductNotFoundException(id));
	}

	public void deleteProduct(int id) {
		repo.deleteById(id);
	}

	public List<String> allAuthor() {
		return repo.allAuthor();
	}
	public List<String> allTitle() {
		return repo.allTitle();
	}

	public List<String> allCategories() {
		return repo.allCategories();
	}

	

}