import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StartChineseDarkChess {
  
  private final int WIDTH = 300;
  private final int HEIGHT = 300;
  private final int TEXTFIELD_COLUMN = 13;
  
  private final String TITLE = "Chinse Dark Chess";

  private JFrame startScreen;
  
  private JPanel container;
  
  private JTextField txtRedInput, txtBlackInput;
  private JButton btnStart;
  
  public StartChineseDarkChess() {
    initUIComponents();
    initActions();
  }
  
  private void initUIComponents() {
    startScreen = new JFrame(this.TITLE);
    
    initCointainer();
    
    startScreen.add(container);
    startScreen.setSize(this.WIDTH, this.HEIGHT);
    startScreen.setLocationRelativeTo(null);
    startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startScreen.setResizable(false);
  }
  
  private void initCointainer() {
    container = new JPanel();
    
    container.setLayout(new BorderLayout());   
    initNorthPanel();
    initForm();
  }
  
  private void initNorthPanel() {
    JPanel panelTitle = new JPanel();
    JLabel lblGameTitle = new JLabel("Chinese Dark Chess");
    
    panelTitle.add(lblGameTitle);
    container.add(panelTitle, BorderLayout.NORTH);
  }
  
  private void initForm() {
    JPanel panelForm = new JPanel();
    JLabel lblPlayerRed = new JLabel("   Player Red: ");
    JLabel lblPlayerBlack = new JLabel("Player Black: ");
    txtRedInput = new JTextField();
    txtBlackInput = new JTextField();
    btnStart = new JButton("Start");
    
    panelForm.setBorder(new EmptyBorder(15, 0, 0, 0));
    
    //panelForm.setLayout(new GridLayout(3, 2));
    txtRedInput.setColumns(TEXTFIELD_COLUMN);
    txtBlackInput.setColumns(TEXTFIELD_COLUMN);
    
    panelForm.add(lblPlayerRed);
    panelForm.add(txtRedInput);
    panelForm.add(lblPlayerBlack);
    panelForm.add(txtBlackInput);
    panelForm.add(btnStart);
    
    container.add(panelForm, BorderLayout.CENTER);
  }
  
  private void initActions() {
    btnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String redInput = txtRedInput.getText().trim();
        String blackInput = txtBlackInput.getText().trim();
        
        if (redInput.isEmpty() || blackInput.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Please input players name.");
          return;
        }
        
        if (redInput.equals(blackInput)) {
          JOptionPane.showMessageDialog(null, "Player name can't be same");
          return;
        }
        
        new Game().show();
        close();
      }
    });
  }
  
  public void show() {
    startScreen.setVisible(true);
  }
  
  private void close() {
    startScreen.dispose();
  }
  
  public static void main(String[] args) {
    new StartChineseDarkChess().show();
  }
}