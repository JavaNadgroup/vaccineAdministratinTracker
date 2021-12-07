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
public class Message_to_db extends SimpleTagSupport {
    
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


    private String reciever;
    private String sender;
    private String message;
    
    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
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
           
           String sql = "SELECT * FROM messages WHERE reciever =?";
           PreparedStatement prps = conn.prepareStatement(sql);
           
           prps.setString(1, reciever);
           
           ResultSet rslt = prps.executeQuery();
           
           if(rslt.next()){
                stmt = conn.createStatement();
           
                sql = "UPDATE messages SET sender='"+sender+"', message='"+message+"' WHERE reciever='"+reciever+"'";
                
                stmt.executeUpdate(sql);
                
                out.println("<h1>Message has been sent successfully.</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/AdminDashboard.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back to Dashboard");
                out.println("</button>");
            }else{
                stmt = conn.createStatement();
           
                sql = "INSERT INTO "+ table +"(reciever,sender,message) VALUES('"+reciever+"','"+sender+"','"+message+"')";
                stmt.executeUpdate(sql);
                
                out.println("<h1>Message has been sent successfully. Advise them to login at any time</h1>");
                out.println("<form action='http://localhost:8080/vaccinationTracker/AdminDashboard.jsp' method='post'>");
                out.println("<button type='submit'>");
                out.println("Go back");
                out.println("</button>");
            }
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
   }
   }}