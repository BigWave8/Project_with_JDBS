package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.PaymentTransaction;
import com.lyndexter.buisnesslogic.service.implementations.PaymentTransactionServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class PaymentTransactionController {
  
  public List<PaymentTransaction> getPaymentTransactions() throws SQLException {
    return new PaymentTransactionServiceImpl().findAll();
  }
  
  public PaymentTransaction getPaymentTransaction(Integer id) throws SQLException {
    return new PaymentTransactionServiceImpl().findById(id);
  }
  
  public int setPaymentTransaction(PaymentTransaction paymentTransaction) throws SQLException {
    return new PaymentTransactionServiceImpl().create(paymentTransaction);
  }
  
  public int putPaymentTransaction(PaymentTransaction paymentTransaction) throws SQLException {
    return new PaymentTransactionServiceImpl().update(paymentTransaction);
  }
  
  public int removePaymentTransaction(Integer id) throws SQLException {
    return new PaymentTransactionServiceImpl().delete(id);
  }
}
