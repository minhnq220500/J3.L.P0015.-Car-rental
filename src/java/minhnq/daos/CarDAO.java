/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import minhnq.dtos.CarDTO;
import minhnq.dtos.CartDTO;
import minhnq.dtos.CategoryDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author Ticket 1
 */
public class CarDAO {

    Connection connect = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

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

    public CarDTO getCarByID(String carID) throws SQLException {
        CarDTO car = new CarDTO();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT carID, carName, color, year, price, picture, status, categoryID, typeID FROM tblCar WHERE carID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, carID);
                rs = ps.executeQuery();
                if (rs.next()) {
//                    String carIDD = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String color = rs.getString("color");
                    String year = rs.getString("year");
                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
                    String picture = rs.getString("picture");
                    String status = rs.getString("status");
                    String categoryID = rs.getString("categoryID");
                    String typeID = rs.getString("typeID");

                    car = new CarDTO(carID, carName, color, year, price, picture, status, categoryID, typeID);

                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return car;
    }

    public List<CarDTO> getAllCar() throws SQLException{
        List<CarDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = " SELECT carID, carName, color, year, price, picture, status, categoryID, typeID "
                        + " from tblCar "
                        + " where status='available' ";
                ps = connect.prepareStatement(sql);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String color = rs.getString("color");
                    String year = rs.getString("year");
                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
                    String picture = rs.getString("picture");
                    String status = rs.getString("status");
                    String categoryID = rs.getString("categoryID");
                    String typeID = rs.getString("typeID");

                    CarDTO car = new CarDTO(carID, carName, color, year, price, picture, status, categoryID, typeID);

                    list.add(car);

                }
            }
        } catch (Exception ex) {

        } finally {
            closeConnection();
        }
        return list;
    }
    
    public List<CategoryDTO> getListCategory() throws SQLException {
        List<CategoryDTO> list = new ArrayList<>();
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT categoryID, categoryName FROM tblCategory";
                ps = connect.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("categoryID");
                    String name = rs.getString("categoryName");

                    CategoryDTO cate = new CategoryDTO(id, name);

                    list.add(cate);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //searchName
    public int countName(String carName) throws SQLException {

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) FROM tblCar WHERE carName like ? AND status='available' ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, "%" + carName + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public List<CarDTO> getListCarByName(String name, int index, int size) throws SQLException {
        List<CarDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = " with x as (select ROW_NUMBER() over (order by year asc) as r, "
                        + "carID, carName, color, year, price, picture, status, categoryID, typeID from tblCar where carName like ? AND status='available' ) "
                        + "select carID, carName, color, year, price, picture, status, categoryID, typeID from x where r between ? * ? - ( ? - 1 ) and ? * ? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ps.setInt(2, index);
                ps.setInt(3, size);
                ps.setInt(4, size);
                ps.setInt(5, index);
                ps.setInt(6, size);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String color = rs.getString("color");
                    String year = rs.getString("year");
                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
                    String picture = rs.getString("picture");
                    String status = rs.getString("status");
                    String categoryID = rs.getString("categoryID");
                    String typeID = rs.getString("typeID");

                    CarDTO car = new CarDTO(carID, carName, color, year, price, picture, status, categoryID, typeID);

                    list.add(car);

                }
            }
        } catch (Exception ex) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //searchCategory
    public int countCategory(String categoryID) throws SQLException {

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) FROM tblCar WHERE categoryID like ? AND status='available' ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, "%" + categoryID + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

    public List<CarDTO> getListCarByCategory(String categoryID, int index, int size) throws SQLException {
        List<CarDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = " with x as (select ROW_NUMBER() over (order by year asc) as r, "
                        + "carID, carName, color, year, price, picture, status, categoryID, typeID from tblCar where categoryID like ? AND status='available' ) "
                        + "select carID, carName, color, year, price, picture, status, categoryID, typeID from x where r between ? * ? - ( ? - 1 ) and ? * ? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, "%" + categoryID + "%");
                ps.setInt(2, index);
                ps.setInt(3, size);
                ps.setInt(4, size);
                ps.setInt(5, index);
                ps.setInt(6, size);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String color = rs.getString("color");
                    String year = rs.getString("year");
                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
                    String picture = rs.getString("picture");
                    String status = rs.getString("status");
                    String categoryIDD = rs.getString("categoryID");
                    String typeID = rs.getString("typeID");

                    CarDTO car = new CarDTO(carID, carName, color, year, price, picture, status, categoryIDD, typeID);

                    list.add(car);

                }
            }
        } catch (Exception ex) {

        } finally {
            closeConnection();
        }
        return list;
    }

    //search Date
    public int countDate(String rentalDate, String returnDate) throws SQLException {

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) "
                        + "FROM tblCar "
                        + "WHERE status='available' "
                        + "EXCEPT "
                        + "SELECT count(*) "
                        + "FROM tblRentalDetail "
                        + "WHERE startDate >= DATEADD(DAY,0,?) AND endDate <= DATEADD(DAY,0,?)";
                ps = connect.prepareStatement(sql);
                ps.setString(1,  rentalDate);
                ps.setString(2,  returnDate);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public List<CarDTO> getListCarByDate(String rentalDate, String returnDate, int index, int size) throws SQLException {
        List<CarDTO> list = new ArrayList<>();
        
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = " with x as (select ROW_NUMBER() over (order by year asc) as r, "
                        + "carID from tblCar where status='available' "
                        + "EXCEPT select ROW_NUMBER() over (order by startDate asc), carID FROM tblRentalDetail WHERE startDate >= DATEADD(DAY,0,?) AND endDate <= DATEADD(DAY,0,?)  ) "
                        + "select carID from x where r between ? * ? - ( ? - 1 ) and ? * ? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, rentalDate);
                ps.setString(2, returnDate);
                ps.setInt(3, index);
                ps.setInt(4, size);
                ps.setInt(5, size);
                ps.setInt(6, index);
                ps.setInt(7, size);

                rs = ps.executeQuery();
                
                while (rs.next()) {
                    String carID = rs.getString("carID");

                    CarDAO dao=new CarDAO();
                    CarDTO car=dao.getCarByID(carID);
                    
                    list.add(car);

                }
            }
        } catch (Exception ex) {

        } finally {
            closeConnection();
        }
        return list;
    }
    
    //searchCategory
    public int countQuantity(int quantity) throws SQLException {

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT count(*) FROM tblCar WHERE quantity => ? AND status='available' ";
                ps = connect.prepareStatement(sql);
                ps.setInt(1,  quantity );
                rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }

//    public List<CarDTO> getListCarByQuantity(int quantity, int index, int size) throws SQLException {
//        List<CarDTO> list = new ArrayList<>();
//
//        try {
//            connect = DBUtils.getConnection();
//            if (connect != null) {
//                String sql = " with x as (select ROW_NUMBER() over (order by year asc) as r, "
//                        + "carID, carName, color, year, price, picture, status, categoryID, typeID from tblCar where quantity => ? AND status='available' AND quantity > 0 ) "
//                        + "select carID, carName, color, year, price, picture, status, categoryID, typeID from x where r between ? * ? - ( ? - 1 ) and ? * ? ";
//                ps = connect.prepareStatement(sql);
//                ps.setInt(1, quantity);
//                ps.setInt(2, index);
//                ps.setInt(3, size);
//                ps.setInt(4, size);
//                ps.setInt(5, index);
//                ps.setInt(6, size);
//
//                rs = ps.executeQuery();
//
//                while (rs.next()) {
//                    String carID = rs.getString("carID");
//                    String carName = rs.getString("carName");
//                    String color = rs.getString("color");
//                    String year = rs.getString("year");
//                    float price = rs.getFloat("price");
////                    int quantityy = rs.getInt("quantity");
//                    String picture = rs.getString("picture");
//                    String status = rs.getString("status");
//                    String categoryIDD = rs.getString("categoryID");
//                    String typeID = rs.getString("typeID");
//
//                    CarDTO car = new CarDTO(carID, carName, color, year, price, picture, status, categoryIDD, typeID);
//
//                    list.add(car);
//
//                }
//            }
//        } catch (Exception ex) {
//
//        } finally {
//            closeConnection();
//        }
//        return list;
//    }

    public int getCarQuantityByID(String carID) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT quantity FROM tblCar WHERE carID=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, carID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int price = rs.getInt("quantity");

                    return price;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    public int getDiscountPercentByDiscountID(String discountCode) throws SQLException{
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT discountPercent FROM tblDiscount WHERE discountCode=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, discountCode);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int percent = rs.getInt("discountPercent");

                    return percent;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
    //nếu có thì vẫn còn hạn sử dụng
    public String checkExpireDate(String discountID) throws SQLException{
        String id=null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT discountID FROM tblDiscount WHERE discountID=? and expireDate > DATEADD(DAY,0,GETDATE()) ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, discountID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getString("discountID");

                    return id;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return id;
    }
    
    public String getDiscountIDByDiscountCode(String discountCode) throws SQLException{
        String id=null;
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT discountID FROM tblDiscount WHERE discountCode=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, discountCode);
                rs = ps.executeQuery();
                if (rs.next()) {
                    id = rs.getString("discountID");

                    return id;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return id;
    }

    public int countNumberRentedByCarID(String carID, String startDate, String endDate) throws SQLException{
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT carID "
                        + " FROM tblRentalDetail "
                        + " WHERE ((startDate between ? AND ? ) or "
                        + " (endDate between ? AND ?) OR "
                        + " (startDate < ? AND endDate > ? )) AND carID=? ";
                ps = connect.prepareStatement(sql);
                ps.setString(1, startDate);
                ps.setString(2, endDate);
                ps.setString(3, startDate);
                ps.setString(4, endDate);
                ps.setString(5, startDate);
                ps.setString(6, endDate);
                ps.setString(7, carID);
                
                rs = ps.executeQuery();
                if (rs.next()) {
                    int count = 1;

                    return count;
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return 0;
    }
    
//    public int getCarQuantityByCarID(String carID) throws SQLException{
//        try {
//            connect = DBUtils.getConnection();
//            if (connect != null) {
//                String sql = "SELECT quantity FROM tblCar WHERE carID=? ";
//                ps = connect.prepareStatement(sql);
//                ps.setString(1, carID);
//                rs = ps.executeQuery();
//                if (rs.next()) {
//                    int count = rs.getInt("quantity");
//
//                    return count;
//                }
//            }
//        } catch (Exception e) {
//
//        } finally {
//            closeConnection();
//        }
//        return 0;
//    }
    
    public List<CarDTO> getListCarByName(String name) throws SQLException{
        List<CarDTO> list = new ArrayList<>();

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT carID, carName, color, year, price, picture, status, categoryID, typeID from tblCar where carName=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1,  name);

                rs = ps.executeQuery();

                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String color = rs.getString("color");
                    String year = rs.getString("year");
                    float price = rs.getFloat("price");
//                    int quantity = rs.getInt("quantity");
                    String picture = rs.getString("picture");
                    String status = rs.getString("status");
                    String categoryIDD = rs.getString("categoryID");
                    String typeID = rs.getString("typeID");

                    CarDTO car = new CarDTO(carID, carName, color, year, price, picture, status, categoryIDD, typeID);

                    list.add(car);

                }
            }
        } catch (Exception ex) {

        } finally {
            closeConnection();
        }
        return list;
    }
    
}
