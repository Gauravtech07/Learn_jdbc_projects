import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class insert_image {



        public static void main(String[] args) throws ClassNotFoundException {

            String url = "jdbc:mysql://localhost:3306/mydatabases";
            String username = "root";
            String password = "Gaurav@8127";

            String image_path = "C:\\Users\\Gaura\\OneDrive\\Desktop\\GJ.jpg";
            String query = "INSERT INTO image_table(image_data) VALUES(?)";


            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver Loaded successfully!!!");
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }

            try{
                Connection con  = DriverManager.getConnection(url,username,password);
                System.out.println("Connection Establish successfully! ");
                FileInputStream fileInputStream = new FileInputStream(image_path);
                byte[] imageData = new byte[fileInputStream.available()];
                fileInputStream.read(imageData);
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setBytes(1,imageData);

                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows>0){
                    System.out.println("Image inserted successfully!!");
                }
                else{
                    System.out.println("Image not inserted!!");
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
