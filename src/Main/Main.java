package Main;

import java.awt.Color;
import logic.Control;

public class Main{
	// Fields (Static) below...
	public static Color c = new Color(200, 100, 150);
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		ctrl.addSpriteToFrontBuffer(850, 500, "f0");						 				// Add a tester sprite to render list by tag (Remove later! Test only!)
		ctrl.drawString(850, 650, "This is a test graphics string!", c);		// Test drawing text on screen where you want (Remove later! Test only!)
	}
	
	// Additional Static methods below...(if needed)

}
