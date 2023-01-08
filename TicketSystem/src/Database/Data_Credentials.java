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
public class Data_Credentials implements Data<Credentials>{
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRes = null;
    MySQLConnector cont = MySQLConnector.getInstance();
    
    public ArrayList<Credentials> ShowRec(String table)
    {
        ArrayList<Credentials> user=new ArrayList<Credentials>();
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();	
            String qry = "SELECT * FROM " + table;
	    ResultSet rs = myStmt.executeQuery(qry);

	    while(rs.next())
            {
                user.add(new Credentials(rs.getInt("num"), rs.getString("empnum"), rs.getString("username"), rs.getString("password"), rs.getString("email_add"), rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"), rs.getInt("age"), rs.getString("birthday"), rs.getString("phonenum"), rs.getString("gender"), rs.getString("residence"), rs.getString("acctype"), rs.getString("startdate"), rs.getString("department"), rs.getString("position")));
            }
            rs.close();
	    myStmt.close();				
        }
	catch(SQLException ex)
	{
            JOptionPane.showMessageDialog(null, ex.getMessage());
	}
        return user;
    }    
    
    public void createTable(String table)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            //String qry = "CREATE TABLE " + table + "(ROOM_NUM INT NOT NULL, TYPE VARCHAR(45), LAND_AREA INT, STATUS VARCHAR(45), TENANT_NAME VARCHAR(50), AGENT_NAME VARCHAR(50), PRICE DOUBLE, PAY_METHOD VARCHAR(45), PAY_SCHEME VARCHAR(45), PRIMARY KEY(ROOM_NUM))";
            //myStmt.executeUpdate(qry);
	    //myStmt.close();
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
    
    public void addRow(String table, Credentials user)
    {
        try{
            cont.getConnection();            
            myStmt=cont.getConnection().createStatement();
            String qry = "INSERT INTO credentials VALUES (" + user.getNum() + ", '" + user.getEmpnum() + "', '" + user.getU_name() + "', '" + user.getPass() + "', '" + user.getEmail() + "', '" + user.getF_name() + "', '" + user.getM_name() + "', " + user.getL_name() + ", '" + user.getAge() + "', " + user.getBday() + ", '" + user.getPhonenum() + "', '" + user.getGender() +"', '" + user.getResidence() + "', '" + user.getActType() + "', '" + user.getStartdate() + "', '" + user.getDepartment() + "', '" + user.getPosition() + "')" ;
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
    public void editRow(String table, Credentials user)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            //String qry = "UPDATE credentials SET USERNAME = '" + user.getU_name() + "', PASSWORD = '" + user.getPass() + "', EMAIL_ADD = '" + user.getEmail() + "', FIRSTNAME = '" + user.getF_name() + "', MIDDLENAME = '" + user.getM_name() + "', LASTNAME = '" + user.getL_name() + "', AGE = '" + user.getAge() + "', PHONENUM = '" + user.getPnum() + "', GENDER = '" + user.getGender() + "', RESIDENCE = '" + user.getResidence() + "', ACCTYPE = '" + user.getActType() + "', EMPNUM = '" + user.getEmpnum() + "', TINNUM = '" + user.getTinnum() + "', STARTDATE = '" + user.getStartdate() + "', FLOOR = '" + user.getFloorass() + "' WHERE NUMBER = " + "'" + user.getAgent_num() + "'";
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
    public void deleteRow(String table, Credentials user)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            String qry = "DELETE FROM" + table + " WHERE NUMBER = '" + user.getNum() + "'";
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
    public void deleteRowSpec(String num)
    {
        try{
            cont.getConnection();
            myStmt=cont.getConnection().createStatement();
            String qry = "DELETE FROM credentials WHERE num = " + num + "";
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
