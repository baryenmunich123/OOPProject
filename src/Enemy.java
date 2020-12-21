package src;

import javax.swing.ImageIcon;
import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private Image img;
    private int HP = 3;
    boolean alive = true;

    public Enemy(int startX, int startY, String imgLocation) {
        this.x = startX;
        this.y = startY;
        ImageIcon icon = new ImageIcon(imgLocation);
        this.img = icon.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }

    public boolean getAlive() {
        if (HP > 0)
            return true;
        return false;
    }

    public int getHP(int megamanBulletX, int megamanBulletY) {
        if (megamanBulletX == this.x && megamanBulletY == this.y)
            this.HP -= 1;
        return HP;
    }

    public void Move(int megamanMove) {
        this.x = x - megamanMove;
    }

    public void Fire() {

    }
}
