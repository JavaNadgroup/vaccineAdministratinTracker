/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.health;

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
public class HealthCenterToDb extends SimpleTagSupport {
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

    public String hospital_name;
    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
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
           
           String sql = "SELECT * FROM hospitals WHERE name = ?";
           PreparedStatement prps = conn.prepareStatement(sql);
           
           prps.setString(1, hospital_name);
           
           ResultSet rslt = prps.executeQuery();
           
           if(rslt.next()){
                out.println("<h1>The Health Center you tried to register already exists...Register another hospital.</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/AddHealthCenter.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back");
                out.println("</button>");
            }else{
                stmt = conn.createStatement();
                sql = "INSERT INTO "+ table +"(name) VALUES('"+hospital_name+"')";
                stmt.executeUpdate(sql);
                out.print("<h1>The Hospital has been added successfully......</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/HealthCenterReg.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back");
                out.println("</button>");
            }
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
   }
   }}

