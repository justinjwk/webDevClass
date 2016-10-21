/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kim_module7;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Justin
 */
@WebServlet(name = "Module7", urlPatterns = {"/Module7"})
public class Module7 extends HttpServlet {

    String yearString;
    String monthString;
    String dayString;
    String tour;
    String durationString;
    int year;
    int month;
    int day;
    int duration;
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
            yearString = request.getParameter("year");
            if (yearString == null) {
                yearString = "no year";
            }

            monthString = request.getParameter("month");
            if (monthString == null) {
                monthString = "no month";
            }

            dayString = request.getParameter("day");
            if (dayString == null) {
                dayString = "no day";
            }

            year = Integer.parseInt(yearString);
            month = Integer.parseInt(monthString);
            day = Integer.parseInt(dayString);
            
            bookingDay = new BookingDay(year, month, day);
            
            if(!bookingDay.isValidDate()) {
                out.println("Year should be between 2007 and 2020 <br>");
                out.println("The day(1-31) and month(1-12) should be valid dates");
            }
            
            tour = request.getParameter("tour");
            
            if(tour.equals("gardiner")) {
                rate = new Rates(Rates.HIKE.GARDINER);
                
            }
            else if(tour.equals("hellroaring")) {
                rate = new Rates(Rates.HIKE.HELLROARING);
            }
            else {
                rate = new Rates(Rates.HIKE.BEATEN);
            }
            
            rate.setBeginDate(bookingDay);
            
            
            
            //rate = new Rates();

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Beartooth Hiking Company</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("Year : " + year + "<br>");
            out.println("Month : " + month + "<br>");
            out.println("Day : " + day + "<br>");
            out.println("Tour : " + tour + "<br>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (NumberFormatException e) {
            out.println("Year, Month, Date should be numbers");
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
