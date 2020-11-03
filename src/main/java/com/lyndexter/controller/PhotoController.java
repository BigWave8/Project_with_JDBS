package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.Photo;
import com.lyndexter.buisnesslogic.service.PhotoService;
import com.lyndexter.buisnesslogic.service.implementations.PhotoServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class PhotoController {
  public List<Photo> getPhotos() throws SQLException {
    PhotoService photoService = new PhotoServiceImpl();
    List<Photo> photos = photoService.findAll();
    return photos;
  }
  
  public Photo getPhoto(int id) throws SQLException {
    PhotoService photoService = new PhotoServiceImpl();
    return photoService.findById(id);
  }
  
  public int setPhoto(Photo photo) throws SQLException {
    return new PhotoServiceImpl().create(photo);
  }
  
  public int updatePhoto(Photo photo) throws SQLException {
    return new PhotoServiceImpl().update(photo);
  }
  
  public int removePhoto(Integer id) throws SQLException {
    return new PhotoServiceImpl().delete(id);
  }
  
}
