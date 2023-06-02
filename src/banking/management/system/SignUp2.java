//Here it is a package of My SignUp2 Class of ATM Project.
package banking.management.system;

//Here it is my Importing statements.
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//Here it is my Public main class.
public class SignUp2 extends JFrame implements ActionListener {
    
    //Here it is my Global regerence variables.
    long random;
    JTextField panTextField, aaddhaarTextField;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, qualificationComboBox,OccupationComboBox;
    JRadioButton sYes, sNo, eYes, eNo;
    JButton nextButton;
    String formNo;

    //Here it is my Constructor of this Class.
    public SignUp2(String formNo) {
        
        //Here I am setting value into the Global variable.
        this.formNo= formNo;
        
        //Here I am Setting Layout of the JFrame.         
        setLayout(null);
        
        //Here I am setting JLabel for print -Page 2: Additional Details- on the JFrame.
        JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Normal", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        //Here I am setting JLabel for print -Religion- on the JFrame.
        JLabel religion= new JLabel("Religion:");
        religion.setFont(new Font("Normal", Font.BOLD, 22));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        //Here I am setting JComboBox for getSelected -Select Item- on the JFrame.
        String valReligion[]= {"--- Select Religion ---", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox= new JComboBox(valReligion);
        religionComboBox.setFont(new Font("Normal", Font.BOLD, 20));
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);
        
        //Here I am setting JLabel for print -Category- on the JFrame.
        JLabel category= new JLabel("Category:");
        category.setFont(new Font("Normal", Font.BOLD, 22));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        //Here I am setting JComboBox for getSelected -Select Item- on the JFrame.
        String valCategory[]= {"--- Select Category ---", "General", "OBC", "SC", "ST", "Other"};
        categoryComboBox= new JComboBox(valCategory);
        categoryComboBox.setFont(new Font("Normal", Font.BOLD, 20));
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);
        
        //Here I am setting JLabel for print -Income- on the JFrame.
        JLabel income= new JLabel("Income:");
        income.setFont(new Font("Normal", Font.BOLD, 22));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        //Here I am setting JComboBox for getSelected -Select Item- on the JFrame.
        String valIncome[]= {"--- Select Income ---", "150000", "250000", "500000", "Upto 1000000"};
        incomeComboBox= new JComboBox(valIncome);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setFont(new Font("Normal", Font.BOLD, 20));
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);
        
        //Here I am setting JLabel for print -Educational- on the JFrame.
        JLabel educationl= new JLabel("Educationl:");
        educationl.setFont(new Font("Normal", Font.BOLD, 22));
        educationl.setBounds(100, 290, 200, 30);
        add(educationl);

        //Here I am setting JLabel for print -Qualification- on the JFrame.
        JLabel qualification= new JLabel("Qualification:");
        qualification.setFont(new Font("Normal", Font.BOLD, 22));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);
        
        //Here I am setting JComboBox for getSelected -Select Item- on the JFrame.
        String valQualification[]= {"--- Select Qualification ---", "Non-Graduation", "Graduate", "Post-Graduation", "Other"};
        qualificationComboBox= new JComboBox(valQualification);
        qualificationComboBox.setFont(new Font("Normal", Font.BOLD, 20));
        qualificationComboBox.setBounds(300, 315, 400, 30);
        qualificationComboBox.setBackground(Color.WHITE);
        add(qualificationComboBox);
        
        //Here I am setting JLabel for print -Occupation- on the JFrame.
        JLabel occupation= new JLabel("Occupation:");
        occupation.setFont(new Font("Normal", Font.BOLD, 22));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        //Here I am setting JComboBox for getSelected -Select Item- on the JFrame.
        String valOccupation[]= {"--- Select Occupation ---", "Salaried", "Self-Employed", "Business-Man", "Student", "Retired"};
        OccupationComboBox= new JComboBox(valOccupation);
        OccupationComboBox.setFont(new Font("Normal", Font.BOLD, 20));
        OccupationComboBox.setBounds(300, 390, 400, 30);
        OccupationComboBox.setBackground(Color.WHITE);
        add(OccupationComboBox);
        
        //Here I am setting JLabel for print -PAN Number- on the JFrame.
        JLabel panNumber= new JLabel("PAN Number:");
        panNumber.setFont(new Font("Normal", Font.BOLD, 22));
        panNumber.setBounds(100, 440, 200, 30);
        add(panNumber);
        
        //Here I am setting JTextField For get -PAN Number from User- on the JFrame.
        panTextField= new JTextField();
        panTextField.setFont(new Font("Normal", Font.BOLD, 20));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        //Here I am setting JLabel for print -Addhar Number- on the JFrame.
        JLabel aaddhaarNumber= new JLabel("Addhar Number:");
        aaddhaarNumber.setFont(new Font("Normal", Font.BOLD, 22));
        aaddhaarNumber.setBounds(100, 490, 200, 30);
        add(aaddhaarNumber);
        
        //Here I am setting JTextField For get -Aaddhaar Number from User- on the JFrame.
        aaddhaarTextField= new JTextField();
        aaddhaarTextField.setFont(new Font("Normal", Font.BOLD, 20));
        aaddhaarTextField.setBounds(300, 490, 400, 30);
        add(aaddhaarTextField);
        
        //Here I am setting JLabel for print -Senior Citizen- on the JFrame.
        JLabel seniorCitizen= new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Normal", Font.BOLD, 22));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);
        
        //Here I am setting JRadioButton for getSelected -yes- on the JFrame.
        sYes= new JRadioButton("Yes");
        sYes.setBounds(300, 540, 100, 30);
        sYes.setFont(new Font("Normal", Font.BOLD, 16));
        sYes.setBackground(Color.WHITE);
        add(sYes);
        
        //Here I am setting JRadioButton for getSelected -No- on the JFrame.
        sNo= new JRadioButton("No");
        sNo.setBounds(450, 540, 100, 30);
        sNo.setFont(new Font("Normal", Font.BOLD, 16));
        sNo.setBackground(Color.WHITE);
        add(sNo);
        
        //Here I am setting JRadioButton into the ButtonGroup Class to getSelected only one at a time.
        ButtonGroup seniorCitizenGroup= new ButtonGroup();
        seniorCitizenGroup.add(sYes);
        seniorCitizenGroup.add(sNo);
        
        //Here I am setting JLabel for print -Existing Account- on the JFrame.
        JLabel exisitingAccount= new JLabel("Exisiting Account:");
        exisitingAccount.setFont(new Font("Normal", Font.BOLD, 22));
        exisitingAccount.setBounds(100, 590, 200, 30);
        add(exisitingAccount);
        
        //Here I am setting JRadioButton for getSelected -Yes- on the JFrame.
        eYes= new JRadioButton("Yes");
        eYes.setBounds(300, 590, 100, 30);
        eYes.setFont(new Font("Normal", Font.BOLD, 16));
        eYes.setBackground(Color.WHITE);
        add(eYes);
        
        //Here I am setting JRadioButton for getSelected -No- on the JFrame.
        eNo= new JRadioButton("No");
        eNo.setBounds(450, 590, 100, 30);
        eNo.setFont(new Font("Normal", Font.BOLD, 16));
        eNo.setBackground(Color.WHITE);
        add(eNo);
        
        //Here I am setting JRadioButton into the ButtonGroup Class to getSelected only one at a time.
        ButtonGroup exisitingAccountGroup= new ButtonGroup();
        exisitingAccountGroup.add(eYes);
        exisitingAccountGroup.add(eNo);
        
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
        setTitle("Sing Up 2");
        setBounds(350, 10, 850, 800);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Here I am Implementing @Overriden method of ActionListener interface.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== nextButton){
            String religion= (String) religionComboBox.getSelectedItem();
            String category= (String) categoryComboBox.getSelectedItem();
            String income= (String) incomeComboBox.getSelectedItem();
            String qualification= (String) qualificationComboBox.getSelectedItem();
            String occupation= (String) OccupationComboBox.getSelectedItem();
            String panNumber= panTextField.getText();
            String aaddhaarNumber= aaddhaarTextField.getText();
            String seniorCitizen= null;
            if(sYes.isSelected()){
                seniorCitizen= "Yes";
            }else if(sNo.isSelected()){
                seniorCitizen= "No";
            }
            String exisitingAccount= null;
            if(eYes.isSelected()){
                exisitingAccount= "yes";
            }else if(eNo.isSelected()){
                exisitingAccount= "No";
            }
            
            try {
                if(religion.equals("")){
                    JOptionPane.showMessageDialog(null, "Religion is Required");
                }else{
                    
                    //Here I am Hitting MySQL database Connection.
                    MySqlConnection msc= new MySqlConnection();
                    String query= "insert into signup2 values('"+formNo+"', '"+religion+"','"+category+"', '"+income+"', "
                            + "'"+qualification+"', '"+occupation+"', '"+panNumber+"', '"+aaddhaarNumber+"', "
                            + "'"+seniorCitizen+"', '"+exisitingAccount+"')";
                    msc.statement.executeUpdate(query);
                    setVisible(false);
                    new SignUp3(formNo).setVisible(true);
                }
            } catch (HeadlessException | SQLException e1) {
                System.out.println(e1);
            } 
        }
    }
    
    //Here It is My public main method of SignUp2 Class.
    public static void main(String[] args) {
        System.out.println("This is my SignUP 2 Window");
        new SignUp2("");
        
    }
}
