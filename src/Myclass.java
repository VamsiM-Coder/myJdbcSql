
//JDBC Driver
//1. Import necessary packages
//2. Load and register the driver (.jar) file
//3. Create a Connection by using util class (DriverManager) url,uname,pass;
//4. Create a statement by using conn object : It is used to send a query from Java to MySQL
//5. Execute a statement
//6. Closing the CONNECTION
// we can use parent exception for all these child exception to handle all the cases by throws Exception
// try and catch or we can use throws ClassNotFound exception



import java.sql.*;
import java.time.LocalDate;

public class Myclass {
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");

       String url = "jdbc:mysql://localhost:3306/kodnest";
       String user = "root";
       String password = "root";
       //single row output
       //String query = "Select sname from student where id = 2";

        //mutli row output
       //String query = "select * from student";

        //insert query
        //String query = "insert into student values(3,'Jashwanth',23,'2004-03-16')";

        //update query
        //String query = "update student set s_name = 'Dedeepya' where s_id =1";

        //delete query
        //String query = "delete from student where s_id = 3";

        //Problem with statement when the user enters data manually
        //1. With Using double quotes like below it is confusing
        //2. It can lead to SQL Injection in future, leaking the data from database
        //3. To improve performance if we want to write it's not possible.

        int s_id = 4;
        String s_name = "Vamsi";
        int s_age = 21;
        LocalDate date1 = LocalDate.parse("2004-04-22");

//        String query = "INSERT INTO student VALUES (" +
//                s_id + ", '" +
//                s_name + "', '" +
//                s_age + "', '" +
//                date + "')";

        String query = "insert into student values (?,?,?,?)";


       Connection con = DriverManager.getConnection(url,user,password);
       System.out.println("Connection Established!");

       //Statement stmt = con.createStatement();
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, s_id);
        stmt.setString(2, s_name);
        stmt.setInt(3, s_age);
        stmt.setDate(4, Date.valueOf(date1));

       // For Reading table data (selecting)
       //ResultSet res = stmt.executeQuery(query);
       // To access Single Data
//       if(res.next()){
//           String name = res.getString("s_name");
//           System.out.println("Student Name is :" + name);
//       }
//       else {
//           System.out.println("Student Not Found");
//       }

//        // To access multiple data.
//        while(res.next()){
//            System.out.print(res.getInt(1) + " - ");
//            System.out.print(res.getString(2) + " - ");
//            System.out.print(res.getString(3) + " - ");
//            System.out.println(res.getDate(4));
//        }

        //Inserting data (CRUD operations) it is not used for prepared statement
//        boolean status = stmt.execute(query);
//        if(!status){
//            System.out.println("Data Inserted/Deleted Successfully!");
//        }
        // status returns true if we perform select query otherwise if we insert,update and delete it shows false


        // we have advanced version of statement is Prepared Statement

        //Problem with statement when the user enters data manually while solution is prepared statement.


       con.close();
       System.out.println("Connection Closed!");
    }
}

//
//For insert/update/delete ➔ use executeUpdate()
//
//For select ➔ use executeQuery()
//
//Avoid execute() unless you specifically need it.


//int rowsAffected = stmt.executeUpdate();
//            if (rowsAffected > 0) {
//        System.out.println("Data Inserted Successfully!");
//            } else {
//                    System.out.println("No rows affected.");
//            }