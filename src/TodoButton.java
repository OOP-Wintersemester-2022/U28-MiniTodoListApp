public class TodoButton {
    private String texturePath;
    private int x;
    private int y;
    private int height;
    private int width;

    public TodoButton(int y, int size, String texturePath) {
        this.x = Config.APP_WIDTH - size - Config.PADDING;
        this.y = y + Config.PADDING;
        this.width = size;
        this.height = size - Config.PADDING;
        this.texturePath = texturePath;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setY(int y) {
        this.y = y;
    }
}
