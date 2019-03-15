package com.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Engine;
import com.engine.Window;

public class Sprite {
	private Image image;
	
	public float posX;
	public float posY;
	public double angle;
	
	private int width, height;
	
	public Sprite(String path,int x, int y)
	{
		posX = x;
		posY = y;
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
			width = image.getWidth(null);
			height = image.getHeight(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public float dist(float x1,float y1,float x2,float y2) {
		float x = (x2 - x1) * (x2 - x1);
		float y = (y2 - y1) * (y2 - y1);
		return (float)Math.sqrt(x + y);
	}
	
	public void update(Engine engine) {}
	
	public void render(Graphics2D g)
	{
		if(posX < 0 - width || posX > Window.WIDTH + width || posY < 0 - height || posY > Window.HEIGHT + height) {
			return;
		}
		if(image != null) {
		AffineTransform old = g.getTransform();
		g.rotate(angle,posX,posY);
		g.drawImage(image, (int)posX - (width/2), (int)posY - (height/2), null);
		g.setTransform(old);
		}
	}
}
