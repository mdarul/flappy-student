import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Renderer extends JPanel
{

    private static final long serialVersionUID = 1L;
    private Game game;
    private BufferedImage img;

    public Renderer(Game game) {
        this.game = game;
        try {
            img = ImageIO.read(new File("projektPaint.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint(g);
    }

    private void paintColumn(Graphics g, Rectangle column) {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y, column.width, column.height);
    }

    public void repaint(Graphics g)
    {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);

        g.setColor(Color.orange);
        g.fillRect(0, Main.HEIGHT - Main.GROUND, Main.WIDTH, Main.GROUND);

        g.setColor(Color.green);
        g.fillRect(0, Main.HEIGHT - Main.GROUND, Main.WIDTH, Main.GRASS);

        game.player.paint(g, img);

        for (Rectangle column : game.columns) {
            paintColumn(g, column);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 75));

        if (!game.started) {
            g.drawString("Gotów na sesję?", 80, Main.HEIGHT / 2 - 50);
        }

        if (game.gameOver) {
            g.drawString("Przekroczono", 160, Main.HEIGHT / 2 - 80 );
            g.drawString("deficyt ects!", 190, Main.HEIGHT / 2);


            try
            {
                FileOperations fo = new FileOperations();
                fo.ScoreUpdate(game.days/2 + 1);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }


        }

        if (!game.gameOver && game.started) {
            g.setFont(new Font("Arial", 1, 50));
            g.drawString("Dzień sesji: "+(Integer.valueOf(String.valueOf(game.days /2))+1), 15, 60);
        }
    }
}
