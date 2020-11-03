package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "apartament_reserved")
public class ApartamentReserved {
  
  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;
  
  @Column(name = "apartament_id", type = "int")
  private Integer apartamentId;
  
  @Column(name = "reserved", type = "bool")
  private Boolean reserved;
  
  @Column(name = "wish")
  private String wish;
  
  @Column(name = "payment_transaction_id", type = "int")
  private Integer paymentTransactionId;
  
  public ApartamentReserved() {
  }
  
  public ApartamentReserved(Integer id, Integer apartamentId, Boolean reserved, String wish,
                            Integer paymentTransactionId) {
    this.id = id;
    this.apartamentId = apartamentId;
    this.reserved = reserved;
    this.wish = wish;
    this.paymentTransactionId = paymentTransactionId;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getApartamentId() {
    return apartamentId;
  }
  
  public void setApartamentId(Integer apartamentId) {
    this.apartamentId = apartamentId;
  }
  
  public Boolean getReserved() {
    return reserved;
  }
  
  public void setReserved(Boolean reserved) {
    this.reserved = reserved;
  }
  
  public String getWish() {
    return wish;
  }
  
  public void setWish(String wish) {
    this.wish = wish;
  }
  
  public Integer getPaymentTransactionId() {
    return paymentTransactionId;
  }
  
  public void setPaymentTransactionId(Integer paymentTransactionId) {
    this.paymentTransactionId = paymentTransactionId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    ApartamentReserved that = (ApartamentReserved) o;
    
    if (!id.equals(that.id)) {
      return false;
    }
    if (!apartamentId.equals(that.apartamentId)) {
      return false;
    }
    if (!reserved.equals(that.reserved)) {
      return false;
    }
    return paymentTransactionId != null ? paymentTransactionId.equals(that.paymentTransactionId) :
        that.paymentTransactionId == null;
  }
  
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + apartamentId.hashCode();
    result = 31 * result + reserved.hashCode();
    result = 31 * result + (paymentTransactionId != null ? paymentTransactionId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %-10s %-10s %-40s %n", id, apartamentId, reserved,
        paymentTransactionId, wish);
  }
}
