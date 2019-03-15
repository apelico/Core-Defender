package com.engine;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.game.Game;

public class Window {
    private BufferedImage image;
    private BufferStrategy bufferStrategy;
    private Graphics2D g;
    private Canvas canvas;
    private JFrame frame;

	public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int SCALE = 1;
    
    private Game game;
    

    public Window(Engine engine) {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new Canvas();
        canvas.setSize(WIDTH * SCALE, HEIGHT * SCALE);

        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        g = (Graphics2D)bufferStrategy.getDrawGraphics();
    }
    
    public void Render() {
    	game.render(g);
        bufferStrategy.show();
        g.clearRect(0, 0, Window.WIDTH * Window.SCALE, Window.HEIGHT * Window.SCALE);
    }
    
    public void setGame(Game game)
    {
    	this.game = game;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public BufferedImage getImage() {
        return image;
    }
    
    public JFrame getFrame() {
		return frame;
	}
}