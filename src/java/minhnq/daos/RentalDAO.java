/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import minhnq.dtos.RentalDTO;
import minhnq.dtos.RentalDetailDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author Ticket 1
 */
public class RentalDAO {

    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

    public void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (connect != null) {
            connect.close();
        }
    }

    public String getLastRentalIDByUser(String email) throws Exception {
        String orderID = null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT rentalID FROM tblRental WHERE rentalDate = (SELECT MAX(rentalDate) FROM tblRental WHERE email = ?)";
                ps = connect.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    orderID = rs.getString("rentalID");
                }
            }

        } finally {
            closeConnection();
        }
        return orderID;
    }

    public int createRental(String rentalID, float totalPrice, Date newDate, String status, String email, String discountID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblRental(rentalID,totalPrice,rentalDate,status,email,discountID) VALUES(?,?,?,?,?,?) ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalID);
                ps.setFloat(2, totalPrice);
                ps.setTimestamp(3, new Timestamp(newDate.getTime()));
                ps.setString(4, status);
                ps.setString(5, email);
                ps.setString(6, discountID);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }

    public int deleteRental(String rentalID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblRental SET status ='False' WHERE rentalID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalID);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }

    public int createRentalDetail(String detailID, String rentalID, String carID, float price, String startDate, String endDate, String feedbackContent, int rateStar) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblRentalDetail(detailID,rentalID,carID,price,startDate,endDate,feedbackContent,rateStar) VALUES(?,?,?,?,?,?,?,?)";
                ps = connect.prepareStatement(sql);
                ps.setString(1, detailID);
                ps.setString(2, rentalID);
                ps.setString(3, carID);
                ps.setFloat(4, price);
                ps.setString(5, startDate);
                ps.setString(6, endDate);
                ps.setString(7, feedbackContent);
                ps.setInt(8, rateStar);

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public List<RentalDTO> getAllListRental(String email) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT R.rentalID, R.totalPrice, R.rentalDate, R.status, R.email, R.discountID "
                        + " FROM tblRental R "
                        + " WHERE R.email=? AND R.status='True' ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, email);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String rentalID = rs.getString("rentalID");
                    float totalPrice = rs.getFloat("totalPrice");
                    Date rentalDatee = rs.getDate("rentalDate");
                    String status = rs.getString("status");
                    String emaill = rs.getString("email");
                    String discountID = rs.getString("discountID");

                    RentalDTO rental = new RentalDTO(rentalID, totalPrice, rentalDatee, status, emaill, discountID);
                    list.add(rental);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    public List<RentalDTO> getListRental(String email, String rentalDate) throws SQLException {
        List<RentalDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT R.rentalID, totalPrice, rentalDate, status, email, discountID "
                        + " FROM tblRental R  "
                        + " WHERE R.email=? AND R.rentalDate <= DATEADD(DAY,1,?) AND R.status='True' ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, rentalDate);

                rs = ps.executeQuery();
                while (rs.next()) {
                    String rentalID = rs.getString("rentalID");
                    float totalPrice = rs.getFloat("totalPrice");
                    Date rentalDatee = rs.getDate("rentalDate");
                    String status = rs.getString("status");
                    String emaill = rs.getString("email");
                    String discountID = rs.getString("discountID");

                    RentalDTO rental = new RentalDTO(rentalID, totalPrice, rentalDatee, status, emaill, discountID);
                    list.add(rental);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //lấy lịch sử mua hàng dựa trên orderID
    public List<RentalDetailDTO> getRentalDetailByRentalID(String rentalID) throws SQLException {
        List<RentalDetailDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT detailID, rentalID, carID, price, startDate, endDate, feedbackContent, rateStar "
                        + " FROM tblRentalDetail  "
                        + " WHERE rentalID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalID);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String detailID = rs.getString("detailID");
                    String rentalIDD = rs.getString("rentalID");
                    String carID = rs.getString("carID");
                    float price = rs.getFloat("price");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    String feedbackContent = rs.getString("feedbackContent");
                    String rateStar = rs.getString("rateStar");

                    RentalDetailDTO detail = new RentalDetailDTO(detailID, rentalID, carID, price, startDate, endDate, feedbackContent, rateStar);
                    list.add(detail);

                }
            }

        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //update quantity by orderID
    public int updateCarQuantityByRentalID(String rentalID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblCar SET quantity=(C.quantity-RD.quantity) "
                        + " FROM tblCar C join tblRentalDetail RD ON C.carID = RD.carID "
                        + " join tblRental R ON R.rentalID=RD.rentalID "
                        + " WHERE R.rentalID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalID);
                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public int updateFeedback(String detailID, String feedbackContent, String star) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "UPDATE tblRentalDetail SET feedbackContent=?, rateStar=? "
                        + " FROM tblRentalDetail "
                        + " WHERE detailID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, feedbackContent);
                ps.setString(2, star);
                ps.setString(3, detailID);
                
                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public List<RentalDetailDTO> getListRentalDetailToNotDelete(String rentalID) throws SQLException {
        List<RentalDetailDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT detailID, rentalID, carID, price, startDate, endDate, feedbackContent, rateStar "
                        + " FROM tblRentalDetail  "
                        + " WHERE rentalID=? AND endDate > DATEADD(DAY,0,GETDATE()) ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalID);
                rs = ps.executeQuery();

                while (rs.next()) {
                    String detailID = rs.getString("detailID");
                    String rentalIDD = rs.getString("rentalID");
                    String carID = rs.getString("carID");
                    float price = rs.getFloat("price");
                    String startDate = rs.getString("startDate");
                    String endDate = rs.getString("endDate");
                    String feedbackContent = rs.getString("feedbackContent");
                    String rateStar = rs.getString("rateStar");

                    RentalDetailDTO detail = new RentalDetailDTO(detailID, rentalID, carID, price, startDate, endDate, feedbackContent, rateStar);
                    list.add(detail);

                }
            }

        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }
    
    public String checkEndDate(String detailID) throws SQLException{
        String id=null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT detailID "
                        + " FROM tblRentalDetail  "
                        + " WHERE detailID=? AND endDate < DATEADD(DAY,0,GETDATE()) ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, detailID);
                rs = ps.executeQuery();

                while (rs.next()) {
                    id=rs.getString("detailID");
                    
                }
            }

        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        
        return id;
        
    }
    
}
