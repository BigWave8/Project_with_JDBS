package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.PhotoDAOimpl;
import com.lyndexter.buisnesslogic.model.Photo;
import com.lyndexter.buisnesslogic.service.PhotoService;

public class PhotoServiceImpl implements PhotoService {
  
  private CommonDAO<Photo, Integer> entityDAO;
  
  @Override
  public CommonDAO<Photo, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new PhotoDAOimpl();
    }
    return entityDAO;
  }
}
