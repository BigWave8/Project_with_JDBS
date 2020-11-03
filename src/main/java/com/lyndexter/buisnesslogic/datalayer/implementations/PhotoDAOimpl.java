package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.PhotoDAO;
import com.lyndexter.buisnesslogic.model.Photo;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhotoDAOimpl implements PhotoDAO {
  
  @Override
  public String getFindAll() {
    return "SELECT * FROM photo";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM photo WHERE photo.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT photo(type,image,image_size,name) VALUES (?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE photo SET type=?, image=?,image_size=?,name=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM photo WHERE id=?";
  }
  
  @Override
  public Photo recordEntity(ResultSet resultSet) throws SQLException {
    return (Photo) new Transformer<>(Photo.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Photo entity)
      throws SQLException {
    preparedStatement.setString(1, entity.getType());
    preparedStatement.setBlob(2, new SerialBlob(entity.getImage()));
    preparedStatement.setString(3, entity.getImageSize());
    preparedStatement.setString(4, entity.getName());
    return preparedStatement;
    
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Photo entity)
      throws SQLException {
    preparedStatement.setInt(5, entity.getId());
    return preparedStatement;
  }
}
