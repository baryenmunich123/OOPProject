package src;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Bullet_Megaman {
	private float x;
	private float y;
	private int speedX = 6;
	private int damage = 1;
	private int state = 1;
	private GameWorldState gameWorld;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX * this.speedX;
	}
	public Bullet_Megaman(float x, float y, GameWorldState gameWorld) {
		this.state = 1;
		this.x = x;
		this.y = y;
		this.gameWorld = gameWorld;
	}
	public Rectangle bound() {
		Rectangle rect = new Rectangle((int)x, (int)y, 20, 20);
		return rect;
	}
	public void draw(Graphics2D g2) {
		g2.setColor(Color.YELLOW);
		g2.drawOval((int)x, (int)y, 10, 10);
		g2.fillOval((int)x, (int)y, 10, 10);
	}
	public boolean OutOfView() {
		if (x - gameWorld.camera.getX() > (gameWorld.camera.getWidth() + 10) || (x - 20) < gameWorld.camera.getX() || y - gameWorld.camera.getY() > (gameWorld.camera.getHeight() + 10) || (y - 20) < gameWorld.camera.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void Update() {
		switch(state) {
		case 1:
			x = x + speedX;
			Enemy object = gameWorld.Enemy_Manager.getCollisionBullet(this);
			if (object != null && object.getState() == 1 /*Alive*/) {
				object.setHP(object.getHP() - damage);
				state = 2;
			}
		case 2:
			break;
		}
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
}
