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
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class AddEllipseDialog {
    private MainWindow mainWindow;
    private Controller controller;

    public AddEllipseDialog(MainWindow mainWindow, Controller controller) {
        this.mainWindow = mainWindow;
        this.controller = controller;

        AnchorPane pane = new AnchorPane();
        pane.setPadding(new Insets(10));

        Label setLabelCenterX = new Label("Координата центра по Х:");
        AnchorPane.setTopAnchor(setLabelCenterX, 0.0);
        AnchorPane.setLeftAnchor(setLabelCenterX, 10.0);

        TextField setCenterX = new TextField();
        AnchorPane.setTopAnchor(setCenterX, 0.0);
        AnchorPane.setLeftAnchor(setCenterX, 220.0);


        Label setLabelCenterY = new Label("Координата центра по Y:");
        AnchorPane.setTopAnchor(setLabelCenterY, 50.0);
        AnchorPane.setLeftAnchor(setLabelCenterY, 10.0);

        TextField setCenterY = new TextField();
        AnchorPane.setTopAnchor(setCenterY, 50.0);
        AnchorPane.setLeftAnchor(setCenterY, 220.0);

        Label setLabelRadX = new Label("Радиус по Х:");
        AnchorPane.setTopAnchor(setLabelRadX, 100.0);
        AnchorPane.setLeftAnchor(setLabelRadX, 10.0);

        TextField setRadX = new TextField();
        AnchorPane.setTopAnchor(setRadX, 100.0);
        AnchorPane.setLeftAnchor(setRadX, 220.0);

        Label setLabelRadY = new Label("Радиус по Y:");
        AnchorPane.setTopAnchor(setLabelRadY, 150.0);
        AnchorPane.setLeftAnchor(setLabelRadY, 10.0);

        TextField setRadY = new TextField();
        AnchorPane.setTopAnchor(setRadY, 150.0);
        AnchorPane.setLeftAnchor(setRadY, 220.0);

        Label setStrokeColorLabel = new Label("Выберите цвет для линии:");
        AnchorPane.setTopAnchor(setStrokeColorLabel, 200.0);
        AnchorPane.setLeftAnchor(setStrokeColorLabel, 10.0);

        ColorPicker setStrokeColor = new ColorPicker();
        AnchorPane.setTopAnchor(setStrokeColor, 200.0);
        AnchorPane.setLeftAnchor(setStrokeColor, 220.0);

        Label setFillLabel = new Label("Выберите цвет для заливки:");
        AnchorPane.setTopAnchor(setFillLabel, 250.0);
        AnchorPane.setLeftAnchor(setFillLabel, 10.0);

        ColorPicker setFill = new ColorPicker();
        AnchorPane.setTopAnchor(setFill, 250.0);
        AnchorPane.setLeftAnchor(setFill, 220.0);

        Button rectButton = new Button("Создать");
        AnchorPane.setTopAnchor(rectButton, 300.0);
        AnchorPane.setLeftAnchor(rectButton, 170.0);

        rectButton.setOnAction(e -> {
            Ellipse ellipse = new Ellipse(
                    Double.parseDouble(setCenterX.getText()),
                    Double.parseDouble(setCenterY.getText()),
                    Double.parseDouble(setRadX.getText()),
                    Double.parseDouble(setRadY.getText()));

            ellipse.setStroke(setStrokeColor.getValue());
            ellipse.setFill(setFill.getValue());

            mainWindow.getWorkspace().getWorkPane().getChildren().add(ellipse);
            controller.addEllipse(ellipse);
            mainWindow.getWorkspace().changePlaceEllipse(ellipse);
            mainWindow.getWorkspace().deleteEllipse(ellipse, this.controller);


            setCenterX.clear();
            setCenterY.clear();
            setRadX.clear();
            setRadY.clear();
            setStrokeColor.setValue(Color.WHITE);
            setFill.setValue(Color.WHITE);

        });


        pane.getChildren().addAll(setLabelCenterX, setCenterX, setLabelCenterY, setCenterY, setLabelRadX, setRadX, setLabelRadY, setRadY, setStrokeColorLabel, setStrokeColor, setFillLabel, setFill, rectButton);

        Stage window = new Stage();
        Scene scene = new Scene(pane, 450, 350);
        window.setScene(scene);
        window.show();


    }
}
