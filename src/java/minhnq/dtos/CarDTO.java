/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

/**
 *
 * @author Ticket 1
 */
public class CarDTO {
    private String carID;
    private String carName;
    private String color;
    private String year;
    private float price;
    
    private int quantity;
    
    private String picture;
    private String status;
    private String categoryID;
    private String typeID;
    
    private String startDate;
    private String returnDate;
    
    private String rentQuantity;
    
    private float rentalPrice;
    private int rentedQuantity;
    private int availableQuantity;

    public CarDTO() {
    }

    public CarDTO(String carID, String carName, String color, String year, float price, String picture, String status, String categoryID, String typeID) {
        this.carID = carID;
        this.carName = carName;
        this.color = color;
        this.year = year;
        this.price = price;
        this.picture = picture;
        this.status = status;
        this.categoryID = categoryID;
        this.typeID = typeID;
    }

    /**
     * @return the carID
     */
    public String getCarID() {
        return carID;
    }

    /**
     * @param carID the carID to set
     */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    /**
     * @return the carName
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @param carName the carName to set
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the categoryID
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID the categoryID to set
     */
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return the typeID
     */
    public String getTypeID() {
        return typeID;
    }

    /**
     * @param typeID the typeID to set
     */
    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the rentQuantity
     */
    public String getRentQuantity() {
        return rentQuantity;
    }

    /**
     * @param rentQuantity the rentQuantity to set
     */
    public void setRentQuantity(String rentQuantity) {
        this.rentQuantity = rentQuantity;
    }

    
    /**
     * @param rentalPrice the rentalPrice to set
     */
    public void setRentalPrice(String rentalPrice) {
        this.setRentalPrice(rentalPrice);
    }

    /**
     * @param rentalPrice the rentalPrice to set
     */
    public void setRentalPrice(float rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    /**
     * @return the rentalPrice
     */
    public float getRentalPrice() {
        return rentalPrice;
    }

    /**
     * @return the rentedQuantity
     */
    public int getRentedQuantity() {
        return rentedQuantity;
    }

    /**
     * @param rentedQuantity the rentedQuantity to set
     */
    public void setRentedQuantity(int rentedQuantity) {
        this.rentedQuantity = rentedQuantity;
    }

    /**
     * @return the availableQuantity
     */
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    /**
     * @param availableQuantity the availableQuantity to set
     */
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    
}
