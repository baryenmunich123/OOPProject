package src;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;

public class Boss extends Enemy {
    private int speedX = 10;
    private int speedY = 10;
    private long startTimeToShoot = 0;
    private long timeToStop = 0;
    private double leftPosition,rightPosistion;
    private Image img;
    public Boss(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        setDamage(4);
        setHP(20);
        ImageIcon i = new ImageIcon("Image/Boss.png");
        img = i.getImage();
        leftPosition = super.getStartX() - 200;
        rightPosistion = super.getStartX() + 200;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        Rectangle rect = getBoundForCollisionWithMap();
        return rect;
    }

    @Override
    public void Attack() {
        Bullet_Enemy bulletLeft = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletLeft.setSpeedX(bulletLeft.getSpeedX());
        bulletLeft.setSpeedY(0);
        bulletLeft.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletLeft);

        Bullet_Enemy bulletRight = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletRight.setSpeedX(-bulletRight.getSpeedX());
        bulletRight.setSpeedY(0);
        bulletRight.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletRight);

        Bullet_Enemy bulletUp = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletUp.setSpeedY(-bulletUp.getSpeedY());
        bulletUp.setSpeedX(0);
        bulletUp.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletUp);

        Bullet_Enemy bulletUpLeft = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletUpLeft.setSpeedY(-bulletUpLeft.getSpeedY() / 2);
        bulletUpLeft.setSpeedX(bulletUpLeft.getSpeedX() / 2);
        bulletUpLeft.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletUpLeft);

        Bullet_Enemy bulletUpRight = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletUpRight.setSpeedY(-bulletUpRight.getSpeedY() / 2);
        bulletUpRight.setSpeedX(-bulletUpRight.getSpeedX() / 2);
        bulletUpRight.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletUpRight);

        Bullet_Enemy bulletDown = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletDown.setSpeedY(+bulletDown.getSpeedY());
        bulletDown.setSpeedX(0);
        bulletDown.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletDown);

        Bullet_Enemy bulletDownLeft = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletDownLeft.setSpeedY(bulletDownLeft.getSpeedY() / 2);
        bulletDownLeft.setSpeedX(bulletDownLeft.getSpeedX() / 2);
        bulletDownLeft.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletDownLeft);

        Bullet_Enemy bulletDownRight = new Bullet_Enemy(super.getStartX(), super.getStartY(), super.getGameWorld());
        bulletDownRight.setSpeedY(bulletDownRight.getSpeedY() / 2);
        bulletDownRight.setSpeedX(-bulletDownRight.getSpeedX() / 2);
        bulletDownRight.setDamage(2);
        super.getGameWorld().Enemy_Manager.addEnemy(bulletDownRight);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(img, (int) super.getStartX() - (int) super.getGameWorld().camera.getX() - 45,
                (int) super.getStartY() - (int) super.getGameWorld().camera.getY() - 50, null);
    }

    @Override
    public void updateState() {
        super.updateState();
        if (super.getStartX() == leftPosition) {
            setSpeedX(0);
            Attack();
            if (System.currentTimeMillis() - timeToStop > 1000) {
                setSpeedX(5);
                timeToStop = System.currentTimeMillis();
            }
        }
        else if (super.getStartX() == rightPosistion) {
            setSpeedX(0);
            Attack();
            if (System.currentTimeMillis() - timeToStop > 1000) {
                setSpeedX(-5);
                timeToStop = System.currentTimeMillis();
            }
        }
        setStartX(super.getStartX() + getSpeedX());

        if (System.nanoTime() - startTimeToShoot > 1000 * 10000000 * 1.5 * 2) {
            Attack();
            startTimeToShoot = System.nanoTime();
        }
    }
}
