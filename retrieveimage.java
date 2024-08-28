import java.io.*;
import java.sql.*;

public class retrieveimage {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/mydatabases";
        String username = "root";
        String password = "Gaurav@8127";

        String folder_path = "C:\\Users\\Gaura\\OneDrive\\Desktop\\";
        String query = " SELECT image_data FROM image_table where image_id= (?)";


        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded successfully!!!");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con  = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Establish successfully! ");
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                byte[] image_data = resultSet.getBytes("image_data");
                String image_path = folder_path + "extractedImage.jpg";
                OutputStream outputStream =  new FileOutputStream(image_path);
                outputStream.write(image_data);
            }else{
                System.out.println("IMAGE NOT FOUND");
            }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
