package com.fdmgroup.springbootbookstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.springbootbookstore.security.DefaultUserDetailsService;
import com.fdmgroup.springbootbookstore.exception.ProductNotFoundException;
import com.fdmgroup.springbootbookstore.model.Picture;
import com.fdmgroup.springbootbookstore.model.User;
import com.fdmgroup.springbootbookstore.model.Product;
import com.fdmgroup.springbootbookstore.service.ProductService;


public class ProductController {
	
	@Autowired
	private ProductService service;
	@Autowired
	private DefaultUserDetailsService userService;
	
	@GetMapping(value = "/")
	public String index(Authentication authentication,ModelMap model) {
		populateModel(model,authentication);
		return "index";
	}
//	@GetMapping(value = "/admin/categories")
//	public String Category() {
//		return "category";
//	}

	@RequestMapping(value = "/productList")
	public String productList(ModelMap model, @RequestParam String search, @RequestParam String author,
			@RequestParam String category, @RequestParam String maxPrice, @RequestParam String title) throws ParseException {
		double price = Double.parseDouble(maxPrice);
		List<Product> products = service.findProducts(search, title, author, category, price);
		model.addAttribute("products", products);
		return "productList";
	}
	
	@GetMapping(value = "/add")
	public String addNewProduct(ModelMap model, Authentication authentication) {
		populateModel(model,  authentication);
		return "add";
	}
	
	private void populateModel(ModelMap model, Authentication authentication) {
		model.addAttribute("products", service.findAllProducts());
		model.addAttribute("title", service.allTitle());
		model.addAttribute("categories", service.allCategories());
		model.addAttribute("authors", service.allAuthor());
		
	}
	
	@PostMapping(value = "/add")
	public String addNewProduct(Authentication authentication, ModelMap model, @RequestParam MultipartFile[] file,
			@RequestParam String author, @RequestParam String description, @RequestParam String title,
			@RequestParam String category, @RequestParam String price) {
		double priceDouble = Double.parseDouble(price);
		User renter = userService.getCurrentUser(authentication);
		Product product = new Product();
//		service.createNewProduct(product);

		InputStream inputStream;

		List<Picture> pictures = new ArrayList<>();

		for (MultipartFile photo : file) {
			if (!photo.getOriginalFilename().isEmpty()) {

				Picture picture = new Picture(photo.getOriginalFilename());

				pictures.add(picture);

				Path destinationFile = Paths.get(System.getProperty("user.dir"), "src/main/webapp/product-pictures",

						photo.getOriginalFilename());

				try {
					inputStream = photo.getInputStream();
					Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					e.printStackTrace();
					return "add";
				}
			}

		}
		product.setPictures(pictures);

		service.saveProduct(product);

		return "redirect:/add";
	}
	
	@GetMapping(value = "/products/{id}")
	public String goToDetails(Authentication authentication,ModelMap model, @PathVariable int id) throws ProductNotFoundException {
		Product product = service.findProductbyId(id);
		model.addAttribute("product", product);
		
		return "details";
	}
		
	@PostMapping(value = "/deleteProduct")
	public String deleteProduct(ModelMap model, @RequestParam("id") int id) {
		service.deleteProduct(id);
		return "redirect:/";
	}
	@ExceptionHandler(value = ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView productNotFound(ProductNotFoundException ex) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("productNotFound");
		mav.addObject("message", ex.getMessage());

		return mav;
	}
}
		
