//Here it is a package of My PinChange Class of ATM Project.
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//Here it is my Public main class.
public class PinChange extends JFrame implements ActionListener{

    //Here it is my Global regerence variables.
    String pinNumber;
    JPasswordField pinPasswordField, rePinPasswordField;
    JButton changeButton, backButton;
    
    //Here it is my Constructor of this Class.
    public PinChange(String pinNumber) {
        
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
        
        //Here I am setting JLabel for print -CHANGE YOUR PIN- on the JFrame Image.
        JLabel text= new JLabel("CHANGE YOUR PIN");
        text.setBounds(235, 270, 700, 35);
        text.setFont(new Font("Noraml", Font.BOLD, 20));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        //Here I am setting JLabel for print -New PIN:- on the JFrame Image.
        JLabel pintText= new JLabel("New PIN:");
        pintText.setBounds(165, 350, 180, 25);
        pintText.setFont(new Font("Noraml", Font.BOLD, 18));
        pintText.setForeground(Color.WHITE);
        image.add(pintText);
        
        //Here I am setting JTextField For get -Password from User- on the JFrame Image.
        pinPasswordField= new JPasswordField();
        pinPasswordField.setBounds(300, 348, 200, 25);
        pinPasswordField.setFont(new Font("Noraml", Font.BOLD, 22));
        pinPasswordField.setForeground(Color.BLACK);
        image.add(pinPasswordField);
        
        //Here I am setting JLabel for print -Re-Enter PIN:- on the JFrame Image.
        JLabel rePintText= new JLabel("Re-Enter PIN:");
        rePintText.setBounds(165, 400, 180, 25);
        rePintText.setFont(new Font("Noraml", Font.BOLD, 18));
        rePintText.setForeground(Color.WHITE);
        image.add(rePintText);
        
        //Here I am setting JTextField For get -Re-Password from User- on the JFrame Image.
        rePinPasswordField= new JPasswordField();
        rePinPasswordField.setBounds(300, 398, 200, 25);
        rePinPasswordField.setFont(new Font("Noraml", Font.BOLD, 22));
        rePinPasswordField.setForeground(Color.BLACK);
        image.add(rePinPasswordField);
        
        //Here I am setting JButton for -Chagne- on the JFrame Image.
        changeButton= new JButton("Change");
        changeButton.setBounds(360, 480, 150, 30);
        changeButton.setFont(new Font("Noraml", Font.BOLD, 18));
        changeButton.setForeground(Color.BLACK);
        image.add(changeButton);
        
        //Here I am setting JButton for -Back- on the JFrame Image.
        backButton= new JButton("Back");
        backButton.setBounds(160, 480, 150, 30);
        backButton.setFont(new Font("Noraml", Font.BOLD, 18));
        backButton.setForeground(Color.BLACK);
        image.add(backButton);
        
        //Here I am setting addActionListener on the -buttons- of JButton.
        changeButton.addActionListener(this);
        backButton.addActionListener(this);
        
        //Here I am setting Properties of JFrame.
        setTitle("Pin Change");
        setBounds(300, 10, 900, 830);
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
        }else if(e.getSource()== changeButton){
                if(pinPasswordField.getText().trim().isEmpty() && rePinPasswordField.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN and Re-Enter PIN");
                    pinPasswordField.setText("");
                    rePinPasswordField.setText("");
                    return;
                }else if(pinPasswordField.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Plese Enter New PIN");
                    pinPasswordField.setText("");
                    return;
                }else if(rePinPasswordField.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter PIN");
                    rePinPasswordField.setText("");
                    return;
                }else{
                    try {
                    String newPin= pinPasswordField.getText();
                    String rePin= rePinPasswordField.getText();
                    if(!newPin.equals(rePin)){
                        JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                        return;
                    }else{
                        
                        //Here I am Hitting MySQL database Connection.
                        MySqlConnection msc= new MySqlConnection();
                        String query1= "Update transactions set Pin_No= '"+rePin+"' where Pin_No= '"+pinNumber+"'";
                        String query2= "Update login set PIN_No= '"+rePin+"' where Pin_No= '"+pinNumber+"'";
                        String query3= "Update signup3 set PIN_No= '"+rePin+"' where Pin_No= '"+pinNumber+"'";
                        msc.statement.executeUpdate(query1);
                        msc.statement.executeUpdate(query2);
                        msc.statement.executeUpdate(query3);
                        JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                        setVisible(false);
                        new Transactions(rePin).setVisible(true);
                    }
                
            } catch (Exception e6) {
                System.out.println(e6);
            }
        }
    }
    }
    
    //Here It is My public main method of PinChange Class.
    public static void main(String[] args) {
        System.out.println("This is my Pin Change Window");
        new PinChange("").setVisible(true);
        
    }
}
