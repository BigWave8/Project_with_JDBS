package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.ApartamentResponse;
import com.lyndexter.buisnesslogic.service.implementations.ApartamentResponseServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ApartamentResponseController {
  public List<ApartamentResponse> getApartamentResponses() throws SQLException {
    return new ApartamentResponseServiceImpl().findAll();
  }
  
  public ApartamentResponse getApartamentResponse(Integer id) throws SQLException {
    return new ApartamentResponseServiceImpl().findById(id);
  }
  
  public int setApartamentResponse(ApartamentResponse apartamentResponse) throws SQLException {
    return new ApartamentResponseServiceImpl().create(apartamentResponse);
  }
  
  public int putApartamentResponse(ApartamentResponse apartamentResponse) throws SQLException {
    return new ApartamentResponseServiceImpl().update(apartamentResponse);
  }
  
  public int removeApartamentResponse(Integer id) throws SQLException {
    return new ApartamentResponseServiceImpl().delete(id);
  }
}
