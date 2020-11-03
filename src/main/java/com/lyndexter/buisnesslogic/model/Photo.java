package com.lyndexter.buisnesslogic.model;


import com.lyndexter.buisnesslogic.model.annotations.Column;
import com.lyndexter.buisnesslogic.model.annotations.PrimaryKey;
import com.lyndexter.buisnesslogic.model.annotations.Table;

@Table(name = "photo")
public class Photo {
  
  @PrimaryKey
  @Column(name = "id", type = "int", length = 5)
  private int id;
  
  @Column(name = "type", length = 10)
  private String type;
  
  @Column(name = "image", type = "blob")
  private byte[] image;
  
  @Column(name = "image_size", length = 20)
  private String imageSize;
  
  @Column(name = "name", length = 20)
  private String name;
  
  public Photo() {
  }
  
  public Photo(int id, String type, byte[] image, String imageSize, String name) {
    this.id = id;
    this.type = type;
    this.image = image.clone();
    this.imageSize = imageSize;
    this.name = name;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public byte[] getImage() {
    return image.clone();
  }
  
  public void setImage(byte[] image) {
    this.image = image.clone();
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getImageSize() {
    return imageSize;
  }
  
  public void setImageSize(String imageSize) {
    this.imageSize = imageSize;
  }
  
  @Override
  public String toString() {
    return String.format("%3s    %-12s %-20s %-10s %-24s%n", id, type, image, imageSize, name);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    
    Photo photo = (Photo) o;
    
    if (id != photo.id) {
      return false;
    }
    if (!type.equals(photo.type)) {
      return false;
    }
    return name.equals(photo.name);
  }
  
  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + type.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }
  
  
}
