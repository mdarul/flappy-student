import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;


public class ScoreTableRenderer extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint(g);
    }


    public void repaint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(0, Main.HEIGHT - Main.GROUND, Main.WIDTH, Main.GROUND);

        g.setColor(Color.green);
        g.fillRect(0, Main.HEIGHT - Main.GROUND, Main.WIDTH, Main.GRASS);




        int[] tab;

        try
        {
            FileOperations fo = new FileOperations();
            fo.LoadScoreFromFile();
            tab = fo.getScores();
            g.setColor(Color.white);
            g.setFont(new Font("Arial", 1, 50));

            for(int i=9; i>=0; i--)
            {
                g.drawString("Miejsce "+(i+1)+" - "+tab[i]+"pkt", 80, 100 + i*60);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }



    }

}
