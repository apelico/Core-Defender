package com.engine;

import com.game.Game;

public class Engine implements Runnable {
    private Thread thread;
    private Window window;
    private Input input;
    private Game game;

    public Game getGame() {
		return game;
	}

	private boolean running = false;

    public Engine() {
    	game = new Game();
    }

    public void start() {
        input = new Input(this);
        window = new Window(this);
        window.getCanvas().addKeyListener(input);
        window.getCanvas().addMouseListener(input);
        window.getCanvas().addMouseMotionListener(input);
        window.setGame(game);

        running = true;
        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }

    public void run() {
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60.0d;
        final double timeF = 1000000000 / 60.0d;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                input.update();
                game.update(this);
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                window.Render();
                
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                //System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
                fps = frames;
                frames = 0;
                ticks = 0;
                timer += 1000;
            }

        }

        dispose();
    }
    
    public static int fps;

    private void dispose() {

    }

    public Window getWindow() {
        return window;
    }
    
    public Input getInput() {
    	return input;
    }
}