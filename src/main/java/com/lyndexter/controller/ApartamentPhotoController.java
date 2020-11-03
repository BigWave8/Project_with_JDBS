package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.ApartamentPhoto;
import com.lyndexter.buisnesslogic.service.implementations.ApartamentPhotoServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ApartamentPhotoController {
  public List<ApartamentPhoto> getApartamentPhotos() throws SQLException {
    return new ApartamentPhotoServiceImpl().findAll();
  }
  
  public ApartamentPhoto getApartamentPhoto(Integer id) throws SQLException {
    return new ApartamentPhotoServiceImpl().findById(id);
  }
  
  public int setApartamentPhoto(ApartamentPhoto apartamentPhoto) throws SQLException {
    return new ApartamentPhotoServiceImpl().create(apartamentPhoto);
  }
  
  public int putApartamentPhoto(ApartamentPhoto apartamentPhoto) throws SQLException {
    return new ApartamentPhotoServiceImpl().update(apartamentPhoto);
  }
  
  public int removeApartamentPhoto(Integer id) throws SQLException {
    return new ApartamentPhotoServiceImpl().delete(id);
  }
}
