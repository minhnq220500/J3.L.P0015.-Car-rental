/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ticket 1
 */
public class RentalDTO implements Serializable{
    private String rentalID;
    private float totalPrice;
    private Date rentalDate;
    private String status;
    private String email;
    private String discountID;
    
    
    private List<CarDTO> list;

    public RentalDTO() {
    }

    public RentalDTO(String rentalID, float totalPrice, Date rentalDate, String status, String email, String discountID) {
        this.rentalID = rentalID;
        this.totalPrice = totalPrice;
        this.rentalDate = rentalDate;
        this.status = status;
        this.email = email;
        this.discountID = discountID;
    }

    /**
     * @return the rentalID
     */
    public String getRentalID() {
        return rentalID;
    }

    /**
     * @param rentalID the rentalID to set
     */
    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * @return the totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the rentalDate
     */
    public Date getRentalDate() {
        return rentalDate;
    }

    /**
     * @param rentalDate the rentalDate to set
     */
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the discountID
     */
    public String getDiscountID() {
        return discountID;
    }

    /**
     * @param discountID the discountID to set
     */
    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    /**
     * @return the list
     */
    public List<CarDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<CarDTO> list) {
        this.list = list;
    }
    
    
    
}
