package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.Response;
import com.lyndexter.buisnesslogic.service.implementations.ResponseServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class ResponseController {
  public List<Response> getResponses() throws SQLException {
    return new ResponseServiceImpl().findAll();
  }
  
  public Response getResponse(Integer id) throws SQLException {
    return new ResponseServiceImpl().findById(id);
  }
  
  public int setResponse(Response response) throws SQLException {
    return new ResponseServiceImpl().create(response);
  }
  
  public int putResponse(Response response) throws SQLException {
    return new ResponseServiceImpl().update(response);
  }
  
  public int removeResponse(Integer id) throws SQLException {
    return new ResponseServiceImpl().delete(id);
  }
}
