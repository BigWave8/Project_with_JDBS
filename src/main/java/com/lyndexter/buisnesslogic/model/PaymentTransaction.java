package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "payment_transaction")
public class PaymentTransaction {
  
  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;
  
  @Column(name = "renter_id", type = "int")
  private Integer renterId;
  
  @Column(name = "lessor_id", type = "int")
  private Integer lessorId;
  
  @Column(name = "renter_payment", type = "bool")
  private Boolean renterPayment;
  
  @Column(name = "lessor_recieve_money", type = "bool")
  private Boolean recievePayment;
  
  public PaymentTransaction() {
  }
  
  public PaymentTransaction(Integer id, Integer renterId, Integer lessorId, Boolean renterPayment,
                            Boolean recievePayment) {
    this.id = id;
    this.renterId = renterId;
    this.lessorId = lessorId;
    this.renterPayment = renterPayment;
    this.recievePayment = recievePayment;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getRenterId() {
    return renterId;
  }
  
  public void setRenterId(Integer renterId) {
    this.renterId = renterId;
  }
  
  public Integer getLessorId() {
    return lessorId;
  }
  
  public void setLessorId(Integer lessorId) {
    this.lessorId = lessorId;
  }
  
  public Boolean getRenterPayment() {
    return renterPayment;
  }
  
  public void setRenterPayment(Boolean renterPayment) {
    this.renterPayment = renterPayment;
  }
  
  public Boolean getRecievePayment() {
    return recievePayment;
  }
  
  public void setRecievePayment(Boolean recievePayment) {
    this.recievePayment = recievePayment;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    PaymentTransaction that = (PaymentTransaction) o;
    
    if (!id.equals(that.id)) {
      return false;
    }
    if (!renterId.equals(that.renterId)) {
      return false;
    }
    if (!lessorId.equals(that.lessorId)) {
      return false;
    }
    if (!renterPayment.equals(that.renterPayment)) {
      return false;
    }
    return recievePayment.equals(that.recievePayment);
  }
  
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + renterId.hashCode();
    result = 31 * result + lessorId.hashCode();
    result = 31 * result + renterPayment.hashCode();
    result = 31 * result + recievePayment.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-8s %-8s %-10s %-10s%n", id, renterId, lessorId, recievePayment,
        recievePayment);
  }
}
