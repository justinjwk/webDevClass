/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim_module10;

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

/**
 *
 * @author Justin
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    String yearString;
    String monthString;
    String dayString;
    String tour;
    String durationString;
    String date;
    int year;
    int month;
    int day;
    int duration;
    int numOfPeople;
    double cost = 0;
    BookingDay bookingDay;
    Rates rate;

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

            // convert user input of year, month, day to integer
            // if user input is not a number, then catch and print error message
            year = Integer.parseInt(yearString);
            month = Integer.parseInt(monthString);
            day = Integer.parseInt(dayString);
            
            // create bookingDay object
            bookingDay = new BookingDay(year, month, day);
            
            // if the date is not valid, then print error message
            if(!bookingDay.isValidDate()) {
                Failed failed = new Failed();
                failed.setErrorMsgTitle("Date is not valid!");
                failed.setErrorMsg("Year should be between 2007 and 2020 <br>"
                        + "The day(1-31) and month(1-12) should be valid dates");
                
                HttpSession session = request.getSession();
                ServletContext servletContext = getServletContext();
                
                session.setAttribute("failed", failed);
                
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
                requestDispatcher.forward(request, response);
            }
            
            // get user's choice for tour
            tour = request.getParameter("tour");
            
            // if user choose Gardiner
            if(tour.equals("gardiner")) {
                rate = new Rates(Rates.HIKE.GARDINER);
            }
            // if user choose Hellroaring
            else if(tour.equals("hellroaring")) {
                rate = new Rates(Rates.HIKE.HELLROARING);
            }
            // if user choose Beaten
            else {
                rate = new Rates(Rates.HIKE.BEATEN);
            }
            
            // set beginning date
            rate.setBeginDate(bookingDay);
            
            // get user's choice for duration
            duration = Integer.parseInt(request.getParameter("duration"));
            
            // get user's choic for number of people
            numOfPeople = Integer.parseInt(request.getParameter("people"));
            
            // for Gardiner tour
            if(tour.equals("gardiner")) {
                for(int i = 0; i < rate.getDurations().length; i++) {
                    // if user's choice for duration is valid, then calculate the cost
                    if(duration == rate.getDurations()[i]) {
                     cost = rate.getBaseRate() * duration * numOfPeople;
                    }
                }
                // if date and duration is valid, print result 
                if(bookingDay.isValidDate() && cost != 0) {
                    
                    Success success = new Success();
                    
                    success.setHike("Gardiner Lake");
                    success.setBookingDay(bookingDay);
                    success.setDuration(duration);
                    success.setNumOfPeople(numOfPeople);
                    success.setCost(cost);
                    
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                    
                    session.setAttribute("success", success);
                    
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/success.jsp");
                    requestDispatcher.forward(request, response);
                    
                    
                // if the duration is not valid, then print error message
                } else if(cost == 0) {
                    
                    Failed failed = new Failed();
                    failed.setErrorMsgTitle("Invalid Duration!");
                    failed.setErrorMsg("Gardiner Lake's duration is 3 or 5 days.");
                
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                
                    session.setAttribute("failed", failed);
                
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
                    requestDispatcher.forward(request, response);
                    
                }
            }
            // for Hellroaring tour
            else if(tour.equals("hellroaring")) {
                for(int i = 0; i < rate.getDurations().length; i++) {
                    // if user's choice for duration is valid, then calculate the cost
                    if(duration == rate.getDurations()[i]) {
                     cost = rate.getBaseRate() * duration * numOfPeople;
                    }
                }
                // if date and duration is valid, print result
                if(bookingDay.isValidDate() && cost != 0) {
                    Success success = new Success();
                    
                    success.setHike("Hellroaring Plateau");
                    success.setBookingDay(bookingDay);
                    success.setDuration(duration);
                    success.setNumOfPeople(numOfPeople);
                    success.setCost(cost);
                    
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                    
                    session.setAttribute("success", success);
                    
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/success.jsp");
                    requestDispatcher.forward(request, response);
                    
                // if the duration is not valid, then print error message    
                } else if(cost == 0) {
                    
                    Failed failed = new Failed();
                    failed.setErrorMsgTitle("Invalid Duration!");
                    failed.setErrorMsg("Hellroaring Plateau's duration is 2, 3, or 4 days.");
                
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                
                    session.setAttribute("failed", failed);
                
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
                    requestDispatcher.forward(request, response);

                }
            }
            // for Beaten tour
            else {
                for(int i = 0; i < rate.getDurations().length; i++) {
                    // if user's choice for duration is valid, then calculate the cost
                    if(duration == rate.getDurations()[i]) {
                     cost = rate.getBaseRate() * duration * numOfPeople;
                    }
                }
                // if date and duration is valid, print result
                if(bookingDay.isValidDate() && cost != 0) {
                    Success success = new Success();
                    
                    success.setHike("Beaten Path");
                    success.setBookingDay(bookingDay);
                    success.setDuration(duration);
                    success.setNumOfPeople(numOfPeople);
                    success.setCost(cost);
                    
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                    
                    session.setAttribute("success", success);
                    
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/success.jsp");
                    requestDispatcher.forward(request, response);
                    
                // if the duration is not valid, then print error message    
                } else if(cost == 0) {
                    
                    Failed failed = new Failed();
                    failed.setErrorMsgTitle("Invalid Duration!");
                    failed.setErrorMsg("Beaten Path's duration is 5, or 7 days.");
                
                    HttpSession session = request.getSession();
                    ServletContext servletContext = getServletContext();
                
                    session.setAttribute("failed", failed);
                
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/failed.jsp");
                    requestDispatcher.forward(request, response);
                    
                }
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
            cost = 0;
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