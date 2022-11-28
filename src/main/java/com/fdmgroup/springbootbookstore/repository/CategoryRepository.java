package com.fdmgroup.springbootbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fdmgroup.springbootbookstore.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

}


