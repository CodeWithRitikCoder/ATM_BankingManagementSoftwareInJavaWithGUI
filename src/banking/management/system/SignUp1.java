//Here it is a package of My SignUp1 Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//Here it is my Public main class.
public class SignUp1 extends JFrame implements ActionListener {
    
    //Here it is my Global regerence variables.
    long random;
    JTextField nameTextField, fatherNameTextField, emailTextField, addressTextField, cityTextField, 
            stateTextField, pinTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, custom, married, unMarried, other;
    JButton nextButton;

    //Here it is my Constructor of this Class.
    public SignUp1() {
        
        //Here I am Setting Layout of the JFrame. 
        setLayout(null);
        
        //Here I am Generating Random Number and Setting it.
        Random ran= new Random();
        random= Math.abs((ran.nextLong()% 9000L)+ 1000L);
        
        //Here I am setting JLabel for print -APPLICATION FOOR NO.- on the JFrame.
        JLabel formNo= new JLabel("APPLICATION FORM NO. "+ random);
        formNo.setFont(new Font("Normal", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);
        
        //Here I am setting JLabel for print -Page 1: Personal Details- on the JFrame.
        JLabel personDetails= new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Normal", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        //Here I am setting JLabel for print -Name:- on the JFrame.
        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Normal", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        //Here I am setting JTextField For get -Name from User- on the JFrame.
        nameTextField= new JTextField();
        nameTextField.setFont(new Font("Normal", Font.BOLD, 20));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        //Here I am setting JLabel for print -Father's Name::- on the JFrame.
        JLabel fatherName= new JLabel("Father's Name:");
        fatherName.setFont(new Font("Normal", Font.BOLD, 22));
        fatherName.setBounds(100, 190, 200, 30);
        add(fatherName);
        
        //Here I am setting JTextField For get -Father's Name from User- on the JFrame Image.
        fatherNameTextField= new JTextField();
        fatherNameTextField.setFont(new Font("Normal", Font.BOLD, 20));
        fatherNameTextField.setBounds(300, 190, 400, 30);
        add(fatherNameTextField);
        
        //Here I am setting JLabel for print -Date of Birth:- on the JFrame.
        JLabel dob= new JLabel("Date of Birth:");
        dob.setFont(new Font("Normal", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        //Here I am setting JDateChoose for get -Date of Birth form the User- on the JFrame.
        dateChooser= new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setFont(new Font("Normal", Font.BOLD, 16));
        add(dateChooser);
        
        //Here I am setting JLabel for print -Gender:- on the JFrame.
        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Normal", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        //Here I am setting JRadioButton for getSelected -Male- on the JFrame.
        male= new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setFont(new Font("Normal", Font.BOLD, 16));
        male.setBackground(Color.WHITE);
        add(male);
        
        //Here I am setting JRadioButton for getSelected -Female- on the JFrame.
        female= new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setFont(new Font("Normal", Font.BOLD, 16));
        female.setBackground(Color.WHITE);
        add(female);
        
        //Here I am setting JRadioButton for getSelected -Custom- on the JFrame.
        custom= new JRadioButton("Custom");
        custom.setBounds(600, 290, 120, 30);
        custom.setFont(new Font("Normal", Font.BOLD, 16));
        custom.setBackground(Color.WHITE);
        add(custom);
        
        //Here I am setting JRadioButton into the ButtonGroup Class to getSelected only one at a time.
        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(custom);
        
        //Here I am setting JLabel for print -Email:- on the JFrame.
        JLabel email= new JLabel("Email:");
        email.setFont(new Font("Normal", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        //Here I am setting JTextField For get -Email from User- on the JFrame Image.
        emailTextField= new JTextField();
        emailTextField.setFont(new Font("Normal", Font.BOLD, 20));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        //Here I am setting JLabel for print -Merital Status:- on the JFrame.
        JLabel materialStatus= new JLabel("Merital Status:");
        materialStatus.setFont(new Font("Normal", Font.BOLD, 22));
        materialStatus.setBounds(100, 390, 200, 30);
        add(materialStatus);
        
        //Here I am setting JRadioButton for getSelected -Married- on the JFrame.
        married= new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setFont(new Font("Normal", Font.BOLD, 16));
        married.setBackground(Color.WHITE);
        add(married);
        
        //Here I am setting JRadioButton for getSelected -UnMarried- on the JFrame.
        unMarried= new JRadioButton("UnMarried");
        unMarried.setBounds(450, 390, 120, 30);
        unMarried.setFont(new Font("Normal", Font.BOLD, 16));
        unMarried.setBackground(Color.WHITE);
        add(unMarried);
        
        //Here I am setting JRadioButton for getSelected -Other- on the JFrame.
        other= new JRadioButton("Other");
        other.setBounds(630, 390, 100, 30);
        other.setFont(new Font("Normal", Font.BOLD, 16));
        other.setBackground(Color.WHITE);
        add(other);
        
        //Here I am setting JRadioButton into the ButtonGroup Class to getSelected only one at a time.
        ButtonGroup maritalGroup= new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unMarried);
        maritalGroup.add(other);
        
        //Here I am setting JLabel for print -Address:- on the JFrame.
        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Normal", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        //Here I am setting JTextField For get -Address from User- on the JFrame Image.
        addressTextField= new JTextField();
        addressTextField.setFont(new Font("Normal", Font.BOLD, 20));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        //Here I am setting JLabel for print -City:- on the JFrame.
        JLabel city= new JLabel("City:");
        city.setFont(new Font("Normal", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        //Here I am setting JTextField For get -City from User- on the JFrame Image.
        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Normal", Font.BOLD, 20));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        //Here I am setting JLabel for print -State:- on the JFrame.
        JLabel state= new JLabel("State:");
        state.setFont(new Font("Normal", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        //Here I am setting JTextField For get -State from User- on the JFrame Image.
        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Normal", Font.BOLD, 20));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        //Here I am setting JLabel for print -Pin Code:- on the JFrame.
        JLabel pinCode= new JLabel("Pin Code:");
        pinCode.setFont(new Font("Normal", Font.BOLD, 22));
        pinCode.setBounds(100, 590, 200, 30);
        add(pinCode);
        
        //Here I am setting JTextField For get -Pin from User- on the JFrame Image.
        pinTextField= new JTextField();
        pinTextField.setFont(new Font("Normal", Font.BOLD, 20));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        //Here I am setting -WorldBank1- image on the JFrame.
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/Worldbank1.png"));
        Image icon2= icon.getImage().getScaledInstance(180, 120, Image.SCALE_DEFAULT);
        ImageIcon icon3= new ImageIcon(icon2);
        JLabel label= new JLabel(icon3);
        label.setBounds(70, 620, 200, 120);
        add(label);
        
        //Here I am setting JButton for -Next- on the JFrame Image.
        nextButton= new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Normal", Font.BOLD, 16));
        nextButton.setBounds(620, 660, 80, 30);
        add(nextButton);
        
        //Here I am setting addActionListener on the -buttons- of JButton.
        nextButton.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Sing Up 1");
        setBounds(350, 10, 850, 800);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== nextButton){
            String formNo= ""+ random;
            String name= nameTextField.getText();
            String fatherName= fatherNameTextField.getText();
            String dob= ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender= null;
            if(male.isSelected()){
                gender= "Male";
            }else if(female.isSelected()){
                gender= "Female";
            }else if(custom.isSelected()){
                gender= "Custome";
            }
            String email= emailTextField.getText();
            String marital= null;
            if(married.isSelected()){
                marital= "Married";
            }else if(unMarried.isSelected()){
                marital= "UnMarried";
            }else if(other.isSelected()){
                marital= "Other";
            }
            String address= addressTextField.getText();
            String city= cityTextField.getText();
            String state= stateTextField.getText();
            String pin= pinTextField.getText();
                        
            try {
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }else{
                    
                    //Here I am Hitting MySQL database Connection.
                    MySqlConnection msc= new MySqlConnection();
                    String query= "insert into signup values('"+formNo+"','"+name+"', '"+fatherName+"', "
                            + "'"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', "
                            + "'"+state+"', '"+pin+"')";
                    msc.statement.executeUpdate(query);
                    setVisible(false);
                    new SignUp2(formNo).setVisible(true);
                } 
            } catch (HeadlessException | SQLException e1) {
                System.out.println(e1);
            } 
        }
    }
    
    //Here It is My public main method of SignUp1 Class.
    public static void main(String[] args) {
        System.out.println("This is my SignUP 1 Window");
        new SignUp1();
        
    }
}
