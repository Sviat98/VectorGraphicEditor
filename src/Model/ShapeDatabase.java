package Model;

import Controller.Controller;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShapeDatabase {

    private List<Line> lines = new ArrayList<>();
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Ellipse> ellipses = new ArrayList<>();
    private Controller controller;
    private File file;

    public ShapeDatabase(Controller controller) {
        this.controller = controller;

    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public List<Ellipse> getEllipses() {
        return ellipses;
    }

    public void setEllipses(List<Ellipse> ellipses) {
        this.ellipses = ellipses;
    }

    public void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void saveFile(File file) {
        DOMParser domParser = new DOMParser();
        domParser.write(file, this);
    }

    public void loadFile() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        SAXLoader loader = new SAXLoader();
        loader.setShapeDatabase(this);
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, loader);
            controller.getMainWindow().update();
        } catch (SAXException | ParserConfigurationException | IOException ex) {

        }
    }


    public void setFile(File file) {
        this.file = file;
    }
}
