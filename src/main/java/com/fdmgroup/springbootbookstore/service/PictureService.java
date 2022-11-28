package com.fdmgroup.springbootbookstore.service;

import com.fdmgroup.springbootbookstore.model.Picture;

public interface PictureService {
	
	Picture getPictureById(int id);
	void savePicture(Picture picture);

}
