import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabases";
        String username = "root";
        String password = "Gaurav@8127";

        String query = "Select * from employees;";


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
             ResultSet rs= stmt.executeQuery(query);
             while(rs.next()){
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String job_title = rs.getString("job_title");
                 double salary = rs.getDouble("salary");
                 System.out.println("---------------------------");
                 System.out.println("ID: "+id);
                 System.out.println("Name: "+name);
                 System.out.println("Job Title: "+ job_title);
                 System.out.println("Salary: "+salary);
             }
             rs.close();
             stmt.close();
             con.close();

             System.out.println("Connection closed successfully");


         }catch(SQLException e){
             System.out.println(e.getMessage());
         }

    }
}







/*
   //database url
       String url = "jdbc:mysql://localhost:3306/students";

       //database credential

        String username = "root";
        String password = "Gaurav@8127";

        //Establish the credentials
        try(Connection con = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to database.");

        }catch (SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }
 */