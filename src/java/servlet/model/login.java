/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.model;

import java.sql.*;


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
    
}
