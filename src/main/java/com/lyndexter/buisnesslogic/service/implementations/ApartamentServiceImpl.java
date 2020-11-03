package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ApartamentDAOimpl;
import com.lyndexter.buisnesslogic.model.Apartament;
import com.lyndexter.buisnesslogic.service.ApartamentService;

public class ApartamentServiceImpl implements ApartamentService {
  
  private CommonDAO<Apartament, Integer> entityDAO;
  
  @Override
  public CommonDAO<Apartament, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ApartamentDAOimpl();
    }
    return entityDAO;
  }
}
