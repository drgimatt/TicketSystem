/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author boxro
 */
public class Tickets {
    private int id;
    private String title;
    private String desc;
    private String type;
    private String priority;
    private String department;
    private String personnel;
    private String dateCreated;
    private String dateUpdated;
    private String status;

    public Tickets(int id, String title, String desc, String type, String priority, String department, String personnel, String dateCreated, String dateUpdated, String status) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.type = type;
        this.priority = priority;
        this.department = department;
        this.personnel = personnel;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.status = status;
    }

    public Tickets(String title, String desc, String type, String priority, String department, String personnel, String dateCreated, String dateUpdated, String status) {
        this.title = title;
        this.desc = desc;
        this.type = type;
        this.priority = priority;
        this.department = department;
        this.personnel = personnel;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.status = status;
    }
    
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public String getPriority() {
        return priority;
    }

    public String getDepartment() {
        return department;
    }

    public String getPersonnel() {
        return personnel;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public String getStatus() {
        return status;
    }


    
}






