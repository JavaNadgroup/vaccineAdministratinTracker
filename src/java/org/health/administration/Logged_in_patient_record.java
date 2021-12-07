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
public class Logged_in_patient_record extends SimpleTagSupport {
    
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
        
        try{ 
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationtracker","root","");
           
           String sql = "SELECT * FROM patients WHERE nin = ? and name = ?";
           PreparedStatement prps = conn.prepareStatement(sql);
          
           prps.setString(1, nin);
           prps.setString(2, name);
           
           ResultSet rslt = prps.executeQuery();
           
           if(rslt.next()){
                out.println("<table class=\"table-auto\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>NIN</th>");
                out.println("<th>NAME</th>");
                out.println("<th>HOSPTIAL</th>");
                out.println("<th>DATE</th>");
                out.println("<th>BATCH_NUMBER</th>");
                out.println("<th>VACCINE_ADMINISTERED</th>");
                out.println("<tr>");
                out.println("</thead>");
                out.println("<tbody>");
                out.println("<tr>");
                out.println(rslt.getString("nin"));
                out.println("<th>");
                out.println("</th>");
                out.println("<th>"+name+"</th>");
                out.println("<th>"+hospital+"</th>");
                out.println("<th>"+date+"</th>");
                out.println("<th>"+batch_number+"</th");
                out.println("<th>"+vaccine+"</th>");
                out.println("<tr>");
                out.println("</tbody>");
                out.println("</table>");
            }
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
        }
    }
}