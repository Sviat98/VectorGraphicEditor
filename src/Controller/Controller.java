package Controller;

import Model.ShapeDatabase;
import View.MainWindow;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Controller {
    private ShapeDatabase shapeDatabase;
    private MainWindow mainWindow;


    public Controller() {
        shapeDatabase = new ShapeDatabase(this);
        mainWindow = new MainWindow(this);

    }

    public void addLine(Line line) {
        shapeDatabase.getLines().add(line);
    }

    public void setFile(File file) {
        shapeDatabase.setFile(file);
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void addRectangle(Rectangle rectangle) {
        shapeDatabase.getRectangles().add(rectangle);
    }

    public void addEllipse(Ellipse ellipse) {
        shapeDatabase.getEllipses().add(ellipse);
    }

    public void saveFile(File file) {
        shapeDatabase.saveFile(file);
    }

    public void loadFile() {
        shapeDatabase.loadFile();
        for (int lineCounter = 0; lineCounter < getShapeDatabase().getLines().size(); lineCounter++) {
            getMainWindow().getWorkspace().changePlaceLine(getShapeDatabase().getLines().get(lineCounter));
            getMainWindow().getWorkspace().deleteLine(getShapeDatabase().getLines().get(lineCounter), this);
        }
        for (int rectCounter = 0; rectCounter < getShapeDatabase().getRectangles().size(); rectCounter++) {
            getMainWindow().getWorkspace().changePlaceRectangle(getShapeDatabase().getRectangles().get(rectCounter));
            getMainWindow().getWorkspace().deleteRectangle(getShapeDatabase().getRectangles().get(rectCounter), this);
        }
        for (int ellipseCounter = 0; ellipseCounter < getShapeDatabase().getLines().size(); ellipseCounter++) {
            getMainWindow().getWorkspace().changePlaceEllipse(getShapeDatabase().getEllipses().get(ellipseCounter));
            getMainWindow().getWorkspace().deleteEllipse(getShapeDatabase().getEllipses().get(ellipseCounter), this);
        }

    }

    public ShapeDatabase getShapeDatabase() {
        return shapeDatabase;
    }

}
