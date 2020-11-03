package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ApartamentPhotoDAO;
import com.lyndexter.buisnesslogic.model.ApartamentPhoto;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartamentPhotoDAOimpl implements ApartamentPhotoDAO {
  public String getFindAll() {
    return "SELECT * FROM apartament_photo";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM apartament_photo WHERE apartament_photo.apartament_id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT apartament_photo(photo_id,apartament_id) VALUES (?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE apartament_photo SET photo_id=? WHERE apartament_id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM apartament_photo WHERE apartament_id=?";
  }
  
  @Override
  public ApartamentPhoto recordEntity(ResultSet resultSet) throws SQLException {
    return (ApartamentPhoto) new Transformer<>(ApartamentPhoto.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement,
                                         ApartamentPhoto entity) throws SQLException {
    preparedStatement.setInt(1, entity.getPhotoId());
    preparedStatement.setInt(2, entity.getApartamentId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, ApartamentPhoto entity)
      throws SQLException {
    preparedStatement.setInt(2, entity.getApartamentId());
    return preparedStatement;
  }
}
