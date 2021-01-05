package src;

import java.awt.*;

public class Bullet_Enemy extends Enemy {
    private int speedX = 1;
    private int speedY = 1;

    public Bullet_Enemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 20, 20, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(1);
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
        g2.setColor(Color.BLACK);
        g2.drawOval((int)super.getStartX() - (int)super.getGameWorld().camera.getX(), (int)super.getStartY() - (int)super.getGameWorld().camera.getY(), 10, 10);
        g2.fillOval((int)super.getStartX() - (int)super.getGameWorld().camera.getX(), (int)super.getStartY() - (int)getGameWorld().camera.getY(), 10, 10);
    }

    public void Update() {
        // super.updateState();
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
