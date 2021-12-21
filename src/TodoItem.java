
public class TodoItem {
    private static final int HEIGHT = Config.BUTTON_SIZE;
    private static final int X = 0;
    private static final int OFFSET = 50;

    private TodoButton todoRemoveButton;

    private int y;
    private String title;

    public TodoItem(int idx, String title) {
        this.y = idx * HEIGHT + OFFSET;
        this.title = title;
        todoRemoveButton = new TodoButton(y, HEIGHT, Config.TEXTURE_PATH_MINUS);
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public String getTitle() {
        return title;
    }

    public TodoButton getTodoRemoveButton() {
        return todoRemoveButton;
    }

    public void setYByIndex(int idx) {
        this.y = idx * HEIGHT + OFFSET;
        this.todoRemoveButton.setY(y);
    }
}
