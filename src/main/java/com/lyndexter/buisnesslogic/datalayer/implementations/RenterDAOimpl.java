package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.RenterDAO;
import com.lyndexter.buisnesslogic.model.Renter;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RenterDAOimpl implements RenterDAO {
  
  
  @Override
  public String getFindAll() {
    return "SELECT * FROM renter";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM renter WHERE renter.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT renter(name,surname,last_name,phone_number,card_number,"
        + "photo_id) VALUES (?,?,?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE renter SET name=?, surname=?,last_name=?,phone_number=?,"
        + "card_number=?,photo_id=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM renter43 WHERE id=?";
  }
  
  
  @Override
  public Renter recordEntity(ResultSet resultSet) throws SQLException {
    return (Renter) new Transformer<>(Renter.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Renter entity)
      throws SQLException {
    preparedStatement.setString(1, entity.getFirstName());
    preparedStatement.setString(2, entity.getSurname());
    preparedStatement.setString(3, entity.getLastName());
    preparedStatement.setString(4, entity.getPhoneNumber());
    preparedStatement.setString(5, entity.getCardNumber());
    preparedStatement.setInt(6, entity.getPhotoId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Renter entity)
      throws SQLException {
    preparedStatement.setInt(7, entity.getId());
    return preparedStatement;
  }
}
