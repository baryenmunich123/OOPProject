package src;
import acm.graphics.*;
import java.awt.*;


import acm.util.*;

import java.awt.Graphics2D;
import java.util.*;
import javax.swing.*;

public class Megaman extends GCompound {
	private float x;
	private float y;
	private int speedX;
	private int speedY;
	private int state;
	
	private GameWorldState gameWorld;
	
	private GImage StandRight;
	private GImage StandLeft;
	private GImage RunRight1;
	private GImage RunRight2;
	private GImage RunRight3;
	private GImage RunLeft1;
	private GImage RunLeft2;
	private GImage RunLeft3;
	private GImage JumpRight;
	private GImage JumpLeft;
	private GImage ShootRight;
	private GImage ShootLeft;
	private GImage RunShootRight1;
	private GImage RunShootRight2;
	private GImage RunShootRight3;
	private GImage RunShootLeft1;
	private GImage RunShootLeft2;
	private GImage RunShootLeft3;
	private GImage JumpShootRight;
	private GImage JumpShootLeft;
	private GImage DamageRight;
	private GImage DamageLeft;
	
	private GRectangle LeftRect;
	private GRectangle RightRect;
	private GRectangle UpRect;
	private GRectangle DownRect;
	private GRectangle BodyRect;
	
	private int Direction = 2; //1 is Left, 2 is Right
	private int HP = 20;
	private int Falling = 0;
	private int Shooting = 0;
	private long ShootTimer;
	private long StartDamageTimer = 0;
	private long EndDamageTimer;
	
	public Megaman(float x, float y, GameWorldState gameWorld) {
		this.x = x;
		this.y = y;
		this.gameWorld = gameWorld;
		StandRight = new GImage(MediaTools.loadImage("Image/con1.png"), 0, 0);
		StandLeft = new GImage(MediaTools.loadImage("Image/con1_reverse.png"), 0, 0);
		RunRight1 = new GImage(MediaTools.loadImage("Image/con4.png"), 0, 0);
		RunRight2 = new GImage(MediaTools.loadImage("Image/con5.png"), 0, 0);
		RunRight3 = new GImage(MediaTools.loadImage("Image/con6.png"), 0, 0);
		RunLeft1 = new GImage(MediaTools.loadImage("Image/con4_reverse.png"), 0, 0);
		RunLeft2 = new GImage(MediaTools.loadImage("Image/con5_reverse.png"), 0, 0);
		RunLeft3 = new GImage(MediaTools.loadImage("Image/con6_reverse.png"), 0, 0);
		JumpRight = new GImage(MediaTools.loadImage("Image/con7.png"), 0, 0);
		JumpLeft = new GImage(MediaTools.loadImage("Image/con7_reverse.png"), 0, 0);
		ShootRight = new GImage(MediaTools.loadImage("Image/shoot1.png"), 0, 0);
		ShootLeft = new GImage(MediaTools.loadImage("Image/shoot1_reverse.png"), 0, 0);
		RunShootRight1 = new GImage(MediaTools.loadImage("Image/shoot2.png"), 0, 0);
		RunShootRight2 = new GImage(MediaTools.loadImage("Image/shoot3.png"), 0, 0);
		RunShootRight3 = new GImage(MediaTools.loadImage("Image/shoot4.png"), 0, 0);
		RunShootLeft1 = new GImage(MediaTools.loadImage("Image/shoot2_reverse.png"), 0, 0);
		RunShootLeft2 = new GImage(MediaTools.loadImage("Image/shoot3_reverse.png"), 0, 0);
		RunShootLeft3 = new GImage(MediaTools.loadImage("Image/shoot4_reverse.png"), 0, 0);
		JumpShootRight = new GImage(MediaTools.loadImage("Image/shoot5.png"), 0, 0);
		JumpShootLeft = new GImage(MediaTools.loadImage("Image/shoot5_reverse.png"), 0, 0);
		DamageRight = new GImage(MediaTools.loadImage("Image/hit1.png"), 0, 0);
		DamageLeft = new GImage(MediaTools.loadImage("Image/hit1_reverse.png"), 0, 0);
		
		LeftRect = new GRectangle(this.x, this.y + 1, 3, StandRight.getHeight() - 5);
		RightRect = new GRectangle(this.x + StandRight.getWidth() - 3, this.y, 3, StandRight.getHeight() - 5);
		UpRect = new GRectangle(this.x + 1, this.y - 1, StandRight.getWidth() - 2, 3);
		DownRect = new GRectangle(this.x + 1, this.y + StandRight.getHeight() - 3, StandRight.getWidth() - 2, 3);
		BodyRect = new GRectangle(this.x, this.y, StandRight.getWidth(), StandRight.getHeight());
		
		/*add(StandRight);
		add(StandLeft);
		add(RunRight1);
		add(RunRight2);
		add(RunRight3);
		add(RunLeft1);
		add(RunLeft2);
		add(RunLeft3);
		add(JumpRight);
		add(JumpLeft);
		add(ShootRight);
		add(ShootLeft);
		add(RunShootRight1);
		add(RunShootRight2);
		add(RunShootRight3);
		add(RunShootLeft1);
		add(RunShootLeft2);
		add(RunShootLeft3);
		add(JumpShootRight);
		add(JumpShootLeft);
		add(DamageRight);
		add(DamageLeft);*/
	}
	
	//public /*void*/ GImage Control(int move, int Direction, int Jump, int Falling, int Damage) {
		/*this.Direction = Direction;
		if (this.HP <= 0) {
			Die();
		}
		if (move == 6 && Damage == 0 && Jump == 0) {
			/*this.Direction = 2;
			StandRight.setVisible(false);
			StandLeft.setVisible(false);
			RunLeft1.setVisible(false);
			RunLeft2.setVisible(false);
			RunLeft3.setVisible(false);
			JumpRight.setVisible(false);
			JumpLeft.setVisible(false);
			ShootRight.setVisible(false);
			ShootLeft.setVisible(false);
			RunShootRight1.setVisible(false);
			RunShootRight2.setVisible(false);
			RunShootRight3.setVisible(false);
			RunShootLeft1.setVisible(false);
			RunShootLeft2.setVisible(false);
			RunShootLeft3.setVisible(false);
			JumpShootRight.setVisible(false);
			JumpShootLeft.setVisible(false);
			DamageRight.setVisible(false);
			DamageLeft.setVisible(false);
			RunRight1.setVisible(true);
			move(1/4, 0);
			RunRight1.setVisible(false);
			RunRight2.setVisible(true);
			move(1/4, 0);
			RunRight2.setVisible(false);
			RunRight3.setVisible(true);
			move(1/4, 0);
			RunRight3.setVisible(false);
			RunRight2.setVisible(true);
			move(1/4, 0);
			RunRight2.setVisible(false);*/
			/*return RunRight1;
		}
		if (move == 4 && Damage == 0 && Jump == 0) {
			/*this.Direction = 1;
			StandRight.setVisible(false);
			StandLeft.setVisible(false);
			RunRight1.setVisible(false);
			RunRight2.setVisible(false);
			RunRight3.setVisible(false);
			JumpRight.setVisible(false);
			JumpLeft.setVisible(false);
			ShootRight.setVisible(false);
			ShootLeft.setVisible(false);
			RunShootRight1.setVisible(false);
			RunShootRight2.setVisible(false);
			RunShootRight3.setVisible(false);
			RunShootLeft1.setVisible(false);
			RunShootLeft2.setVisible(false);
			RunShootLeft3.setVisible(false);
			JumpShootRight.setVisible(false);
			JumpShootLeft.setVisible(false);
			DamageRight.setVisible(false);
			DamageLeft.setVisible(false);
			RunLeft1.setVisible(true);
			move(1/4, 0);
			RunLeft1.setVisible(false);
			RunLeft2.setVisible(true);
			move(1/4, 0);
			RunLeft2.setVisible(false);
			RunLeft3.setVisible(true);
			move(1/4, 0);
			RunLeft3.setVisible(false);
			RunLeft2.setVisible(true);
			move(1/4, 0);
			RunLeft2.setVisible(false);*/
			/*return RunLeft1;
		}
		if (move == 0 && Damage == 0 && Jump == 0) {
			if (this.Direction == 2) {
				/*StandRight.setVisible(true);
				StandLeft.setVisible(false);
				RunRight1.setVisible(false);
				RunRight2.setVisible(false);
				RunRight3.setVisible(false);
				RunLeft1.setVisible(false);
				RunLeft2.setVisible(false);
				RunLeft3.setVisible(false);
				JumpRight.setVisible(false);
				JumpLeft.setVisible(false);
				ShootRight.setVisible(false);
				ShootLeft.setVisible(false);
				RunShootRight1.setVisible(false);
				RunShootRight2.setVisible(false);
				RunShootRight3.setVisible(false);
				RunShootLeft1.setVisible(false);
				RunShootLeft2.setVisible(false);
				RunShootLeft3.setVisible(false);
				JumpShootRight.setVisible(false);
				JumpShootLeft.setVisible(false);
				DamageRight.setVisible(false);
				DamageLeft.setVisible(false);*/
				/*return StandRight;
			}
			if (this.Direction == 1) {
				/*StandRight.setVisible(false);
				StandLeft.setVisible(true);
				RunRight1.setVisible(false);
				RunRight2.setVisible(false);
				RunRight3.setVisible(false);
				RunLeft1.setVisible(false);
				RunLeft2.setVisible(false);
				RunLeft3.setVisible(false);
				JumpRight.setVisible(false);
				JumpLeft.setVisible(false);
				ShootRight.setVisible(false);
				ShootLeft.setVisible(false);
				RunShootRight1.setVisible(false);
				RunShootRight2.setVisible(false);
				RunShootRight3.setVisible(false);
				RunShootLeft1.setVisible(false);
				RunShootLeft2.setVisible(false);
				RunShootLeft3.setVisible(false);
				JumpShootRight.setVisible(false);
				JumpShootLeft.setVisible(false);
				DamageRight.setVisible(false);
				DamageLeft.setVisible(false);*/
				/*return StandLeft;
			}
		}
		return StandRight;
		
	}*/
	public void run() {
		if(Direction == 1) {
			this.speedX = -3;
		}
		else {
			this.speedX = 3;
		}
	}
	public void stopRunning() {
		this.speedX = 0;
	}
	public void jump() {
		if (Falling == 0) {
			Falling = 1;
			this.speedY = -5;
		}
	}
	public void shoot() {
		if (Shooting == 0) {
			Shooting = 1;
			Bullet_Megaman bullet = new Bullet_Megaman(this.x, this.y + (float)(StandRight.getHeight()/4), gameWorld);
			gameWorld.Bullet_Megaman_Manager.add(bullet);
			if (Direction == 1) {
				bullet.setSpeedX(-2);
			}
			else {
				bullet.setX(this.x + (float)StandRight.getWidth());
				bullet.setSpeedX(2);
			}
			ShootTimer = System.currentTimeMillis();
		}
	}
	public void Die() {
		
	}
	public void draw(Graphics2D g2) {
		switch(state) {
		case 0: //Alive
		case 4: //Normal
			if (Falling == 1) {
				if (Direction == 1) {
					if(Shooting == 0) {
						g2.drawImage(JumpLeft.getImage(), (int)x, (int)y, null);
					}
					else {
						g2.drawImage(JumpShootLeft.getImage(), (int)x, (int)y, null);
					}
				}
				else {
					if (Shooting == 0) {
						g2.drawImage(JumpRight.getImage(), (int)x, (int)y, null);
					}
					else {
						g2.drawImage(JumpShootRight.getImage(), (int)x, (int)y, null);
					}
				}
			}
			else {
				if (speedX > 0) {
					if (Direction == 2) {
						if (Shooting == 0) {
							g2.drawImage(RunRight1.getImage(), (int)x, (int)y, null);
							g2.dispose();
							g2.drawImage(RunRight2.getImage(), (int)x+1, (int)y, null);
							g2.dispose();
							g2.drawImage(RunRight3.getImage(), (int)x+2, (int)y, null);
							g2.dispose();
						}
						else {
							g2.drawImage(RunShootRight1.getImage(), (int)x, (int)y, null);
							g2.dispose();
							g2.drawImage(RunShootRight2.getImage(), (int)x+1, (int)y, null);
							g2.dispose();
							g2.drawImage(RunShootRight3.getImage(), (int)x+2, (int)y, null);
							g2.dispose();
						}
					}
					else {
						if (Shooting == 0) {
							g2.drawImage(RunLeft1.getImage(), (int)x, (int)y, null);
							g2.dispose();
							g2.drawImage(RunLeft2.getImage(), (int)x-1, (int)y, null);
							g2.dispose();
							g2.drawImage(RunLeft3.getImage(), (int)x-2, (int)y, null);
							g2.dispose();
						}
						else {
							g2.drawImage(RunShootLeft1.getImage(), (int)x, (int)y, null);
							g2.dispose();
							g2.drawImage(RunShootLeft2.getImage(), (int)x-1, (int)y, null);
							g2.dispose();
							g2.drawImage(RunShootLeft3.getImage(), (int)x-2, (int)y, null);
							g2.dispose();
						}
					}
				}
				else {
					if(Direction == 1) {
						if (Shooting == 0) {
							g2.drawImage(StandLeft.getImage(), (int)x, (int)y, null);
						}
						else {
							g2.drawImage(ShootLeft.getImage(), (int)x, (int)y, null);
						}
					}
					else {
						if (Shooting == 0) {
							g2.drawImage(StandRight.getImage(), (int)x, (int)y, null);
						}
						else {
							g2.drawImage(ShootRight.getImage(), (int)x, (int)y, null);
						}
					}
				}
			}
			break;
		case 1: //Damaged
			if (Direction == 1) {
				g2.drawImage(DamageLeft.getImage(), (int)x, (int)y, null);
				g2.dispose();
				g2.drawImage(DamageLeft.getImage(), (int)x+1, (int)y, null);
				g2.dispose();
				g2.drawImage(DamageLeft.getImage(), (int)x+2, (int)y, null);
			}
			else {
				g2.drawImage(DamageRight.getImage(), (int)x, (int)y, null);
				g2.dispose();
				g2.drawImage(DamageRight.getImage(), (int)x-1, (int)y, null);
				g2.dispose();
				g2.drawImage(DamageRight.getImage(), (int)x-2, (int)y, null);
			}
			break;
		}
			
	}
	public void Update() {
		switch (state) {
		case 0: //Alive
			Enemy object = gameWorld.EnemyManager.getCollisionMegaman(this);
			if (object != null) {
				if (object.getDamage() != 0) {
					//HP = HP - object.getDamage();
					state = 1;
				}
			}
			break;
		case 1: //Damaged
			Enemy object1 = gameWorld.EnemyManager.getCollisionMegaman(this);
			if (System.currentTimeMillis() - StartDamageTimer > 80) {
				StartDamageTimer = System.currentTimeMillis();
				HP = HP - object1.getDamage();
				if (Direction == 1) {
					set_X(this.x + 2);
					speedX = 0;
				}
				else {
					if (Direction == 2) {
						set_X(this.x - 2);
						speedX = 0;
					}
				}
				if (HP == 0) {
					state = 2;
				}
			}
			break;
		case 2: //Death
			break;
		}
		if (state == 1 || state == 0) {
			if (Falling == 0) {
				set_X(x + speedX);
				if (Direction == 1 && gameWorld.PhysicalMap.haveCollisionWithLeftWall(this.getBodyRect()) != null) {
					Rectangle r1 = gameWorld.PhysicalMap.collisionWithLeftWall(this.getBodyRect());
					set_X((float)r1.getX() + (float)r1.getWidth());
				}
				if (Direction == 1 && gameWorld.PhysicalMap.haveCollisionWithRightWall(this.getBodyRect()) != null) {
					Rectangle r2 = gameWorld.PhysicalMap.collisionWithLeftWall(this.getBodyRect());
					set_X((float)r2.getX() - (float)BodyRect.getWidth());
				}
				if (gameWorld.PhysicalMap.haveCollisionWithTop(getUpRect())) {
					Rectangle r3 = gameWorld.PhysicalMap.haveCollisionWithTop(getUpRect());
					speedY = 0;
					set_Y((float)r3.getY() + gameWorld.PhysicalMap.getTileSize());
				}
				if (gameWorld.PhysicalMap.haveCollisionWithLand(getDownRect())) {
					Rectangle r4 = gameWorld.PhysicalMap.haveCollisionWithLand(getDownRect());
					Falling = 0;
					speedY = 0;
					set_Y((float)r4.getY() - (float)BodyRect.getHeight());
				}
				else {
					Falling = 1;
					speedY = -5;
					set_Y(y + speedY);
				}
			}
		}
		if (Shooting == 1) {
			if (System.currentTimeMillis() - ShootTimer > 20) {
				Shooting = 0;
			}
		}
	}
	//public GImage getStandRight() {
		//return StandRight;
	//}
	public float get_X() {
		return x;
	}
	public void set_X(float x) {
		this.x = x;
	}
	public float get_Y() {
		return y;
	}
	public void set_Y(float y) {
		this.y = y;
	}
	public void setDirection(int Direction) {
		this.Direction = Direction;
	}
	public int getDirection() {
		return Direction;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getState() {
		return state;
	}
	public Rectangle getBodyRect() {
		Rectangle body = BodyRect.toRectangle();
		body.setBounds((int)x, (int)y, (int)BodyRect.getWidth(), (int)BodyRect.getHeight());
		return body;
	}
	public Rectangle getDownRect() {
		Rectangle down = DownRect.toRectangle();
		down.setBounds((int)this.x + 1, (int)this.y + (int)StandRight.getHeight() - 3, (int)StandRight.getWidth() - 2, 3);
		return down;
	}
	public Rectangle getUpRect() {
		Rectangle up = UpRect.toRectangle();
		up.setBounds((int)this.x + 1, (int)this.y - 1, (int)StandRight.getWidth() - 2, 3);
		return up;
	}
}
