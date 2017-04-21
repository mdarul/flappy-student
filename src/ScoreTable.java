import javax.swing.*;


public class ScoreTable {

    public ScoreTable() {
        JFrame jframe = new JFrame();

        ScoreTableRenderer renderer = new ScoreTableRenderer();

        jframe.add(renderer);
        jframe.setTitle("Wyniki");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(Main.WIDTH, Main.HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }
}
