package com.example.shanindu.hearts.model;

import com.example.shanindu.hearts.support.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;


public class user {
    private String userName;
    private int userId;
    private String Password;
    private int userType;
    private String contact;
    private String gender;

    public boolean logIn()
    {
        boolean status =false;
        try {
            DBConnection con = new DBConnection();
            Connection conn= con.getConnection();
            if (conn!=null)
            {
                String query = "Select * from Where username = '"+userName+"' and password ='"+ Password+"'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if(rs.next())
                {
                  status =true;
                  getUserDetails();
                  updateLogin();

                  conn.close();
                }
                else {
                    status = false;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return status;
    }
    public void RegisterUser()
    {

        try {
            DBConnection con = new DBConnection();
            Connection conn= con.getConnection();
            if (conn!=null)
            {
               String query= "INSERT INTO `users`(`username`, `password`, `contact`, `gender`, `type`, `created_at`, `updated_at`) VALUES ('"+ getUserName()+"','"+ getPassword()+"','"+ getContact()+"','"+ getUserName()+"','"+ getGender()+"','"+ currentDateTime() +"','"+ currentDateTime() +"' )";
               PreparedStatement prest = conn.prepareStatement(query);
               prest.execute();
               conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String currentDateTime()
    {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        return year+" "+month+" "+ day +" " + hour + " " + min + " " + sec;
    }

    public void getUserDetails()
    {
        try {
            DBConnection con = new DBConnection();
            Connection conn= con.getConnection();
            if (conn!=null)
            {
                String query = "Select * from Where username = '"+userName+"' and password ='"+ Password+"'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                setUserId(rs.getInt("user_id"));
                setUserType(rs.getInt("type"));
                setContact(rs.getString("contact"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void updateLogin()
    {
        try {
            DBConnection con = new DBConnection();
            Connection conn= con.getConnection();
            if (conn!=null)
            {
                String query= "UPDATE `users`set `updated_at` ='"+ currentDateTime() +"' WHERE user_id = '"+ getUserId()+"'";
                PreparedStatement prest = conn.prepareStatement(query);
                prest.execute();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
