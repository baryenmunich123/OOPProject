package src;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Bullet_Megaman_Manager {
	ArrayList <Bullet_Megaman> bullet = new ArrayList<Bullet_Megaman>();
	private GameWorldState gameWorld;
	public Bullet_Megaman_Manager(GameWorldState gameWorld) {
		this.gameWorld = gameWorld;
	}
	public void add(Bullet_Megaman object) {
		bullet.add(object);
	}
	public void Update() {
		synchronized(bullet) {
			for (int i = 0; i < bullet.size(); i++) {
				Bullet_Megaman object = bullet.get(i);
				if (object.OutOfView() || object.getState() == 2) {
					bullet.remove(i);
				}
			}
			return null;
		}
	}
	public Bullet_Megaman getCollisionEnemy(Enemy object) {
		synchronized(bullet) {
			for (Bullet_Megaman e: bullet) {
				if (e.bound().intersects(object.getBoundForCollisionWithEnemy())) {
					return e;
				}
			}
		}
	}
	public void draw(Graphics2D g2) {
		synchronized(bullet) {
			for(Bullet_Megaman object : bullet) {
				if (!object.OutOfView()) {
					object.draw(g2);
				}
			}
		}
	}
	
}
