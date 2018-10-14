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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AddRectDialog {
    private MainWindow mainWindow;
    private Controller controller;

    public AddRectDialog(MainWindow mainWindow, Controller controller) {
        this.mainWindow = mainWindow;
        this.controller = controller;

        AnchorPane pane = new AnchorPane();
        pane.setPadding(new Insets(10));

        Label setLabelX = new Label("Начальная координата по Х:");
        AnchorPane.setTopAnchor(setLabelX, 0.0);
        AnchorPane.setLeftAnchor(setLabelX, 10.0);

        TextField setX = new TextField();
        AnchorPane.setTopAnchor(setX, 0.0);
        AnchorPane.setLeftAnchor(setX, 220.0);


        Label setLabelY = new Label("Начальная координата по Y:");
        AnchorPane.setTopAnchor(setLabelY, 50.0);
        AnchorPane.setLeftAnchor(setLabelY, 10.0);

        TextField setY = new TextField();
        AnchorPane.setTopAnchor(setY, 50.0);
        AnchorPane.setLeftAnchor(setY, 220.0);

        Label setLabelWidth = new Label("Ширина:");
        AnchorPane.setTopAnchor(setLabelWidth, 100.0);
        AnchorPane.setLeftAnchor(setLabelWidth, 10.0);

        TextField setWidth = new TextField();
        AnchorPane.setTopAnchor(setWidth, 100.0);
        AnchorPane.setLeftAnchor(setWidth, 220.0);

        Label setLabelHeight = new Label("Высота:");
        AnchorPane.setTopAnchor(setLabelHeight, 150.0);
        AnchorPane.setLeftAnchor(setLabelHeight, 10.0);

        TextField setHeight = new TextField();
        AnchorPane.setTopAnchor(setHeight, 150.0);
        AnchorPane.setLeftAnchor(setHeight, 220.0);

        Label setArcWidthLabel = new Label("Ширина дуги:");
        AnchorPane.setTopAnchor(setArcWidthLabel, 200.0);
        AnchorPane.setLeftAnchor(setArcWidthLabel, 10.0);

        TextField setArcWidth = new TextField();
        AnchorPane.setTopAnchor(setArcWidth, 200.0);
        AnchorPane.setLeftAnchor(setArcWidth, 220.0);
        setArcWidth.setText("0.0");

        Label setArcHeightLabel = new Label("Высота дуги:");
        AnchorPane.setTopAnchor(setArcHeightLabel, 250.0);
        AnchorPane.setLeftAnchor(setArcHeightLabel, 10.0);

        TextField setArcHeight = new TextField();
        AnchorPane.setTopAnchor(setArcHeight, 250.0);
        AnchorPane.setLeftAnchor(setArcHeight, 220.0);
        setArcHeight.setText("0.0");

        Label setStrokeColorLabel = new Label("Выберите цвет для линии:");
        AnchorPane.setTopAnchor(setStrokeColorLabel, 300.0);
        AnchorPane.setLeftAnchor(setStrokeColorLabel, 10.0);

        ColorPicker setStrokeColor = new ColorPicker();
        AnchorPane.setTopAnchor(setStrokeColor, 300.0);
        AnchorPane.setLeftAnchor(setStrokeColor, 220.0);

        Label setFillLabel = new Label("Выберите цвет для заливки:");
        AnchorPane.setTopAnchor(setFillLabel, 350.0);
        AnchorPane.setLeftAnchor(setFillLabel, 10.0);

        ColorPicker setFill = new ColorPicker();
        AnchorPane.setTopAnchor(setFill, 350.0);
        AnchorPane.setLeftAnchor(setFill, 220.0);

        Button rectButton = new Button("Создать");
        AnchorPane.setTopAnchor(rectButton, 400.0);
        AnchorPane.setLeftAnchor(rectButton, 170.0);

        rectButton.setOnAction(e -> {
            Rectangle rect = new Rectangle(
                    Double.parseDouble(setX.getText()),
                    Double.parseDouble(setY.getText()),
                    Double.parseDouble(setWidth.getText()),
                    Double.parseDouble(setHeight.getText()));


            rect.setArcWidth(Double.parseDouble(setArcWidth.getText()));
            rect.setArcHeight(Double.parseDouble(setArcHeight.getText()));

            rect.setStroke(setStrokeColor.getValue());
            rect.setFill(setFill.getValue());

            mainWindow.getWorkspace().getWorkPane().getChildren().add(rect);
            controller.addRectangle(rect);
            mainWindow.getWorkspace().changePlaceRectangle(rect);
            mainWindow.getWorkspace().deleteRectangle(rect, this.controller);

            setX.clear();
            setY.clear();
            setWidth.clear();
            setHeight.clear();
            setStrokeColor.setValue(Color.WHITE);
            setFill.setValue(Color.WHITE);

        });
/*

        */
        pane.getChildren().addAll(
                setLabelX,
                setX,
                setLabelY,
                setY,
                setLabelWidth,
                setWidth,
                setLabelHeight,
                setHeight,
                setArcWidthLabel,
                setArcWidth,
                setArcHeightLabel,
                setArcHeight,
                setStrokeColorLabel,
                setStrokeColor,
                setFillLabel,
                setFill,
                rectButton);

        Stage window = new Stage();
        Scene scene = new Scene(pane, 450, 450);
        window.setScene(scene);
        window.show();


    }
}

