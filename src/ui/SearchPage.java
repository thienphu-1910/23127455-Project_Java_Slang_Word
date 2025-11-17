package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class SearchEvent implements ActionListener {
  private JTextField searchField;
  private JPanel resultPanel;

  public SearchEvent(JTextField searchField, JPanel resultPanel) {
    this.searchField = searchField;
    this.resultPanel = resultPanel;
  }

  public void actionPerformed(ActionEvent ae) {

  }
}

public class SearchPage extends Page {
  private int defalutTextFieldColumns = 20;

  private JPanel renderSearchField(String label, String actionCommand) {
    JPanel mainPanel = Components.createBoxLayoutPanel(BoxLayout.Y_AXIS);
   
    JTextField searchInput = Components.createTextField(actionCommand, defalutTextFieldColumns);
    JPanel searchPanel = Components.renderTextField(label, searchInput);    
    mainPanel.add(searchPanel);        

    JPanel resultPanel = Components.createBoxLayoutPanel(BoxLayout.Y_AXIS);
    mainPanel.add(resultPanel, BorderLayout.CENTER);

    SearchEvent se = new SearchEvent(searchInput, resultPanel);
    searchInput.addActionListener(se);

    return mainPanel;
  }

  public JPanel render(String pageTitle) {
    JPanel mainPanel = Components.createBorderLayoutPanel();   
    
    JLabel title = new JLabel(pageTitle);
    
    JPanel contentPanel = Components.createGridLayoutPanel(1, 2);

    JPanel leftPanel = renderSearchField("Word", "search-word");
    JPanel rightPanel = renderSearchField("Definition", "search-keyword");

    contentPanel.add(leftPanel);
    contentPanel.add(rightPanel);    

    mainPanel.add(title, BorderLayout.PAGE_START);
    mainPanel.add(contentPanel, BorderLayout.CENTER);
    
    return mainPanel;
  }

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Slang word Dictionary");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    
    SearchPage sp = new SearchPage();    
    frame.add(sp.render("Search Slang Word"));
    
    frame.setVisible(true);
  }
}
