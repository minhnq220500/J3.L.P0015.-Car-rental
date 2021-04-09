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
public class RentalDetailDTO {
    private String detailID;
    private String rentalID;
    private String carID;
    private float price;
    
    private String startDate;
    private String endDate;
    private String feedbackContent;
    private String rateStar;
    
   

    public RentalDetailDTO() {
    }

//    public RentalDetailDTO(String detailID, String rentalID, String carID, float price, int quantity, String startDate, String endDate, String feedbackContent, String rateStar) {
//        this.detailID = detailID;
//        this.rentalID = rentalID;
//        this.carID = carID;
//        this.price = price;
//        this.quantity = quantity;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.feedbackContent = feedbackContent;
//        this.rateStar = rateStar;
//    }

    public RentalDetailDTO(String detailID, String rentalID, String carID, float price, String startDate, String endDate, String feedbackContent, String rateStar) {
        this.detailID = detailID;
        this.rentalID = rentalID;
        this.carID = carID;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.feedbackContent = feedbackContent;
        this.rateStar = rateStar;
    }

    
    
    

    /**
     * @return the detailID
     */
    public String getDetailID() {
        return detailID;
    }

    /**
     * @param detailID the detailID to set
     */
    public void setDetailID(String detailID) {
        this.detailID = detailID;
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
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the feedbackContent
     */
    public String getFeedbackContent() {
        return feedbackContent;
    }

    /**
     * @param feedbackContent the feedbackContent to set
     */
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    /**
     * @return the rateStar
     */
    public String getRateStar() {
        return rateStar;
    }

    /**
     * @param rateStar the rateStar to set
     */
    public void setRateStar(String rateStar) {
        this.rateStar = rateStar;
    }    
    
}
