import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class MainTest extends Frame implements ActionListener{   
    JTextField text; JLabel label;
    MainTest() {
        JFrame f = new JFrame("TEST");

        JButton b1 = new JButton("Members");
        b1.setBounds(0,0, 150,20);
        b1.setActionCommand("member");
        b1.addActionListener(this);

        JButton b2 = new JButton("Development Plans ");
        b2.setBounds(150,0, 150,20);
        b2.setActionCommand("Development Plans");
        b2.addActionListener(this);

        JButton b3 = new JButton("Plats");
        b3.setBounds(300,0, 150,20);
        b3.setActionCommand("Plats");
        b3.addActionListener(this); 
        
        text = new JTextField();
        text.setBounds(50,0, 150,20);

        label=new JLabel();  
        label.setBounds(100,300, 250,20);    
        f.setLayout(new FlowLayout());

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(text);
        f.add(label);


        f.setSize(500, 500); // Set frame size
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        f.setVisible(true); // Make frame visible
    }

    public void actionPerformed(ActionEvent e) {  
        try{  
        label.setText("The " + e.getActionCommand() + " button was pressed");
        }catch(Exception ex){System.out.println(ex);}  
    } 
    

    public static void main(String[] args) {
        new MainTest();
    }

    
}
