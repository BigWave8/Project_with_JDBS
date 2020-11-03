package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.ResponsePhotoDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.ResponsePhotoDAOimpl;
import com.lyndexter.buisnesslogic.model.ResponsePhoto;
import com.lyndexter.buisnesslogic.service.ResponsePhotoService;

public class ResponsePhotoServiceImpl implements ResponsePhotoService {
  
  private ResponsePhotoDAO entityDAO;
  
  @Override
  public CommonDAO<ResponsePhoto, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new ResponsePhotoDAOimpl();
    }
    return entityDAO;
  }
}
