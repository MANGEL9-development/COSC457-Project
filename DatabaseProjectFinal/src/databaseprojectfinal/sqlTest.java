/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseProjectFinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;


public class sqlTest {
    public static void main(String[] args) {
        // TODO code application logic here
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
        System.out.println(e);
        }
        
        final String ID = "nwhite16";
        final String PW = "COSC*aea5h";
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/nwhite16db?useSSL=false";
       
        try {
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nwhite16db.member");
            System.out.println("Id  Name");
            while (rs.next()){
                String name = rs.getString("Fname");
                String id = rs.getString("StaffID");
                System.out.println(id+", "+name);
            }

        }catch (SQLException e){
            System.err.println(e);
        }
        //Main
    }
}
