package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ApartamentReservedDAO;
import com.lyndexter.buisnesslogic.model.ApartamentReserved;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartamentReservedDAOimpl implements ApartamentReservedDAO {
  @Override
  public String getFindAll() {
    return "SELECT * FROM apartament_reserved";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM apartament_reserved WHERE apartament_reserved.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT apartament_reserved(apartament_id,reserved,wish,payment_transaction_id) VALUES"
        + " (?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE apartament_reserved SET apartament_id=?, reserved=?,wish=?,"
        + "payment_transaction_id=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM apartament_reserved WHERE id=?";
  }
  
  @Override
  public ApartamentReserved recordEntity(ResultSet resultSet) throws SQLException {
    return (ApartamentReserved) new Transformer<>(ApartamentReserved.class)
        .extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement,
                                         ApartamentReserved entity) throws SQLException {
    preparedStatement.setInt(1, entity.getApartamentId());
    preparedStatement.setBoolean(2, entity.getReserved());
    preparedStatement.setString(3, entity.getWish());
    preparedStatement.setInt(4, entity.getPaymentTransactionId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, ApartamentReserved entity)
      throws SQLException {
    preparedStatement.setInt(5, entity.getId());
    return preparedStatement;
  }
}
