package src;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	private GameWorldState gameWorld;
	Thread gameThread;
	
	public GamePanel() {
		gameWorld = new GameWorldState();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void startGame() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long previousTime = System.currentTimeMillis();
		long currentTime;
		long sleepTime;
		
		while(true) { //Running
			gameWorld.Update();
			gameWorld.Render();
			repaint();
			currentTime = System.currentTimeMillis();
			sleepTime = 100/8 - (currentTime - previousTime);
			try{

                if(sleepTime > 0)
                        Thread.sleep(sleepTime);
                else Thread.sleep((100/8)/2);

        }catch(Exception e){}

        previousTime = System.currentTimeMillis();
		}
	}
	public void paint(Graphics g) {
		g.drawImage(gameWorld.getBufferedImage(), 0, 0, this);
	}
	@Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        gameWorld.setPressedButton(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameWorld.setReleasedButton(e.getKeyCode());
    }

}
