package com.game;
import com.engine.Engine;

public abstract class Entity extends Sprite{
	
	public String tag;
	public boolean alive;
	public Game game;

	public Entity(String path, int x, int y,Game game) {
		super(path, x, y);
		alive = true;
		this.game = game;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public abstract void update(Engine engine);
	
	void lookAt(float pointX, float pointY) {
    	angle = Math.atan2(posY - pointY, posX - pointX) - Math.PI / 2;
    }
	
	float distance(float x1,float y1, float x2, float y2) {
		float x = (x2 - x1) * (x2 - x1);
		float y = (y2 - y1) * (y2 - y1);
		return (float)Math.sqrt(x + y);
	}
	
	public void kill() {
		alive = false;
	}
	
	
	public abstract void collide(Entity other);
}
