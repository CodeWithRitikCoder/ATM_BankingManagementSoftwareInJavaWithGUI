//Here it is a package of My MiniStatement Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.sql.SQLException;

//Here it is my Public main class.
public class MiniStatement extends JFrame{
    
    //Here it is my Global regerence variables.
    String pinNumber;

    //Here it is my Constructor of this Class.
    public MiniStatement(String pinNumber) {
        
        //Here I am setting value into the Global variable.
        this.pinNumber= pinNumber;
        
        //Here I am Setting Layout of the JFrame.
        setLayout(null);
        
        //Here I am setting JLabel For Print -Welcome to ATM- on the JFrame.
        JLabel bankNameJLabel= new JLabel("Indian Bank");
        bankNameJLabel.setBounds(125, 20, 1000, 30);
        bankNameJLabel.setFont(new Font("Noraml", Font.BOLD, 22));
        bankNameJLabel.setForeground(Color.BLACK);
        add(bankNameJLabel);
        
        //Here I am setting JLabel For Print -Card Number- on the JFrame.
        JLabel cardNumber= new JLabel();
        cardNumber.setBounds(55, 80, 800, 35);
        cardNumber.setFont(new Font("Noraml", Font.BOLD, 20));
        cardNumber.setForeground(Color.BLACK);
        add(cardNumber);
        
        //Here I am Hitting MySQL database Connection.
        try {
            MySqlConnection msc= new MySqlConnection();
            String query= "select *from login where PIN_No= '"+pinNumber+"'";
            ResultSet resultSet= msc.statement.executeQuery(query);
            while (resultSet.next()) {
                cardNumber.setText("Card No: "+ resultSet.getString("Card_No").substring(0, 4)+ "XXXXXXXX"
                        + resultSet.getString("Card_No").substring(12));
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        //Here I am setting JLabel For Print -Mini Statement- on the JFrame.
        JLabel miniStatementJLabel= new JLabel();
        miniStatementJLabel.setBounds(13, 130, 400, 300);
        miniStatementJLabel.setFont(new Font("Noraml", Font.BOLD, 14));
        miniStatementJLabel.setForeground(Color.BLACK);
        add(miniStatementJLabel);
        
        //Here I am creating balance Local variable.
        int balance= 0;
        
        //Here I am Hitting MySQL database Connection.
        try {
            MySqlConnection msc= new MySqlConnection();
            String query= "select *from transactions where Pin_No= '"+pinNumber+"' order by Sr_No DESC limit 8";
            ResultSet resultSet= msc.statement.executeQuery(query);
            while (resultSet.next()) {
                miniStatementJLabel.setText(miniStatementJLabel.getText()+ "<html>"+ resultSet.getString("Date") 
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ resultSet.getString("Type_Of_Transaction")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ resultSet.getString("Amount")+ "<br><br><html>");
                
                    if(resultSet.getString("Type_Of_Transaction").equals("Deposit")){
                        balance+= Integer.parseInt(resultSet.getString("Amount"));
                    }else{
                        balance-= Integer.parseInt(resultSet.getString("Amount"));
                    }
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        //Here I am setting JLabel For Print -Your Curren amount Balance is- on the JFrame.
        JLabel balanceJLabel1= new JLabel("Your Current account Balance is");
        balanceJLabel1.setBounds(35, 460, 800, 35);
        balanceJLabel1.setFont(new Font("Noraml", Font.BOLD, 20));
        balanceJLabel1.setForeground(Color.BLACK);
        add(balanceJLabel1);
        
        //Here I am setting JLabel For Print -Rs: balance- on the JFrame.
        JLabel balanceJLabel2= new JLabel("Rs: "+ balance);
        balanceJLabel2.setBounds(120, 500, 800, 35);
        balanceJLabel2.setFont(new Font("Noraml", Font.BOLD, 22));
        balanceJLabel2.setForeground(Color.BLACK);
        add(balanceJLabel2);
        
        //Here I am setting Properties of JFrame.
        setTitle("Mini Statement");
        setBounds(600, 80, 400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
    }
    
    //Here It is My public main method of MiniStatement Class.
    public static void main(String[] args) {
        System.out.println("This is my Mini Statement Window");
        new MiniStatement("").setVisible(true);
    }
}
