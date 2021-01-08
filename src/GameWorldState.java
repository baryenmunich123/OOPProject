package src;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameWorldState {
	private BufferedImage bufferedImage;
	private int state = 1;
	private int bossfight = 1;
	private Enemy bossEnemy;

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
		megaman = new Megaman(200, 443, this); // 200, 443 starting position
		physicalMap = new PhysicalMap(0, 0, this);
		backgroundMap = new BackgroundMap(0, 0, this);
		camera = new Camera(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT, this);
		Bullet_Megaman_Manager = new Bullet_Megaman_Manager(this);
		Enemy_Manager = new Enemy_Manager(this);
		bossEnemy = new Boss(11700, 690, this);
		Enemy_Manager.addEnemy(bossEnemy);
		initializeEnemy();
	}

	public void initializeEnemy() {
		Enemy e1 = new StandingEnemy(1100, 482, this);
		Enemy_Manager.addEnemy(e1);
		Enemy e2 = new StandingEnemy(3500, 510, this);
		Enemy_Manager.addEnemy(e2);
		Enemy e3 = new StandingEnemy(2840, 660, this);
		Enemy_Manager.addEnemy(e3);
		//Enemy e4 = new StandingEnemy(5000, 600, this);
		//Enemy_Manager.addEnemy(e4);
		Enemy e5 = new ShortRangeEnemy(1800,720,this);
		Enemy_Manager.addEnemy(e5);
		Enemy e6 = new FlyEnemy(2400,600,this);
		Enemy_Manager.addEnemy(e6);
		Enemy e7 = new FlyShootEnemy(2000,400,this);
		Enemy_Manager.addEnemy(e7);
		Enemy e8 = new ShortRangeEnemy(1100,300,this);
		Enemy_Manager.addEnemy(e8);
		Enemy e9 = new ShortRangeEnemy(3500, 400, this);
		Enemy_Manager.addEnemy(e9);
		Enemy e10 = new FlyShootEnemy(2800,400,this);
		Enemy_Manager.addEnemy(e10);
		Enemy e11 = new ShortRangeEnemy(3700, 482, this);
		Enemy_Manager.addEnemy(e11);
		Enemy e12 = new FlyEnemy(3750,400,this);
		Enemy_Manager.addEnemy(e12);
		Enemy e13 = new ShortRangeEnemy(3900, 482, this);
		Enemy_Manager.addEnemy(e13);
		Enemy e14 = new FlyEnemy(4050,400,this);
		Enemy_Manager.addEnemy(e14);
		Enemy e15 = new ShortRangeEnemy(4150, 482, this);
		Enemy_Manager.addEnemy(e15);
		Enemy e16 = new FlyEnemy(4350,400,this);
		Enemy_Manager.addEnemy(e16);
		Enemy e17= new FlyEnemy(5340, 440, this);
		Enemy_Manager.addEnemy(e17);
//		Enemy boss = new Boss(400,430,this);
//		Enemy_Manager.addEnemy(boss);
		Enemy e18= new FlyEnemy(5550, 390, this);
		Enemy_Manager.addEnemy(e18);
		Enemy e19 = new StandingEnemy(5490, 270, this);
		Enemy_Manager.addEnemy(e19);
		Enemy e20 = new ShortRangeEnemy(5760, 50, this);
		Enemy_Manager.addEnemy(e20);
		Enemy_Manager.addEnemy(e20);
		Enemy e21 = new FlyShootEnemy(6180,425,this);
		Enemy_Manager.addEnemy(e21);
		Enemy e22 = new FlyShootEnemy(6180,200,this);
		Enemy_Manager.addEnemy(e22);
		Enemy e23 = new StandingEnemy(6870, 600, this);
		Enemy_Manager.addEnemy(e23);
		Enemy e24 = new StandingEnemy(7050, 600, this);
		Enemy_Manager.addEnemy(e24);
		Enemy e25= new FlyEnemy(7160, 500, this);
		Enemy_Manager.addEnemy(e25);
		Enemy e26= new FlyEnemy(7360, 500, this);
		Enemy_Manager.addEnemy(e26);
		Enemy e27 = new StandingEnemy(7500, 600, this);
		Enemy_Manager.addEnemy(e27);
		Enemy e28 = new ShortRangeEnemy(7500, 400, this);
		Enemy_Manager.addEnemy(e28);
		Enemy e29 = new ShortRangeEnemy(7900, 400, this);
		Enemy_Manager.addEnemy(e29);
		Enemy e30 = new ShortRangeEnemy(8395, 400, this);
		Enemy_Manager.addEnemy(e30);
		Enemy e31 = new FlyShootEnemy(8200,380,this);
		Enemy_Manager.addEnemy(e31);
		Enemy e32 = new ShortRangeEnemy(8450, 100, this);
		Enemy_Manager.addEnemy(e32);
		Enemy e33 = new FlyShootEnemy(8900,380,this);
		Enemy_Manager.addEnemy(e33);
		Enemy e34 = new FlyShootEnemy(9080,380,this);
		Enemy_Manager.addEnemy(e34);
		Enemy e35 = new FlyShootEnemy(9270,380,this);
		Enemy_Manager.addEnemy(e35);
		Enemy e36 = new ShortRangeEnemy(10500, 500, this);
		Enemy_Manager.addEnemy(e36);
		Enemy_Manager.addEnemy(e36);
		Enemy e37 = new ShortRangeEnemy(10750, 750, this);
		Enemy_Manager.addEnemy(e37);
		Enemy e38 = new StandingEnemy(10900, 780, this);
		Enemy_Manager.addEnemy(e38);
		Enemy e39 = new ShortRangeEnemy(10950, 750, this);
		Enemy_Manager.addEnemy(e39);
		Enemy e40 = new StandingEnemy(11000, 780, this);
		Enemy_Manager.addEnemy(e40);
		//bossEnemy = new Boss(11700, 680, this);
		//Enemy_Manager.addEnemy(bossEnemy);
		
	}

	public void Update() {
		switch (state) {
			case game:
				megaman.Update();
				Bullet_Megaman_Manager.Update();
				camera.Update();
				physicalMap.Update();
				Enemy_Manager.UpdateEnemy();
				if (megaman.get_X() >= 25000 && bossfight == 1) {
					state = boss;
					break;
				}
				if (megaman.getHP() <= 0) {
					state = lose;
					break;
				}
				if (bossEnemy.getHP() <= 0) {
					state = win;
					break;
				}
				break;
			case boss:
				// Remove all enemies here
				
				if (megaman.get_X() < 30000 && bossfight == 1) {
					megaman.run();
					camera.setX(camera.getX() + 2);
				} else {
					bossfight = 0;
					megaman.stopRunning();
					camera.lock();
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
					//g2.setColor(Color.GRAY);
					//g2.fillRect(59, 19, 22, 102);
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
					break;
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
				megaman.resetJump();
				break;
			case KeyEvent.VK_X:
				break;
		}
	}
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
}
