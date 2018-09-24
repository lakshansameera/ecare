package com.example.shanindu.hearts.support;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dBConnection;
    private Connection conn;
    public DBConnection()throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://192.168.1.101:8080/ecare";
        String username = "root";
        String password = "";
        conn = DriverManager.getConnection(url, username, password);
    }
    public static synchronized DBConnection getInstance() throws SQLException, ClassNotFoundException{
        if(dBConnection==null){
            dBConnection=new DBConnection();
        }
        return dBConnection;
    }
    public Connection getConnection(){

        return conn;
    }

}
