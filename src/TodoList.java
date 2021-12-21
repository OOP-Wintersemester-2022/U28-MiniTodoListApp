import java.util.ArrayList;

public class TodoList {
    private TodoButton todoButton;

    private ArrayList<TodoItem> items;

    public TodoList() {
        this.todoButton = new TodoButton(0, Config.BUTTON_SIZE, Config.TEXTURE_PATH_PLUS);
        this.items = new ArrayList<>();
    }

    public void addItem(String title) {
        items.add(new TodoItem(items.size(), title));
    }

    public TodoButton getButton() {
        return todoButton;
    }

    public ArrayList<TodoItem> getItems() {
        return items;
    }

    public TodoItem getLastItem() {
        return items.get(items.size() - 1);
    }

    public void update(int idx) {
        items.remove(idx);
        for(int i = idx; i < items.size(); i++) {
            items.get(i).setYByIndex(i);
        }
    }
}
