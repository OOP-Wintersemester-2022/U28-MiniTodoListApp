import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.*;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class MiniTodoListApp extends GraphicsApp implements GraphicsAppMouseListener, GraphicsAppKeyListener {
    private TodoList todoList;
    private TodoListView todoListView;

    @Override
    public void initialize() {
        setCanvasSize(Config.APP_WIDTH, Config.APP_HEIGHT);

        this.todoList = new TodoList();
        this.todoListView = new TodoListView(todoList);
    }

    @Override
    public void draw() {
        drawBackground(Config.APP_BACKGROUND_COLOR);
        this.todoListView.draw();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        super.onMousePressed(event);
        this.todoListView.onClick(event.getXPos(), event.getYPos());
    }
}
