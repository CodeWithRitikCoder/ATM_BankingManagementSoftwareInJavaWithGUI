//Here it is a package of My Withdrawl Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Here it is my Public main class.
public class Withdrawl extends JFrame implements ActionListener{

    //Here it is my Global regerence variables.
    JTextField amountTextField;
    JButton withdrawl, back;
    String pinNumber;
    
    //Here it is my Constructor of this Class.
    public Withdrawl(String pinNumber) {
        
        //Here I am setting value into the Global variable.
        this.pinNumber= pinNumber;
        
        //Here I am Setting Layout of the JFrame.
        setLayout(null);
        
        //Here I am setting image on the JFrame.
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 950, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);
        
        //Here I am setting JLabel For Print -Enter the amount you want to Withdraw- on the JFrame Image.
        JLabel text= new JLabel("Enter the amount You want to Withdraw");
        text.setBounds(158, 270, 400, 35);
        text.setFont(new Font("Noraml", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Here I am setting JTextField For get -Amount from User- on the JFrame Image.
        amountTextField= new JTextField();
        amountTextField.setBounds(170, 350, 330, 30);
        amountTextField.setFont(new Font("Normal", Font.BOLD, 16));
        add(amountTextField);
        
        //Here I am setting JButton for -Withdraw- on the JFrame Image.
        withdrawl= new JButton("Withdraw");
        withdrawl.setBounds(360, 460, 150, 30);
        withdrawl.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(withdrawl);
        
        //Here I am setting JButton for -Back- on the JFrame Image.
        back= new JButton("Back");
        back.setBounds(160, 460, 150, 30);
        back.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(back);
        
        //Here I am setting addActionListener on the -buttons- of JButton.
        withdrawl.addActionListener(this);
        back.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Deposit window");
        setBounds(300, 10, 900, 830);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== withdrawl){
            boolean booleanForCheckNumberFormatException= false;
            String amount= amountTextField.getText();
            
            //Here I am checking NumberFormatException of amountTextField.
            try {
                int x= Integer.parseInt(amount);
            } catch (NumberFormatException e7) {
                booleanForCheckNumberFormatException= true;
            }
            Date date= new Date();
            if(amount.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter the amount to Withdrawl");
                amountTextField.setText("");
                return;
            }else if(booleanForCheckNumberFormatException){
                JOptionPane.showMessageDialog(null, "Characters are not allowed");
            }else {
                try{
                    
                    //Here I am Hitting MySQL database Connection.
                    MySqlConnection msc= new MySqlConnection();
                    String query= "insert into Transactions value('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    msc.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs: "+ amount+ " Withdrawl Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                
                }catch(HeadlessException | SQLException e4){
                    System.out.println(e4);
                }
            }
        }else if(e.getSource()== back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        
    }
    
    //Here It is My public main method of Withdrawl Class.
    public static void main(String[] args) {
        System.out.println("This is my Deposit window");
        new Withdrawl("");
    }
}
