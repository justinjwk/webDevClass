/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim_module11;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private String yearString;
    private String monthString;
    private String dayString;
    private String date;
    
    private String startDate;

    private static final String USERNAME = "johncolter";
    private static final String PASSWORD = "LetMeIn";
    private static final String HOST = "web6.jhuep.com";
    private static final String DB = "mysql";
    private static final int PORT = 3306;
    private static final String DB_NAME = "class";
    
    ArrayList<Success> results = new ArrayList<Success>();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try {

            // for HTML declaration
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Beartooth Hiking Company</title>");

            // Style for table and fonts
            out.println("<style>");
            out.println("table {");
            out.println("    width: 700px;");
            out.println("    border: 1px solid black;");
            out.println("    border-spacing: 1px;");
            out.println("}");
            out.println("th {");
            out.println("    text-align: center;");
            out.println("}");
            out.println("td {");
            out.println("    padding: 5px;");
            out.println("    text-align: top, left;");
            out.println("}");
            out.println("h1 {");
            out.println("    text-align: center;");
            out.println("    color: blue;");
            out.println("}");
            out.println("h2 {");
            out.println("    text-align: center;");
            out.println("    color: red;");
            out.println("}");
            out.println("h3 {");
            out.println("    text-align: center;");
            out.println("}");
            out.println("        </style>  ");
            out.println("</head>");
            out.println("<body>");

            out.print("body start<br>");
            
            date = request.getParameter("dateInput");

            // split date string by "-"
            String[] dateString = date.split("-");

            // if dateString doesn't contains month, date, year, then print error message
            if (dateString.length != 3) {

                Failed failed = new Failed();
                failed.setErrorMsgTitle("Date format is not valid!");
                failed.setErrorMsg("Date format should be MM-DD-YYYY in numbers. <br>"
                        + "Year should be between 2007 and 2020. <br>"
                        + "The day(1-31) and month(1-12) should be valid dates");

                HttpSession session = request.getSession();
                ServletContext servletContext = getServletContext();

                session.setAttribute("failed", failed);

                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
                requestDispatcher.forward(request, response);
            }

            // if user didn't input year, then set with default value
            yearString = dateString[2];
            if (yearString == null) {
                yearString = "no year";
            }

            // if user didn't input month, then set with default value
            monthString = dateString[0];
            if (monthString == null) {
                monthString = "no month";
            }

            // if user didn't input day, then set with default value
            dayString = dateString[1];
            if (dayString == null) {
                dayString = "no day";
            }
          
            startDate = yearString + "-" + monthString + "-" + dayString;
            out.print("Start date is set: " + startDate + "<br>");
            
            // DB access
            try {
                out.print("First try block <br>");
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException cnfe) {
                out.print("class not found exception thrown<br>");
                System.out.println("Error loading driver " + cnfe.getMessage());
            }
            try {
                out.print("Second try block <br>");
                String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
                out.print("DB URL = " + dbURL + "<br>");
                Connection connection = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
                out.print("Connection is made<br>");
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("Driver name: " + meta.getDriverName());
                System.out.println("Driver version: " + meta.getDriverVersion());

                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                out.print("Statement is created<br>");
                
                try {
                    out.print("Third try block<br>");
                    ResultSet resultSet = statement.executeQuery(
                            "SELECT " + 
                                    "reservation.StartDay as startDay, " + 
                                    "locations.location as tourLocation, " + 
                                    "guides.First as guideFirstName, " + 
                                    "guides.Last as guideLastName, " + 
                                    "reservation.First as reserveFirstName, " + 
                                    "reservation.Last as reserveLastName " + 
                            "FROM " + 
                                    "reservation, guides, locations" + 
                            "WHERE " + 
                                    "reservation.StartDay > " + startDate + " " +
                                "AND " + 
                                    "reservation.location = locations.idlocations " + 
                                "AND " + 
                                    "reservation.guide = guides.idguides;");
                    
                    out.print("executeQuery is done<br>");
                    
                    results.clear();

                    while (resultSet.next()) {

                        Success success = new Success();
                        success.setDate(resultSet.getString("startDay"));
                        success.setLocation(resultSet.getString("tourLocation"));
                        success.setGuideName(resultSet.getString("guideFirstName") + " " + resultSet.getString("guideLastName"));
                        success.setReservationFirst(resultSet.getString("reserveFirstName"));
                        success.setReservationLast(resultSet.getString("reserveLastName"));
                        
                        results.add(success);
                    }
                    
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();

                    session.setAttribute("results", results);
                    
                    connection.close();

                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/success.jsp");
                    requestDispatcher.forward(request, response);
                        
                } catch (SQLException sqle) {
                    out.print("SQLException!!!");
                    System.err.println("error: " + sqle.getMessage());
                }

            } catch (SQLException ex) {
                out.print("SQLException2!!!");
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        out.println("</body>");
        out.println("</html>");

        // if user input for date is not a number, then print error message
        } catch (NumberFormatException e) {
           
            Failed failed = new Failed();
            failed.setErrorMsgTitle("Invalid Input Type for Date!");
            failed.setErrorMsgTitle("Year, Month, Date should be numbers.");

            HttpSession session = request.getSession();
            ServletContext servletContext = getServletContext();

            session.setAttribute("failed", failed);

            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
            requestDispatcher.forward(request, response);
    } finally {
            out.close();
    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
