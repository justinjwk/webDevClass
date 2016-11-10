/*
 * ClientThread.java
 * 
 * Created on Nov 4, 2016
 * 
 */
package kim_module9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justin Kim
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private int year;
    private int month;
    private int day;
    private int hike;
    private int duration;
    private String[] input;

    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {

        BufferedReader in = null;
        PrintWriter out = null;

        try {

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String outputLine = null;

            while (!socket.isClosed()) {
                outputLine = in.readLine();
                if (outputLine == null) {
                    break;
                }
                if (outputLine.equalsIgnoreCase("bye")) {
                    break;
                } else {
                    // split input into an array
                    input = outputLine.split(":");
                    
                    // if number of inputs is not 5, then print an error message
                    if (input.length != 5) {
                        out.println("-0.01:Input should have 5 values "
                                + "\"begin_year:begin_month:begin_day:hike:duration\"");
                    } else {
                        try {
                            // parse each String values to integer
                            year = Integer.parseInt(input[0]);
                            month = Integer.parseInt(input[1]);
                            day = Integer.parseInt(input[2]);
                            hike = Integer.parseInt(input[3]);
                            duration = Integer.parseInt(input[4]);

                            // create BookingDay class
                            BookingDay bookDay = new BookingDay(year, month, day);

                            // validate dates. If it is valid, the process calculation
                            if (bookDay.isValidDate()) {
                                Rates rate;

                                // if user choose Gardiner
                                if (hike == 1) {
                                    rate = new Rates(Rates.HIKE.GARDINER);
                                    rate.setBeginDate(bookDay);
                                    out.println(rate.getBaseRate() * duration + ":Quoted Rate");
                                } 
                                // if user choose Hellroaring
                                else if (hike == 2) {
                                    rate = new Rates(Rates.HIKE.HELLROARING);
                                    rate.setBeginDate(bookDay);
                                    out.println(rate.getBaseRate() * duration + ":Quoted Rate");
                                } 
                                // if user choose Beaten
                                else if (hike == 3) {
                                    rate = new Rates(Rates.HIKE.BEATEN);
                                    rate.setBeginDate(bookDay);
                                    out.println(rate.getBaseRate() * duration + ":Quoted Rate");
                                } 
                                // if user input is invalid number(not 1-3), then print an error message
                                else {
                                    out.println("-0.01:Hiking is NOT valid!"
                                            + " Hike value should be between 1 and 3");
                                }

                            } // if the date is invalid, then print an error message
                            else {
                                out.println("-0.01:Date is NOT valid! "
                                        + "Year should be between 2007 and 2020. The day(1-31) "
                                        + "and month(1-12) should be valid dates");
                            }

                        }
                        // if input contains invalid format which are not numbers, then print an error message
                        catch (NumberFormatException e) {
                            out.println("-0.01:Invalid Input Type for Date! "
                                    + "Year, Month, Date, Hike, Duration should be numbers.");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
