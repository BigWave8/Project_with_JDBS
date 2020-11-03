package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.PaymentTransactionDAO;
import com.lyndexter.buisnesslogic.model.PaymentTransaction;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentTransactionDAOimpl implements PaymentTransactionDAO {
  @Override
  public String getFindAll() {
    return "SELECT * FROM payment_transaction";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM payment_transaction WHERE payment_transaction.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT payment_transaction(renter_id,lessor_id,renter_payment,lessor_recieve_money) "
        + "VALUES (?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE payment_transaction SET renter_id=?, lessor_id=?,renter_payment=?,"
        + "lessor_recieve_money=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM payment_transaction WHERE id=?";
  }
  
  @Override
  public PaymentTransaction recordEntity(ResultSet resultSet) throws SQLException {
    return (PaymentTransaction) new Transformer<>(PaymentTransaction.class)
        .extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement,
                                         PaymentTransaction entity) throws SQLException {
    preparedStatement.setInt(1, entity.getRenterId());
    preparedStatement.setInt(2, entity.getLessorId());
    preparedStatement.setBoolean(3, entity.getRenterPayment());
    preparedStatement.setBoolean(4, entity.getRecievePayment());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, PaymentTransaction entity)
      throws SQLException {
    preparedStatement.setInt(5, entity.getId());
    return preparedStatement;
  }
}
