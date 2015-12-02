import ChessGame.ChessGame;
import ChessGame.ChineseDarkChessGame;
import ChessGame.GomokuChessGame;
import ChessGame.Player;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame{

  private final int FRAME_WIDTH = 300;
  private final int FRAME_HEIGHT = 300;
  private final int TEXTFIELD_COLUMN = 13;

  private final String TITLE = "Chess Game";

  private final String[] games = {
    "Select a Game",
    "Chinese Dark Chess",
    "Gomoku"
  };

  private JPanel container;

  private JTextField txtRedInput, txtBlackInput;
  private JButton btnStart;
  private JComboBox cmbGames;

  public Main() {
    initFrame();
    initActions();
  }

  private void initFrame() {
    initCointainer();

    this.setTitle(this.TITLE);
    setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
  }

  private void initCointainer() {
    container = new JPanel();
    container.setLayout(new BorderLayout());
    initNorthPanel();
    initForm();
    add(container);
  }

  private void initNorthPanel() {
    JPanel panelTitle = new JPanel();
    JLabel lblGameTitle = new JLabel("Chinese Dark Chess");

    panelTitle.add(lblGameTitle);
    container.add(panelTitle, BorderLayout.NORTH);
  }

  private void initForm() {
    JPanel panelForm = new JPanel();
    JLabel lblPlayerRed = new JLabel("    Player Red: ");
    JLabel lblPlayerBlack = new JLabel("Player Black: ");
    JLabel lblGame = new JLabel("            Game: ");

    txtRedInput = new JTextField();
    txtBlackInput = new JTextField();
    btnStart = new JButton("Start");
    cmbGames = new JComboBox(games);

    panelForm.setBorder(new EmptyBorder(15, 0, 0, 0));

    txtRedInput.setColumns(TEXTFIELD_COLUMN);
    txtBlackInput.setColumns(TEXTFIELD_COLUMN);

    panelForm.add(lblGame);
    panelForm.add(cmbGames);
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

        ChessGame chessGame;

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

        if (cmbGames.getSelectedIndex() == 0) {
          JOptionPane.showMessageDialog(null, "Please select a game.");
          return;
        }

        chessGame = bindSelectedGame();

        if (chessGame == null) {
          JOptionPane.showMessageDialog(null, "Game selection error.");
          return;
        }

        chessGame.playGame();
        close();
      }
    });
  }

  private ChessGame bindSelectedGame() {
    String selectedItem = cmbGames.getSelectedItem().toString();

    Player p1 = new Player(txtRedInput.getText());
    Player p2 = new Player(txtBlackInput.getText());

    if (selectedItem.equalsIgnoreCase("Chinese Dark Chess")) {
      return new ChineseDarkChessGame(p1, p2);
    }
    else if (selectedItem.equalsIgnoreCase("Gomoku")) {
      return new GomokuChessGame();
    }

    return null;
  }

  private void open() {
    setVisible(true);
  }

  private void close() {
    dispose();
  }

  public static void main(String[] args) {
    new Main().open();
  }
}
