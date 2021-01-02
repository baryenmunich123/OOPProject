package src;

public class Camera {
	private float x;
	private float y;
	private float width;
	private float height;
	private GameWorldState gameWorld;
	private boolean fixed = false;
	
	public Camera (float x, float y, float width, float height, GameWorldState gameWorld) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.gameWorld = gameWorld;
	}
	public void lock() {
		this.fixed = true;
	}
	public void unlock() {
		this.fixed = false;
	}
	public void Update() {
		if (this.fixed == false) {
			Megaman megaman = gameWorld.megaman; //get Megaman from the current stage
			if (megaman.getX() - this.x >= 500 /*starting position of camera movement*/) {
				setX(megaman.get_X() - 500);
			}
			if (megaman.getY() - this.y > 400) /*starting position of camera movement*/{
				setY(megaman.get_Y() - 400);
			}
			else {
				if(megaman.getY() - this.y < 250) /*The domain [250, 400] is the range where camera don't move*/ {
					setY(megaman.get_Y() - 250);
				}
			}
		}
	}
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
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public GameWorldState getGameWorld() {
		return gameWorld;
	}
}
