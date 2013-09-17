/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nishant
 */
public class login {

     public static String getPassword(String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifm", "root", "admin");
            
            Statement smt = conn.createStatement();
                                    
            ResultSet rs = smt.executeQuery("SELECT * FROM PASSWORD WHERE EMAIL=\"" + email + "\"");

            String ret = null;
            
            while(rs.next()) {
                ret = rs.getString("Pass");
            }
            smt.close();
            
            return ret;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
