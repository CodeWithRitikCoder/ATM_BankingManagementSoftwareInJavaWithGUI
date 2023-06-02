//Here it is a package of My FastCash Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//Here it is my Public main class.
public class FastCash extends JFrame implements ActionListener{
    
    //Here it is my Global regerence variables.
    JButton rs100Button, rs500Button, rs1000Button, rs2000Button, rs5000Button, rs10000Button, backButton;
    String pinNumber;

    //Here it is my Constructor of this Class.
    public FastCash(String pinNumber) {
        
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
        
        //Here I am setting JLabel For Print -Select Withdrawl Amount- on the JFrame Image.
        JLabel text= new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(195, 270, 700, 35);
        text.setFont(new Font("Noraml", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Here I am setting JButton for -Rs: 100- on the JFrame Image.
        rs100Button= new JButton("Rs: 100");
        rs100Button.setBounds(160, 390, 150, 30);
        rs100Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs100Button);
        
        //Here I am setting JButton for -Rs: 500- on the JFrame Image.
        rs500Button= new JButton("Rs: 500");
        rs500Button.setBounds(340, 390, 174, 30);
        rs500Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs500Button);
        
        //Here I am setting JButton for -Rs: 1000- on the JFrame Image.
        rs1000Button= new JButton("Rs: 1000");
        rs1000Button.setBounds(160, 425, 150, 30);
        rs1000Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs1000Button);
        
        //Here I am setting JButton for -Rs: 2000- on the JFrame Image.
        rs2000Button= new JButton("Rs: 2000");
        rs2000Button.setBounds(340, 425, 174, 30);
        rs2000Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs2000Button);
        
        //Here I am setting JButton for -Rs: 5000- on the JFrame Image.
        rs5000Button= new JButton("Rs: 5000");
        rs5000Button.setBounds(160, 460, 150, 30);
        rs5000Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs5000Button);
        
        //Here I am setting JButton for -Rs: 10000- on the JFrame Image.
        rs10000Button= new JButton("Rs: 10000");
        rs10000Button.setBounds(340, 460, 174, 30);
        rs10000Button.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(rs10000Button);
        
        //Here I am setting JButton for -Back- on the JFrame Image.
        backButton= new JButton("Back");
        backButton.setBounds(160, 495, 150, 30);
        backButton.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(backButton);
        
        //Here I am setting addActionListener on the -Buttons- of JButton.
        rs100Button.addActionListener(this);
        rs500Button.addActionListener(this);
        rs1000Button.addActionListener(this);
        rs2000Button.addActionListener(this);
        rs5000Button.addActionListener(this);
        rs10000Button.addActionListener(this);
        backButton.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Transaction window");
        setSize(900, 830);
        setLocation(300, 10);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== backButton){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount= ((JButton)e.getSource()).getText().substring(4);
            
            //Here I am Hitting MySQL database Connection.
            MySqlConnection msc= new MySqlConnection();
            try {
                String query= "Select *from transactions where Pin_No= '"+pinNumber+"'";
                ResultSet resultSet= msc.statement.executeQuery(query);
                int balance= 0;
                while(resultSet.next()){
                    if(resultSet.getString("Type_Of_Transaction").equals("Deposit")){
                        balance+= Integer.parseInt(resultSet.getString("Amount"));
                    }else{
                        balance-= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
                if(e.getSource() != backButton && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                Date date= new Date();
                String query1= "insert into transactions values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                msc.statement.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Rs: "+ amount+ " - Debited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            } catch (SQLException e5) {
                System.out.println("Ex: "+e5);
            }
        }
    }
    
    //Here It is My public main method of FastCash Class.
    public static void main(String[] args) {
        System.out.println("This is my Fast cash window");
        new FastCash("2870");
    }
}
