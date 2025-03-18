package Data;
public class SpriteInfo {
    private Vector2D position;
    private String spriteTag;

    public SpriteInfo(int x, int y, String spriteTag) {
        this.position = new Vector2D(x, y);
        this.spriteTag = spriteTag;
    }

    public Vector2D getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public String getSpriteTag() {
        return spriteTag;
    }

    public void setX(int newX) {
        position.setX(newX);
    }

    public void setY(int newY) {
        position.setY(newY);
    }

    public void adjustX(int adjustment) {
        position.adjustX(adjustment);
    }

    public void adjustY(int adjustment) {
        position.adjustY(adjustment);
    }
}
