package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.LessorDAOimpl;
import com.lyndexter.buisnesslogic.model.Lessor;
import com.lyndexter.buisnesslogic.service.LessorService;

public class LessorServiceImpl implements LessorService {
  
  private CommonDAO<Lessor, Integer> entityDAO;
  
  @Override
  public CommonDAO<Lessor, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new LessorDAOimpl();
    }
    return entityDAO;
  }
}
