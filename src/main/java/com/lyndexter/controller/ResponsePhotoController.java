package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.ResponsePhoto;
import com.lyndexter.buisnesslogic.service.implementations.ResponsePhotoServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ResponsePhotoController {
  public List<ResponsePhoto> getResponsePhotos() throws SQLException {
    return new ResponsePhotoServiceImpl().findAll();
  }
  
  public ResponsePhoto getResponsePhoto(Integer id) throws SQLException {
    return new ResponsePhotoServiceImpl().findById(id);
  }
  
  public int setResponsePhoto(ResponsePhoto responsePhoto) throws SQLException {
    return new ResponsePhotoServiceImpl().create(responsePhoto);
  }
  
  public int putResponsePhoto(ResponsePhoto responsePhoto) throws SQLException {
    return new ResponsePhotoServiceImpl().update(responsePhoto);
  }
  
  public int removeResponsePhoto(Integer id) throws SQLException {
    return new ResponsePhotoServiceImpl().delete(id);
  }
}
