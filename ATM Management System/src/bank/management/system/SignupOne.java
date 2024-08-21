package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameField,faname,emailText,addText,cityText,stateText,pinText;
    JButton next;
    JRadioButton male,female,oth,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L+1000L));
        
        JLabel formno= new JLabel("APPLICATION FORM NO. "+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personalDetails= new JLabel("PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);        
        
        JLabel name= new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);     
        
        nameField=new JTextField();
        nameField.setFont(new Font("Raleway",Font.BOLD,20));
        nameField.setBounds(300,140,400,30);
        add(nameField);
        
        JLabel fname= new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        faname=new JTextField();
        faname.setFont(new Font("Raleway",Font.BOLD,20));
        faname.setBounds(300,190,400,30);
        add(faname);        
        
        JLabel dob= new JLabel("DOB: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        
        JLabel gender= new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);        
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email= new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,20));
        emailText.setBounds(300,340,400,30);
        add(emailText);          
     
        JLabel marital= new JLabel("Marital Status ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married=new JRadioButton("married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        oth=new JRadioButton("others");
        oth.setBounds(630,390,100,30);
        oth.setBackground(Color.WHITE);
        add(oth);          
        
        ButtonGroup marriedgroup=new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);   
        marriedgroup.add(oth); 

        JLabel address= new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addText=new JTextField();
        addText.setFont(new Font("Raleway",Font.BOLD,20));
        addText.setBounds(300,440,400,30);
        add(addText);

        JLabel city= new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,20));
        cityText.setBounds(300,490,400,30);
        add(cityText);        
        
        JLabel state= new JLabel("state: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);  
        
        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,20));
        stateText.setBounds(300,540,400,30);
        add(stateText);              
        
        JLabel pincode= new JLabel("Pin Code: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);  
        
        pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,20));
        pinText.setBounds(300,590,400,30);
        add(pinText);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameField.getText();
        String fname=faname.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }

        String email=emailText.getText();
        
        String maritial=null;
        if(married.isSelected()){
            maritial="Married";
        }
        else if(unmarried.isSelected()){
            maritial="Unmarried";
        }
        else if(oth.isSelected()){
            maritial="Other";
        }
        String address=addText.getText();
        String city=cityText.getText();
        String state=stateText.getText();
        String pin=pinText.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"All Fields Are Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
        
    }
    public static void main(String[] args){
        new SignupOne();
    }
}
