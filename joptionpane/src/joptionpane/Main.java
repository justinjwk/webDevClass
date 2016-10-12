/*
 * Main.java
 *
 * Created on September 26, 2007, 1:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package joptionpane;

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main extends JFrame implements ActionListener {
    // Instance attributes used in this example
    private	JPanel	topPanel;
    private	JButton	buttonErrx1or;
    private	JButton	buttonWarning;
    private	JButton	buttonInfo;
    private	JButton	buttonQuestion;
    private	JButton	buttonPlain;
    private     JButton buttonInput;
    private     JButton buttonQuit;
    private     JButton buttonError;
    // Constructor of main frame
    public Main()
    {
	// Set the frame characteristics
	setTitle( "Dialog Test Frame" );
	setSize( 310, 130 );
	setBackground( Color.gray );
	
	// Create a panel to hold all other components
	topPanel = new JPanel();
	topPanel.setLayout( new FlowLayout() );
	getContentPane().add( topPanel );
	
	// Create a button for each message type
	buttonError = new JButton( "Error" );
	topPanel.add( buttonError );
	buttonWarning = new JButton( "Warning" );
	topPanel.add( buttonWarning );
	buttonInfo = new JButton( "Informational" );
	topPanel.add( buttonInfo );
	buttonQuestion = new JButton( "Question" );
	topPanel.add( buttonQuestion );
	buttonPlain = new JButton( "Plain" );
	topPanel.add( buttonPlain );
	buttonInput = new JButton("Input");
	topPanel.add( buttonInput);
	buttonQuit = new JButton("Quit");
	topPanel.add( buttonQuit);
	
	// add an action listener to listener for button clicks
	buttonError.addActionListener( this );
	buttonWarning.addActionListener( this );
	buttonInfo.addActionListener( this );
	buttonQuestion.addActionListener( this );
	buttonPlain.addActionListener( this );
	buttonInput.addActionListener( this );
	buttonQuit.addActionListener( this );
    }
    
    // ActionListener handler to listener for button clicks
    // within this application fram
    public void actionPerformed( ActionEvent event )
    {
	// Display a message on the console
	System.out.println( event.getActionCommand() );
	
	if( event.getSource() == buttonError )
	    {
		JOptionPane dialog = new JOptionPane();
		dialog.showMessageDialog( this, "This is an error",
					  "Error", JOptionPane.ERROR_MESSAGE );
	    }
	else if( event.getSource() == buttonWarning )
	    {
		Object[] possibleValues = { "First", "Second", "Third" };
		JOptionPane dialog = new JOptionPane();
		Object selectedValue = dialog.showInputDialog
		    ( this,
		      "This is a warning",
		      "Warning", JOptionPane.WARNING_MESSAGE,
		      null, possibleValues, possibleValues[0] );
		System.out.println("Selected Value was " + selectedValue);
	    }
	else if( event.getSource() == buttonInfo )
	    {
		JOptionPane dialog = new JOptionPane();
		dialog.showConfirmDialog
		    ( this,
		      "This is an informational message",
		      "Information", JOptionPane.DEFAULT_OPTION,
		      JOptionPane.INFORMATION_MESSAGE, null );
	    }
	else if( event.getSource() == buttonQuestion )
	    {
		JOptionPane dialog = new JOptionPane();
		int answer = dialog.showConfirmDialog
		    ( this, "Is this a question?",
		      "Question", JOptionPane.YES_NO_OPTION,
		      JOptionPane.QUESTION_MESSAGE, null );
		if (answer == JOptionPane.YES_OPTION) {
		    System.out.println("You Pressed Yes");
		} else {
		    System.out.println("You Pressed NO");
		}
	    }
	else if( event.getSource() == buttonPlain )
	    {
		JOptionPane dialog = new JOptionPane();
		dialog.showConfirmDialog
		    ( this, "This is a plain message",
		      "Plain", JOptionPane.DEFAULT_OPTION,
		      JOptionPane.PLAIN_MESSAGE, null );
	    }
	else if( event.getSource() == buttonInput )
	    {
		JOptionPane dialog = new JOptionPane();
		dialog.showInputDialog(this, "Enter your name",
				       "Input Name", 
				       JOptionPane.QUESTION_MESSAGE);
	    }
	else if( event.getSource() == buttonQuit )
	    {
		System.exit(0);
	    }
    }
    
    // Main entry point for this example
    public static void main( String args[] )
    {
	// Create an instance of the test application
	final Main mainFrame	= new Main();
	Runnable showFrame = new Runnable() {
		public void run() {
		    mainFrame.setVisible(true);
		}
	    };
	SwingUtilities.invokeLater(showFrame);
    }
}
