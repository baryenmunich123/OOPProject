package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import java.awt.*;

public class FlyEnemy extends Enemy {
    private long startTimeToShoot = 0;
    private Image img;
    private int speedX = 2;
    private double leftPosition,rightPosistion;

    public FlyEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(3);
        setHP(3);
        ImageIcon i = new ImageIcon("Image/Enemy3.png");
        img = i.getImage();
        leftPosition = super.getStartX() - 150;
        rightPosistion = super.getStartX() + 150;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        Rectangle bound = getBoundForCollisionWithMap();
        return bound;
    }

    @Override
    public void Attack() {
        // TODO Auto-generated method stub
//        Bullet_Enemy bulletLeft = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
//        super.getGameWorld().Enemy_Manager.addEnemy(bulletLeft);
//        Bullet_Enemy bulletRight = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
//        bulletRight.setSpeedX(-bulletRight.getSpeedX());
//        super.getGameWorld().Enemy_Manager.addEnemy(bulletRight);
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        g2.drawImage(img, (int) super.getStartX() - (int) super.getGameWorld().camera.getX() - 45,
                (int) super.getStartY() - (int) super.getGameWorld().camera.getY() - 50, null);
//        drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void updateState() {
        super.updateState();
        if (super.getStartX() == leftPosition)
            setSpeedX(5);
        else if (super.getStartX() == rightPosistion)
            setSpeedX(-5);
        setStartX(super.getStartX() + getSpeedX());

        if (System.nanoTime() - startTimeToShoot > 1000 * 10000000) {
            Attack();
            startTimeToShoot = System.nanoTime();
        }
    }
}
