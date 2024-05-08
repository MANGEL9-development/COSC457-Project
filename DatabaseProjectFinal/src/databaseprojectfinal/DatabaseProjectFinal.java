/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package databaseprojectfinal;

/**
 *
 * @author nWhite16
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.table.*;

public class DatabaseProjectFinal extends JFrame implements ActionListener {

    JPanel buttonsPanel;
    JPanel cards;
    CardLayout cardLayout;
    JPanel searchPanel;
    SqlConnection connection = new SqlConnection();
    String name;
    JTextField textField;
    JTable searchEditorTable;
    DefaultTableModel m;

    //MainTest is the frame object
    DatabaseProjectFinal() {
        //Connect to database
        connection.connect();
        // Create the main frame
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);

        // Create panel for buttons
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        addButtons();

        // Create panel for cards
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        addPages();

        //Add panel to search sources by an editor
        searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        addSearchEditor();

        // Add panels to frame
        add(buttonsPanel, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.SOUTH);

    }
    

    private void addSearchEditor() {
        JButton search = new JButton("Search Editor's Sources");
        search.setBounds(0, 150, 250, 20);
        search.setActionCommand("searchEditor");
        search.addActionListener(this);

        textField = new JTextField(20);
        //textField.addActionListener(this);
        

        searchPanel.add(search);
        searchPanel.add(textField);

        JPanel page6 = new JPanel();
        cards.add(page6, "searchEditor");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 10);
        page6.setLayout(flowLayout);
        searchEditorTable = loadTable(connection.getSourcesByEditor(name));
        JScrollPane searchEditorPane = new JScrollPane(searchEditorTable);
        searchEditorPane.setBounds(50, 200, 500, 500);
        page6.add(searchEditorPane);
    }

    //Adds the buttons along the top that exist for all cards
    private void addButtons() {
        JButton b1 = new JButton("Editors");
        b1.setBounds(0, 0, 150, 20);
        b1.setActionCommand("editor");
        b1.addActionListener(this);
        buttonsPanel.add(b1);

        JButton b2 = new JButton("Revised Plats");
        b2.setBounds(150, 0, 150, 20);
        b2.setActionCommand("revised");
        b2.addActionListener(this);
        buttonsPanel.add(b2);

        JButton b3 = new JButton("Unrevised Plats");
        b3.setBounds(300, 0, 150, 20);
        b3.setActionCommand("unrevised");
        b3.addActionListener(this);
        buttonsPanel.add(b3);

        JButton b4 = new JButton("Approved Sources");
        b4.setBounds(0, 150, 150, 20);
        b4.setActionCommand("approved");
        b4.addActionListener(this);
        buttonsPanel.add(b4);

        JButton b5 = new JButton("Unapproved Sources");
        b5.setBounds(0, 150, 250, 20);
        b5.setActionCommand("unapproved");
        b5.addActionListener(this);
        buttonsPanel.add(b5);

    }

    //Create cards with differnt pages [Area below buttons] 
    private void addPages() {
        JPanel page1 = new JPanel();
        cards.add(page1, "editor");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 10);
        page1.setLayout(flowLayout);
        JTable editorTable = loadTable(connection.getEditors());
        JScrollPane editorScrollPane = new JScrollPane(editorTable);
        editorScrollPane.setBounds(50, 200, 500, 400);
        page1.add(editorScrollPane);

        JPanel page2 = new JPanel();
        cards.add(page2, "revised");
        page2.setLayout(flowLayout);
        JTable revisedTable = loadTable(connection.getRevisedPlats());
        JScrollPane revisedScrollPane = new JScrollPane(revisedTable);
        revisedScrollPane.setBounds(50, 200, 500, 400);
        page2.add(revisedScrollPane);

        JPanel page3 = new JPanel();
        cards.add(page3, "unrevised");
        page3.setLayout(flowLayout);
        JTable newTable = loadTable(connection.getUnrevisedPlats());
        JScrollPane scrollPane = new JScrollPane(newTable);
        scrollPane.setBounds(50, 200, 500, 400);
        page3.add(scrollPane);

        JPanel page4 = new JPanel();
        cards.add(page4, "approved");
        page4.setLayout(flowLayout);
        JTable approvedTable = loadTable(connection.getApprovedSources());
        JScrollPane approvedScrollPane = new JScrollPane(approvedTable);
        approvedScrollPane.setBounds(50, 200, 500, 400);
        page4.add(approvedScrollPane);
        
        

        JPanel page5 = new JPanel();
        cards.add(page5, "unapproved");
        
        JButton addNewSource = new JButton("Add New Source");
        FlowLayout flowLayout5 = new FlowLayout(FlowLayout.CENTER, 100, 10); 
        page5.setLayout(flowLayout5);
        JTable unapprovedTable = loadTable(connection.getUnapprovedSources());
        JScrollPane unapprovedPane = new JScrollPane(unapprovedTable);
        page5.add(unapprovedPane);
        addNewSource();
        addNewSource.setActionCommand("newSource");
        addNewSource.addActionListener(this);
        page5.add(addNewSource);
        
        
    }
    private void addNewSource(){
        JPanel page7 = new JPanel();
        JTextField newSourceTF = new JTextField("Enter data for new source to be approved");
        newSourceTF.setBounds(50,150, 100,30); 
        Font newFont=new Font(newSourceTF.getFont().getName(),newSourceTF.getFont().getStyle(),16);
        newSourceTF.setFont(newFont); 
        newSourceTF.setEditable(false);
        newSourceTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        page7.add(newSourceTF);
        JButton addsorce = new JButton("ADD");
        addsorce.setBounds(0, 0, 150, 20);
        addsorce.setActionCommand("unapproved");
        addsorce.addActionListener(this);
        page7.add(addsorce);

        GridLayout grid = new GridLayout(4, 2,50,50);
        page7.setLayout(grid);

       
        JLabel conIDL = new JLabel("ConveyanceID:");
        JLabel  reciveL= new JLabel("Date Recieved:");
        JLabel pNameL = new JLabel("Project Name:");
        
        JTextField conIN = new JTextField("");
        JTextField reciveIN = new JTextField("");
        JTextField pNameIN = new JTextField("");

        page7.add(conIDL);
        page7.add(conIN);
        page7.add(reciveL);
        page7.add(reciveIN);
        page7.add(pNameL);
        page7.add(pNameIN);

        cards.add(page7, "newSource");
    }
    public JTable loadTable(ResultSet rs) {

        try {

            m = new DefaultTableModel();
            int colcnt = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= colcnt; i++) {
                m.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                String[] data = new String[colcnt];
                for (int i = 0; i < colcnt; i++) {
                    data[i] = rs.getString(rs.getMetaData().getColumnName(i + 1));
                }
                m.addRow(data);
            }
            JTable dataTable = new JTable();
            dataTable.setModel(m);
            return dataTable;

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
    public JTable updateTable(JTable table,ResultSet rs){
        
        try {   

            m = new DefaultTableModel();
            int colcnt = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= colcnt; i++) {
                m.addColumn(rs.getMetaData().getColumnName(i));
            }

            while (rs.next()) {
                String[] data = new String[colcnt];
                for (int i = 0; i < colcnt; i++) {
                    data[i] = rs.getString(rs.getMetaData().getColumnName(i + 1));
                }
                m.addRow(data);
            }

            table.setModel(m);
            m.fireTableDataChanged();
            return table;
            
        }catch (SQLException e){
            System.err.println(e);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String Action = e.getActionCommand();
        if (Action.equals("search")) { //Chain elseifs for different commands 
            String data="";
        }
        else if (Action.equals("searchEditor")) { //Chain elseifs for different commands 
            name = textField.getText();
            searchEditorTable = updateTable(searchEditorTable,connection.getSourcesByEditor(name));
            cardLayout.show(cards, Action);
        }    
        else {
            cardLayout.show(cards, Action);
        }

    }

    public static void main(String[] args) {
        DatabaseProjectFinal start = new DatabaseProjectFinal(); //Create mainTest object that is a frame with two panels
        start.setVisible(true);
    }

}