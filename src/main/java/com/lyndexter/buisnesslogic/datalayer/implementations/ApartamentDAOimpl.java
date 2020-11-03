package com.lyndexter.buisnesslogic.datalayer.implementations;

import com.lyndexter.buisnesslogic.datalayer.ApartamentDAO;
import com.lyndexter.buisnesslogic.model.Apartament;
import com.lyndexter.buisnesslogic.transformer.Transformer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApartamentDAOimpl implements ApartamentDAO {
  
  @Override
  public String getFindAll() {
    return "SELECT * FROM apartament";
  }
  
  @Override
  public String getFindOfElement() {
    return "SELECT * FROM apartament WHERE apartament.id = ?";
  }
  
  @Override
  public String getCreate() {
    return "INSERT apartament(area,adress,ceiling_high,room_number,"
        + "recomended_people_count,price,lessor_id) VALUES (?,?,?,?,?,?,?)";
  }
  
  @Override
  public String getUpdate() {
    return "UPDATE apartament SET area=?, adress=?,ceiling_high=?,room_number=?,"
        + "recomended_people_count=?,price=?,lessor_id=? WHERE id=?";
  }
  
  @Override
  public String getRemove() {
    return "DELETE FROM apartament WHERE id=?";
  }
  
  @Override
  public Apartament recordEntity(final ResultSet resultSet) throws SQLException {
    return (Apartament) new Transformer<>(Apartament.class).extractDataToModel(resultSet);
  }
  
  @Override
  public PreparedStatement setParameters(PreparedStatement preparedStatement, Apartament entity)
      throws SQLException {
    preparedStatement.setDouble(1, entity.getArea());
    preparedStatement.setString(2, entity.getAdress());
    preparedStatement.setDouble(3, entity.getCeilingHigh());
    preparedStatement.setInt(4, entity.getRoomNumber());
    preparedStatement.setInt(5, entity.getRecommendPeopleCount());
    preparedStatement.setBigDecimal(6, entity.getPriceInUAH());
    preparedStatement.setInt(7, entity.getLessorId());
    return preparedStatement;
  }
  
  @Override
  public PreparedStatement setId(PreparedStatement preparedStatement, Apartament entity)
      throws SQLException {
    preparedStatement.setInt(8, entity.getId());
    return preparedStatement;
  }
}
