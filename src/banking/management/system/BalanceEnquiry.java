//Here it is a package of My BalanceEnquiry Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Here it is my Public main class.
public class BalanceEnquiry extends JFrame implements ActionListener{

    //Here it is my Global regerence variables.
    String pinNumber;
    JButton backButton;
    
    //Here it is my Constructor of this Class.
    public BalanceEnquiry(String pinNumber) {
        
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
        
        //Here I am setting JLabel for print -Balance Enquiry- on the JFrame Image.
        JLabel text= new JLabel("Balance Enquiry");
        text.setBounds(250, 270, 700, 35);
        text.setFont(new Font("Noraml", Font.BOLD, 22));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Here I am setting JButton for -Back- on the JFrame Image.
        backButton= new JButton("Back");
        backButton.setBounds(290, 495, 110, 30);
        backButton.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(backButton);
        
        //Here I am Hitting MySQL database Connection.
        MySqlConnection msc= new MySqlConnection();
        int balance= 0;
            try {
                String query= "Select *from transactions where Pin_No= '"+pinNumber+"'";
                ResultSet resultSet= msc.statement.executeQuery(query);
                while(resultSet.next()){
                    if(resultSet.getString("Type_Of_Transaction").equals("Deposit")){
                        balance+= Integer.parseInt(resultSet.getString("Amount"));
                    }else{
                        balance-= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
            //Here I am setting JLabel for print -Your Current Account Balance- on the JFrame Image.
            JLabel balanceLabel1= new JLabel("Your Current Account Balance");
            balanceLabel1.setBounds(190, 330, 400, 30);
            balanceLabel1.setFont(new Font("Noraml", Font.BOLD, 20));
            balanceLabel1.setForeground(Color.WHITE);
            image.add(balanceLabel1);
            
            //Here I am setting JLabel for pirnt -Rs: balance- on the JFrame Image.
            JLabel balanceLabel2= new JLabel("Rs: "+ balance);
            balanceLabel2.setBounds(260, 370, 400, 30);
            balanceLabel2.setFont(new Font("Noraml", Font.BOLD, 20));
            balanceLabel2.setForeground(Color.WHITE);
            image.add(balanceLabel2);
        
        //Here I am setting addActionListener on the -backButton- of JButton.
        backButton.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Balance Enquiry");
        setBounds(300, 10, 900, 830);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    //Here It is My public main method of BalanceEnquiry Class.
    public static void main(String[] args) {
        System.out.println("This is My Balance Enquiry Window");
        new BalanceEnquiry("");
    }
}
