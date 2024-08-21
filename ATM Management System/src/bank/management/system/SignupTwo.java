
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField pan,adhaar;
    JButton next;
    JComboBox religion,category,income,qualification,occupation;
    JRadioButton syes,sno,eyes,eno;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT REGISTRATION FORM");
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L+1000L));

        
        JLabel additionalDetails= new JLabel("ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);        
        
        JLabel name= new JLabel("Religion ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        String valreligion[]= {"Hindu","Muslim","Sikh"};
        religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        JLabel fname= new JLabel("Category ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        String valcategory[]= {"General"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        add(category);        
        
        JLabel dob= new JLabel("Income ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valincome[]= {"null","Above 4 lakhs ","Above 7 lakhs","Above 10 lakhs"};
        income=new JComboBox(valincome);
        income.setBounds(300,240,400,30);
        add(income);
        
        JLabel gender= new JLabel("Education");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email= new JLabel("Qualification ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        String valeducation[]= {"Non Graduate","Graduate","Post Graduate","others"};
        qualification=new JComboBox(valeducation);
        qualification.setBounds(300,315,400,30);
        add(qualification);          
     
        JLabel marital= new JLabel("Occupation");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        String valoccupation[]= {"Self Employed","Salaried","Student","Retired"};
        occupation=new JComboBox(valoccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);         
        JLabel address= new JLabel("Pan Number");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city= new JLabel("Adhaar Number ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        adhaar=new JTextField();
        adhaar.setFont(new Font("Raleway",Font.BOLD,20));
        adhaar.setBounds(300,490,400,30);
        add(adhaar);        
        
        JLabel state= new JLabel("Senior Citizen  ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);  
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,60,30);
        add(syes);
        sno=new JRadioButton("No");
        sno.setBounds(370,540,60,30);
        add(sno);
        
        ButtonGroup marriedgroup=new ButtonGroup();
        marriedgroup.add(syes);
        marriedgroup.add(sno);            
        
        JLabel pincode= new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);  
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,60,30);
        add(eyes);
        eno=new JRadioButton("No");
        eno.setBounds(370,590,60,30);
        add(eno);
        
        ButtonGroup existing=new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);
        
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
      //  String formno=""+random;
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();;
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)qualification.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String senior=null;
        if(syes.isSelected()){
            senior="Yes";
        }
        else if(sno.isSelected()){
            senior="No";
        }
        
        String existingacc=null;
        if(eyes.isSelected()){
            existingacc="Yes";
        }
        else if(eno.isSelected()){
            existingacc="No";
        }        

        String span=pan.getText();
        String sadhaar=adhaar.getText();
        
        try{

                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhaar+"','"+senior+"','"+existingacc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.print(e);
        }
        
    }
    public static void main(String[] args){
        new SignupTwo("");
    }
}
