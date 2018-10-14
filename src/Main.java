import Controller.Controller;
import Model.ShapeDatabase;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        Controller controller = new Controller();
        ShapeDatabase shapeDatabase = new ShapeDatabase(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
