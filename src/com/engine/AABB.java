package com.engine;

public class AABB {
	public int posX;
	public int posY;
	
	public int width;
	public int height;
	
	public boolean active = false;
	
	public AABB(int x, int y, int w, int h)
	{
		posX = x;
		posY = y;
		width = w;
		height = h;
	}
	
	public void update(float x, float y)
	{
		posX = (int)x;
		posY = (int)y;
	}
	
	public boolean isColliding(AABB other) {
		if((posX < other.posX + other.width) && 
			(posX + width > other.posX) && 
			(posY < other.posY + other.height) && 
			(posY + height > other.posY))
				return true;
		
		return false;
	}
}
