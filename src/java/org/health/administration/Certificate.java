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
public class Certificate extends SimpleTagSupport {
    
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
     public void setNin(String nin) {
        this.nin = nin;
    }

    public void setName(String name) {
        this.name = name;
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
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            st = conn.createStatement();
            String sql = "SELECT * FROM patients WHERE nin = '"+nin+"' AND name = '"+name+"'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                out.print("<div class='max-w-md py-4 px-8 bg-white shadow-lg rounded-lg my-20'>");
                out.println("<div class='flex justify-center md:justify-end -mt-16'>");
                out.println("<img class='w-20 h-20 object-cover rounded-full border-2 border-indigo-500' src='avatar.png'></div>");
                out.println("<div>");
                out.println("<h2 class='text-gray-800 text-3xl font-semibold'>");
                out.println(rs.getString("health_center") +" Hospital");
                out.println("</h2>");
                out.println("<h4 class='text-1x2 '><span class='text-1xl font-bold text-blue-500'>Patient Name: ");
                out.println("</span>");
                out.println(rs.getString("name"));
                out.println("</h4>");
                out.println("<h4 class='text-1x2 '><span class='text-1xl font-bold text-blue-500'>NIN Number: ");
                out.println("</span>");
                out.println(rs.getString("nin"));
                out.println("</h4>");
                out.println("<h4 class='text-1x2 '><span class='text-1xl font-bold text-blue-500'>Date of Vaccination: ");
                out.println("</span>");
                out.println(rs.getString("date_of_administration"));
                out.println("</h4>");
                out.println("<h4 class='text-1x2 '><span class='text-1xl font-bold text-blue-500'>Vaccine Type: ");
                out.println("</span>");
                out.println(rs.getString("vaccine_administered"));
                out.println("</h4>");
                out.println("<h4 class='text-1x2 '><span class='text-1xl font-bold text-blue-500'>Vaccine Batch Number: ");
                out.println("</span>");
                out.println(rs.getString("batch_number"));
                out.println("</h4>");
            }
       
       }catch(ClassNotFoundException | SQLException e){
                out.println(e);
       }
   }
}