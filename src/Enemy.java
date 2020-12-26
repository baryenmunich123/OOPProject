import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Enemy {
    // public static final int Enemy_Team = 2;
    // public static final int ALIVE = 0;
    // public static final int BEHURT = 1;
    // public static final int FEY = 2;
    // public static final int DEATH = 3;
    // public static final int NOBEHURT = 4;

    private double startX;
    private double startY;
    private GameWorldSate gameWorld;
    private int state;
    private double width;
    private double height;
    private double mass;
    private int HP;
    private int damage;
    // private int direction;

    public Enemy(double startX, double startY, double width, double height, double mass, int HP,
            GameWorldSate gameWorld) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.mass = mass;
        this.HP = HP;
        this.gameWorld = gameWorld;
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

    public double getMass() {
        return mass;
    }

    public int getHP() {
        return HP;
    }

    public GameWorldSate getGameWorld() {
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

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setHP(int hP) {
        HP = hP;
    }

    public void setGameWorld(GameWorldSate gameWorld) {
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

    public abstract void Attack();

    public Rectangle getBoundCollisionWithMap() {
        Rectangle bound = new Rectangle();
        bound.x = (int) (getStartX() - getWidth() / 2);
        bound.y = (int) (getStartY() - getHeight() / 2);
        bound.width = (int) getWidth();
        bound.height = (int) getHeight();
    }

    public void damaged(int megamanBullet) {
        this.HP = HP - megamanBullet;
        state = 1;
        // damagedUpdate();
    }

    public void updateState() {
        switch (state) {
            case 0: // Alive
                Megaman object = new Megaman();
                if (object != null) {
                    if (object.getDamage() > 0)
                        state = 1;
                }
                break;
            case 1: // Damaged;
                if (this.HP == 0)
                    state = 2;
                break;
            case 2: // Death
                break;
        }
    }

    // public void damagedUpdate(){};

    public abstract void draw(Graphics2D g2);
}