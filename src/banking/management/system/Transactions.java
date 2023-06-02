//Here it is a package of My Transactions Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Here it is my Public main class.
public class Transactions extends JFrame implements ActionListener{
    
    //Here it is my Global regerence variables.
    JButton deposit, withdrawl, fastcash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;

    //Here it is my Constructor of this Class.
    public Transactions(String pinNumber) {
        
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
        
        //Here I am setting JLabel For Print -Please Select Your Transaction- on the JFrame Image.
        JLabel text= new JLabel("Please Select Your Transaction");
        text.setBounds(168, 270, 700, 35);
        text.setFont(new Font("Noraml", Font.BOLD, 22));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Here I am setting JButton for -Deposit- on the JFrame Image.
        deposit= new JButton("Deposit");
        deposit.setBounds(160, 390, 150, 30);
        deposit.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(deposit);
        
        //Here I am setting JButton for -Cash Withdrawl- on the JFrame Image.
        withdrawl= new JButton("Cash Withdrawl");
        withdrawl.setBounds(340, 390, 174, 30);
        withdrawl.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(withdrawl);
        
        //Here I am setting JButton for -Fast Cash- on the JFrame Image.
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(160, 425, 150, 30);
        fastcash.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(fastcash);
        
        //Here I am setting JButton for -Mini Statement- on the JFrame Image.
        miniStatement= new JButton("Mini Statement");
        miniStatement.setBounds(340, 425, 174, 30);
        miniStatement.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(miniStatement);
        
        //Here I am setting JButton for -PIN Change- on the JFrame Image.
        pinChange= new JButton("PIN Change");
        pinChange.setBounds(160, 460, 150, 30);
        pinChange.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(pinChange);
        
        //Here I am setting JButton for -Balance Enquiry- on the JFrame Image.
        balanceEnquiry= new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(340, 460, 174, 30);
        balanceEnquiry.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(balanceEnquiry);
        
        //Here I am setting JButton for -Exit- on the JFrame Image.
        exit= new JButton("Exit");
        exit.setBounds(160, 495, 150, 30);
        exit.setFont(new Font("Noraml", Font.BOLD, 16));
        image.add(exit);
        
        //Here I am setting addActionListener on the -buttons- of JButton.
        deposit.addActionListener(this);
        withdrawl.addActionListener(this);
        fastcash.addActionListener(this);
        miniStatement.addActionListener(this);
        pinChange.addActionListener(this);
        balanceEnquiry.addActionListener(this);
        exit.addActionListener(this);
        
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
        if(e.getSource()== deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }else if(e.getSource()== withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if(e.getSource()== fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(e.getSource()== miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }else if(e.getSource()== pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(e.getSource()== balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(e.getSource()== exit){
            System.exit(0);
        }
    }
    
    //Here It is My public main method of Transations Class.
    public static void main(String[] args) {
        System.out.println("This is my Transaction window");
        new Transactions("");
    }
}
