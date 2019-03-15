package com.game;
import com.engine.Engine;

public class Entity extends Sprite{
	
	public String tag;
	public boolean alive;

	public Entity(String path, int x, int y) {
		super(path, x, y);
		alive = true;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(Engine engine) {
		
	}
	
	void lookAt(int pointX, int pointY) {
    	angle = Math.atan2(posY - pointY, posX - pointX) - Math.PI / 2;
    }
	
	public void kill() {
		alive = false;
	}
	
	
	public void collide(Entity other)
	{
		
	}
}
