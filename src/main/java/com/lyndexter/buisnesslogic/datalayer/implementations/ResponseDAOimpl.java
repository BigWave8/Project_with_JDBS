package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ResponseDAO;
import com.lyndexter.buisnesslogic.model.Response;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseDAOimpl implements ResponseDAO {
  public String getFindAll() {
    return "SELECT * FROM response";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM response WHERE response.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT response(coment,rate) VALUES (?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE response SET coment=?, rate=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM response WHERE id=?";
  }
  
  @Override
  public Response recordEntity(ResultSet resultSet) throws SQLException {
    return (Response) new Transformer<>(Response.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Response entity)
      throws SQLException {
    preparedStatement.setString(1, entity.getComent());
    preparedStatement.setInt(2, entity.getRate());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Response entity)
      throws SQLException {
    preparedStatement.setInt(3, entity.getId());
    return preparedStatement;
  }
}
