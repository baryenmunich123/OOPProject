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
	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) { //Running
			gameWorld.Update();
			gameWorld.Render();
			repaint();
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
