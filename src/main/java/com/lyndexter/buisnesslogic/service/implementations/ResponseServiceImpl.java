package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ResponseDAOimpl;
import com.lyndexter.buisnesslogic.model.Response;
import com.lyndexter.buisnesslogic.service.ResponseService;

public class ResponseServiceImpl implements ResponseService {
  
  CommonDAO<Response, Integer> entityDAO;
  
  @Override
  public CommonDAO<Response, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ResponseDAOimpl();
    }
    return entityDAO;
  }
}
