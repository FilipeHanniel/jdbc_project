package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.protocol.Resultset;

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University";
        String name  = "root";
        String password = "root";
        String query = "select * from EngineeringStudents";
              
         /* 
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        */
        try {
            Connection con = DriverManager.getConnection(url, name, password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String UniversityData = "";
                for (int i = 1; i < 6; i++) {
                    UniversityData += result.getString(i) + "|";
                }
                System.out.println(UniversityData);
            }
        } catch (SQLException e) {
            e.printStackTrace();            
        }
    }

}
