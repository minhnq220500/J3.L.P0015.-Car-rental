/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhnq.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Ticket 1
 */
public class DBUtils {
    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context tomCatContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomCatContext.lookup("SE1422DS");
        Connection connect = ds.getConnection();
        return connect;
    }
    
//    public static Connection getConnectionn() throws ClassNotFoundException, SQLException {
//        Connection connect = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=Car_Rental";
//        connect = DriverManager.getConnection(url, "sa", "123456789");
//        return connect;
//    }
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException, NamingException {
//        Connection con = DBUtils.getConnectionn();
//        if (con != null) {
//            System.out.println("Thanh cong");
//        } else {
//            System.out.println("That bai");
//        }
//    }
}
