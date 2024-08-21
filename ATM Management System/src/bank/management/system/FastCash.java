package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,fastcash,ministatement,pinchange,balanceenquiry,exit,withdraw;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Select withdrawl ammount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        image.add(deposit);
        deposit.addActionListener(this);
        
        withdraw=new JButton("Rs 500");
        withdraw.setBounds(355,415,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);
        
        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);
        fastcash.addActionListener(this);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(170,485,150,30);
        image.add(ministatement);
        ministatement.addActionListener(this);
        
        pinchange=new JButton("2000");
        pinchange.setBounds(355,450,150,30);
        image.add(pinchange);
        pinchange.addActionListener(this);
        
        balanceenquiry=new JButton("10000");
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry);
        balanceenquiry.addActionListener(this);
        
        exit=new JButton("Back");
        exit.setBounds(355,520,150,30);
        image.add(exit);
        exit.addActionListener(this);
        
        setSize(900,900);
        setLocation(300,0);
       // setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        System.exit(0);
        }
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
