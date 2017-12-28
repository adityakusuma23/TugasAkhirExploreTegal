package net.aditkus.exploretegal.Model;

/**
 * Created by Aditya on 19-Dec-17.
 */

public class Food {
    private String Name, Images, Description, Price, Discount, MenuId;

    public Food() {

    }

    public Food(String name, String image, String description, String price, String discount, String menuId) {
        Name = name;
        Images = image;
        Description = description;
        Price = price;
        Discount = discount;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public String getImages() {
        return Images;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public String getDiscount() {
        return Discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImages(String images) {
        Images = images;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}