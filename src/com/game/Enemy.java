package com.game;

import com.engine.Engine;
import com.engine.Window;

public class Enemy extends Entity{	
	public int speed;
	public int health;
	public int maxHealth;

    public Enemy(String path,int x, int y,Game game) {
    	super(path,x,y, game);
    	tag = "enemy";
    	aabb.active = true;
    }
    
    
    int timer = 0;
    @Override
    public void update(Engine engine) {
        moveForward();
        lookAt(Window.WIDTH/2,Window.HEIGHT/2);
        //System.out.println("X: " + posX + " Y: " + posY);
    }
    
    void moveForward()
    {
    	posX += Math.sin(angle);
    	posY -= Math.cos(angle);
    }

	@Override
	public void collide(Entity other) {
		
	}
}