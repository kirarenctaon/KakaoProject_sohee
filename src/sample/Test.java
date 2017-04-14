package sample;

import javax.swing.*;
import javax.swing.event.*;
import java.beans.*;
import java.awt.event.*;
import java.awt.*;
 
public class Test extends JFrame implements VetoableChangeListener
{
  public Test()
  {
    super("Test");
    setBounds(200,200,800, 600);   // starting location of frame
    setUndecorated(true);          // no min/max/close icons
    setAlwaysOnTop(true);          // always on top
 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JDesktopPane desktopPane = new JDesktopPane();
    desktopPane.setBackground(new Color(132,184,236));    // give background blue color
    getContentPane().add(desktopPane);
 
    // Overwrite some methods to disable movement of frames.
    final JInternalFrame jif1 = new JInternalFrame("Frame 1")
    {
    };
 
    // create a new JFrame to try and add to THIS JFrame
    JFrame frame = new JFrame("JFRAME");   // displays outside area of "this"
    frame.setSize(400, 300);
    frame.setVisible(true);
 
    // create a new JDialog to try and add to THIS JFrame
    JDialog dlg = new JDialog();                   // displays outside area of "this"
    dlg.setSize(400, 300);
    dlg.setVisible(true);
 
    JInternalFrame jif2 = new JInternalFrame("Frame 2");
 
    desktopPane.add(jif1);
    desktopPane.add(jif2);
    // this.addImpl((Component)frame, null, 0);     // adding the frame to "this" JFrame causes runtime exception (can't add window to frame)
 
    // of course adding the JInternalFrames works fine
    jif1.setSize(400, 300);
    jif1.setLocation(50, 50);
    jif1.setVisible(true);
    jif1.getContentPane().add(new JTextArea("Textbereich"));
    jif2.setSize(400, 300);
    jif2.setLocation(100, 100);
    jif2.setVisible(true);
 
    setVisible(true);
 
 
    // Add a veto change listener to avoid the selection of the first frame.
    jif1.addVetoableChangeListener(this);
  }
 
  public void vetoableChange(PropertyChangeEvent evt)
  throws PropertyVetoException
  {
    if(evt.getPropertyName().equals(JInternalFrame.IS_SELECTED_PROPERTY))
    {
    System.err.println("SELECTED");
    throw new PropertyVetoException("Selected", null);
    }
 
  }
 
  public static void main(String arguments[])
  {
  Test test = new Test();
  }
} 
