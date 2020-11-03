package com.lyndexter.buisnesslogic.model;


import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "apartament_response")
public class ApartamentResponse {
  
  @PrimaryKey
  @Column(name = "response_id", type = "int")
  private Integer responseId;
  
  @Column(name = "apartament_id", type = "int")
  private Integer apartamentId;
  
  public ApartamentResponse() {
  }
  
  public ApartamentResponse(Integer responseId, Integer apartamentId) {
    this.responseId = responseId;
    this.apartamentId = apartamentId;
  }
  
  public Integer getResponseId() {
    return responseId;
  }
  
  public void setResponseId(Integer responseId) {
    this.responseId = responseId;
  }
  
  public Integer getApartamentId() {
    return apartamentId;
  }
  
  public void setApartamentId(Integer apartamentId) {
    this.apartamentId = apartamentId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    ApartamentResponse that = (ApartamentResponse) o;
    
    if (!responseId.equals(that.responseId)) {
      return false;
    }
    return apartamentId.equals(that.apartamentId);
  }
  
  @Override
  public int hashCode() {
    int result = responseId.hashCode();
    result = 31 * result + apartamentId.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %n", responseId, apartamentId);
  }
}
