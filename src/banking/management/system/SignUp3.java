//Here it is a package of My SignUp3 Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//Here it is my Public main class.
public class SignUp3 extends JFrame implements ActionListener {

    //Here it is my Global regerence variables.
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formNo;
    
    //Here it is my Constructor of this Class.
    public SignUp3(String formNo) {
        
        //Here I am setting value into the Global variable.
        this.formNo= formNo;
        
        //Here I am Setting Layout of the JFrame.
        setLayout(null);
        
        //Here I am setting JLabel for print -Page 3: Account Details- on the JFrame.
        JLabel l1= new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Noraml", Font.BOLD, 24));
        l1.setBounds(200, 20, 400, 40);
        add(l1);
        
        //Here I am setting -WorldBank1- image on the JFrame.
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/Worldbank1.png"));
        Image icon2= icon.getImage().getScaledInstance(180, 120, Image.SCALE_DEFAULT);
        ImageIcon icon3= new ImageIcon(icon2);
        JLabel label= new JLabel(icon3);
        label.setBounds(380, 50, 200, 120);
        add(label);
        
        //Here I am setting JLabel for print -Accunt type- on the JFrame.
        JLabel type= new JLabel("Account type");
        type.setFont(new Font("Noraml", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 40);
        add(type);
        
        //Here I am setting JRadioButton for getSelected -Saving Account- on the JFrame.
        r1= new JRadioButton("Saving Account");
        r1.setFont(new Font("Noraml", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        
        //Here I am setting JRadioButton for getSelected -Fixed Deposit Amount- on the JFrame.
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Noraml", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        
        //Here I am setting JRadioButton for getSelected -Current Account- on the JFrame.
        r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Noraml", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 150, 20);
        add(r3);
        
        //Here I am setting JRadioButton for getSelected -Recurring Deposit Account- on the JFrame.
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Noraml", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);
        //Here I am setting JRadioButton into the ButtonGroup Class to getSelected only one at a time.
        ButtonGroup groupAccount= new ButtonGroup();
        groupAccount.add(r1);
        groupAccount.add(r2);
        groupAccount.add(r3);
        groupAccount.add(r4);
        
        //Here I am setting JLabel for print -Card Number- on the JFrame.
        JLabel card= new JLabel("Card Number:");
        card.setFont(new Font("Noraml", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);
        
        //Here I am setting JLabel for print -XXXX - XXXX - XXXX - 4184- on the JFrame.
        JLabel number= new JLabel("XXXX - XXXX - XXXX - 4184");
        number.setFont(new Font("Noraml", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);
        
        //Here I am setting JLabel for print -Your 16 Digit card Number- on the JFrame.
        JLabel cardDetail= new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Noraml", Font.BOLD, 12));
        cardDetail.setBounds(100, 330, 300, 20);
        add(cardDetail);
        
        //Here I am setting JLabel for print -PIN- on the JFrame.
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Noraml", Font.BOLD, 22));
        pin.setBounds(100, 370, 300, 30);
        add(pin);
        
        //Here I am setting JLabel for print -XXXX- on the JFrame.
        JLabel pinNumber= new JLabel("XXXX");
        pinNumber.setFont(new Font("Noraml", Font.BOLD, 22));
        pinNumber.setBounds(330, 370, 300, 30);
        add(pinNumber);
        
        //Here I am setting JLabel for print -Your $ Digit PIN- on the JFrame.
        JLabel pinDetail= new JLabel("Your 4 Digit PIN");
        pinDetail.setFont(new Font("Noraml", Font.BOLD, 12));
        pinDetail.setBounds(100, 400, 300, 20);
        add(pinDetail);
        
        //Here I am setting JLabel for print -Services Required- on the JFrame.
        JLabel services= new JLabel("Services Required:");
        services.setFont(new Font("Noraml", Font.BOLD, 22));
        services.setBounds(100, 450, 250, 30);
        add(services);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Noraml", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 40);
        add(c1);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Noraml", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 40);
        add(c2);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Noraml", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 40);
        add(c3);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c4= new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Noraml", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 40);
        add(c4);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Noraml", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 40);
        add(c5);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c6= new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Noraml", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 40);
        add(c6);
        
        //Here I am setting JCheckBox for getSelected on the JFrame.
        c7= new JCheckBox("I hearby declares that the above entered details are correct to "
                + "the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Noraml", Font.BOLD, 12));
        c7.setBounds(100, 650, 600, 40);
        add(c7);
        
        //Here I am setting JButton for -Submit- on the JFrame Image.
        submit= new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Noraml", Font.BOLD, 16));
        submit.setBounds(200, 720, 100, 30);
        add(submit);
        
        //Here I am setting JButton for -Cancel- on the JFrame Image.
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Noraml", Font.BOLD, 16));
        cancel.setBounds(400, 720, 100, 30);
        add(cancel);
        
        //Here I am setting addActionListener on the -buttons- of JButton.
        submit.addActionListener(this);
        cancel.addActionListener(this);
          
        //Here I am setting Properties of JFrame.
        setSize(700, 820);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== submit){
            if(!c7.isSelected()){
                JOptionPane.showMessageDialog(null, "Please Aprove Your all Information.");
            }else{
                String accountType= null;
                if(r1.isSelected()){
                    accountType= "Saving Account";
                }else if(r2.isSelected()){
                    accountType= "Fixed Deposit Account";
                }else if(r3.isSelected()){
                    accountType= "Current Account";
                }else if(r4.isSelected()){
                    accountType= "Reccuring Deposit Account";
                }
                Random random= new Random();
                String cardNumber= ""+ Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
                String pinNumber= ""+ Math.abs((random.nextLong() % 9000L)+ 1000L);
                String facility= "";
                if(c1.isSelected()){
                    facility= facility+ " ATM card";
                }else if(c2.isSelected()){
                facility= facility+ " Internet Banking";
                }else if(c3.isSelected()){
                    facility= facility+ " Mobile Banking";
                }else if(c4.isSelected()){
                    facility= facility+ " Email & SMS Alerts";
                }else if(c5.isSelected()){
                    facility= facility+ " Cheque Book";
                }else if(c6.isSelected()){
                    facility= facility+ " E-Statement";
                }
            
                //Here I am Hitting MySQL database Connection.
                try {
                    if(accountType.equals("")){
                        JOptionPane.showMessageDialog(null, "Account Type is Required");
                    }else{
                        MySqlConnection msc= new MySqlConnection();
                        String query= "insert into signup3 values('"+formNo+"', '"+accountType+"', '"+cardNumber+"', "
                                + "'"+pinNumber+"', '"+facility+"')";
                        String query2= "insert into login values('"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')";
                        msc.statement.execute(query);
                        msc.statement.execute(query2);
                        JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber+ "\n PIN: "+ pinNumber);
                        setVisible(false);
                        new Deposit(pinNumber).setVisible(true);
                    } 
                } catch (HeadlessException | SQLException e2) {
                    System.out.println("Error in mysql");
                }
            }
        }else if(e.getSource()== cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    //Here It is My public main method of SignUp3 Class.
    public static void main(String[] args) {
        System.out.println("This is my SignUp 3 window");
        new SignUp3("4352");
    }
}
