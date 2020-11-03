package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ResponsePhotoDAO;
import com.lyndexter.buisnesslogic.model.ResponsePhoto;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsePhotoDAOimpl implements ResponsePhotoDAO {
  public String getFindAll() {
    return "SELECT * FROM response_photo";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM response_photo WHERE response_photo.response_id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT response_photo(photo_id,response_id) VALUES (?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE response_photo SET photo_id=? WHERE response_id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM response_photo WHERE response_id=?";
  }
  
  @Override
  public ResponsePhoto recordEntity(ResultSet resultSet) throws SQLException {
    return (ResponsePhoto) new Transformer<>(ResponsePhoto.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, ResponsePhoto entity)
      throws SQLException {
    preparedStatement.setInt(1, entity.getPhotoId());
    preparedStatement.setInt(2, entity.getResponseId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, ResponsePhoto entity)
      throws SQLException {
    preparedStatement.setInt(2, entity.getResponseId());
    return preparedStatement;
  }
}
