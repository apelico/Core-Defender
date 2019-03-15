package com.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener {
    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];
    
    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];
    
    private int mouseX = 0, mouseY = 0;
    
    Engine engine;
     
    public Input(Engine e) {
    	engine = e;
    }

    public void update() {
    	//set lastkey to last frame position. Up or Down
        for (int i = 0; i < NUM_KEYS; i++) {
            keysLast[i] = keys[i];
        }
        
        for (int i = 0; i < NUM_BUTTONS; i++) {
        	buttonsLast[i] = buttons[i];
        }
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {		
	}

	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
		
	}

	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
		
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = (int)(e.getX()); // /getScale
		mouseY = (int)(e.getY()); // /getScale
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = (int)e.getX();
		mouseY = (int)e.getY();
		
	}
	
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
	
	public boolean isKey(int keyCode) {
        return keys[keyCode];
    }

    public boolean isKeyDown(int keyCode) {
        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isKeyUp(int keyCode) {
        return keys[keyCode] && keysLast[keyCode];
    }
    
    public boolean isButton(int button) {
        return buttons[button];
    }

    public boolean isButtonDown(int button) {
        return buttons[button] && !buttonsLast[button];
    }

    public boolean isButtonUp(int button) {
        return buttons[button] && buttonsLast[button];
    }

}