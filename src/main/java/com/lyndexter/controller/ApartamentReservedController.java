package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.datalayer.implementations.ApartamentReservedDAOimpl;
import com.lyndexter.buisnesslogic.model.ApartamentReserved;
import java.sql.SQLException;
import java.util.List;

public class ApartamentReservedController {
  public List<ApartamentReserved> getApartamentReserveds() throws SQLException {
    return new ApartamentReservedDAOimpl().findAll();
  }
  
  public ApartamentReserved getApartamentReserved(Integer id) throws SQLException {
    return new ApartamentReservedDAOimpl().findById(id);
  }
  
  public int setApartamentReserved(ApartamentReserved lessor) throws SQLException {
    return new ApartamentReservedDAOimpl().create(lessor);
  }
  
  public int putApartamentReserved(ApartamentReserved lessor) throws SQLException {
    return new ApartamentReservedDAOimpl().update(lessor);
  }
  
  public int removeApartamentReserved(Integer id) throws SQLException {
    return new ApartamentReservedDAOimpl().delete(id);
  }
}
