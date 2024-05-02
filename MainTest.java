import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class MainTest extends Frame implements ActionListener{   
    JTextField text; JLabel ScreenpickLabel;
    
    MainTest() {
        JFrame f = new JFrame("TEST");

        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("smith");  
        l1.addElement("jones");  
        l1.addElement("blake");  
        l1.addElement("clark");  
        JList<String> memberList = new JList<>(l1);  
        memberList.setBounds(50,100, 150,100);
        memberList.setAlignmentY(BOTTOM_ALIGNMENT);
       

        JButton b1 = new JButton("Members");
        b1.setBounds(0,0, 150,20);
        b1.setActionCommand("memberSwitch");
        

        JButton b2 = new JButton("Development Plans ");
        b2.setBounds(150,0, 150,20);
        b2.setActionCommand("development");
        

        JButton b3 = new JButton("Plats");
        b3.setBounds(300,0, 150,20);
        b3.setActionCommand("plat");
         
        JButton searchButton = new JButton("search");
        searchButton.setBounds(50,250, 150,50);
        
        text = new JTextField();
        text.setBounds(50,0, 150,20);

        ScreenpickLabel=new JLabel();  
        ScreenpickLabel.setBounds(100,50, 250,20);    
        

        JLabel memberLabel=new JLabel();  
        memberLabel.setBounds(100,200, 250,20);    
        

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(text);
        f.add(ScreenpickLabel);
        f.add(memberLabel);
        f.add(memberList);
        f.add(searchButton);

        b1.addActionListener(this); 
        b2.addActionListener(this);
        b3.addActionListener(this);
        searchButton.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {   
               String data = "";  
               if (memberList.getSelectedIndex() != -1) {                       
                  data = "Member Selected: " + memberList.getSelectedValue();   
                  memberLabel.setText(data);  
               }  
               
            }  
         });   
        f.setLayout(null);
        f.setSize(500, 500); // Set frame size
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        f.setVisible(true); // Make frame visible
    }

    public void actionPerformed(ActionEvent e) {  
        try{  
        String Action = e.getActionCommand();
        switch (Action){

            case "memberSwitch":
            ScreenpickLabel.setText("The " + Action + " button was pressed");
            break;

            case "development":
            ScreenpickLabel.setText("The " + Action + " button was pressed");
            break;

            case "plat":
            ScreenpickLabel.setText("The " + Action + " button was pressed");
            break;

            default:
            
        }
        
        }catch(Exception ex){System.out.println(ex);}  
    } 
    

    public static void main(String[] args) {
        new MainTest();
    }

    
}
