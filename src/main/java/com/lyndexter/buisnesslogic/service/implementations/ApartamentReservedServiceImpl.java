package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ApartamentReservedDAOimpl;
import com.lyndexter.buisnesslogic.model.ApartamentReserved;
import com.lyndexter.buisnesslogic.service.ApartamentReservedService;

public class ApartamentReservedServiceImpl implements ApartamentReservedService {
  
  private CommonDAO<ApartamentReserved, Integer> entityDAO;
  
  @Override
  public CommonDAO<ApartamentReserved, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ApartamentReservedDAOimpl();
    }
    return entityDAO;
  }
}
