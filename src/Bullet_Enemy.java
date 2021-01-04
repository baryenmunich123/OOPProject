package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet_Enemy extends Enemy {
    private int speedX = 1;
    private int speedY = 1;

    public Bullet_Enemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 20, 20, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(10);
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
        // TODO Auto-generated method stub
        Rectangle rect = new Rectangle((int) super.getStartX(), (int) super.getStartY(), 20, 20);
        return rect;
    }

    @Override
    public void Attack() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        g2.drawOval((int) super.getStartX(), (int) super.getStartY(), 0, 20);
    }

    public void Update() {
        super.updateState();
        setStartX(getStartX() + getSpeedX());
        setStartY(getStartY() + getSpeedY());
        // getBoundForCollisionWithEnemy().intersects(getGameWorld().megaman.getBodyRect());
        // if (getGameWorld().megaman.getHP() != 0 && getGameWorld().megaman.getState()
        // == 0)
        // getGameWorld().megaman.setHP(getGameWorld().megaman.getHP() -
        // super.getDamage());
    }

    public boolean OutOfView() {
        if (super.getStartX() - super.getGameWorld().camera.getX() > (super.getGameWorld().camera.getWidth() + 10)
                || (super.getStartX() - 20) < super.getGameWorld().camera.getX()
                || super.getStartY()
                        - super.getGameWorld().camera.getY() > (super.getGameWorld().camera.getHeight() + 10)
                || (super.getStartY() - 20) < super.getGameWorld().camera.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
