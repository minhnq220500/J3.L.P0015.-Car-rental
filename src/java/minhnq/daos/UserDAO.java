/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.daos;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.naming.NamingException;
import minhnq.dtos.UserDTO;
import minhnq.utils.DBUtils;

/**
 *
 * @author Ticket 1
 */
public class UserDAO {

    Connection connect;
    PreparedStatement ps;
    ResultSet rs;

    public UserDAO() {
        connect = null;
        ps = null;
        rs = null;
    }

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

    public String checkEmail(String emailVuaNhap) throws SQLException {
        String email = null;

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT email FROM tblUser WHERE email=?";
                ps = connect.prepareStatement(sql);
                ps.setString(1, emailVuaNhap);
                rs = ps.executeQuery();
                if (rs.next()) {
                    email = rs.getString("email");
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return email;
    }

    public UserDTO checkLogin(String email, String password) throws SQLException {
        UserDTO user = null;

        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT email, password, name, phone, address, createDate, roleID, status FROM tblUser WHERE email=?";

                ps = connect.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String emaill = rs.getString("email");
                    String pass = rs.getString("password");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    Date createDate = rs.getDate("createDate");
                    String roleID = rs.getString("roleID");
                    String status = rs.getString("status");

                    if (password.equals(pass)) {
                        user = new UserDTO(emaill, password, name, phone, address, createDate, roleID, status);
                    }
                }
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }
        return user;
    }

    public int signUp(UserDTO user) throws NamingException, SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "INSERT INTO tblUser(email,password,name,phone,address,createDate,roleID,status) VALUES(?,?,?,?,?,?,?,?)";

                ps = connect.prepareStatement(sql);

                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getName());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getAddress());
                ps.setTimestamp(6, new Timestamp(user.getCreateDate().getTime()));
                ps.setString(7, user.getRoleID());
                ps.setString(8, user.getStatus());

                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }

    public int setActive(UserDTO user) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "Update tblUser SET status='Active' WHERE email=?";

                ps = connect.prepareStatement(sql);

                ps.setString(1, user.getEmail());
                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }

    public int setCode(String email, String code) throws SQLException {
        try {
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "Update tblUser SET code=? WHERE email=?";

                ps = connect.prepareStatement(sql);

                ps.setString(1, code);
                ps.setString(2, email);
                return ps.executeUpdate();
            }
        } catch (Exception e) {

        } finally {
            closeConnection();
        }

        return 0;
    }
    
    public boolean checkCode(String email, String code) throws SQLException{
        try{
            connect = DBUtils.getConnection();
            if (connect != null) {
                String sql = "SELECT email FROM tblUser WHERE email=? AND code=?";

                ps = connect.prepareStatement(sql);

                ps.setString(1, email);
                ps.setString(2, code);
                rs= ps.executeQuery();
                if(rs.next()){
                    return true;
                }
            }
        }catch(Exception e){
            
        }finally{
            closeConnection();
        }
        
        return false;
    }

//    public UserDTO getUserByEmail(String email) throws SQLException{
//        UserDTO user=null;
//        try{
//            connect=DBUtils.getConnection();
//            if(connect!=null){
//                String sql="SELECT userID, password, name, email, roleID FROM tblUser WHERE email=?";
//                ps=connect.prepareStatement(sql);
//                ps.setString(1, email);
//                rs=ps.executeQuery();
//                if(rs.next()){
//                    String userID=rs.getString("userID");
//                    String password=rs.getString("password");
//                    String name=rs.getString("name");
////                    String emaill=rs.getString("email");
//                    String roleID=rs.getString("roleID");
//                    
//                    user=new UserDTO(userID, password, name, email, roleID);
//                }
//            }
//        }catch(Exception e){
//            
//        }finally{
//            closeConnection();
//        }
//        return user;
//    }
}
