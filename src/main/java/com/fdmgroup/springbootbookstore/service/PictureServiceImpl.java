package com.fdmgroup.springbootbookstore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.springbootbookstore.model.Picture;
import com.fdmgroup.springbootbookstore.repository.PictureRepository;

public class PictureServiceImpl implements PictureService{
	
	private PictureRepository repo;
	
	@Autowired
	public PictureServiceImpl(PictureRepository repo) {
		this.repo = repo;
	}

	@Override
	public Picture getPictureById(int id) {
		
		return repo.getById(id);
	}

	@Override
	public void savePicture(Picture picture) {
		repo.save(picture);
		
		
	}

}
