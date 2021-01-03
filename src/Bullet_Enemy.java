package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bullet_Enemy extends Enemy {
    public Bullet_Enemy(double startX, double startY, double width, double height, GameWorldState gameWorld) {
        super(startX, startY, width, height, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(1);
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void Attack() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub

    }

}
