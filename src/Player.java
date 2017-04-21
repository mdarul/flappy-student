import java.awt.*;

public class Player {

    public static final int SIZE = 30;
    private Rectangle rect;
    private int yMove;
    private Game game;

    public Player(Game game) {
        this.game = game;
        rect = new Rectangle(Main.WIDTH / 2 - 10, Main.HEIGHT / 2 - 10, SIZE, SIZE);
        yMove = 0;
    }

    public int getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

    public void jump() {
        if (yMove > 0) {
            yMove = -10;
        } else {
            yMove -= 10;
        }
    }

    public void checkCollisionWithColumn(Rectangle column) {
        if (rect.intersects(column)) {
            game.gameOver = true;

            //ustawiamy aby nie przenikał po porażce
            if (rect.x <= column.x) {
                rect.x = column.x - rect.width;
            } else {
                //czy mamy do czynienia ze zderzeniem z gorna czy z dolna kolumna

                //dolna
                if (column.y != 0) {
                    rect.y = column.y - rect.height;
                }

                //gorna
                else if (rect.y < column.height) {
                    rect.y = column.height;
                }

            }
        }
    }

    public void checkCollisionWithEdges() {
        //sprawdzenie czy nie uderzyl w dol czy w gore
        if (rect.y > Main.HEIGHT - 120 || rect.y < 0) {
            game.gameOver = true;
        }

        //sprawdzenie czy sie nie zderzy w nastepnym ruchu
        if (rect.y + yMove >= Main.HEIGHT - 120) {
            rect.y = Main.HEIGHT - 120 - rect.height;
            game.gameOver = true;
        }
    }

    public void gravityInfluence(){
        // Przyspieszenie "grawitacyjne"
        if(game.ticks % 2 == 0 && yMove < 16) {
            yMove += 2;
        }
    }

    public void paint(Graphics g, Image img) {
        g.drawImage(img, rect.x, rect.y, rect.width, rect.height, null);
    }

    public void move() {
        rect.y += yMove;
    }

    public void checkColumnTransition(Rectangle column) {
        if(column.y == 0 && rect.x + rect.width / 2 > column.x + column.width / 2 - 15 && rect.x + rect.width / 2 < column.x + column.width / 2 + 15) {
            game.days++;
        }
    }

}
