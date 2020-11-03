package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.ApartamentPhotoDAO;
import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ApartamentPhotoDAOimpl;
import com.lyndexter.buisnesslogic.model.ApartamentPhoto;
import com.lyndexter.buisnesslogic.service.ApartamentPhotoService;

public class ApartamentPhotoServiceImpl implements ApartamentPhotoService {
  
  ApartamentPhotoDAO entityDAO;
  
  @Override
  public CommonDAO<ApartamentPhoto, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ApartamentPhotoDAOimpl();
    }
    return entityDAO;
  }
}
