package ui;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Components {
  // Layout Manager's Panel creator methods
  public static JPanel createGridLayoutPanel(int rows, int cols) {
    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(rows, cols));    
    return panel;
  }

  public static JPanel createBoxLayoutPanel(int alignment) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, alignment));
    return panel;
  }

  public static JPanel createBorderLayoutPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    return panel;
  }

  public static JPanel createFlowLayoutPanel(int alignment) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(alignment));
    return panel;
  }  

  // Component creator methods
  public static JButton createButton(String buttonTitle, String actionCommand, ActionListener al) {        
    JButton button = new JButton(buttonTitle);      
    button.setActionCommand(actionCommand);
    button.addActionListener(al);
    return button;
  }

  public static JTextField createTextField(int cols) {
    JTextField textField = new JTextField(cols);        

    return textField; 
  }

  public static JTextField createTextField(String actionCommand, int cols) {
    JTextField textField = new JTextField(cols);    
    textField.setActionCommand(actionCommand);

    return textField; 
  }

  public static JPanel renderTextField(String labelTitle, JTextField textField) {
    JPanel panel = createFlowLayoutPanel(FlowLayout.LEFT);            
    JLabel label = new JLabel(labelTitle);
    
    panel.add(label);
    panel.add(textField);

    return panel; 
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Slang word Dictionary");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    
    
    frame.setVisible(true);
  }
}
