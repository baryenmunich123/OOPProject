package src;

import javax.swing.*;
import java.awt.*;

public class ShortRangeEnemy extends Enemy {
    private Image img;

    private int speedX = -3, speedY = 5;

    public ShortRangeEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        setDamage(3);
        setHP(3);
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
                (int) super.getStartY() - (int) super.getGameWorld().camera.getY() - 50 + 5, null);
    }

    @Override
    public void updateState() {
        super.updateState();

        super.setStartX(super.getStartX() + speedX);
        super.setStartY(super.getStartY() + speedY);
        if (super.getGameWorld().physicalMap.haveCollisionWithLeftWall(getLeftRect()) != null) {
            Rectangle r1 = super.getGameWorld().physicalMap.haveCollisionWithLeftWall(getLeftRect());
            super.setStartX((float)r1.getX() + (float)r1.getWidth());
            speedX = 3;
        }
        if (super.getGameWorld().physicalMap.haveCollisionWithRightWall(getRightRect()) != null) {
            Rectangle r2 = super.getGameWorld().physicalMap.haveCollisionWithRightWall(getRightRect());
            super.setStartX((float)r2.getX() - (float)(super.getWidth()));
            speedX = -3;
        }
        if (super.getGameWorld().physicalMap.haveCollisionWithTop(getUpRect()) != null) {
			Rectangle r3 = super.getGameWorld().physicalMap.haveCollisionWithTop(getUpRect());
			speedY = 0;
			setStartY((float)r3.getY() + super.getGameWorld().physicalMap.getTileSize());
		}
		if (super.getGameWorld().physicalMap.haveCollisionWithLand(getDownRect()) != null) {
			Rectangle r4 = super.getGameWorld().physicalMap.haveCollisionWithLand(getDownRect());
			speedY = 0;
			setStartY((float)r4.getY() - (float)super.getHeight() + 5);
		}
		else {
				speedY = 7;
		}

    }
    public Rectangle getLeftRect() {
		Rectangle left = new Rectangle();
		left.setBounds((int)super.getStartX(), (int)super.getStartY() + 1, 3, (int)super.getHeight() - 5);
		return left;
	}
	public Rectangle getRightRect() {
		Rectangle right = new Rectangle();
		right.setBounds((int)super.getStartX() + (int)super.getWidth() - 3, (int)super.getStartY() + 1, 3, (int)super.getHeight() - 5);
		return right;
	}
	public Rectangle getDownRect() {
		Rectangle down = new Rectangle();
		down.setBounds((int)super.getStartX() + 1, (int)super.getStartY() + (int)super.getHeight() -1, (int)super.getWidth() - 2, 3);
		return down;
	}
	public Rectangle getUpRect() {
		Rectangle up = new Rectangle();
		up.setBounds((int)super.getStartX() + 1, (int)super.getStartY() - 5, (int)super.getWidth() - 2, 8);
		return up;
	}
}

