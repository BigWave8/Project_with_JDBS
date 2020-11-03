package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;
import java.math.BigDecimal;

@Table(name = "apartament")
public class Apartament {
  
  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;
  
  @Column(name = "area", type = "double")
  private double area;
  
  @Column(name = "adress", length = 60)
  private String adress;
  
  @Column(name = "ceiling_high", type = "double")
  private double ceilingHigh;
  
  @Column(name = "room_number", type = "int")
  private int roomNumber;
  
  @Column(name = "recomended_people_count", type = "int")
  private int recommendPeopleCount;
  
  @Column(name = "price", type = "bigDecimal")
  private BigDecimal priceInUAH;
  
  @Column(name = "lessor_id", type = "int")
  private Integer lessorId;
  
  public Apartament() {
  }
  
  public Apartament(int id, double area, String adress, double ceilingHigh, int roomNumber,
                    int recommendPeopleCount, BigDecimal priceInUAH, Integer lessorId) {
    this.id = id;
    this.area = area;
    this.adress = adress;
    this.ceilingHigh = ceilingHigh;
    this.roomNumber = roomNumber;
    this.recommendPeopleCount = recommendPeopleCount;
    this.priceInUAH = priceInUAH;
    this.lessorId = lessorId;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public double getArea() {
    return area;
  }
  
  public void setArea(double area) {
    this.area = area;
  }
  
  public String getAdress() {
    return adress;
  }
  
  public void setAdress(String adress) {
    this.adress = adress;
  }
  
  public double getCeilingHigh() {
    return ceilingHigh;
  }
  
  public void setCeilingHigh(double ceilingHigh) {
    this.ceilingHigh = ceilingHigh;
  }
  
  public int getRoomNumber() {
    return roomNumber;
  }
  
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }
  
  public int getRecommendPeopleCount() {
    return recommendPeopleCount;
  }
  
  public void setRecommendPeopleCount(int recommendPeopleCount) {
    this.recommendPeopleCount = recommendPeopleCount;
  }
  
  public BigDecimal getPriceInUAH() {
    return priceInUAH;
  }
  
  public void setPriceInUAH(BigDecimal priceInUAH) {
    this.priceInUAH = priceInUAH;
  }
  
  public Integer getLessorId() {
    return lessorId;
  }
  
  public void setLessorId(Integer lessorId) {
    this.lessorId = lessorId;
  }
  
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    Apartament that = (Apartament) o;
    
    if (id != that.id) {
      return false;
    }
    if (Double.compare(that.area, area) != 0) {
      return false;
    }
    if (Double.compare(that.ceilingHigh, ceilingHigh) != 0) {
      return false;
    }
    if (roomNumber != that.roomNumber) {
      return false;
    }
    if (recommendPeopleCount != that.recommendPeopleCount) {
      return false;
    }
    if (!adress.equals(that.adress)) {
      return false;
    }
    if (!priceInUAH.equals(that.priceInUAH)) {
      return false;
    }
    {
      return lessorId.equals(that.lessorId);
    }
  }
  
  @Override
  public int hashCode() {
    int result;
    long temp;
    result = id;
    temp = Double.doubleToLongBits(area);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + adress.hashCode();
    temp = Double.doubleToLongBits(ceilingHigh);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + roomNumber;
    result = 31 * result + recommendPeopleCount;
    result = 31 * result + priceInUAH.hashCode();
    result = 31 * result + lessorId.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return String
        .format("%3s    %-8s %-60s %-8s %-6s %-6s %-12s %-6s%n", id, area, adress, ceilingHigh,
            roomNumber, recommendPeopleCount, priceInUAH, lessorId);
  }
}
