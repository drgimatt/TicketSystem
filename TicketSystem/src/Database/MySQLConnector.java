/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.*;

/**
 *
 * @author boxro
 */
public class MySQLConnector {
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRes = null;
    String addr = "112.205.150.129:3310/ticketsys";
    String address = "jdbc:mysql://" + addr + "?enabledTLSProtocols=TLSv1.2&autoReconnect=true&failOverReadOnly=false&maxReconnects=10";
    String user = "admin";
    String pass = "titingkayad";
    
    private static MySQLConnector dbObject;

    private MySQLConnector(){
    }

    public static MySQLConnector getInstance(){
        if (dbObject == null){
            dbObject = new MySQLConnector();
        }
        return dbObject;
    }

    public Connection getConnection()
    {
        try{
            myConn = DriverManager.getConnection(address, user, pass);
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
        return myConn;
    }
         
    public void interactData (String qry)
    {
        try{
            myStmt=getConnection().createStatement();
            myStmt.executeUpdate(qry);
        }
        catch (SQLException se)
        {
            System.out.println(se.getMessage());
        }
         finally {
            try { myConn.close(); } catch (Exception e) { /* Ignored */ }
            try { myStmt.close(); } catch (Exception e) { /* Ignored */ }
            try { myRes.close(); } catch (Exception e) { /* Ignored */ }
        }       
    }       

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddr() {
        return addr;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

   
}

