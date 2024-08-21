package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please enter ammount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(170,350,320,25);
        amount.setForeground(Color.WHITE);
        amount.setFont(new Font("System",Font.BOLD,16));
        image.add(amount);
        
        withdraw=new JButton("Withdrawl");
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        back=new JButton("back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);
        setSize(900,900);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date =new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Ammount cannot be null");
            }
            else{
                try{
                Conn con=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawl Successfull");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.print(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}

