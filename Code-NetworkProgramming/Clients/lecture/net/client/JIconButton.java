package lecture.net.client;
import javax.swing.*;

/** A regular JButton created with an ImageIcon and with borders
 *  and content areas turned off.
 *
 *  Taken from Core Web Programming from 
 *  Prentice Hall and Sun Microsystems Press,
 *  http://www.corewebprogramming.com/.
 *  &copy; 2001 Marty Hall and Larry Brown;
 *  may be freely used or adapted. 
 */

public class JIconButton extends JButton {
  public JIconButton(String file) {
    super(new ImageIcon(file));
    setContentAreaFilled(false);
    setBorderPainted(false);
    setFocusPainted(false);
  }
}