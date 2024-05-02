import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  

public class MainTest extends Frame implements ActionListener{   
    JTextField text; JLabel label;
    MainTest() {
        JFrame f = new JFrame("TEST");

        JButton b1 = new JButton("Members");
        b1.addActionListener(this);

        JButton b2 = new JButton("Development Plans ");

        JButton b3 = new JButton("Plats");

        text = new JTextField();
        text.setBounds(50,100, 150,20);

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
        String page = " ";
        label.setText("NewText");
        }catch(Exception ex){System.out.println(ex);}  
    }  

    public static void main(String[] args) {
        new MainTest();
    }

    
}
