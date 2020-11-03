package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.LessorDAO;
import com.lyndexter.buisnesslogic.model.Lessor;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LessorDAOimpl implements LessorDAO {
  
  @Override
  public String getFindAll() {
    return "SELECT * FROM lessor";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM lessor WHERE lessor.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT lessor(name,surname,last_name,phone_number,card_number,contact_info,"
        + "photo_id) VALUES (?,?,?,?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE lessor SET name=?, surname=?,last_name=?,phone_number=?,"
        + "card_number=?,contact_info=?,photo_id=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM lessor WHERE id=?";
  }
  
  @Override
  public Lessor recordEntity(ResultSet resultSet) throws SQLException {
    return (Lessor) new Transformer<>(Lessor.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Lessor entity)
      throws SQLException {
    preparedStatement.setString(1, entity.getFirstName());
    preparedStatement.setString(2, entity.getSurname());
    preparedStatement.setString(3, entity.getLastName());
    preparedStatement.setString(4, entity.getPhoneNumber());
    preparedStatement.setString(5, entity.getCardNumber());
    preparedStatement.setString(6, entity.getContactInfo());
    preparedStatement.setInt(7, entity.getPhotoId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Lessor entity)
      throws SQLException {
    preparedStatement.setInt(8, entity.getPhotoId());
    return preparedStatement;
  }
  
}
