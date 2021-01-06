package src;

import java.awt.*;

public class ShortRangeEnemy extends Enemy {
    public ShortRangeEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
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
    
    }

    @Override
    public void updateState() {
        super.updateState();

    }
}
