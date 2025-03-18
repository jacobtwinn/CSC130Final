package Main;

import Data.SpriteInfo;
import java.awt.Color;
import java.util.ArrayList;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	public static Color c = new Color(200, 100, 150);
	public static boolean isImageDrawn = false;
	public static stopWatchX timer = new stopWatchX(250);
	public static ArrayList<SpriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;

	public static final int SCREEN_WIDTH = 800;
    public static final int STEP = 25;
    public static final int START_X = -100;
    public static final int Y_POSITION = 200;
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start() {
        // Initialize sprites list
        for (int x = START_X, i = 0; x <= SCREEN_WIDTH; x += STEP, i++) {
            sprites.add(new SpriteInfo(x, Y_POSITION, "walk" + i));
        }
    }
	public static void update(Control ctrl) {
        if (timer.isTimeUp()) { 
            // Move sprite across the screen
            SpriteInfo currentSprite = sprites.get(currentSpriteIndex);
            currentSprite.adjustX(STEP);

            // Reset when reaching the right boundary
            if (currentSprite.getX() >= SCREEN_WIDTH) {
                currentSprite.setX(START_X);
            }

            // Move to next frame
            currentSpriteIndex++;
            if (currentSpriteIndex >= sprites.size()) {
                currentSpriteIndex = 0; // Loop animation
            }

            timer.resetWatch();
        }

        // Draw current frame
        SpriteInfo displaySprite = sprites.get(currentSpriteIndex);
        ctrl.addSpriteToFrontBuffer(displaySprite.getX(), displaySprite.getY(), displaySprite.getSpriteTag());
        ctrl.drawString(displaySprite.getX(), displaySprite.getY() + 30, "Miaw", c);
    }
}