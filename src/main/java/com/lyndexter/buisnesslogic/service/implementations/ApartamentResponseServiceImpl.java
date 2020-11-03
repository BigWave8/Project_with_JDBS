package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ApartamentResponseDAOimpl;
import com.lyndexter.buisnesslogic.model.ApartamentResponse;
import com.lyndexter.buisnesslogic.service.ApartamentResponseService;

public class ApartamentResponseServiceImpl implements ApartamentResponseService {
  
  private CommonDAO<ApartamentResponse, Integer> entityDAO;
  
  @Override
  public CommonDAO<ApartamentResponse, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ApartamentResponseDAOimpl();
    }
    return entityDAO;
  }
}
