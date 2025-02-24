package Main;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Color c = new Color(200, 100, 150);
	public static boolean isImageDrawn = false;
	public static stopWatchX timer = new stopWatchX(250);
	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100, -100);
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		int startX = -100; // Starting X position (off screen)
		int endX = 800; // Triggers reset position
		int step = 25; // Increment
		int yPosition = 200; // Y starting position
		
		for (int x = startX; x<= endX; x += step) { // Loop to load to vecs1 
			vecs1.add(new Vector2D(x,yPosition));
		}
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		if (timer.isTimeUp()) { // Every 250ms this block executes and starts animation frame

            if (vecs1.isEmpty()) { // If vecs1 is empty, refill with second queue
            	while (!vecs2.isEmpty()) { // Transfer elements from vecs2 to tempQueue
                    vecs1.add(vecs2.remove());
                }
                
            }

            if (!vecs1.isEmpty()) { // If vecs1 is not empty, meaning there is still frames in vecs1, 
                currentVec = vecs1.remove(); // Transfer queues out of vecs1 to current
                vecs2.add(currentVec);
            }

            timer.resetWatch(); // Resets timer after frame is executed
        }

        ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "kitty1"); // Adding the kitty1 tagged sprite to FB for rendering
        ctrl.drawString(currentVec.getX(), currentVec.getY(), "Miaw :P", c);
    }
}