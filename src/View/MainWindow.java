package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class MainWindow {

    private VBox pane;
    private Workspace workspace;
    private Controller controller;


    public MainWindow(Controller controller) {
        this.controller = controller;

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("Файл");


        MenuItem loadItem = new MenuItem("Загрузить файл");

        loadItem.setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", ".xml"));
            File file = new FileChooser().showOpenDialog(stage);
            controller.setFile(file);
            controller.loadFile();

        });


        MenuItem saveItem = new MenuItem("Сохранить файл");

        saveItem.setOnAction(e -> {
            Stage stage = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML", ".xml"));
            File file = new FileChooser().showSaveDialog(stage);

            if (file == null) {

            }
            controller.saveFile(file);
        });

        fileMenu.getItems().addAll(loadItem, saveItem);
        menuBar.getMenus().add(fileMenu);

        ToolBar toolBar = new ToolBar();
        Button lineButton = new Button("Линия");
        Button ellipseButton = new Button("Эллипс");
        Button rectangleButton = new Button("Прямоугольник");
        toolBar.getItems().addAll(lineButton, ellipseButton, rectangleButton);

        lineButton.setOnAction((ActionEvent e) -> {
            AddLineDialog addLineDialog = new AddLineDialog(this, this.controller);
        });

        rectangleButton.setOnAction((ActionEvent e) -> {
            AddRectDialog addRectDialog = new AddRectDialog(this, this.controller);

        });

        ellipseButton.setOnAction(e -> {
            AddEllipseDialog ellipseDialog = new AddEllipseDialog(this, this.controller);
        });
        pane = new VBox();

        workspace = new Workspace();


        Stage stage = new Stage();
        Scene scene = new Scene(pane, 800, 700);
        pane.getChildren().addAll(
                menuBar, toolBar, workspace.getWorkPane()
        );
        stage.setScene(scene);
        stage.show();
    }

    public void update() {
        workspace.clear();
        workspace.getWorkPane().getChildren().addAll(controller.getShapeDatabase().getLines());
        workspace.getWorkPane().getChildren().addAll(controller.getShapeDatabase().getRectangles());
        workspace.getWorkPane().getChildren().addAll(controller.getShapeDatabase().getEllipses());

    }


    public Workspace getWorkspace() {
        return workspace;
    }
}
