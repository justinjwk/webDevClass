/*
 * Module5.java
 */

package module5;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import module5.Rates.HIKE;
       
/**
 *
 * @author Justin
 */
public class Module5 extends JFrame implements ActionListener {
    
    int year;
    int month;
    int day;
    int tourNumber;
    int duration;
    
    final int COST_GARDINER_LAKE = 40;
    final int COST_HELLROARING_PLATEAU = 35;
    final int COST_BEATEN_PATH = 45;
    
    JPanel titlePanel = new JPanel();
    JPanel selectDatePanel = new JPanel();
    JPanel selectTourPanel = new JPanel();
    JPanel selectDurationPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    
    JTextField yearField = new JTextField(10);
    JTextField monthField = new JTextField(10);    
    JTextField dayField = new JTextField(10);

    JButton tour1;
    JButton tour2;
    JButton tour3;
    JButton calculateButton = new JButton("Calculate");;
    JButton verifyDateButton = new JButton("Verify Date");
    
    JComboBox durationList;

    JLabel title = new JLabel ("Welcome to Beartooth Hiking Compnay", JLabel.CENTER);
    String[] tourListString = {"Gardiner Lake", "Hellroaring Plateau", "BeatenPath"};
    String[] durationListString ={"Select Tour First"};
    
    Rates rate;
    BookingDay bookingDay;
    
    public Module5() {
        
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
        JButton test = new JButton("Date");
        selectDatePanel.setBorder(BorderFactory.createTitledBorder("Input Beginning Date"));
        selectDatePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = GridBagConstraints.RELATIVE;
        gbc1.anchor=GridBagConstraints.EAST;
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
        tour1 = new JButton(tourListString[0]);
        tour2 = new JButton(tourListString[1]);
        tour3 = new JButton(tourListString[2]);
        selectTourPanel.setBorder(BorderFactory.createTitledBorder("Select Tour List"));
        selectTourPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.gridx = 0;
        gbc2.gridy = GridBagConstraints.RELATIVE;
        gbc2.insets = new Insets(5, 5, 5, 5);
        gbc2.weightx = 1.0;                
        selectTourPanel.add(tour1, gbc2);
        selectTourPanel.add(tour2, gbc2);
        selectTourPanel.add(tour3, gbc2);  
        
        tour1.addActionListener(this);
        tour2.addActionListener(this);
        tour3.addActionListener(this);
        
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
            
            // if user didn't input year or month or date, then show error message
            if (yearField.getText().equals("") || monthField.getText().equals("") || dayField.getText().equals("")) {
                JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog( this, "Input dates before click the button!",
					  "Error", JOptionPane.ERROR_MESSAGE );
            }
            else {
                
                year = Integer.parseInt(yearField.getText());
                month = Integer.parseInt(monthField.getText());
                day = Integer.parseInt(dayField.getText());
                System.out.println("Year: " + year + " Month: " + month + " Day: " + day);
                bookingDay = new BookingDay(year, month, day);
                
                if (bookingDay.isValidDate()) {
                JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog( this, "This date is available",
					  "Valid", JOptionPane.INFORMATION_MESSAGE );
                }
                
                else {
                    JOptionPane dialog = new JOptionPane();
                    dialog.showMessageDialog( this, "This date is not valid. Year(4 digits, 2007-2019), Month(1-12)",
					  "Error", JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        else if (event.getSource() == tour1) {
            durationListString = new String[] {"Select Days", "3 days", "5 days"};
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);
            
            rate = new Rates(HIKE.GARDINER);
            
        }
        
        else if (event.getSource() == tour2) {
            durationListString = new String[] {"Select Days", "2 days", "3 days", "4 days"};
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);
            
            rate = new Rates(HIKE.HELLROARING);
        }
        
        else if (event.getSource() == tour3) {
            durationListString = new String[] {"Select Days", "5 days", "7 days"};
            durationList.removeAllItems();
            DefaultComboBoxModel model = new DefaultComboBoxModel(durationListString);
            durationList.setModel(model);
            durationList.setSelectedIndex(0);
            
            rate = new Rates(HIKE.BEATEN);

        }
        
        else if (event.getSource() == durationList) {
            System.out.println(durationList.getSelectedItem());
//            if (durationList.getSelectedItem().toString().equals("2 days")) {
//                rate.setDuration(2);
//            }
//            else if (durationList.getSelectedItem().toString().equals("3 days")) {
//                rate.setDuration(3);
//            }
//            else if (durationList.getSelectedItem().toString().equals("4 days")) {
//                rate.setDuration(4);
//            }
//            else if (durationList.getSelectedItem().toString().equals("5 days")) {
//                rate.setDuration(5);
//            }
//            else if (durationList.getSelectedItem().toString().equals("7 days")) {
//                rate.setDuration(7);
//            }
//            else {
//                rate.setDuration(0);
//            }
                
        }
        
        else if (event.getSource() == calculateButton) {
            
            // If user didn't choose tour or duration, then show error message
            if(rate == null) {
                JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog( this, "Select Tour and Duration First!",
					  "Error", JOptionPane.ERROR_MESSAGE );
            }
            
            else {
                rate.getCost();
                JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog( this, rate.getCost(),
					  "Total Cost is", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Module5();
    }
}
