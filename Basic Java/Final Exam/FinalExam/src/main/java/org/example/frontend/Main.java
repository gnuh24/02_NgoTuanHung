package org.example.frontend;

import org.example.utils.JDBCUtils;
import org.example.utils.ScannerUtils;

import java.sql.Connection;
import java.sql.DriverManager;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception{
        JDBCUtils connection = new JDBCUtils();
        connection.connect();
        System.out.println(connection.getMySQLConnection());
        System.out.println(connection.getMySQLConnection().isClosed());
        System.out.println(connection.isConnected());
        System.out.println();

        connection.disconnect();
        System.out.println(connection.getMySQLConnection());
        System.out.println(connection.getMySQLConnection().isClosed());
        System.out.println(connection.isConnected());
        System.out.println();

        connection.connect();
        System.out.println(connection.getMySQLConnection());
        System.out.println(connection.getMySQLConnection().isClosed());
        System.out.println(connection.isConnected());
        System.out.println();


    }
}