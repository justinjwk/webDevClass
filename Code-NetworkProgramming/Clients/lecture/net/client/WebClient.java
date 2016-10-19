 package lecture.net.client;
import java.awt.*; // For BorderLayout, GridLayout, Font, Color.
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/** A graphical client that lets you interactively connect to
 *  Web servers and send custom request lines and
 *  request headers.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class WebClient extends JPanel
    implements Runnable, Interruptible, ActionListener {
  public static void main(String[] args) {
    WindowUtilities.setNativeLookAndFeel();
    WindowUtilities.openInJFrame(new WebClient(), 600, 700, 
                                 "Web Client", 
                                 SystemColor.control);
  }

  private LabeledTextField hostField, portField,
          requestLineField;
  private JTextArea requestHeadersArea, resultArea;
  private String host, requestLine;
  private int port;
  private String[] requestHeaders = new String[30];
  private JButton submitButton, interruptButton;
  private boolean isInterrupted = false;

  public WebClient() {
    setLayout(new BorderLayout(5, 30));
    int fontSize = 14;
    Font labelFont =
      new Font("Serif", Font.BOLD, fontSize);
    Font headingFont =
      new Font("SansSerif", Font.BOLD, fontSize+4);
    Font textFont =
      new Font("Monospaced", Font.BOLD, fontSize-2);
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BorderLayout());
    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new GridLayout(4,1));
    hostField = new LabeledTextField("Host:", labelFont,
                                     30, textFont);
    portField = new LabeledTextField("Port:", labelFont,
                                     "80", 5, textFont);
    // Use HTTP 1.0 for compatibility with the most servers.
    // If you switch this to 1.1, you *must* supply a
    // Host: request header.
    requestLineField =
      new LabeledTextField("Request Line:", labelFont,
                           "GET / HTTP/1.0", 50, textFont);
    labelPanel.add(hostField);
    labelPanel.add(portField);
    labelPanel.add(requestLineField);
    JLabel requestHeadersLabel =
      new JLabel("Request Headers:");
    requestHeadersLabel.setFont(labelFont);
    labelPanel.add(requestHeadersLabel);
    inputPanel.add(labelPanel, BorderLayout.NORTH);
    requestHeadersArea = new JTextArea(5, 80);
    requestHeadersArea.setFont(textFont);
    JScrollPane headerScrollArea = 
      new JScrollPane(requestHeadersArea);
    inputPanel.add(headerScrollArea, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    submitButton = new JButton("Submit Request");
    submitButton.addActionListener(this);
    submitButton.setFont(labelFont);
    buttonPanel.add(submitButton);
    inputPanel.add(buttonPanel, BorderLayout.SOUTH);
    add(inputPanel, BorderLayout.NORTH);
    JPanel resultPanel = new JPanel();
    resultPanel.setLayout(new BorderLayout());
    JLabel resultLabel =
      new JLabel("Results", JLabel.CENTER);
    resultLabel.setFont(headingFont);
    resultPanel.add(resultLabel, BorderLayout.NORTH);
    resultArea = new JTextArea();
    resultArea.setFont(textFont);
    JScrollPane resultScrollArea = 
      new JScrollPane(resultArea);    
    resultPanel.add(resultScrollArea, BorderLayout.CENTER);
    JPanel interruptPanel = new JPanel();
    interruptButton = new JButton("Interrupt Download");
    interruptButton.addActionListener(this);
    interruptButton.setFont(labelFont);
    interruptPanel.add(interruptButton);
    resultPanel.add(interruptPanel, BorderLayout.SOUTH);
    add(resultPanel, BorderLayout.CENTER);
  }

  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == submitButton) {
      Thread downloader = new Thread(this);
      downloader.start();
    } else if (event.getSource() == interruptButton) {
      isInterrupted = true;
    } 
  }

  public void run() {
    isInterrupted = false;
    if (hasLegalArgs()) 
      new HttpClient(host, port, requestLine,
		     requestHeaders, resultArea, this);
  }
                         
  public boolean isInterrupted() {
    return(isInterrupted);
  }

  private boolean hasLegalArgs() {
    host = hostField.getTextField().getText();
    if (host.length() == 0) {
      report("Missing hostname");
      return(false);
    }
    String portString =
      portField.getTextField().getText();
    if (portString.length() == 0) {
      report("Missing port number");
      return(false);
    }
    try {
      port = Integer.parseInt(portString);
    } catch(NumberFormatException nfe) {
      report("Illegal port number: " + portString);
      return(false);
    }
    requestLine =
      requestLineField.getTextField().getText();
    if (requestLine.length() == 0) {
      report("Missing request line");
      return(false);
    }
    getRequestHeaders();
    return(true);
  }

  private void report(String s) {
    resultArea.setText(s);
  }

  private void getRequestHeaders() {
    for(int i=0; i<requestHeaders.length; i++) {
      requestHeaders[i] = null;
    }
    int headerNum = 0;
    String header =
      requestHeadersArea.getText();
    StringTokenizer tok =
      new StringTokenizer(header, "\r\n");
    while (tok.hasMoreTokens()) {
      requestHeaders[headerNum++] = tok.nextToken();
    }
  }
}