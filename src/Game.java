import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Game {

    public Renderer renderer;
    public Player player;
    public Random rand;


    public int ticks, yMove, days;
    public boolean gameOver, started;
    public ArrayList<Rectangle> columns;



    public Game()
    {
        JFrame jframe = new JFrame();
        EventHandler eventHandler = new EventHandler(this);
        Timer timer = new Timer(20, eventHandler);

        renderer = new Renderer(this);
        rand = new Random();

        jframe.add(renderer);
        jframe.setTitle("Flappy student");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(Main.WIDTH, Main.HEIGHT);
        jframe.addMouseListener(eventHandler);
        jframe.addKeyListener(eventHandler);
        jframe.setResizable(false);
        jframe.setVisible(true);

        player = new Player(this);
        columns = new ArrayList<Rectangle>();
        addColumn(true);
        addColumn(true);


        timer.start();
    }

    private void addColumn(boolean start)
    {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start) {
            columns.add(new Rectangle(Main.WIDTH + 150 + columns.size() * 300, Main.HEIGHT - height - Main.GROUND, width, height));
            columns.add(new Rectangle(Main.WIDTH + 150 + (columns.size() - 1) * 300, 0, width, Main.HEIGHT - height - space));
        }
        else {
            columns.add(new Rectangle(columns.get(columns.size() - 1).x + 550, Main.HEIGHT - height - 120, width, height));
            columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, Main.HEIGHT - height - space));
        }
    }

    public void action()
    {
        if(gameOver)restart();

        if(!started) {
            started = true;
        }
        else if (!gameOver) player.jump();
    }

    public void nextFrame() {
        int speed = 10;

        ticks++;

        if(started) {
            moveColumns(speed);
            player.gravityInfluence();
            removeAndAddColumn();
            player.move();
            for(Rectangle column : columns) {
                player.checkColumnTransition(column);
                player.checkCollisionWithColumn(column);
            }
            player.checkCollisionWithEdges();
        }


        renderer.repaint();

    }



    private void restart() {
        player = new Player(this);
        columns.clear();
        yMove = 0;
        days = 0;

        addColumn(true);
        addColumn(true);

        gameOver = false;
    }

    private void moveColumns(int speed) {
        for(int i = 0; i < columns.size(); i++) {
            Rectangle column = columns.get(i);

            column.x -= speed;
        }
    }

    private void removeAndAddColumn(){
        for (int i = 0; i < columns.size(); i++) {
            Rectangle column = columns.get(i);

            if (column.x + column.width < 0) {
                columns.remove(column);

                if (column.y == 0) {
                    addColumn(false);
                }
            }
        }
    }
}
