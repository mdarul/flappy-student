import javax.swing.*;
import java.awt.*;

public class MainActionFrame extends JFrame {

    public MainActionFrame() {
        super("Menu główne");

        JPanel buttonPanel = new MainButtonPanel();
        add(buttonPanel);


        setSize(Main.WIDTH,Main.HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

    }
}