import java.sql.*;

public class preparedStatement {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabases";
        String username = "root";
        String password = "Gaurav@8127";

        String query = "Select * from employees where name = ? ";



        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con  = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish successfully! ");
           // Statement stmt = con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "Gaurav");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                String job_title = resultSet.getString("job_title");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: "+id );
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
            }

            resultSet.close();
            preparedStatement.close();
            con.close();

            System.out.println("Connection closed successfully");


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}










