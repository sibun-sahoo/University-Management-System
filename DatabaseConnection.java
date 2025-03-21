
package university.management.system;

import java.sql.*;

public class DatabaseConnection {

    Connection conn;
    Statement st;

    public DatabaseConnection()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UNIVERSITY_MANAGEMENT" ,"root","Litindia@123");
            st = conn.createStatement();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
