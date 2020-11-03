package com.lyndexter.buisnesslogic.service.implementations;

import com.lyndexter.buisnesslogic.datalayer.CommonDAO;
import com.lyndexter.buisnesslogic.datalayer.implementations.PaymentTransactionDAOimpl;
import com.lyndexter.buisnesslogic.model.PaymentTransaction;
import com.lyndexter.buisnesslogic.service.PaymentTransactionService;

public class PaymentTransactionServiceImpl implements PaymentTransactionService {
  
  CommonDAO<PaymentTransaction, Integer> entityDAO;
  
  @Override
  public CommonDAO<PaymentTransaction, Integer> giveDAOobject() {
    if (entityDAO == null) {
      entityDAO = new PaymentTransactionDAOimpl();
    }
    return entityDAO;
  }
}
