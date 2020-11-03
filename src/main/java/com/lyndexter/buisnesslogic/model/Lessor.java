package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "lessor")
public class Lessor {
  
  @PrimaryKey
  @Column(name = "id", type = "int", length = 5)
  private int id;
  
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
  
  @Column(name = "contact_info")
  private String contactInfo;
  
  @Column(name = "photo_id", type = "int", length = 5)
  private Integer photoId;
  
  public Lessor() {
  }
  
  public Lessor(int id, String firstName, String surname, String lastName, String phoneNumber,
                String cardNumber, String contactInfo, Integer photoId) {
    this.id = id;
    this.firstName = firstName;
    this.surname = surname;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.cardNumber = cardNumber;
    this.contactInfo = contactInfo;
    this.photoId = photoId;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
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
  
  public String getContactInfo() {
    return contactInfo;
  }
  
  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
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
    
    Lessor lessor = (Lessor) o;
    
    if (id != lessor.id) {
      return false;
    }
    if (!firstName.equals(lessor.firstName)) {
      return false;
    }
    if (!surname.equals(lessor.surname)) {
      return false;
    }
    if (lastName != null ? !lastName.equals(lessor.lastName) : lessor.lastName != null) {
      return false;
    }
    if (!phoneNumber.equals(lessor.phoneNumber)) {
      return false;
    }
    if (!cardNumber.equals(lessor.cardNumber)) {
      return false;
    }
    if (contactInfo != null ? !contactInfo.equals(lessor.contactInfo) :
        lessor.contactInfo != null) {
      return false;
    }
    return photoId != null ? photoId.equals(lessor.photoId) : lessor.photoId == null;
  }
  
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + firstName.hashCode();
    result = 31 * result + surname.hashCode();
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + phoneNumber.hashCode();
    result = 31 * result + cardNumber.hashCode();
    result = 31 * result + (contactInfo != null ? contactInfo.hashCode() : 0);
    result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String
        .format("%3s    %-22s %-22s %-22s %-18s %-19s %-60s %-5s%n", id, firstName, surname,
            lastName,
            phoneNumber,
            cardNumber, contactInfo, photoId);
  }
}
