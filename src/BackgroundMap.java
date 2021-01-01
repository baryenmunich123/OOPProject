package src;

import java.awt.*;

public class BackgroundMap {

    private final GameWorldState gameWorld;
    public int[][] map;
    private final int tileSize;
    private float posX;
    private float posY;
    
    public BackgroundMap(float x, float y, GameWorldState gameWorld) {
        this.gameWorld = gameWorld;
        map = CacheDataLoader.getInstance().getBackgroundMap();
        tileSize = 30;
    }
    private GameWorldState getGameWorld() { return gameWorld; }

    public void setPosX(float x){
        posX = x;
    }

    public float getPosX(){
        return posX;
    }

    public void setPosY(float y){
        posY = y;
    }

    public float getPosY(){
        return posY;
    }

    public void Update() {}
    
    public void draw(Graphics2D g2){
        
        Camera camera = getGameWorld().camera;
        
        g2.setColor(Color.RED);
        for(int i = 0;i< map.length;i++)
            for(int j = 0;j<map[0].length;j++)
                if(map[i][j]!=0 && j*tileSize - camera.getX() > -30
                        && j*tileSize - camera.getX() < Main.SCREEN_WIDTH
                        && i*tileSize - camera.getY() > -30
                        && i*tileSize - camera.getY() < Main.SCREEN_HEIGHT){
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("tiled"+map[i][j]).getImage(), (int) getPosX() + j*tileSize - (int) camera.getX(),
                        (int) getPosY() + i*tileSize - (int) camera.getY(), null);
                }
        
    }



}
