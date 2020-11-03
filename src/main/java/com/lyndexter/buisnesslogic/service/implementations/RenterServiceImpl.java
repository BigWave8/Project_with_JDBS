package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.RenterDAOimpl;
import com.lyndexter.buisnesslogic.model.Renter;
import com.lyndexter.buisnesslogic.service.RenterService;

public class RenterServiceImpl implements RenterService {
  
  private CommonDAO<Renter, Integer> entityDAO;
  
  @Override
  public CommonDAO<Renter, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new RenterDAOimpl();
    }
    return entityDAO;
  }
}
