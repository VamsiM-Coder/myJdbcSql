package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        //STEP - 2
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }

        String url = "jdbc:mysql://localhost:3306/myjdbcsql";
        String user = "root";
        String password = "root";

        String query = "UPDATE EMPLOYEE SET DEPARTMENT = ? WHERE E_ID = ?";
        try{
            //STEP - 3
            Connection con = DriverManager.getConnection(url,user,password);

            //STEP - 4
            PreparedStatement st= con.prepareStatement(query);
            //Setting the Values
            st.setString(1,"Development");
            st.setInt(2,1);
            st.addBatch();

            st.setString(1,".NET DEV");
            st.setInt(2,8);
            st.addBatch();

            //STEP - 5

            //Single Valued insert
            int rows = st.executeUpdate();
            System.out.println("Rows Updated: " + rows);

            //MultiValued insert
            int [] rows = st.executeBatch();
            System.out.println("Rows Inserted: " + rows.length);

            //STEP - 6
            st.close();
            con.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
}
