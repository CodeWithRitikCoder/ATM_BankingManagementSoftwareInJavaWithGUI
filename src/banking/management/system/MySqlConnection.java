//Here it is a package of My MySqlConnection Class of ATM Project which is used to Create connection with the MySQL
//Database.
package banking.management.system;

//Here it is my Importing statements.
import java.sql.*;

//Here it is my Public main class.
public class MySqlConnection {

    //Here it is my Global regerence variables.
    Connection connection;
    Statement statement;
    
    //Here it is my Constructor of this Class.
    public MySqlConnection() {
        
        //Here I am Hitting MySQL database Connection.
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String stringForURL= "jdbc:mysql:///bankmanagementsystem";
            String stringForUser= "root";
            String stringForPassword= "RitikCoder@mysql";
            connection= DriverManager.getConnection(stringForURL, stringForUser, stringForPassword);
            statement= connection.createStatement();
            
        } catch (SQLException e) {
            System.out.println("Exception is occurred here.");
        }
    }
    
}
