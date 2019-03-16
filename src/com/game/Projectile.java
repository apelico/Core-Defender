package com.game;

import com.engine.Engine;

public class Projectile extends Entity{
	private Entity target;
	

	public Projectile(String path, int x, int y,Game game,Entity e) {
		super(path, x, y,game);
		tag = "projectile";
		shootAt(e);
		aabb.active = true;
	}

	@Override
	public void update(Engine engine) {
		if(target.alive)
		{
			lookAt(target.posX,target.posY);
			/*if(distance(posX,posY,target.posX,target.posY) < 3) {
				target.kill();
				this.kill();
			}*/
		}
		
		posX += 5 * Math.sin(angle);
		posY -= 5 * Math.cos(angle);
		
	}
	
	void shootAt(Entity e) {
		target = e;
		lookAt(e.posX,e.posY);
	}

	@Override
	public void collide(Entity other) {
		if(other.tag == "enemy")
		{
			other.kill();
			this.kill();
		}
		
	}

}
