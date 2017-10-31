package application.models;

public class SearchProduct {

    String description, picture_url, brand, model, price, type;

    public SearchProduct(String description, String picture_url, String brand, String model, String price) {
        this.description = description;
        this.picture_url = picture_url;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String toString(){
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
