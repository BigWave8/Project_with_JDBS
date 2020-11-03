package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "response")
public class Response {
  
  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;
  
  @Column(name = "coment")
  private String coment;
  
  @Column(name = "rate", type = "int")
  private Integer rate;
  
  public Response() {
  }
  
  public Response(Integer id, String coment, Integer rate) {
    this.id = id;
    this.coment = coment;
    this.rate = rate;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getComent() {
    return coment;
  }
  
  public void setComent(String coment) {
    this.coment = coment;
  }
  
  public Integer getRate() {
    return rate;
  }
  
  public void setRate(Integer rate) {
    this.rate = rate;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    Response response = (Response) o;
    
    if (!id.equals(response.id)) {
      return false;
    }
    if (coment != null ? !coment.equals(response.coment) : response.coment != null) {
      return false;
    }
    return rate != null ? rate.equals(response.rate) : response.rate == null;
  }
  
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + (coment != null ? coment.hashCode() : 0);
    result = 31 * result + (rate != null ? rate.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %-40s %n", id, rate, coment);
  }
}
