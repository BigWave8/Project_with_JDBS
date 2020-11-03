package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.Renter;
import com.lyndexter.buisnesslogic.service.implementations.RenterServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class RenterController {
  
  public List<Renter> getRenters() throws SQLException {
    return new RenterServiceImpl().findAll();
  }
  
  public Renter getRenter(Integer id) throws SQLException {
    return new RenterServiceImpl().findById(id);
  }
  
  public int setRenter(Renter renter) throws SQLException {
    return new RenterServiceImpl().create(renter);
  }
  
  public int putRenter(Renter renter) throws SQLException {
    return new RenterServiceImpl().update(renter);
  }
  
  public int removeRenter(Integer id) throws SQLException {
    return new RenterServiceImpl().delete(id);
  }
}
