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
	public void Update() {
		synchronized(bullet) {
			for (int i = 0; i < bullet.size(); i++) {
				Bullet_Megaman object = bullet.get(i);
				if (object.OutOfView() || object.getState() == 2) {
					bullet.remove(i);
				}
			}
		}
	}
	
}
