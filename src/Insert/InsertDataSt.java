package Insert;
//STEP - 1
import java.sql.*;
public class InsertDataSt {
    public static void main(String[] args) {
        //STEP - 2 :
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/myjdbcsql";
        String username = "root";
        String password = "root";

        String Query = "INSERT INTO EMPLOYEE(E_NAME,DEPARTMENT) VALUES('HIMANTH','TESTER')," +
                "('JASHWANTH','MANAGER')";
        try {
            //STEP - 3
            Connection conn = DriverManager.getConnection(url,username,password);

            //STEP - 4 Using Statement
            Statement stmt = conn.createStatement();


            //STEP - 5
            int rows = stmt.executeUpdate(Query);
            System.out.println("Rows inserted: " + rows);

            //STEP - 6
            stmt.close();
            conn.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
