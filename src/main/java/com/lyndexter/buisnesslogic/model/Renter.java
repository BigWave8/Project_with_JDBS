package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "renter")
public class Renter {
  
  @PrimaryKey
  @Column(name = "id", type = "int")
  private Integer id;
  
  @Column(name = "name", length = 20)
  private String firstName;
  
  @Column(name = "surname", length = 20)
  private String surname;
  
  @Column(name = "last_name", length = 20)
  private String lastName;
  
  @Column(name = "phone_number", length = 15)
  private String phoneNumber;
  
  @Column(name = "card_number", length = 16)
  private String cardNumber;
  
  @Column(name = "photo_id", type = "int", length = 5)
  private Integer photoId;
  
  public Renter() {
  }
  
  public Renter(Integer id, String firstName, String surname, String lastName,
                String phoneNumber, String cardNumber, Integer photoId) {
    this.id = id;
    this.firstName = firstName;
    this.surname = surname;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.cardNumber = cardNumber;
    this.photoId = photoId;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getSurname() {
    return surname;
  }
  
  public void setSurname(String surname) {
    this.surname = surname;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public String getCardNumber() {
    return cardNumber;
  }
  
  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }
  
  public Integer getPhotoId() {
    return photoId;
  }
  
  public void setPhotoId(Integer photoId) {
    this.photoId = photoId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    Renter renter = (Renter) o;
    
    if (!id.equals(renter.id)) {
      return false;
    }
    if (!firstName.equals(renter.firstName)) {
      return false;
    }
    if (!surname.equals(renter.surname)) {
      return false;
    }
    if (lastName != null ? !lastName.equals(renter.lastName) : renter.lastName != null) {
      return false;
    }
    if (!phoneNumber.equals(renter.phoneNumber)) {
      return false;
    }
    if (!cardNumber.equals(renter.cardNumber)) {
      return false;
    }
    return photoId != null ? photoId.equals(renter.photoId) : renter.photoId == null;
  }
  
  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + firstName.hashCode();
    result = 31 * result + surname.hashCode();
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + phoneNumber.hashCode();
    result = 31 * result + cardNumber.hashCode();
    result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String
        .format("%3s    %-22s %-22s %-22s %-18s %-19s %-5s%n", id, firstName, surname, lastName,
            phoneNumber,
            cardNumber, photoId);
  }
}
