package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ApartamentResponseDAO;
import com.lyndexter.buisnesslogic.model.ApartamentResponse;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartamentResponseDAOimpl implements ApartamentResponseDAO {
  public String getFindAll() {
    return "SELECT * FROM apartament_response";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM apartament_response WHERE apartament_response.response_id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT apartament_response(response_id,apartament_id) VALUES (?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE apartament_response SET apartament_id=? WHERE response_id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM apartament_response WHERE response_id=?";
  }
  
  @Override
  public ApartamentResponse recordEntity(ResultSet resultSet) throws SQLException {
    return (ApartamentResponse) new Transformer<>(ApartamentResponse.class)
        .extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement,
                                         ApartamentResponse entity) throws SQLException {
    preparedStatement.setInt(1, entity.getApartamentId());
    preparedStatement.setInt(2, entity.getResponseId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, ApartamentResponse entity)
      throws SQLException {
    preparedStatement.setInt(2, entity.getResponseId());
    return preparedStatement;
  }
}
