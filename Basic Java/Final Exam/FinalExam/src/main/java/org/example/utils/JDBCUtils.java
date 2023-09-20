package org.example.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtils {
    private Connection mySQLConnection = null;

    public Connection getMySQLConnection() {
        return mySQLConnection;
    }

    public void setMySQLConnection(Connection connection) {
        this.mySQLConnection = connection;
    }

    //Test connection
    public void isConnectedForTesting(){
        Connection connection = null;
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/java/org/example/utils/mysql.properties"));
            connection = DriverManager.getConnection( properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pass") );
            if (connection != null){

                System.out.println("Connect success! (Testing)");
            }
            else {
                throw new Exception("Kết nối thất bại !!");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                assert connection != null;
                connection.close();

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public boolean isConnected() {
        try {
            if (mySQLConnection != null && !mySQLConnection.isClosed()) {
                return true; // Đã kết nối và kết nối đang mở.
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }



    //Disconnect
    public void connect(){
        try{
            if (mySQLConnection == null || mySQLConnection.isClosed()){
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/main/java/org/example/utils/mysql.properties"));
                mySQLConnection = DriverManager.getConnection( properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pass") );
                if ( mySQLConnection != null  || mySQLConnection.isClosed() ){
                    System.out.println("Connect success!");
                }
                else {
                    throw new Exception("Kết nối thất bại !!");
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void disconnect(){
        try{
            if (!mySQLConnection.isClosed()){
                mySQLConnection.close();
                System.out.println("Disconnected!!");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
