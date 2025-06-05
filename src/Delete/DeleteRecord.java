package Delete;
//STEP - 1
import java.sql.*;
public class DeleteRecord {
    public static void main(String[] args) {
        try {
            //STEP - 2
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/myjdbcsql";
        String username = "root";
        String pass = "root";

        try {
            // STEP - 3
            Connection conn = DriverManager.getConnection(url, username, pass);

            //STEP - 4
            PreparedStatement ps = conn.prepareStatement("delete FROM EMPLOYEE where E_ID = ?");
            ps.setInt(1,6);
            ps.addBatch();
            ps.setInt(1,8);
            ps.addBatch();

            //STEP - 5
            //For single row deletion
            //int rows = ps.executeUpdate();

            //For Multi Row deletion
            int rows[] = ps.executeBatch();
            if(rows.length > 0) {
                System.out.println("Records deleted");
            }
            else{
                System.out.println("Record not deleted");
            }

            //STEP -  6
            ps.close();
            conn.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
