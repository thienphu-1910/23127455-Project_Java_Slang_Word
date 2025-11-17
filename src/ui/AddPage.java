package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

class AddEvent implements ActionListener {
  private JTextField wordField;
  private JTextField definitionField;
  
  public AddEvent(JTextField wordField, JTextField definitionField) {
    this.wordField = wordField;
    this.definitionField = definitionField;
  }
  
  private void deleteTextField(JTextField textField) {
    textField.setText("");
  }
  
  private void addSlangWord(JTextField word, JTextField definition) {
    
  }

  public void actionPerformed(ActionEvent ae) {
    String s = ae.getActionCommand();
    if (s.contentEquals("add")) {
      addSlangWord(wordField, definitionField);
    }
    else if (s.contentEquals("delete-word")) {
      deleteTextField(wordField);
    }
    else if (s.contentEquals("delete-definition")) {
      deleteTextField(definitionField);
    }
    else if (s.contentEquals("delete-all")) {
      deleteTextField(wordField);
      deleteTextField(definitionField);
    }
  }
}


public class AddPage extends Page {  
  private JPanel createButtonPanel(ActionListener al) {
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

    // Add Button
    JButton addBtn = Components.createButton("Add",
                                             "add-word", al);    
    buttonPanel.add(addBtn);    
    // Delete Buttons
    // Delete Word TextField
    JButton deleteWordBtn = Components.createButton("Delete Word", 
                                                    "delete-word", al);    
    buttonPanel.add(deleteWordBtn);
    // Delete Definition TextField
    JButton deleteDefBtn = Components.createButton("Delete Definition",
                                                   "delete-definition", al);    
    buttonPanel.add(deleteDefBtn);
    // Delete both TextField
    JButton deleteAllBtn = Components.createButton("Delete All", 
                                                   "delete-all", al);    
    buttonPanel.add(deleteAllBtn);    

    return buttonPanel;
  }

  public JPanel render(String pageTitle) {
    JPanel mainPanel = Components.createFlowLayoutPanel(FlowLayout.LEFT);
    
    // Title and TextFiled
    JPanel titleAndTextPanel = Components.createBoxLayoutPanel(BoxLayout.Y_AXIS);
    JLabel title = new JLabel(pageTitle);    
    
    JTextField wordField = Components.createTextField(20);
    JPanel wordPanel = Components.renderTextField("Word:         ", wordField);    
    
    JTextField definitionField = Components.createTextField(50);
    JPanel definitionPanel = Components.renderTextField("Definition: ", definitionField);    

    titleAndTextPanel.add(title);
    titleAndTextPanel.add(wordPanel);
    titleAndTextPanel.add(definitionPanel);
    mainPanel.add(titleAndTextPanel);

    AddEvent addEvent = new AddEvent(wordField, definitionField);

    // Button
    JPanel buttonPanel = createButtonPanel(addEvent);
    
    mainPanel.add(buttonPanel);   

    return mainPanel;
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Slang word Dictionary");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    
    AddPage ap = new AddPage();    
    frame.add(ap.render("Add Page"));
    
    frame.setVisible(true);
  }
}
