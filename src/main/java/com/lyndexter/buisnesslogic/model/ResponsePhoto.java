package com.lyndexter.buisnesslogic.model;

import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "response_photo")
public class ResponsePhoto {
  
  @Column(name = "photo_id", type = "int")
  private Integer photoId;
  
  @Column(name = "response_id", type = "int")
  private Integer responseId;
  
  public ResponsePhoto() {
  }
  
  public ResponsePhoto(Integer photoId, Integer responseId) {
    this.photoId = photoId;
    this.responseId = responseId;
  }
  
  public Integer getPhotoId() {
    return photoId;
  }
  
  public void setPhotoId(Integer photoId) {
    this.photoId = photoId;
  }
  
  public Integer getResponseId() {
    return responseId;
  }
  
  public void setResponseId(Integer responseId) {
    this.responseId = responseId;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    ResponsePhoto that = (ResponsePhoto) o;
    
    if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) {
      return false;
    }
    return responseId != null ? responseId.equals(that.responseId) : that.responseId == null;
  }
  
  @Override
  public int hashCode() {
    int result = photoId != null ? photoId.hashCode() : 0;
    result = 31 * result + (responseId != null ? responseId.hashCode() : 0);
    return result;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %n", photoId, responseId);
  }
}
