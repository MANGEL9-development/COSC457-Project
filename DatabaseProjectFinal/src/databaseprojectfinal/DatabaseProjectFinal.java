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
import java.sql.SQLException;

public class DatabaseProjectFinal extends JFrame implements ActionListener{   
    JPanel buttonsPanel;
    JPanel cards;
    CardLayout cardLayout;
    JList<String> memberList;
    JLabel memberLabel;
        
    
    //MainTest is the frame object
    DatabaseProjectFinal() { 
        // Create the main frame
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Create panel for buttons
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        addButtons();

        // Create panel for cards
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        addPages();

        // Add panels to frame
        add(buttonsPanel, BorderLayout.PAGE_START);
        add(cards, BorderLayout.LINE_START);

    }

    //Adds the buttons along the top that exist for all cards
    private void addButtons() {
        JButton b1 = new JButton("Members");
        b1.setBounds(0,0, 150,20);
        b1.setActionCommand("member");
        b1.addActionListener(this);
        buttonsPanel.add(b1);

        JButton b2 = new JButton("Development Plans ");
        b2.setBounds(150,0, 150,20);
        b2.setActionCommand("development");
        b2.addActionListener(this);
        buttonsPanel.add(b2);

        JButton b3 = new JButton("Plats");
        b3.setBounds(300,0, 150,20);
        b3.setActionCommand("plat");
        b3.addActionListener(this);
        buttonsPanel.add(b3);
    }

    //Create cards with differnt pages [Area below buttons] 
    private void addPages() {
        JPanel page1 = new JPanel();
        JLabel P1l = new JLabel("Member Page");  
        page1.add(P1l);

        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("smith");  
        l1.addElement("jones");  
        l1.addElement("blake");  
        l1.addElement("clark");  
        memberList = new JList<>(l1);  
        memberList.setBounds(0,100, 150,100);
        memberList.setAlignmentY(BOTTOM_ALIGNMENT);
        memberList.setAlignmentX(LEFT_ALIGNMENT);
        page1.add(memberList);
        memberLabel = new JLabel(" ");  
        page1.add(memberLabel);

        JButton searchButton = new JButton("search");
        searchButton.setBounds(50,250, 150,50);
        searchButton.addActionListener(this);
        searchButton.setActionCommand("search");
        page1.add(searchButton);
        cards.add(page1, "member");

        JPanel page2 = new JPanel();
        JLabel P2l = new JLabel("Development plans page");  
        page2.add(P2l);
        String column[]={"ID","NAME","SALARY"};
        String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
        JTable table=new JTable(data,column);
        table.setAlignmentY(BOTTOM_ALIGNMENT);
        page2.add(table);    
        cards.add(page2, "development");

        JPanel page3 = new JPanel();
        JLabel P3l = new JLabel("Plats page");  
        page3.add(P3l);
        cards.add(page3, "plat");
    }

    public void actionPerformed(ActionEvent e) {  
        String Action = e.getActionCommand();
        if (Action.equals("search")){ //Chain elseifs for different commands 
            String data = "";  
               if (memberList.getSelectedIndex() != -1) {                       
                  data = "Member Selected: " + memberList.getSelectedValue();   
                  memberLabel.setText(data);  
               }  
        }
        else{
            cardLayout.show(cards, Action);
        }
        
    } 
    

    public static void main(String[] args) {
        DatabaseProjectFinal start = new DatabaseProjectFinal(); //Create mainTest object that is a frame with two panels
        start.setVisible(true);
    }

    
}
