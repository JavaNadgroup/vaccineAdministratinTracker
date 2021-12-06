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
public class PatientAuth extends SimpleTagSupport {
    
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

    private String name;
    private String nin;
    public void setName(String name) {
        this.name = name;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }
    

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        if(name != "" && nin !=""){
        try{ 
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationtracker","root","");
           
           String sql = "SELECT * FROM patients WHERE name = ? and nin = ?";
           PreparedStatement prps = conn.prepareStatement(sql);
           
           prps.setString(1, name);
           prps.setString(2, nin);
           
           ResultSet rslt = prps.executeQuery();
           
           if(rslt.next()){
                out.println("<h1>Logged in successfully</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/PatientDashboard.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go to Dashboard");
                out.println("</button>");
//            out.println("<button type='submit'>");
//            out.println("Dashboard<br><br>");
//            out.println("</button>");
            }else{
                out.println("<h1>Failed to login. Please check your details</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/patientLogin.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back to login page");
                out.println("</button>");
            }
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
        }
    }
    }
}