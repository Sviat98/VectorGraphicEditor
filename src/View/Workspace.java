package View;

import Controller.Controller;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Workspace {
    private Pane workPane;
    private Rectangle work;
    private MainWindow mainWindow;
    private Controller controller;

    public Workspace() {
        this.mainWindow = mainWindow;
        this.controller = controller;

        workPane = new Pane();

        work = new Rectangle(0, 0, 800, 650);
        work.setFill(Color.WHITE);

        workPane.getChildren().add(work);
    }


    public void clear() {
        workPane.getChildren().clear();
        workPane.getChildren().add(work);

    }

    public Pane getWorkPane() {
        return workPane;
    }

    public void changePlaceLine(Line line) {
        double deltaX = line.getEndX() - line.getStartX();
        double deltaY = line.getEndY() - line.getStartY();

        line.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                line.setStartX(event.getX());
                line.setStartY(event.getY());
                line.setEndX(event.getX() + deltaX);
                line.setEndY(event.getY() + deltaY);
            }
        });
    }

    public void deleteLine(Line line, Controller controller) {
        ContextMenu delete = new ContextMenu();
        MenuItem deleteButton = new MenuItem("Удалить");

        delete.getItems().add(deleteButton);

        line.setOnContextMenuRequested(event -> {
            delete.show(line, event.getScreenX(), event.getScreenY());
        });

        deleteButton.setOnAction(deleteEvent -> {
            controller.getShapeDatabase().getLines().remove(line);
            workPane.getChildren().remove(line);

        });

    }

    public void changePlaceRectangle(Rectangle rect) {
        rect.setOnMouseDragged(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                rect.setX(event.getX());
                rect.setY(event.getY());
            }
        });
    }

    public void deleteRectangle(Rectangle rect, Controller controller) {
        ContextMenu delete = new ContextMenu();
        MenuItem deleteButton = new MenuItem("Удалить");

        delete.getItems().add(deleteButton);

        rect.setOnContextMenuRequested(event -> {
            delete.show(rect, event.getScreenX(), event.getScreenY());
        });

        deleteButton.setOnAction(deleteEvent -> {
            controller.getShapeDatabase().getRectangles().remove(rect);
            workPane.getChildren().remove(rect);

        });


    }

    public void changePlaceEllipse(Ellipse ellipse) {
        ellipse.setOnMouseDragged(event -> {
            ellipse.setCenterX(event.getX());
            ellipse.setCenterY(event.getY());
        });
    }

    public void deleteEllipse(Ellipse ellipse, Controller controller) {
        ContextMenu delete = new ContextMenu();
        MenuItem deleteButton = new MenuItem("Удалить");

        delete.getItems().add(deleteButton);

        ellipse.setOnContextMenuRequested(event -> {
            delete.show(ellipse, event.getScreenX(), event.getScreenY());
        });

        deleteButton.setOnAction(deleteEvent -> {
            controller.getShapeDatabase().getEllipses().remove(ellipse);
            workPane.getChildren().remove(ellipse);

        });
    }
}
