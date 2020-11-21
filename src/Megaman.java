package src;
import acm.graphics.*;
import acm.util.*;
import java.util.*;

public class Megaman extends GCompound {
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
	
	private int Direction;
	private int HP = 20;
	private int Falling;
	private int DamageTimer = 24;
	
	public Megaman() {
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
		
		LeftRect = new GRectangle(StandRight.getX(), StandRight.getY() + 1, 3, StandRight.getHeight() - 5);
		RightRect = new GRectangle(StandRight.getX() + StandRight.getWidth() - 3, StandRight.getY(), 3, StandRight.getHeight() - 5);
		UpRect = new GRectangle(StandRight.getX() + 1, StandRight.getY() - 1, StandRight.getWidth() - 2, 3);
		DownRect = new GRectangle(StandRight.getX() + 1, StandRight.getY() + StandRight.getHeight() - 3, StandRight.getWidth() - 2, 3);
		BodyRect = new GRectangle(StandRight.getBounds());
		
		add(StandRight);
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
		add(DamageLeft);
	}
	
	public void Control(int move, int Direction, int Jump, int Falling, int Damage) {
		this.Direction = Direction;
		if (this.HP <= 0) {
			Die();
		}
		if (move == 6 && Damage == 0 && Jump == 0) {
			this.Direction = 2;
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
			RunRight2.setVisible(false);
		}
		if (move == 4 && Damage == 0 && Jump == 0) {
			this.Direction = 1;
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
			RunLeft2.setVisible(false);
		}
		if (move == 0 && Damage == 0 && Jump == 0) {
			if (this.Direction == 2) {
				StandRight.setVisible(true);
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
				DamageLeft.setVisible(false);
			}
			if (this.Direction == 1) {
				StandRight.setVisible(false);
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
				DamageLeft.setVisible(false);
			}
		}
	}
	public void Die() {
		
	}
}
