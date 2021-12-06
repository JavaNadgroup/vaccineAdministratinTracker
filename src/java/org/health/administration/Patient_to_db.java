/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import static jakarta.servlet.jsp.tagext.Tag.SKIP_BODY;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static jdk.internal.vm.vector.VectorSupport.insert;


/**
 *
 * @author ogrey
 */
public class Patient_to_db extends SimpleTagSupport {
    
    //JBDC driver name and database URL
    private final String driver = "com.mysql.jdbc.Driver";

    private final String database_type = "mysql";

    private final String database_url = "\"jdbc:mysql://localhost:3306/vaccinationtracker\"";

    private final String database_username = "root";

    private final String database_password = "";

    private String table;
    public void setTable(String table){
        this.table = table;
    }

    private String nin;
    private String name;
    private String hospital;
    private String date;
    private String batch_number;
    private String vaccine;
    public void setNin(String nin) {
        this.nin = nin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }
    

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        Statement stmt = null;
        try{ 
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationtracker","root","");
           
           String sql = "SELECT * FROM bookings WHERE name =? AND nin =?";
           PreparedStatement prps = conn.prepareStatement(sql);
           
           prps.setString(1, name);
           prps.setString(2, nin);
           
           ResultSet rslt = prps.executeQuery();
           
           if(rslt.next()){
                stmt = conn.createStatement();
           
                sql = "DELETE FROM bookings WHERE name='"+name+"' and nin='"+nin+"'";
                
                stmt.executeUpdate(sql);
                
                stmt = conn.createStatement();
           
                sql = "INSERT INTO "+ table +"(nin,name,health_center,date_of_administration,batch_number,vaccine_administered) VALUES('"+nin+"','"+name+"','"+hospital+"','"+date+"','"+batch_number+"','"+vaccine+"')";
                stmt.executeUpdate(sql);
                
                out.println("<h1>Patient has been added successfully. Advise them to login at any time</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/HealthCenterReg.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back to Health Center Page");
                out.println("</button>");
            }else{
                stmt = conn.createStatement();
           
                sql = "INSERT INTO "+ table +"(nin,name,health_center,date_of_administration,batch_number,vaccine_administered) VALUES('"+nin+"','"+name+"','"+hospital+"','"+date+"','"+batch_number+"','"+vaccine+"')";
                stmt.executeUpdate(sql);
                
                out.println("<h1>Patient has been added successfully. Advise them to login at any time</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/HealthCenterReg.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back");
                out.println("</button>");
            }
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
   }
   }}