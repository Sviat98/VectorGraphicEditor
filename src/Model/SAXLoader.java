package Model;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXLoader extends DefaultHandler {
    private ShapeDatabase shapeDatabase;
    private List<Line> lines = new ArrayList<>();
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Ellipse> ellipses = new ArrayList<>();
    private Line line;
    private Rectangle rectangle;
    private Ellipse ellipse;
    private String element = "";
    private boolean bLineStartX = false;
    private boolean bLineStartY = false;
    private boolean bLineEndX = false;
    private boolean bLineEndY = false;
    private boolean bLineStrokeColor = false;
    private boolean bRectStartX = false;
    private boolean bRectStartY = false;
    private boolean bRectWidth = false;
    private boolean bRectHeight = false;
    private boolean bRectArcWidth = false;
    private boolean bRectArcHeight = false;
    private boolean bRectStrokeColor = false;
    private boolean bRectFillColor = false;
    private boolean bEllipseCenterX = false;
    private boolean bEllipseCenterY = false;
    private boolean bEllipseRadiusX = false;
    private boolean bEllipseRadiusY = false;
    private boolean bEllipseStrokeColor = false;
    private boolean bEllipseFillColor = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        if (qName.equals("line"))
            line = new Line();
        else if (qName.equals("lineStartX"))
            bLineStartX = true;
        else if (qName.equals("lineStartY"))
            bLineStartY = true;
        else if (qName.equals("lineEndX"))
            bLineEndX = true;
        else if (qName.equals("lineEndY"))
            bLineEndY = true;
        else if (qName.equals("lineStrokeColor"))
            bLineStrokeColor = true;
        else if (qName.equals("rectangle"))
            rectangle = new Rectangle();
        else if (qName.equals("rectStartX"))
            bRectStartX = true;
        else if (qName.equals("rectStartY"))
            bRectStartY = true;
        else if (qName.equals("rectWidth"))
            bRectWidth = true;
        else if (qName.equals("rectHeight"))
            bRectHeight = true;
        else if (qName.equals("rectArcWidth"))
            bRectArcWidth = true;
        else if (qName.equals("rectArcHeight"))
            bRectArcHeight = true;
        else if (qName.equals("rectStrokeColor"))
            bRectStrokeColor = true;
        else if (qName.equals("rectFillColor"))
            bRectFillColor = true;
        else if (qName.equals("ellipse"))
            ellipse = new Ellipse();
        else if (qName.equals("ellipseCenterX"))
            bEllipseCenterX = true;
        else if (qName.equals("ellipseCenterY"))
            bEllipseCenterY = true;
        else if (qName.equals("ellipseRadiusX"))
            bEllipseRadiusX = true;
        else if (qName.equals("ellipseRadiusY"))
            bEllipseRadiusY = true;
        else if (qName.equals("ellipseStrokeColor"))
            bEllipseStrokeColor = true;
        else if (qName.equals("ellipseFillColor"))
            bEllipseFillColor = true;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (element.equals("lineStartX") && bLineStartX) {
            line.setStartX(Double.parseDouble(new String(ch, start, length).trim()));
            bLineStartX = false;
        } else if (element.equals("lineStartY") && bLineStartY) {
            line.setStartY(Double.parseDouble(new String(ch, start, length).trim()));
            bLineStartY = false;
        } else if (element.equals("lineEndX") && bLineEndX) {
            line.setEndX(Double.parseDouble(new String(ch, start, length).trim()));
            bLineEndX = false;
        } else if (element.equals("lineEndY") && bLineEndY) {
            line.setEndY(Double.parseDouble(new String(ch, start, length).trim()));
            bLineEndY = false;
        } else if (element.equals("lineStrokeColor") && bLineStrokeColor) {
            line.setStroke(Paint.valueOf(new String(ch, start, length).trim()));
            bLineStrokeColor = false;
        } else if (element.equals("rectStartX") && bRectStartX) {
            rectangle.setX(Double.parseDouble(new String(ch, start, length).trim()));
            bRectStartX = false;
        } else if (element.equals("rectStartY") && bRectStartY) {
            rectangle.setY(Double.parseDouble(new String(ch, start, length).trim()));
            bRectStartY = false;
        } else if (element.equals("rectWidth") && bRectWidth) {
            rectangle.setWidth(Double.parseDouble(new String(ch, start, length).trim()));
            bRectWidth = false;
        } else if (element.equals("rectHeight") && bRectHeight) {
            rectangle.setHeight(Double.parseDouble(new String(ch, start, length).trim()));
            bRectHeight = false;
        } else if (element.equals("rectArcWidth") && bRectArcWidth) {
            rectangle.setArcWidth(Double.parseDouble(new String(ch, start, length).trim()));
            bRectArcWidth = false;
        } else if (element.equals("rectArcHeight") && bRectArcHeight) {
            rectangle.setArcHeight(Double.parseDouble(new String(ch, start, length).trim()));
            bRectArcHeight = false;
        } else if (element.equals("rectStrokeColor") && bRectStrokeColor) {
            rectangle.setStroke(Paint.valueOf(new String(ch, start, length).trim()));
            bRectStrokeColor = false;
        } else if (element.equals("rectFillColor") && bRectFillColor) {
            rectangle.setFill(Paint.valueOf(new String(ch, start, length).trim()));
            bRectFillColor = false;
        } else if (element.equals("ellipseCenterX") && bEllipseCenterX) {
            ellipse.setCenterX(Double.parseDouble(new String(ch, start, length).trim()));
            bEllipseCenterX = false;
        } else if (element.equals("ellipseCenterY") && bEllipseCenterY) {
            ellipse.setCenterY(Double.parseDouble(new String(ch, start, length).trim()));
            bEllipseCenterY = false;
        } else if (element.equals("ellipseRadiusX") && bEllipseRadiusX) {
            ellipse.setRadiusX(Double.parseDouble(new String(ch, start, length).trim()));
            bEllipseRadiusX = false;
        } else if (element.equals("ellipseRadiusY") && bEllipseRadiusY) {
            ellipse.setRadiusY(Double.parseDouble(new String(ch, start, length).trim()));
            bEllipseRadiusY = false;
        } else if (element.equals("ellipseStrokeColor") && bEllipseStrokeColor) {
            ellipse.setStroke(Paint.valueOf(new String(ch, start, length).trim()));
            bEllipseStrokeColor = false;
        } else if (element.equals("ellipseFillColor") && bEllipseFillColor) {
            ellipse.setFill(Paint.valueOf(new String(ch, start, length).trim()));
            bEllipseFillColor = false;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        element = qName;
        if (qName.equals("lineStartX"))
            bLineStartX = false;
        else if (qName.equals("lineStartY"))
            bLineStartY = false;
        else if (qName.equals("lineEndX"))
            bLineEndX = false;
        else if (qName.equals("lineEndY"))
            bLineEndY = false;
        else if (qName.equals("lineStrokeColor"))
            bLineStrokeColor = false;
        else if (qName.equals("line"))
            lines.add(line);
        else if (qName.equals("lineList"))
            shapeDatabase.setLines(lines);

        else if (qName.equals("rectStartX"))
            bRectStartX = false;
        else if (qName.equals("rectStartY"))
            bRectStartY = false;
        else if (qName.equals("rectWidth"))
            bRectWidth = false;
        else if (qName.equals("rectHeight"))
            bRectHeight = false;
        else if (qName.equals("rectArcWidth"))
            bRectArcWidth = false;
        else if (qName.equals("rectArcHeight"))
            bRectArcHeight = false;
        else if (qName.equals("rectStrokeColor"))
            bRectStrokeColor = false;
        else if (qName.equals("rectFillColor"))
            bRectFillColor = false;
        else if (qName.equals("rectangle"))
            rectangles.add(rectangle);
        else if (qName.equals("rectangleList"))
            shapeDatabase.setRectangles(rectangles);


        else if (qName.equals("ellipseCenterX"))
            bEllipseCenterX = false;
        else if (qName.equals("ellipseCenterY"))
            bEllipseCenterY = false;
        else if (qName.equals("ellipseRadiusX"))
            bEllipseRadiusX = false;
        else if (qName.equals("ellipseRadiusY"))
            bEllipseRadiusY = false;
        else if (qName.equals("ellipseStrokeColor"))
            bEllipseStrokeColor = false;
        else if (qName.equals("ellipseFillColor"))
            bEllipseFillColor = false;
        else if (qName.equals("ellipse"))
            ellipses.add(ellipse);
        else if (qName.equals("ellipseList"))
            shapeDatabase.setEllipses(ellipses);
    }

    public void setShapeDatabase(ShapeDatabase shapeDatabase) {
        this.shapeDatabase = shapeDatabase;
    }
}
