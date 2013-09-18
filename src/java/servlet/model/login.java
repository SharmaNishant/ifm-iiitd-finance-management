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
    
    /**
     * This function searches for password corresponding to email address.
     * 
     * @param email
     * @return password
     */
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
    
    /**
     * this function returns details for an email address
     * 
     * @param email
     * @return 
     */
    public static String[] getDetails(String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifm", "root", "admin");
            
            Statement smt = conn.createStatement();
                                    
            ResultSet rs = smt.executeQuery("SELECT * FROM PROFILE WHERE EMAIL=\"" + email + "\"");
            
            String[] ret = new String[9];
            
            int flag=0;
            
            while(rs.next()) {
                ret[0] = rs.getString("Name");
                ret[1] = rs.getString("ContactNumber");
                ret[2] = rs.getString("Address");
                ret[3] = rs.getString("Email");
                ret[4] = rs.getString("Student/Faculty/Staff");
                ret[5] = rs.getString("RollNumber/Emp_ID");
                ret[6] = rs.getString("Stream/Department");
                ret[7] = rs.getString("City");
                ret[8] = rs.getString("Designation");
                flag=1;
            }

            if(flag==0)
                ret = null;
            
            smt.close();
            
            return ret;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Adds a new user to the database, and marks it as unverified
     * 
     * @param newProfile
     * @return 1 for success, 0 for failure
     */
    public int addUnverifiedUser(ProfileDetails newProfile) {
        
        String statement = "INSERT INTO profile VALUES ("
                + "'" + newProfile.Name + "',\r\n"
                + "'" + newProfile.ContactNumber + "',\r\n"
                + "'" + newProfile.Address + "',\r\n"
                + "'" + newProfile.Email + "',\r\n"
                + "'" + newProfile.RoleInstitute + "',\r\n"
                + "'" + newProfile.ID + "',\r\n"
                + "'" + newProfile.Department + "',\r\n"
                + "'" + newProfile.City + "',\r\n"
                + "'" + newProfile.Designation + "',\r\n"
                + "'NO')";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ifm", "root", "admin");
            
            Statement smt = conn.createStatement();
                                    
            smt.executeUpdate(statement);                        
            
            smt.close();
            
            return 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
////    //  FOR TESTING FUNCTIONS IN THIS CLASS ONLY
////     
////     
////    public static void main(String[] args) {
////        
////        ProfileDetails tmp = new ProfileDetails();
////        
////        tmp.Address = "xxxxxxxxxx";
////        tmp.City = "aaaaaaaaa";
////        tmp.ContactNumber="asdasdas";
////        tmp.Department = "ssssssssf";
////        tmp.Designation = "vvvvvvvvvv";
////        tmp.Email="sssssss";
////        tmp.ID="aaaaaaaa";
////        tmp.Name="sssssssssss";
////        tmp.RoleInstitute="sffffffffff";
////        
////        addUnverifiedUser(tmp);               
////    }
//    
}
