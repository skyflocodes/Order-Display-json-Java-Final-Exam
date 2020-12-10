package Models;

import com.google.gson.annotations.SerializedName;

public class Product {
  @SerializedName("sku")
  private String sku;
  @SerializedName("name")
  private String name;
  @SerializedName("salePrice")
  private double salePrice;
  @SerializedName("regularPrice")
  private double regularPrice;
  @SerializedName("images")
  private String images;

  public Product(String sku, String name, double salePrice, double regularPrice, String images) {
    setSku(sku);
    setName(name);
    setSalePrice(salePrice);
    setRegularPrice(regularPrice);
    setImages(images);
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(double salePrice) {
    this.salePrice = salePrice;
  }

  public double getRegularPrice() {
    return regularPrice;
  }

  public void setRegularPrice(double regularPrice) {
    this.regularPrice = regularPrice;
  }

  public String getImages() {
    return images;
  }

  public void setImages(String images) {
    this.images = images;
  }
}
