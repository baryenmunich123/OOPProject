package src;

import javax.swing.*;
import java.awt.*;

public class ShortRangeEnemy extends Enemy {
    private Image img;
    private int speedX = 5, speedY = 5;
    public ShortRangeEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        setDamage(3);
        setHP(5);
        ImageIcon i = new ImageIcon("Image/Enemy4.png");
        img = i .getImage();
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        Rectangle rect = getBoundForCollisionWithMap();
        return rect;
    }

    @Override
    public void Attack() {

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(img, (int) super.getStartX() - (int) super.getGameWorld().camera.getX() - 45,
                (int) super.getStartY() - (int) super.getGameWorld().camera.getY() - 50, null);
    }

    @Override
    public void updateState() {
        super.updateState();

//        super.setStartX(super.getStartX() + speedX);
//        if (super.getGameWorld().physicalMap.haveCollisionWithLeftWall(super.getBoundForCollisionWithMap()) != null) {
//            Rectangle r1 = super.getGameWorld().physicalMap.haveCollisionWithLeftWall(this.getBoundForCollisionWithEnemy());
//            super.setStartX((float)r1.getX() + (float)r1.getWidth());
//            //speedX = 0;
//        }
//        if (super.getGameWorld().physicalMap.haveCollisionWithRightWall(super.getBoundForCollisionWithMap()) != null) {
//            Rectangle r2 = super.getGameWorld().physicalMap.haveCollisionWithRightWall(this.getBoundForCollisionWithEnemy());
//            super.setStartX((float)r2.getX() - (float)(r2.getWidth()));
//            //speedX = 0;
//        }
    }
}
