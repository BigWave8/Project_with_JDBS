package com.lyndexter.controller;

import com.lyndexter.buisnesslogic.model.Lessor;
import com.lyndexter.buisnesslogic.service.implementations.LessorServiceImpl;
import java.sql.SQLException;
import java.util.List;

public class LessorController {
  
  public List<Lessor> getLessors() throws SQLException {
    return new LessorServiceImpl().findAll();
  }
  
  public Lessor getLessor(Integer id) throws SQLException {
    return new LessorServiceImpl().findById(id);
  }
  
  public int setLessor(Lessor lessor) throws SQLException {
    return new LessorServiceImpl().create(lessor);
  }
  
  public int putLessor(Lessor lessor) throws SQLException {
    return new LessorServiceImpl().update(lessor);
  }
  
  public int removeLessor(Integer id) throws SQLException {
    return new LessorServiceImpl().delete(id);
  }
}
