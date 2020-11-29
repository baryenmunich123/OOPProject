package src;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
//import acm.graphics.*;
//import acm.program.*;
//import acm.program.GraphicsProgram;
//import acm.util.*;
import java.awt.event.KeyEvent;

public class Main{
	GamePanel game;
	public Main() {
		JFrame f = new JFrame("Megaman 1");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = f.getToolkit();
        Dimension screen = toolkit.getScreenSize();
		f.setBounds(screen.width/2 - 500, screen.height/2 - 300, 1000, 600);
		game = new GamePanel();
		f.add(game);
		f.setVisible(true);
	}
	public void start() {
		game.start();
		
	}
	public static void main(String[]args) {
		Main frame = new Main();
		frame.start();
	}
}
