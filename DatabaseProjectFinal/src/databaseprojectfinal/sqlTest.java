/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseprojectfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class sqlTest {

    public static void main(String[] args) {

        SqlConnection connection = new SqlConnection();
        connection.connect();
        ResultSet rs2 = connection.getSourcesByEditor("ava");

        try {
            while (rs2.next()) {
                String project = rs2.getString("ProjectName");
                System.out.println(project);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        ResultSet rs1 = connection.getApprovedSources();
        try {
            while (rs1.next()) {
                String date = rs1.getString("DateRecieved");
                String name = rs1.getString("ProjectName");
                System.out.println(date + " " + name);
            }
        } catch (SQLException e) {
            System.err.print(e);
        }

        ResultSet rs = connection.getUnrevisedPlats();
        try {
            while (rs.next()) {
                String book = rs.getString("Book");
                int page = rs.getInt("Page");
                System.out.println(book + " " + page);
            }
        } catch (SQLException e) {
            System.err.print(e);
        }
    }
}