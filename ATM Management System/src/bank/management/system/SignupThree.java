/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type= new JLabel("Acount Type ");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,200,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,200,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,220,200,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup grpaccount=new ButtonGroup();
        grpaccount.add(r1);
        grpaccount.add(r2);
        grpaccount.add(r3);
        grpaccount.add(r4);   
        
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        
        JLabel carddetail=new JLabel("Your 16 digit card number: ");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,30);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        JLabel pindetail=new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);
        
        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);
        
        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4=new JCheckBox("Email/SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6=new JCheckBox("E-statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7=new JCheckBox("I hereby declare declares that the above entered detais are correct");
        c7.setFont(new Font("Raleway",Font.BOLD,16));
        c7.setBounds(100,670,600,30);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        add(submit);
        submit.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        add(cancel);
        cancel.addActionListener(this);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }
            else if(r2.isSelected()){
                accountType="Fixed Deposit";
            }
            else if(r3.isSelected()){
                accountType="Current Account";
            }
            else if(r4.isSelected()){
                accountType="Reccuring Deposit Account";
            }
            
            Random random=new Random();
            String cardnumber=""+Math.abs(random.nextLong()%9000000L+505093600L);
            
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM Card";
            }
            else if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }
            else if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            }
            else if(c4.isSelected()){
                facility=facility+" Email/sms alerts";
            }
            else if(c5.isSelected()){
                facility=facility+" Cheque Book";
            }
            else if(c6.isSelected()){
                facility=facility+" E-statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Required");
                }
                else{
                    Conn conn=new Conn();
                    String query="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    conn.s.executeUpdate(query);
                    
                    String query2="insert login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\n Pin: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
        
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
