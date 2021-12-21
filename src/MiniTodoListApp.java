import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class MiniTodoListApp extends GraphicsApp {
    private static final int APP_WIDTH = 280;
    private static final int APP_HEIGHT = 360;

    @Override
    public void initialize() {
        setCanvasSize(APP_WIDTH, APP_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
