
package university.management.system;
import java.sql.*;

public class Cons {
    
    Connection c;
    Statement s;
    
    Cons () {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "@Yash9897");
            s = c.createStatement(); 
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 