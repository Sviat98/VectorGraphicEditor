package Model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMParser {
    private File file;
    private Document document;
    private ShapeDatabase shapeDatabase;

    public void write(File file, ShapeDatabase shapeDatabase) {
        this.file = file;
        this.shapeDatabase = shapeDatabase;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");
            Element lineList = document.createElement("lineList");
            list.appendChild(lineList);

            Element rectangleList = document.createElement("rectangleList");
            list.appendChild(rectangleList);

            Element ellipseList = document.createElement("ellipseList");
            list.appendChild(ellipseList);


            for (int lineCounter = 0; lineCounter < shapeDatabase.getLines().size(); lineCounter++) {
                Element line = document.createElement("line");
                line.setAttribute("id", lineCounter + "");

                Element startX = document.createElement("lineStartX");
                startX.setTextContent(String.valueOf(shapeDatabase.getLines().get(lineCounter).getStartX()));
                line.appendChild(startX);

                Element startY = document.createElement("lineStartY");
                startY.setTextContent(String.valueOf(shapeDatabase.getLines().get(lineCounter).getStartY()));
                line.appendChild(startY);

                Element endX = document.createElement("lineEndX");
                endX.setTextContent(String.valueOf(shapeDatabase.getLines().get(lineCounter).getEndX()));
                line.appendChild(endX);

                Element endY = document.createElement("lineEndY");
                endY.setTextContent(String.valueOf(shapeDatabase.getLines().get(lineCounter).getEndY()));
                line.appendChild(endY);

                Element strokeColor = document.createElement("lineStrokeColor");
                strokeColor.setTextContent(String.valueOf(shapeDatabase.getLines().get(lineCounter).getStroke()));
                line.appendChild(strokeColor);

                lineList.appendChild(line);

            }

            for (int rectCounter = 0; rectCounter < shapeDatabase.getRectangles().size(); rectCounter++) {
                Element rectangle = document.createElement("rectangle");
                rectangle.setAttribute("id", rectCounter + "");

                Element startX = document.createElement("rectStartX");
                startX.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getX()));
                rectangle.appendChild(startX);

                Element startY = document.createElement("rectStartY");
                startY.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getY()));
                rectangle.appendChild(startY);

                Element width = document.createElement("rectWidth");
                width.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getWidth()));
                rectangle.appendChild(width);

                Element height = document.createElement("rectHeight");
                height.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getHeight()));
                rectangle.appendChild(height);

                Element arcWidth = document.createElement("rectArcWidth");
                arcWidth.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getArcWidth()));
                rectangle.appendChild(arcWidth);

                Element arcHeight = document.createElement("rectArcHeight");
                arcHeight.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getArcHeight()));
                rectangle.appendChild(arcHeight);

                Element strokeColor = document.createElement("rectStrokeColor");
                strokeColor.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getStroke()));
                rectangle.appendChild(strokeColor);

                Element fillColor = document.createElement("rectFillColor");
                fillColor.setTextContent(String.valueOf(shapeDatabase.getRectangles().get(rectCounter).getFill()));
                rectangle.appendChild(fillColor);

                rectangleList.appendChild(rectangle);

            }

            for (int ellipseCounter = 0; ellipseCounter < shapeDatabase.getEllipses().size(); ellipseCounter++) {
                Element ellipse = document.createElement("ellipse");
                ellipse.setAttribute("id", ellipseCounter + "");

                Element centerX = document.createElement("ellipseCenterX");
                centerX.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getCenterX()));
                ellipse.appendChild(centerX);

                Element centerY = document.createElement("ellipseCenterY");
                centerY.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getCenterY()));
                ellipse.appendChild(centerY);

                Element radiusX = document.createElement("ellipseRadiusX");
                radiusX.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getRadiusX()));
                ellipse.appendChild(radiusX);

                Element radiusY = document.createElement("ellipseRadiusY");
                radiusY.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getRadiusY()));
                ellipse.appendChild(radiusY);

                Element strokeColor = document.createElement("ellipseStrokeColor");
                strokeColor.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getStroke()));
                ellipse.appendChild(strokeColor);

                Element fillColor = document.createElement("ellipseFillColor");
                fillColor.setTextContent(String.valueOf(shapeDatabase.getEllipses().get(ellipseCounter).getFill()));
                ellipse.appendChild(fillColor);

                ellipseList.appendChild(ellipse);

            }
            list.appendChild(lineList);
            list.appendChild(rectangleList);
            list.appendChild(ellipseList);


            document.appendChild(list);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | TransformerException ex) {

        }
    }

}
