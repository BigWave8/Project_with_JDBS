package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.Apartament;
import com.lyndexter.buisnesslogic.service.implementations.ApartamentServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ApartamentController {
  
  public List<Apartament> getApartaments() throws SQLException {
    return new ApartamentServiceImpl().findAll();
  }
  
  public Apartament getApartament(Integer id) throws SQLException {
    return new ApartamentServiceImpl().findById(id);
  }
  
  public int setApartament(Apartament apartament) throws SQLException {
    return new ApartamentServiceImpl().create(apartament);
  }
  
  public int putApartament(Apartament apartament) throws SQLException {
    return new ApartamentServiceImpl().update(apartament);
  }
  
  public int removeApartament(Integer id) throws SQLException {
    return new ApartamentServiceImpl().delete(id);
  }
}
