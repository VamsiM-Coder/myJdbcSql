package ReadOrSelect;
//STEP - 1
import java.sql.*;
public class ReadingMultipleData {
    public static void main(String[] args) {
        try {
            //STEP - 2
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/myjdbcsql";
        String user = "root";
        String password = "root";

        try{
            //STEP - 3
            Connection conn = DriverManager.getConnection(url,user,password);
            //STEP - 4
            PreparedStatement ps = conn.prepareStatement("select * from Employee");

            //STEP - 5
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("E_ID"));
                System.out.println(rs.getString("E_NAME"));
                System.out.println(rs.getString("DEPARTMENT"));
                System.out.println("-----------");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
