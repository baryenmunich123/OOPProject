package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StandingEnemy extends Enemy {
    private long startTimeToShoot = 0;
    private BufferedImage image;

    public StandingEnemy(double startX, double startY, GameWorldState gameWorld) {
        super(startX, startY, 50, 50, gameWorld);
        // TODO Auto-generated constructor stub
        setDamage(10);
        setHP(30);
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Enemy1.png"));
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
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
        getGameWorld().Enemy_Manager.addEnemy(bullet);
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO Auto-generated method stub
        if (!OutOfView()) {
            g2.drawImage(image, (int) super.getStartX(), (int) super.getStartY(), null);
        }
    }

    public void Update() {
        super.updateState();
        if (System.nanoTime() - startTimeToShoot > 1000 * 100000000) {
            Attack();
            startTimeToShoot = System.nanoTime();
        }
    }
}
