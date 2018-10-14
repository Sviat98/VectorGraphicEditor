package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class AddLineDialog {
    private MainWindow mainWindow;
    private Controller controller;

    public AddLineDialog(MainWindow mainWindow, Controller controller) {
        this.mainWindow = mainWindow;
        this.controller = controller;

        AnchorPane pane = new AnchorPane();
        pane.setPadding(new Insets(10));

        Label setLabelX1 = new Label("Начальная координата по Х:");
        AnchorPane.setTopAnchor(setLabelX1, 0.0);
        AnchorPane.setLeftAnchor(setLabelX1, 10.0);

        TextField setX1 = new TextField();
        AnchorPane.setTopAnchor(setX1, 0.0);
        AnchorPane.setLeftAnchor(setX1, 220.0);


        Label setLabelY1 = new Label("Начальная координата по Y:");
        AnchorPane.setTopAnchor(setLabelY1, 50.0);
        AnchorPane.setLeftAnchor(setLabelY1, 10.0);

        TextField setY1 = new TextField();
        AnchorPane.setTopAnchor(setY1, 50.0);
        AnchorPane.setLeftAnchor(setY1, 220.0);

        Label setLabelX2 = new Label("Конечная координата по Х:");
        AnchorPane.setTopAnchor(setLabelX2, 100.0);
        AnchorPane.setLeftAnchor(setLabelX2, 10.0);

        TextField setX2 = new TextField();
        AnchorPane.setTopAnchor(setX2, 100.0);
        AnchorPane.setLeftAnchor(setX2, 220.0);

        Label setLabelY2 = new Label("Конечная координата по Y:");
        AnchorPane.setTopAnchor(setLabelY2, 150.0);
        AnchorPane.setLeftAnchor(setLabelY2, 10.0);

        TextField setY2 = new TextField();
        AnchorPane.setTopAnchor(setY2, 150.0);
        AnchorPane.setLeftAnchor(setY2, 220.0);

        Label setLineColor = new Label("Выберите цвет для линии:");
        AnchorPane.setTopAnchor(setLineColor, 200.0);
        AnchorPane.setLeftAnchor(setLineColor, 10.0);

        ColorPicker linePicker = new ColorPicker();
        AnchorPane.setTopAnchor(linePicker, 200.0);
        AnchorPane.setLeftAnchor(linePicker, 220.0);

        Button lineButton = new Button("Создать");
        AnchorPane.setTopAnchor(lineButton, 250.0);
        AnchorPane.setLeftAnchor(lineButton, 170.0);


        lineButton.setOnAction(e -> {
            Line line = new Line(
                    Double.parseDouble(setX1.getText()),
                    Double.parseDouble(setY1.getText()),
                    Double.parseDouble(setX2.getText()),
                    Double.parseDouble(setY2.getText()));

            line.setStroke(linePicker.getValue());

            mainWindow.getWorkspace().deleteLine(line, this.controller);
            mainWindow.getWorkspace().changePlaceLine(line);
            mainWindow.getWorkspace().getWorkPane().getChildren().add(line);
            controller.addLine(line);

            setX1.clear();
            setY1.clear();
            setX2.clear();
            setY2.clear();
            linePicker.setValue(Color.WHITE);

        });


        pane.getChildren().addAll(setLabelX1, setX1, setLabelY1, setY1, setLabelX2, setX2, setLabelY2, setY2, setLineColor, linePicker, lineButton);

        Stage window = new Stage();
        Scene scene = new Scene(pane, 450, 300);
        window.setScene(scene);
        window.show();


    }
}
