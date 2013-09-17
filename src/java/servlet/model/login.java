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
    
    public void login() {  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection connection = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/EMPLOYEE", "root", "root");  
            Statement statement = connection.createStatement();  
            ResultSet resultSet = statement  
                    .executeQuery("SELECT EMPNAME FROM EMPLOYEEDETAILS");  
            }
        catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    /**
     * This function searches for password corresponding to email address.
     * 
     * @param email
     * @return password
     */
    public String getPassword(String email) {
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
    
//    //  FOR TESTING FUNCTIONS IN THIS CLASS ONLY
//     
//     
//    public static void main(String[] args) {
//        String[] str = getDetails("rishav1088@iiitd.ac.in");
//        
//        for(int i=0;i<str.length;i++) {
//            System.out.println(str[i]);
//        }
//    }
    
}
