import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Image;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class TodoItemView {
    private Color background;
    private TodoItem todoItem;
    private Label text;
    private Rectangle rectangle;
    private Image todoRemoveButton;

    public TodoItemView(TodoItem item) {
        this.background =  Colors.GREY;
        this.todoItem = item;
        this.text = new Label(Config.ITEM_TEXT_X_OFFSET + item.getX(), item.getY() + item.getHeight() / 2 + Config.ITEM_TEXT_Y_OFFSET, item.getTitle(), Colors.WHITE);
        this.rectangle = new Rectangle(item.getX(), item.getY(), Config.APP_WIDTH, item.getHeight(), background);
        this.text.setWidth(Config.APP_WIDTH);
        this.text.setHeight(item.getHeight());
        this.text.setFontSize(Config.FONT_SIZE);
        this.rectangle.setBorder(Colors.WHITE, Config.BORDER_SIZE);
        this.todoRemoveButton = new Image(todoItem.getTodoRemoveButton().getX(), todoItem.getTodoRemoveButton().getY(), todoItem.getTodoRemoveButton().getTexturePath());
        this.todoRemoveButton.setWidth(todoItem.getTodoRemoveButton().getWidth());
        this.todoRemoveButton.setHeight(todoItem.getTodoRemoveButton().getHeight());
    }

    public void draw() {
        this.rectangle.draw();
        this.text.draw();
        this.todoRemoveButton.draw();
    }

    public boolean isRemoveButtonClicked(int xPos, int yPos) {
        return xPos >= todoRemoveButton.getXPos() && xPos <= todoRemoveButton.getXPos() + todoRemoveButton.getWidth() && yPos >= todoRemoveButton.getYPos() && yPos <= todoRemoveButton.getYPos() + todoRemoveButton.getHeight();
    }

    public void onClick(int xPos, int yPos) {
        if (isClicked(xPos, yPos)) {
            if(background == Colors.BLUE) {
                background = Colors.GREY;
            } else {
                background = Colors.BLUE;
            }
            rectangle.setColor(background);
        }
    }

    public boolean isClicked(int xPos, int yPos) {
        return xPos >= rectangle.getXPos() && xPos <= rectangle.getXPos() + rectangle.getWidth() && yPos >= rectangle.getYPos() && yPos <= rectangle.getYPos() + rectangle.getHeight();
    }
}
