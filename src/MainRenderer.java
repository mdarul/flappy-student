import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;


public class MainRenderer extends JPanel {

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
    }

}
