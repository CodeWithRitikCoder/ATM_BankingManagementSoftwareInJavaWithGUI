//Here it is a package of My Login Class of ATM Project which is Main Window Class.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//Here it is my Public main class.
public class Login extends JFrame implements ActionListener {
    
    //Here it is my Global regerence variables.
    JButton signIn, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    
    //Here it is my Constructor of this Class.
    public Login(){
        
        //Here I am Setting Layout of the JFrame.
        setLayout(null);
        
        //Here I am setting banklogo image on the JFrame.
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image icon2= icon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon icon3= new ImageIcon(icon2);
        JLabel label= new JLabel(icon3);
        label.setBounds(70, 10, 120, 120);
        add(label);
        
        //Here I am setting JLabel For Print -Welcome to ATM- on the JFrame.
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Normal", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        add(text);
        
        //Here I am setting JLabel For Print -Card No:- on the JFrame.
        JLabel cardNo= new JLabel("Card No:");
        cardNo.setFont(new Font("Normal", Font.BOLD, 30));
        cardNo.setBounds(120, 150, 150, 40);
        add(cardNo);
        
        //Here I am setting JTextField For get -Card Number- on the JFrame.
        cardTextField= new JTextField();
        cardTextField.setBounds(300, 155, 230, 30);
        cardTextField.setFont(new Font("Normal", Font.BOLD, 16));
        add(cardTextField);
        
        //Here I am setting JLabel For Print -PIN No:- on the JFrame.
        JLabel pinNo= new JLabel("PIN No:");
        pinNo.setFont(new Font("Normal", Font.BOLD, 30));
        pinNo.setBounds(120, 220, 250, 40);
        add(pinNo);
        
        //Here I am setting JTextField For get -PIN Number- on the JFrame.
        pinPasswordField= new JPasswordField();
        pinPasswordField.setBounds(300, 225, 230, 30);
        pinPasswordField.setFont(new Font("Normal", Font.BOLD, 16));
        add(pinPasswordField);
        
        //Here I am setting Rupees image on the JFrame.
        ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icons/Rupees2.jpeg"));
        Image icon4= icon1.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT);
        ImageIcon icon5= new ImageIcon(icon4);
        JLabel label1= new JLabel(icon5);
        label1.setBounds(60, 270, 150, 150);
        add(label1);
        
        //Here I am setting JButton for -Sign In- on the JFrame Image.
        signIn= new JButton("SING IN");
        signIn.setBounds(300, 300, 100, 30);
        signIn.setFont(new Font("Normal", Font.BOLD, 16));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        add(signIn);
        
        //Here I am setting JButton for -Clear- on the JFrame Image.
        clear= new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setFont(new Font("Normal", Font.BOLD, 16));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        
        //Here I am setting JButton for -Sign Up- on the JFrame Image.
        signUp= new JButton("SIGN UP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setFont(new Font("Normal", Font.BOLD, 16));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        add(signUp);
        
        //Here I am setting addActionListener on the -Buttons- of JButton.
        signIn.addActionListener(this);
        clear.addActionListener(this);
        signUp.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Automated Teller Machine");
        setSize(700, 480);
        setLocation(400, 100);
        //It is used to chage JFrame color.
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== signIn){
            String cardNumber= cardTextField.getText();
            String pinNumber= pinPasswordField.getText();
            MySqlConnection msc= new MySqlConnection();
            
            //Here it is checking is not Empty Card Number and PIN.
            if(cardNumber.trim().isEmpty() && pinNumber.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter Your Card Number or PIN");
                
            //Here it is Ceching is not Empty Card Number.
            }else if(cardNumber.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter your Card Number");
                
            //Here it is Ceching is not Empty PIN.
            }else if(pinNumber.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter your PIN");
            }else{
                
                //Here I am Hitting MySQL database Connection.
                try {
                    boolean booleanForCheckCardNoAndPin= false;
                    //String query= "select *from login where Card_No= '"+cardNumber+"' and PIN_No= '"+pinNumber+"'";
                    String query= "select *from login";
                    ResultSet resultSet=  msc.statement.executeQuery(query);
                    while(resultSet.next()){
                        if(cardNumber.equalsIgnoreCase(resultSet.getString("Card_No")) && pinNumber.equals(resultSet.getString("PIN_No"))){
                            JOptionPane.showMessageDialog(null, "Login Successfully!");                            
                            setVisible(false);
                            new Transactions(pinNumber).setVisible(true);
                            booleanForCheckCardNoAndPin= false;
                            break;
                            
                        //Here it is checking is not Invalie Card Number.
                        }else if(cardNumber.equalsIgnoreCase(resultSet.getString("Card_No"))){
                            JOptionPane.showMessageDialog(null, "PIN is Invalid");
                            booleanForCheckCardNoAndPin= false;
                            break;
                            
                        //Here it is checking is not Invalid PIN.
                        }else if(pinNumber.equals(resultSet.getString("PIN_No"))){
                            JOptionPane.showMessageDialog(null, "Card Number is Invalid");
                            booleanForCheckCardNoAndPin= false;
                            break;
                        }else{
                            booleanForCheckCardNoAndPin= true;
                        }
                    }
                    
                    //Here it is checking is not Invalid Card Number and PIN.
                    if(booleanForCheckCardNoAndPin){
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    } 
                } catch (SQLException e3) {
                    System.out.println(e3);
                }
            }
        }else if(e.getSource()== clear){
            if(cardTextField.getText().trim().isEmpty() && pinPasswordField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Field Already Empty");
                cardTextField.setText("");
                pinPasswordField.setText("");
            }else{
                cardTextField.setText("");
                pinPasswordField.setText("");
            }
        }else if(e.getSource()== signUp){
            System.out.println("SingUp");
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }
    
    //Here It is My public main method of Login Class.
    public static void main(String[] args) {
        System.out.println("My name is Login Window");
        new Login();
        
    }
}
