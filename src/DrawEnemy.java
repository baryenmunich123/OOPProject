package src;

import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawEnemy extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Enemy e1 = new Enemy(getWidth() / 2, getHeight() / 2, "D:\\study\\Code\\OOP\\Image\\Enemy.png");
        Enemy e2 = new Enemy(getWidth() / 5, getHeight() / 2, "D:\\study\\Code\\OOP\\Image\\Enemy.png");
        Enemy e3 = new Enemy(getWidth() / 2, 0, "D:\\study\\Code\\OOP\\Image\\Enemy2.png");
        if (e1.getAlive() == true)
            g.drawImage(e1.getImg(), e1.getX(), e1.getY(), null);
        if (e2.getAlive() == true)
            g.drawImage(e2.getImg(), e2.getX(), e2.getY(), null);
        if (e3.getAlive() == true)
            g.drawImage(e3.getImg(), e3.getX(), e3.getY(), null);
    }
}
