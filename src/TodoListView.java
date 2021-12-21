import de.ur.mi.oop.graphics.Image;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListView {

    private TodoList todoList;

    private ArrayList<TodoItemView> items;
    private Image todoButtonView;

    public TodoListView(TodoList todoList) {
        this.items = new ArrayList<>();
        this.todoList = todoList;

        this.todoButtonView = new Image(todoList.getButton().getX(), todoList.getButton().getY(), todoList.getButton().getTexturePath());
        this.todoButtonView.setWidth(todoList.getButton().getWidth());
        this.todoButtonView.setHeight(todoList.getButton().getHeight());
    }

    public void draw() {
        todoButtonView.draw();

        for(TodoItemView item: items) {
            item.draw();
        }
    }

    public void onClick(int xPos, int yPos) {
        if (isButtonClicked(xPos, yPos)) {
            System.out.println("Geben Sie Ihr TodoItem ein:");

            todoList.addItem(new Scanner(System.in).nextLine());
            items.add(new TodoItemView(todoList.getLastItem()));
        } else {
            handleItemClick(xPos, yPos);
            handleRemoveClick(xPos, yPos);
        }
    }

    private void handleItemClick(int xPos, int yPos) {
        for(TodoItemView item: items) {
            item.onClick(xPos, yPos);
        }
    }

    private void handleRemoveClick(int xPos, int yPos) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).isRemoveButtonClicked(xPos, yPos)) {
                removeItems(i);
                break;
            }
        }
    }

    private void removeItems(int i) {
        todoList.update(i);
        items.clear();
        for(TodoItem item: todoList.getItems()) {
            items.add(new TodoItemView(item));
        }
    }

    private boolean isButtonClicked(int xPos, int yPos) {
        return xPos >= todoButtonView.getXPos() && xPos <= todoButtonView.getXPos() + todoButtonView.getWidth() && yPos >= todoButtonView.getYPos() && yPos <= todoButtonView.getYPos() + todoButtonView.getHeight();
    }
}
