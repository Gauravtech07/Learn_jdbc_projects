import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updation {

        public static void main(String[] args) throws ClassNotFoundException {

            String url = "jdbc:mysql://localhost:3306/mydatabases";
            String username = "root";
            String password = "Gaurav@8127";

            String query = "UPDATE employees\n" +
                    "SET job_title = 'Java backend developer', salary= 70000.0\n" +
                    "WHERE id = 1;";


            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loaded successfully!!!");
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }

            try{
                Connection con  = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Establish successfully! ");
                Statement stmt = con.createStatement();
                int rowsaffected = stmt.executeUpdate(query);

                if(rowsaffected>0){
                    System.out.println("Updation Successfully"+ rowsaffected + " row(s) affected.");
                }else{
                    System.out.println("Updation Failed!!");
                }

                stmt.close();
                con.close();
                System.out.println("Connection closed successfully");


            }catch(SQLException e){
                System.out.println(e.getMessage());
            }

        }
    }


