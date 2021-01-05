package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;

public class StandingEnemy extends Enemy {
    private long startTimeToShoot = 0;
    private Image image;

    public StandingEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(1);
        setHP(5);
        // try {
        // image =
        // ImageIO.read(getClass().getResourceAsStream("OOPProject\\Image\\Enemy1.png"));
        // } catch (IOException e) {
        // // TODO: handle exception
        // e.printStackTrace();
        // }
        ImageIcon i = new ImageIcon("Image/Enemy1.png");
        image = i.getImage();
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        Rectangle bound = getBoundForCollisionWithMap();
        // bound.x += 20;
        // bound.width -= 40;
        return bound;
    }

    @Override
    public void Attack() {
        // TODO Auto-generated method stub
        Bullet_Enemy bullet = new Bullet_Enemy(getStartX(), getStartY(), getGameWorld());
        bullet.Update();
        getGameWorld().Enemy_Manager.addEnemy(bullet);
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        //if (!OutOfView()) {
            g2.drawImage(image, (int) super.getStartX() - (int)super.getGameWorld().camera.getX() - 20, (int) super.getStartY() - (int)super.getGameWorld().camera.getY() - 50, null);
        //}
    }

    @Override
    public void updateState() {
        super.updateState();
        if (System.nanoTime() - startTimeToShoot > 1000 * 100000000) {
            Attack();
            startTimeToShoot = System.nanoTime();
        }
    }

//    public void Update() {
//        super.updateState();
//        if (System.nanoTime() - startTimeToShoot > 1000 * 100000000) {
//            Attack();
//            startTimeToShoot = System.nanoTime();
//        }
//    }
}
