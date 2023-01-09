/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author boxro
 */
public class Data_Tickets implements Data<Tickets> {
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRes = null;
    MySQLConnector cont = MySQLConnector.getInstance();
    
    public void createTable(String table)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
//            String qry = "CREATE TABLE " + table + " (NUM INT NOT NULL AUTO_INCREMENT, INQUIREDATE DATE NOT NULL, NAME VARCHAR(45) NOT NULL, EMAIL VARCHAR(45) NOT NULL, UNITTYPE VARCHAR(45) NOT NULL, ACQUIREMETHOD VARCHAR(10) NOT NULL, PRICERANGE VARCHAR(45) NOT NULL, PAYSCHEME VARCHAR(45) NOT NULL, PRIMARY KEY(NUM))";
//            System.out.println(qry);
//            myStmt.executeUpdate(qry);
	    myStmt.close();
            JOptionPane.showMessageDialog(null, "Table created");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }   
    
    public void deleteTable(String table)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            String qry = "DROP TABLE " + table;
            myStmt.executeUpdate(qry);
	    myStmt.close();
            JOptionPane.showMessageDialog(null, "Table deleted");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    } 
    
    public ArrayList<Tickets> ShowRec(String table)
    {
        ArrayList<Tickets> ticket=new ArrayList<Tickets>();
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();	
            String qry = "SELECT * FROM alltickets";
	    ResultSet rs = myStmt.executeQuery(qry);

	    while(rs.next())
            {
                ticket.add(new Tickets(rs.getInt("TicketID"), rs.getString("SubjectTitle"), rs.getString("SubjectDesc"), rs.getString("TicketType"), rs.getString("PriorityLevel"), rs.getString("AssignedDepartment"), rs.getString("AssignedPersonnel"), rs.getString("DateCreated"), rs.getString("DateUpdated"), rs.getString("Status")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException ex)
	{
            JOptionPane.showMessageDialog(null, ex.getMessage());
	}
        return ticket;
    }     

    public ArrayList<Tickets> ShowRecInquireSpec(String parameters)
    {
        ArrayList<Tickets> ticket=new ArrayList<Tickets>();
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();	
            String qry = "SELECT * FROM alltickets WHERE " + parameters;
	    ResultSet rs = myStmt.executeQuery(qry);

	    while(rs.next())
            {
                ticket.add(new Tickets(rs.getInt("TicketID"), rs.getString("SubjectTitle"), rs.getString("SubjectDesc"), rs.getString("TicketType"), rs.getString("PriorityLevel"), rs.getString("AssignedDepartment"), rs.getString("AssignedPersonnel"), rs.getString("DateCreated"), rs.getString("DateUpdated"), rs.getString("Status")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException ex)
	{
            JOptionPane.showMessageDialog(null, ex.getMessage());
	}
        return ticket;
    }
    
        public void addRow(String table, Tickets ticket)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            //String qry = "INSERT INTO " + table + "(INQUIREDATE, NAME, EMAIL, PHONENUM, AGE, UNITTYPE, ACQUIREMETHOD, PRICERANGE, PAYSCHEME)" +  " VALUES ('" + ticket.getDate()+ "', '" + ticket.getName() + "', '" + ticket.getEmail() + "', '" + ticket.getPhoneNum() + "', " + ticket.getAge() + ", '" + ticket.getUnitType() + "', '" + ticket.getAcqMethod() + "' ,'" + ticket.getPrice() + "', '" + ticket.getPayScheme() + "')";
            //System.out.println(qry);
            //myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null, "Entry added");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    } 
        public void editRow(String table, Tickets ticket)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            //String qry = "UPDATE " + table + " SET INQUIREDATE = " + ticket.getDate() + ", NAME = '" + ticket.getEmail() + "', EMAIL = '" + ticket.getEmail() + "', PHONENUM = '" + ticket.getPhoneNum() + "', AGE = '" + ticket.getAge() + "', UNITTYPE = '" + ticket.getUnitType() + "', ACQUIREMETHOD = '" + ticket.getAcqMethod() + "', PRICERANGE = '" + ticket.getPrice() + "', PAYSCHEME = '" + ticket.getPayScheme() + "' WHERE NUM = " + "'" + ticket.getNum() + "'";
            //System.out.println(qry);
            //myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null, "Entry updated");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    } 
        public void deleteRow(String table, Tickets ticket)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            String qry = "DELETE FROM " + table + " WHERE TicketID = " + ticket.getId();
            System.out.println(qry);
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null, "Entry deleted");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}

 