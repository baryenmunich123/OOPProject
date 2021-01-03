package src;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Enemy {
    // public static final int Enemy_Team = 2;
    // public static final int ALIVE = 0;
    // public static final int BEHURT = 1;
    // public static final int FEY = 2;
    // public static final int DEATH = 3;
    // public static final int NOBEHURT = 4;
    // public static final int LEFT_DIRECTION = 0;
    // public static final int RIGHT_DIRECTION = 1;

    private double startX;
    private double startY;
    private double width;
    private double height;
    private int HP = 5;
    private GameWorldState gameWorld;

    private int damage;
    private int state;
    // private int direction;

    public Enemy(double startX, double startY, double width, double height, GameWorldState gameWorld) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.gameWorld = gameWorld;
        // direction = RIGHT_DIRECTION;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getHP() {
        return HP;
    }

    public GameWorldState getGameWorld() {
        return gameWorld;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setHP(int hP) {
        HP = hP;
    }

    public void setGameWorld(GameWorldState gameWorld) {
        this.gameWorld = gameWorld;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getBoundForCollisionWithMap() {
        Rectangle bound = new Rectangle();
        bound.x = (int) (getStartX() - getWidth() / 2);
        bound.y = (int) (getStartY() - getHeight() / 2);
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
        return bound;
    }

    // public void drawBoundForCollisionWithMap(Graphics2D g2) {
    // Rectangle rect = getBoundForCollisionWithMap();
    // g2.setColor(Color.BLUE);
    // g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int)
    // getGameWorld().camera.getPosY(),
    // rect.width, rect.height);
    // }

    // public void drawBoundForCollisionWithEnemy(Graphics2D g2) {
    // Rectangle rect = getBoundForCollisionWithEnemy();
    // g2.setColor(Color.RED);
    // g2.drawRect(rect.x - (int) getGameWorld().camera.getPosX(), rect.y - (int)
    // getGameWorld().camera.getPosY(),
    // rect.width, rect.height);
    // }

    public void damaged(int megamanBullet) {
        this.HP = HP - megamanBullet;
        state = 1;
        damagedUpdate();
    }

    public void updateState() {
        switch (state) {
            case 0: // Alive
                // Megaman man = getGameWorld().megaman.getCollisionWithEnemy(this);
                Bullet_Megaman bullet = gameWorld.Bullet_Megaman_Manager.getCollisionEnemy(this);
                if (bullet.getDamage() > 0)
                    state = 1;
                break;
            case 1: // Damaged;
                if (this.HP == 0)
                    state = 2;
                break;
            case 2: // Death
                break;
        }
    }

    public boolean checkVisible() {
        if (this.startX - getGameWorld().camera.getX() > getGameWorld().camera.getWidth()
                || this.startX - getGameWorld().camera.getX() < -50
                || this.startY - getGameWorld().camera.getY() > getGameWorld().camera.getHeight()
                || this.startY - getGameWorld().camera.getY() < -50)
            return true;
        return false;
    }

    public void damagedUpdate() {
    };

    public abstract Rectangle getBoundForCollisionWithEnemy();

    public abstract void Attack();

    public abstract void draw(Graphics2D g2);

}