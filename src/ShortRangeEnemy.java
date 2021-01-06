package src;

import javax.swing.*;
import java.awt.*;

public class ShortRangeEnemy extends Enemy {
    private Image img;
    private int speedX;
    private int speedY;
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
        super.setStartX(super.getStartX() - speedX);
        super.setStartY(super.getStartY() + speedY);
        if (super.getGameWorld().physicalMap.haveCollisionWithLeftWall(this.getLeftRect()) != null) {
            Rectangle r1 = super.getGameWorld().physicalMap.haveCollisionWithLeftWall(this.getLeftRect());
            super.setStartX(super.getStartX()+ r1.getWidth());
            //speedX = 0;
        }
        if (super.getGameWorld().physicalMap.haveCollisionWithRightWall(this.getRightRect()) != null) {
            Rectangle r2 = super.getGameWorld().physicalMap.haveCollisionWithRightWall(this.getRightRect());
            super.setStartX(super.getStartX() - getBoundForCollisionWithEnemy().getWidth());
            //speedX = 0;
        }
        if (super.getGameWorld().physicalMap.haveCollisionWithTop(getUpRect()) != null) {
            Rectangle r3 = super.getGameWorld().physicalMap.haveCollisionWithTop(getUpRect());
            speedY = 0;
            //resetJump();
            super.setStartY(super.getStartY() + super.getGameWorld().physicalMap.getTileSize());
        }
        if (super.getGameWorld().physicalMap.haveCollisionWithLand(getDownRect()) != null) {
            Rectangle r4 = super.getGameWorld().physicalMap.haveCollisionWithLand(getDownRect());
            speedY = 0;
            super.setStartY(super.getStartY() - (float)getBoundForCollisionWithEnemy().getHeight());
        }
    }
    public Rectangle getLeftRect(){
        Rectangle leftRect = getBoundForCollisionWithMap();
        leftRect.setBounds((int)super.getStartX(),(int)super.getStartY()+1,3,(int)getBoundForCollisionWithEnemy().getHeight() - 5);
        return leftRect;
    }
    public Rectangle getRightRect(){
        Rectangle rightRect = getBoundForCollisionWithMap();
        rightRect.setBounds((int)super.getStartX() + (int)getBoundForCollisionWithEnemy().getWidth() - 3,(int)super.getStartY(),3,(int)getBoundForCollisionWithEnemy().getHeight() - 5);
        return rightRect;
    }
    public Rectangle getDownRect() {
        Rectangle down = getBoundForCollisionWithEnemy();
        down.setBounds((int)super.getStartX(), (int)super.getStartY() + (int)getBoundForCollisionWithEnemy().getHeight(), (int)getBoundForCollisionWithEnemy().getWidth(), 3);
        return down;
    }
    public Rectangle getUpRect() {
        Rectangle up = getBoundForCollisionWithEnemy();
        up.setBounds((int)super.getStartX() , (int)super.getStartY() , (int)getBoundForCollisionWithEnemy().getWidth() , 8);
        return up;
    }
}
