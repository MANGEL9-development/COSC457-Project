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
            rs = stmt.executeQuery("SELECT StaffId, Fname, Lname, Email, PhoneNumber FROM baltimorecountygis.member WHERE JobType = 'Editor'");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getRevisedPlats() {
        try {
            rs = stmt.executeQuery("SELECT ConveyanceID, Book, Page FROM baltimorecountygis.plat WHERE isRevised = 1");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getUnrevisedPlats() {
        try {
            rs = stmt.executeQuery("SELECT ConveyanceID, Book, Page FROM baltimorecountygis.plat WHERE isRevised = 0");
            return rs;
        } catch (SQLException e) {
            System.err.print(e);
        }
        return rs;
    }

    public ResultSet getApprovedSources() {
        try {
            rs = stmt.executeQuery("SELECT ConveyanceID, DateRecieved, ProjectName FROM baltimorecountygis.sources WHERE ProjectStatus = 'Complete'");
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
    
    public int addSource(int CID,String Date, String approve, String ProjectName){
      try{
        String sql=("INSERT INTO baltimorecountygis.sources (ConveyanceID, DateRecieved, ProjectStatus, ProjectName)" +
                                    "VALUES (?,?,?,?)");
        
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setInt (1, CID);
        preparedStmt.setString (2, Date);
        preparedStmt.setString (3, approve);
        preparedStmt.setString(4, ProjectName);
        preparedStmt.executeUpdate();
        }catch (SQLException e) {
            System.out.print("Error in Insert, make sure CID is a unique value");
            return 1;
        }
        return 0;
    }
    
    public int deleateSource(int CID){
      try{
        String sql=("DELETE FROM baltimorecountygis.sources WHERE baltimorecountygis.sources.ConveyanceID = '"+CID+"'");
        
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.executeUpdate();
        }catch (SQLException e) {
            System.out.print("Error in Delete, make sure CID exists");
            return 1;
        }
        return 0;
    }
 public int addEditorToSource(String memberName, String pName){
      try{
        String sql=("INSERT INTO baltimorecountygis.works_on (StaffID,ConveyanceID)" +
                                    "VALUES (?,?)");
        String MemID = "";
        String CID = "";
        
        try{
        rs = stmt.executeQuery("SELECT StaffID FROM baltimorecountygis.member WHERE Fname = '"+memberName+"'");
        while (rs.next()) {
            MemID = rs.getString("StaffID");
            System.out.println("MemID: " + MemID);
        }
        } catch (SQLException e) {
            System.err.print(e);
        }
        
        try{
        rs = stmt.executeQuery("SELECT ConveyanceID FROM baltimorecountygis.sources WHERE ProjectStatus = 'Complete' AND ProjectName = '"+pName+"'");
        while (rs.next()) {
            CID = rs.getString("ConveyanceID");
            System.out.print(CID);

        }
        } catch (SQLException e) {
            System.err.print(e);
        }
        
        int memIDint=0;
        int CIDint = 0;
        if (!MemID.isEmpty() && !CID.isEmpty()) {
        memIDint = Integer.parseInt(MemID);
        CIDint = Integer.parseInt(CID);

        } else {
        System.out.println("MemID or CID is empty.");
        }

        
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setInt(1, memIDint);
        preparedStmt.setInt (2, CIDint);
        preparedStmt.executeUpdate();
        
        }catch (SQLException e) {
            System.out.print("Error in Insert, make sure The names are correct and the source is approved");
            return 1;
        }
        return 0;
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
