import java.awt.event.*;


public class EventHandler implements ActionListener, MouseListener, KeyListener {

    private Game game;

    public EventHandler(Game game)
    {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.nextFrame();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {game.action();}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {
        game.action();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
