/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            String qry = "CREATE TABLE `ticketsys`.`alltickets` (`Number` INT NOT NULL AUTO_INCREMENT,`TicketID` VARCHAR(12) NOT NULL,`RevisionCount` VARCHAR(5) NOT NULL,`SubjectTitle` VARCHAR(45) NULL,`SubjectDesc` VARCHAR(45) NULL,`TicketType` VARCHAR(45) NULL,`PriorityLevel` VARCHAR(45) NULL,`AssignedDepartment` VARCHAR(45) NULL,`AssignedPersonnel` VARCHAR(45) NULL,`DateCreated` VARCHAR(45) NULL,`DateUpdated` VARCHAR(45) NULL,`Status` VARCHAR(45) NULL,`Creator` VARCHAR(45) NULL,PRIMARY KEY (`Number`),UNIQUE INDEX `new_tablecol_UNIQUE` (`TicketID` ASC) VISIBLE);";
            System.out.println(qry);
            myStmt.executeUpdate(qry);
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
                ticket.add(new Tickets(rs.getString("TicketID"),rs.getString("RevisionCount"), rs.getString("SubjectTitle"), rs.getString("SubjectDesc"), rs.getString("TicketType"), rs.getString("PriorityLevel"), rs.getString("AssignedDepartment"), rs.getString("AssignedPersonnel"), rs.getString("DateCreated"), rs.getString("DateUpdated"), rs.getString("Status"), rs.getString("Creator")));
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

    public ArrayList<Tickets> ShowRecSpec(String parameters)
    {
        ArrayList<Tickets> ticket=new ArrayList<Tickets>();
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();	
            String qry = parameters;
            System.out.println(qry);
	    ResultSet rs = myStmt.executeQuery(qry);
	    while(rs.next())
            {
                ticket.add(new Tickets(rs.getString("TicketID"),rs.getString("RevisionCount"), rs.getString("SubjectTitle"), rs.getString("SubjectDesc"), rs.getString("TicketType"), rs.getString("PriorityLevel"), rs.getString("AssignedDepartment"), rs.getString("AssignedPersonnel"), rs.getString("DateCreated"), rs.getString("DateUpdated"), rs.getString("Status"), rs.getString("Creator")));
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
            String qry = "INSERT INTO " + table + "(TicketID, RevisionCount, SubjectTitle, SubjectDesc, TicketType, PriorityLevel, AssignedDepartment, AssignedPersonnel, DateCreated, DateUpdated, Status, Creator)" +  " VALUES ('" + ticket.getId() + "', '" + ticket.getRevcount() +"', '" + ticket.getTitle() + "', '" + ticket.getDesc() + "', '" + ticket.getType() + "', '" + ticket.getPriority() + "', '" + ticket.getDepartment() + "', '" + ticket.getPersonnel() + "' ,'" + ticket.getDateCreated() + "', '" + ticket.getDateUpdated() + "', '"+ ticket.getStatus() + "', '" + ticket.getCreator()+ "')";
            System.out.println(qry);
            myStmt.executeUpdate(qry);
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
            String qry = "UPDATE " + table + " SET SubjectTitle = " + ticket.getTitle() + ", SubjectDesc = '" + ticket.getDesc() + "', TicketType = '" + ticket.getType() + "', PriorityLevel = '" + ticket.getPriority() + "', AssignedDepartment = '" + ticket.getDepartment() + "', AssignedPersonnel = '" + ticket.getPersonnel() + "', DateCreated = '" + ticket.getDateCreated() + "', DateUpdated = '" + ticket.getDateUpdated() + "', Status = '" + ticket.getStatus() + "', Creator = '" + ticket.getCreator() +"' WHERE TicketID = " + "'" + ticket.getId() + "'";
            System.out.println(qry);
            myStmt.executeUpdate(qry);
            myStmt.close();
            JOptionPane.showMessageDialog(null, "Entry updated");            
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    } 
        public void deleteRowParam(String table, Tickets ticket, String param)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            String qry = "DELETE FROM " + table + " WHERE TicketID = " + ticket.getId() + param;
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
        public int tallyCount(String parameters)
        {
            int tally = 0;
            try{
                cont.getConnection();
                myStmt=cont.getConnection().createStatement();	
                String qry = "SELECT COUNT(*) from " + parameters;
                System.out.println(qry);
                ResultSet rs = myStmt.executeQuery(qry);
                while(rs.next())
                {
                    tally = rs.getInt(1);
                }
                rs.close();
                myStmt.close();				
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return tally;
        }
        public ArrayList<String> employeeList (String parameters){

            ArrayList<String> employees = new ArrayList<String>();
            try{
                cont.getConnection();
                myStmt=cont.getConnection().createStatement();	
                String qry = parameters;
                ResultSet rs = myStmt.executeQuery(qry);
            while (rs.next()){
            String x = rs.getString("combined");
                employees.add(x);
            }
                myStmt.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            
            return employees;

        }
}

 