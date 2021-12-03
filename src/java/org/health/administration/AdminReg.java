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
import static jdk.internal.vm.vector.VectorSupport.insert;


/**
 *
 * @author ogrey
 */
public class AdminReg extends SimpleTagSupport {
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
   private String email;
   public void setEmail(String email){
       this.email = email;
   }
   private String username;
   public void setUsername(String username){
       this.username = username;
   }
   private String password;
   public void setPassword(String password){
       this.password = password;
   }
   
   
    /**
     * Called by the container to invoke this tag.The implementation of this
 method is provided by the tag library developer, and handles all tag
 processing, body iteration, etc.
     * @throws jakarta.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        Statement stmt = null;
        try{ 
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccinationtracker","root","");
           stmt = conn.createStatement();
           
           String sql = "INSERT INTO "+ table +"(email,username,password) VALUES('"+email+"','"+username+"','"+password+"')";
           stmt.executeUpdate(sql);
           
           System.out.print("Inserted records");
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       
   }
   }}