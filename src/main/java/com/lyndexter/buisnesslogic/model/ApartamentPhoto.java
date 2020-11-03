package com.lyndexter.buisnesslogic.model;


import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "apartament_photo")
public class ApartamentPhoto {
  
  @Column(name = "photo_id", type = "int")
  private Integer photoId;
  
  @PrimaryKey
  @Column(name = "apartament_Id", type = "int")
  private Integer apartamentId;
  
  public ApartamentPhoto() {
  }
  
  public ApartamentPhoto(Integer photoId, Integer apartamentId) {
    this.photoId = photoId;
    this.apartamentId = apartamentId;
  }
  
  public Integer getPhotoId() {
    return photoId;
  }
  
  public void setPhotoId(Integer photoId) {
    this.photoId = photoId;
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
      {
        return true;
      }
    }
    if (o == null || getClass() != o.getClass()) {
      {
        return false;
      }
    }
    
    ApartamentPhoto that = (ApartamentPhoto) o;
    
    if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) {
      return false;
    }
    return apartamentId.equals(that.apartamentId);
  }
  
  @Override
  public int hashCode() {
    int result = photoId != null ? photoId.hashCode() : 0;
    result = 31 * result + apartamentId.hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %n", photoId, apartamentId);
  }
}
