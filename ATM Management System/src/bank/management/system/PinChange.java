
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    JTextField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text= new JLabel("Change your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        add(text);
        
        JLabel pintext= new JLabel("New Pin");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        pintext.setBounds(165,320,180,25);
        add(pintext);
        
        pin = new JTextField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Arial", Font.BOLD, 14));
        add(pin);
        
        JLabel repintext= new JLabel("Re-Enter");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        repintext.setBounds(165,320,180,25);
        add(repintext);
        
        repin = new JTextField();
        repin.setBounds(330,320,180,25);
        repin.setFont(new Font("Arial", Font.BOLD, 14));
        add(repin);
        
        change = new JButton("CLEAR");
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setBounds(335,485,150,30);
        image.add(change);
        
        back = new JButton("CLEAR");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(335,520,150,30);
        image.add(back);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"pin not match");
                return;
            }
            if(npin.equals("") || rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter pin");
            }
            Conn c=new Conn();
            String query1="update bank set pin='"+rpin+"'+ where pin='"+pinnumber+"'";
            String query2="update login set pin='"+rpin+"'+ where pin='"+pinnumber+"'";
            String query3="update signupthree set pin='"+rpin+"'+ where pin='"+pinnumber+"'";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"pin changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }
        catch(Exception e){
            System.out.print(e);
        }
        }
        
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
