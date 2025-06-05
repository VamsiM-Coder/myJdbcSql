package ReadOrSelect;
// STEP - 1
import java.sql.*;
public class ReadingSingleData {
    public static void main(String[] args){
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
            Connection con = DriverManager.getConnection(url,user,password);
            //STEP - 4
            PreparedStatement ps = con.prepareStatement("select * from Employee where E_ID = ?");
            ps.setInt(1,7);

            //STEP - 5
            ResultSet rs = ps.executeQuery();


            if(rs.next()) {
                System.out.println(rs.getString("E_ID"));
                System.out.println(rs.getString("E_NAME"));
                System.out.println(rs.getString("DEPARTMENT"));
            }
            else{
                System.out.println("No Record Found");
            }

            //STEP - 6
            ps.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
