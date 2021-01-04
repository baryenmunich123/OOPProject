package src;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameWorldState {
	private BufferedImage bufferedImage;
	private int state = 1;
	private int bossfight = 1;

	public static final int game = 1;
	public static final int boss = 2;
	public static final int win = 3;
	public static final int lose = 4;

	public Megaman megaman;
	public PhysicalMap physicalMap;
	public BackgroundMap backgroundMap;
	public Camera camera;
	public Bullet_Megaman_Manager Bullet_Megaman_Manager;
	public Enemy_Manager Enemy_Manager;

	public GameWorldState() {
		bufferedImage = new BufferedImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		megaman = new Megaman(20, 20, this);
		physicalMap = new PhysicalMap(0, 0, this);
		backgroundMap = new BackgroundMap(0, 0, this);
		camera = new Camera(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, this);
		Bullet_Megaman_Manager = new Bullet_Megaman_Manager(this);
		Enemy_Manager = new Enemy_Manager(this);
		initializeEnemy();
	}

	public void initializeEnemy() {
		Enemy e1 = new StandingEnemy(100, 100, this);
		Enemy_Manager.addEnemy(e1);
		Enemy e1 = new StandingEnemy(500, 100, this);
		Enemy_Manager.addEnemy(e1);
		Enemy e1 = new StandingEnemy(1000, 100, this);
		Enemy_Manager.addEnemy(e1);
		Enemy e1 = new StandingEnemy(1250, 100, this);
		Enemy_Manager.addEnemy(e1);
	}

	public void Update() {
		switch (state) {
			case game:
				megaman.Update();
				Bullet_Megaman_Manager.Update();
				camera.Update();
				physicalMap.Update();
				Enemy_Manager.UpdateEnemy();
				if (megaman.get_X() >= 2500 && bossfight == 1) {
					state = boss;
				}
				if (megaman.getHP() == 0) {
					state = lose;
				}
				if (Enemy_Manager.getSize() == 0) {
					state = win;
				}
				break;
			case boss:
				// Remove all enemies here
				if (megaman.get_X() < 3000 && bossfight == 1) {
					megaman.run();
					camera.setX(camera.getX() + 2);
				} else {
					bossfight = 0;
					megaman.stopRunning();
					state = game;
				}
				break;
			case lose:
				break;
			case win:
				break;
		}
	}

	public void Render() {
		Graphics2D g2 = (Graphics2D) bufferedImage.getGraphics();
		if (g2 != null) {
			switch (state) {
				case win:
				case game:
					backgroundMap.draw(g2);
					Enemy_Manager.draw(g2);
					megaman.draw(g2);
					Bullet_Megaman_Manager.draw(g2);
					g2.setColor(Color.GRAY);
					g2.fillRect(59, 19, 22, 102);
					g2.setColor(Color.YELLOW); // 79 pixels, each 3
					for (int i = 1; i <= megaman.getHP(); i++) {
						g2.fillRect(20, 60 + 3 * i + i, 20, 3);
					}
					if (state == win) {
						g2.setColor(Color.BLACK);
						g2.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
						g2.setColor(Color.WHITE);
						g2.drawString("YOU WIN", 450, 300);
						break;
					}
				case lose:
					g2.setColor(Color.BLACK);
					g2.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
					g2.setColor(Color.WHITE);
					g2.drawString("GAME OVER!", 450, 300);
					break;
			}
		}
	}

	public void setPressedButton(int code) {
		switch (code) {
			case KeyEvent.VK_LEFT:
				megaman.setDirection(1);
				megaman.run();
				break;
			case KeyEvent.VK_RIGHT:
				megaman.setDirection(2);
				megaman.run();
				break;
			case KeyEvent.VK_Z:
				megaman.jump();
				break;
			case KeyEvent.VK_X:
				megaman.shoot();
				break;
		}
	}

	public void setReleasedButton(int code) {
		switch (code) {
			case KeyEvent.VK_LEFT:
				if (megaman.getSpeedX() < 0) {
					megaman.stopRunning();
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (megaman.getSpeedX() > 0) {
					megaman.stopRunning();
				}
				break;
			case KeyEvent.VK_Z:
				break;
			case KeyEvent.VK_X:
				break;
		}
	}
}
