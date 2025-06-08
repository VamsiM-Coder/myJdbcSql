package Insert;
//STEP - 1
import java.sql.*;
public class InsertData_PSt {
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

        String query = "INSERT INTO EMPLOYEE(E_NAME,DEPARTMENT) VALUES(?,?)";
        try{
            //STEP - 3
            Connection con = DriverManager.getConnection(url,user,password);

            //STEP - 4
            PreparedStatement st= con.prepareStatement(query);
            //Setting the Values
            st.setString(1,"Arshad");
            st.setString(2,"Python Dev");
            st.addBatch();

            st.setString(1,"Durga");
            st.setString(2,"Testing");
            st.addBatch();

            //STEP - 5

            //Single Valued insert
            int rows = st.executeUpdate();
            System.out.println("Rows Inserted: " + rows);

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


// Dynamic input is possible using prepared statement not possible using statement.
// Statement - SQL Injection may occur : Prepared Statement - Safe and Secure
// Readability is adv of Prepared Statement.


// addBatch() - (Queuing the inputs) is used to add multiple records in PS.
// executeBatch() - sends them all at once