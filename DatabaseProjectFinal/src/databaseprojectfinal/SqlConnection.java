/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseprojectfinal;

import java.sql.*;

public class SqlConnection {

    private String ID;
    private String PW;
    private String SERVER;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public SqlConnection() {
        //These values are only unique to my localhost sql server
        ID = "root";
        PW = "Rockstarman576!";
        SERVER = "jdbc:mysql://localhost:3360/baltimorecountygis";
        conn = null;
        stmt = null;
        rs = null;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            conn = DriverManager.getConnection(SERVER, ID, PW);
            stmt = conn.createStatement();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public ResultSet getEditors() {
        try {
            rs = stmt.executeQuery("SELECT Fname, Lname FROM baltimorecountygis.member WHERE JobType = 'Editor'");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getRevisedPlats() {
        try {
            rs = stmt.executeQuery("SELECT Book, Page FROM baltimorecountygis.plat WHERE isRevised = 1");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getUnrevisedPlats() {
        try {
            rs = stmt.executeQuery("SELECT Book, Page FROM baltimorecountygis.plat WHERE isRevised = 0");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getApprovedSources() {
        try {
            rs = stmt.executeQuery("SELECT DateRecieved, ProjectName FROM baltimorecountygis.sources WHERE ProjectStatus = 'Complete'");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getUnapprovedSources() {
        try {
            rs = stmt.executeQuery("SELECT ConveyanceID, DateRecieved, ProjectName FROM baltimorecountygis.sources WHERE ProjectStatus = 'Incomplete'");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getSourcesByEditor(String editor) {
        try {
            rs = stmt.executeQuery("SELECT ProjectName "
                    + "FROM baltimorecountygis.sources, baltimorecountygis.works_on, baltimorecountygis.editor, baltimorecountygis.member "
                    + "WHERE baltimorecountygis.sources.ConveyanceID = baltimorecountygis.works_on.ConveyanceID "
                    + "AND baltimorecountygis.works_on.StaffID = baltimorecountygis.editor.StaffID "
                    + "AND baltimorecountygis.editor.StaffID = baltimorecountygis.member.StaffID "
                    + "AND Fname = '" + editor + "' "
                    + "AND JobType = 'Editor'");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

}
