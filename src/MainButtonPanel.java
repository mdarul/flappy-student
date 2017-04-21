
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainButtonPanel extends JPanel implements ActionListener
{


    private JButton option1;
    private JButton option2;

    public MainButtonPanel()
    {
        option1 = new JButton("Nowa gra");
        option2 = new JButton("Top 10 wyników");

        option1.addActionListener(this);
        option2.addActionListener(this);

        setLayout(new FlowLayout());
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(Main.WIDTH-100, Main.HEIGHT-200));
        add(option1);
        add(option2);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == option1)
        {
            new Game();
        }

        else if(source == option2)
        {
            new ScoreTable();
        }
    }
}
