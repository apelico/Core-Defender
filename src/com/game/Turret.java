package com.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.Engine;

public class Turret extends Entity{
	private Image barrel;
	private double ang = 35; 

	public Turret(String path, int x, int y,Game game) {
		super(path, x, y,game);

		try {
			barrel = ImageIO.read(Image.class.getResourceAsStream("/barrell.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		tag = "turret";
		this.game = game;
		
	}
	float timer = 0;
	@Override
	public void update(Engine engine)
	{
		if(timer >= 30)
		{
			timer = 0;
			for(int i = 0; i < game.entites.size();i++)
			{
				if(game.entites.get(i).tag == "enemy" && game.entites.get(i).alive) {
					Shoot(game.entites.get(i));
					break;
				}
			}
		}else
			timer++;
	}
	
	public void Shoot(Entity target)
	{
		Projectile p = new Projectile("/pix.png",(int)posX,(int)posY,game,target);
		game.addEntity(p);
		
		ang = Math.atan2(posY - target.posY, posX - target.posX) + Math.PI;
		//target.kill();
	}
	
	@Override
	public void render(Graphics2D g)
	{
		super.render(g);
		
		AffineTransform old = g.getTransform();
		g.rotate(ang,posX,posY);
		g.drawImage(barrel, (int)posX - 24, (int)posY - 24, null);
		g.setTransform(old);
	}

	@Override
	public void collide(Entity other) {
		// TODO Auto-generated method stub
		
	}

}
