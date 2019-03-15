package com.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.engine.Engine;
import com.engine.Window;

public class Game {
	public ArrayList<Entity> entites = new ArrayList<Entity>();
	
    public Game() {
    	entites.add(new Turret("/turret.png",400,300,this));
    }
    
    public void addEntity(Entity e) {
    	entites.add(e);
    }
    
    double timer= 0;
    public void update(Engine engine)
    {
    	
    	if(timer >= 35)
    	{
    		timer = 0;
    		createEntity();
    	}else
    		timer++;
    	
    	
    	for(int i = 0; i < entites.size();i++) {
    		if(entites.get(i).alive) {
    			entites.get(i).update(engine);
    		}else {
    			entites.remove(i);
    			i--;
    		}
    	}
    }
    
    public void render(Graphics2D g) {
    	for(int i = 0; i < entites.size();i++) {
    		if(entites.get(i).alive)
    			entites.get(i).render(g);
    	}
    	
    	g.setColor(Color.BLACK);
    	g.drawString("Sprites: " + entites.size(), 0, Window.HEIGHT - 5);
    	g.drawString("FPS: " + Engine.fps, 0, 10);
    }
    
    public void createEntity() {
    	double angle = Math.random() * Math.PI * 2;
    	
    	int x = 400 + (int)(Math.cos(angle) * (600));
    	int y = 300 + (int)(Math.sin(angle) * (500));
    	
    	entites.add(new Enemy("/enemy.png",x,y,this));
    }
    
    
}