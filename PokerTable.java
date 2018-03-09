import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PokerTable extends JPanel
                            implements ActionListener
{
  private JButton check, bet, fold, go;
  private JTextField display;
  private Player p;
  private String changeString;
  Color tableColor;
  PokerSim poker;
  
  public PokerTable(Color color)
  {
    setBackground(Color.WHITE);
    tableColor = color;

    JTextField banner = new JTextField("Poker");
    banner.setEditable(false);
    banner.setFont(new Font("Serif", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);

    check = new JButton();
    check.addActionListener(this);
    bet = new JButton();
    bet.addActionListener(this);
    fold = new JButton();
    fold.addActionListener(this);
    go = new JButton("   ");
    go.setBackground(Color.RED);
    go.addActionListener(this);
    JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
    buttons.setBackground(Color.BLUE);
    buttons.add(check);
    buttons.add(bet);
    buttons.add(fold);

    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(go);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    add(b1);
    
    poker = new PokerSim();
  }

  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();

    if (b == check)
      poker.addToPot(0);
    else if (b == bet)
      poker.addToPot(5);
    else if (b == fold)
      poker.addToPot(0);
    else if (b == go)
    
    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    final int x0 = getWidth() / 12;
    final int y0 = getHeight() / 2;
    final int yStep = 14;

    g.setColor(Color.BLACK);
    g.drawRect(x0, y0, 28, 28);
  }

  private void drawCan(Graphics g, int x, int y)
  {
    g.setColor(tableColor);
    g.fillRoundRect(x, y, 20, 10, 4, 4);
    g.setColor(Color.WHITE);
    g.drawLine(x + 2, y + 4, x + 14, y + 4);
    g.drawLine(x + 2, y + 6, x + 14, y + 6);
  }
}