package com.fdmgroup.springbootbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.springbootbookstore.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
