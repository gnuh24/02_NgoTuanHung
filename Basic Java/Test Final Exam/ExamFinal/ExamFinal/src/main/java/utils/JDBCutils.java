package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {

    static Connection connection = null;

    public static void main(String[] args) {
        JDBCutils.getConnection();
    }

    public static Connection getConnection() {
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\DELL-5580\\eclipse-workspace\\ExamFinal\\src\\main\\resources\\DB.properties"));
            String username= properties.getProperty("user");
            String password= properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            if (connection != null){
                System.out.println("Kết nối Database  Thành Công !!!");
            }
            else {
                System.out.println("Kết nối Database Không Thành Công !! Mời Kiểm Tra Lại");
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                System.err.println(e.getMessage());
            }

        }
    }

}
