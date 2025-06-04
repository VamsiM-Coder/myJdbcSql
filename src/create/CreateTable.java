package create;
//STEP - 1
import java.sql.*;
public class CreateTable {
    public static void main(String[] args) {
        //STEP - 2
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            // If Jdbc jar not added to this project (or) typed class name wrongly (or) not added in project class path.
            System.out.println(e);
        }

        String url = "jdbc:mysql://localhost:3306/myjdbcsql";
        String username = "root";
        String password = "root";

        String query = "CREATE TABLE EMPLOYEE("
                + "E_ID INT NOT NULL AUTO_INCREMENT,"
                + "E_NAME VARCHAR(25) NOT NULL,"
                + "DEPARTMENT VARCHAR(25) NOT NULL,"
                + "PRIMARY KEY (E_ID)"
                + ");";

        try {
            //STEP - 3
            // 1.If wrong - username or password - Access denied, 2.Wrong URL or syntax - No Suitable Driver, 3.Database doesn't exist - Unknown DB
            Connection con = DriverManager.getConnection(url, username, password);
            //STEP - 4
            Statement stmt = con.createStatement();

            //STEP - 5
            stmt.executeUpdate(query);
            System.out.println("Table created Successfully");

            //STEP - 6
            stmt.close();
            con.close();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }
}
