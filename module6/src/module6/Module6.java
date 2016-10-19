/*
 * Module6.java
 * This program asks user to input dates and select tour and duration
 * and it calculates the total cost of the tour
 * This program interact with server using Socket and get a result.
 */
package module6;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;

/**
 *
 * @author Justin
 */
public class Module6 extends JFrame implements ActionListener {

    int begin_year;
    int begin_month;
    int begin_day;
    int hike_id;
    int durationbase_rate = 0;

    JPanel titlePanel = new JPanel();
    JPanel selectDatePanel = new JPanel();
    JPanel selectTourPanel = new JPanel();
    JPanel selectDurationPanel = new JPanel();
    JPanel resultPanel = new JPanel();

    JTextField yearField = new JTextField(10);
    JTextField monthField = new JTextField(10);
    JTextField dayField = new JTextField(10);

    JButton gardiner;
    JButton hellroaring;
    JButton beaten;
    JButton verifyDateButton = new JButton("Verify Date");
    JButton calculateButton = new JButton("Calculate");

    JComboBox durationList;

    JLabel title = new JLabel("Welcome to Beartooth Hiking Compnay", JLabel.CENTER);
    String[] tourListString = {"Gardiner Lake", "Hellroaring Plateau", "Beaten Path"};
    String[] durationListString = {"Select Tour First"};
    
    final String CLASS_COM_URL = "web6.jhuep.com";
    final int CLASS_COM_PORT = 20025;

    public Module6() {

        super("Beartooth Hiking Company");

        // Title Panel
        titlePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        Icon icon = new ImageIcon(getClass().getResource("Beartooth002-01.jpg"));
        titlePanel.add(title, gbc);
        titlePanel.add(new JLabel(icon, JLabel.CENTER), gbc);

        // Date selection
        selectDatePanel.setBorder(BorderFactory.createTitledBorder("Input Beginning Date"));
        selectDatePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = GridBagConstraints.RELATIVE;
        gbc1.anchor = GridBagConstraints.EAST;
        selectDatePanel.add(new JLabel("Year:"), gbc1);
        selectDatePanel.add(new JLabel("Month:"), gbc1);
        selectDatePanel.add(new JLabel("Date:"), gbc1);
        gbc1.gridx = 1;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        selectDatePanel.add(yearField, gbc1);
        gbc1.gridy = GridBagConstraints.RELATIVE;
        selectDatePanel.add(monthField, gbc1);
        selectDatePanel.add(dayField, gbc1);
        gbc1.gridx = 0;
        gbc1.gridwidth = 2;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        selectDatePanel.add(verifyDateButton, gbc1);

        verifyDateButton.addActionListener(this);

        // Tour selection
        gardiner = new JButton(tourListString[0]);
        hellroaring = new JButton(tourListString[1]);
        beaten = new JButton(tourListString[2]);
        selectTourPanel.setBorder(BorderFactory.createTitledBorder("Select Tour List"));
        selectTourPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.gridx = 0;
        gbc2.gridy = GridBagConstraints.RELATIVE;
        gbc2.insets = new Insets(5, 5, 5, 5);
        gbc2.weightx = 1.0;
        selectTourPanel.add(gardiner, gbc2);
        selectTourPanel.add(hellroaring, gbc2);
        selectTourPanel.add(beaten, gbc2);

        gardiner.addActionListener(this);
        hellroaring.addActionListener(this);
        beaten.addActionListener(this);

        // Duration selection
        durationList = new JComboBox(durationListString);
        durationList.setSelectedIndex(0);
        selectDurationPanel.setBorder(BorderFactory.createTitledBorder("Select Duration"));
        selectDurationPanel.add(durationList);
        selectDurationPanel.revalidate();
        selectDurationPanel.repaint();

        durationList.addActionListener(this);

        // Calculate Button
        resultPanel.add(calculateButton);

        calculateButton.addActionListener(this);

        // add each panel to window
        add(titlePanel, BorderLayout.NORTH);
        add(selectDatePanel, BorderLayout.WEST);
        add(selectTourPanel, BorderLayout.CENTER);
        add(selectDurationPanel, BorderLayout.EAST);
        add(resultPanel, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        System.out.println(event.getActionCommand());

        // when Verify Date was clicked
        if (event.getSource() == verifyDateButton) {

            // if user input not number values for dates, then show an error message
            try {
                begin_year = Integer.parseInt(yearField.getText());
                begin_month = Integer.parseInt(monthField.getText());;
                begin_day = Integer.parseInt(dayField.getText());;
            } catch (NumberFormatException e) {
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Year, Month, Date should be numbers",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

            // if user didn't input year or month or date, then show an error message
            if (yearField.getText().equals("") 
                    || monthField.getText().equals("") 
                    || dayField.getText().equals("")) {
                
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Input dates before click the button!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } 
            // if user input less than 4 digit for year, or less than 2007, 
            // or greater than 2020, then show an error message
            else if (yearField.getText().length() < 4 
                    || begin_year < 2007 || begin_year > 2020) {
                
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Year should be 4 digits between 2008 and 2020",
                        "Error", JOptionPane.ERROR_MESSAGE);

            } 
            // if user input less than 1, or greater than 12 for month, 
            // then show an error message
            else if (begin_month < 1 || begin_month > 12) {
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Month should be between 1 and 12",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } 
            // if user input less than 1, or greater than 31 for date, 
            // then show an error message 
            else if (begin_day < 1 || begin_day > 31) {
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Date should be between 1 and 31",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } 
            // if user input valid dates, then show a message
            else {
                JOptionPane dialog = new JOptionPane();
                dialog.showMessageDialog(this, "Date is valid!",
                        "Date Validation", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Year: " + begin_year + " Month: " 
                        + begin_month + " Day: " + begin_day);
            }
        } 
        
        // when Gardiner button is clicked
        else if (event.getSource() == gardiner) {
                       
            // update duration based on user's selection
            durationListString = new String[]{"Select Days", "3 days", "5 days"};
            
            // update ComboBox
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);

            // assign hike_id to 0
            hike_id = 0;

        } 
        
        // when Hellroaring button is clicked
        else if (event.getSource() == hellroaring) {

            // update duration based on user's selection
            durationListString = new String[]{"Select Days", "2 days", "3 days", "4 days"};
            
            // update ComboBox
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);

            // assign hike_id to 1
            hike_id = 1;

        } 
        
        // when BeatenPath button is clicked
        else if (event.getSource() == beaten) {
                        
            // update duration based on user's selection
            durationListString = new String[]{"Select Days", "5 days", "7 days"};
           
            // update ComboBox
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);

            // assign hike_id to 2
            hike_id = 2;

        } 
        
        // if user select duration
        else if (event.getSource() == durationList) {
            System.out.println(durationList.getSelectedItem());

            if (durationList.getSelectedItem() != null) {

                // get the duration by taking first character of duration menu which is a number
                durationbase_rate = Character.getNumericValue(
                        durationList.getSelectedItem().toString().charAt(0));
                System.out.println("Duration : " + durationbase_rate);
            }

        }
        
        // when Calculate button is clicked
        else if (event.getSource() == calculateButton) {

            Socket echoSocket = null;
            PrintWriter out = null;
            BufferedReader in = null;

            try {
                // create a Socket, PrintWriter, and BufferedReader
                echoSocket = new Socket(CLASS_COM_URL, CLASS_COM_PORT);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

                String userInput = hike_id + ":" + begin_year + ":" 
                        + begin_month + ":" + begin_day + ":" + durationbase_rate;
                
                System.out.println("User input = " + userInput);

                out.println(userInput);

                String output = in.readLine();
                System.out.println("echo: " + output);

                // If server doesn't return anything, then show an error message
                if (output == null) {
                    JOptionPane dialog = new JOptionPane();
                    dialog.showMessageDialog(this, "Server didn't respond!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } 
                // when server respond
                else {
                    // if things go well and server responded with the cost
                    if (output.contains("Quoted Rate")) {
                        // split the server reponse by ":" and take the first part for the cost
                        String[] response = output.split(":");
                        String cost = response[0];
                        
                        // show a total cost to user
                        JOptionPane dialog = new JOptionPane();
                        dialog.showMessageDialog(this, "The total cost is $" + cost,
                            "Total Cost", JOptionPane.INFORMATION_MESSAGE);
                    }
                    // if things didn't go well and server responded with error message
                    else {
                        // split the server response by ":" and take second part for the message
                        String[] response = output.split(":");
                        String serverMessage = response[1];
                        
                        // show a message from server to user
                        JOptionPane dialog = new JOptionPane();
                        dialog.showMessageDialog(this, serverMessage,
                            "Server repose: ", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // close
                out.close();
                in.close();
                stdIn.close();
                echoSocket.close();

            } catch (UnknownHostException e) {
                System.err.println("Don't know about host: web6.jhuep.com");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to : web6.jhuep.com");
                System.exit(1);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Module6();
    }
}
