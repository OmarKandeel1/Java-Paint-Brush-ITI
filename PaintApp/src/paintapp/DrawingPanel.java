package paintapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

//*****************************     Private Section *******************************//
    private Color currentColor = Color.RED;
    private ShapeType currentShape = ShapeType.LINE; //Line is the defult //shape class

    private List<DrawShape> shapes = new ArrayList<>();
    private int startX, startY, endX, endY;
    private DrawShape previewShape;
    private boolean filled = false; // default value of filled is not filled "FALSE"
    private boolean dotted = false;
    private int prevX, prevY; // For hand drawing Doodle mood i need this to track my current point and the point in Previous to draw a tiny Line.

    private void createPreviewShape() {
        int x = Math.min(startX, endX);
        int y = Math.min(startY, endY);
        int w = Math.abs(startX - endX);
        int h = Math.abs(startY - endY);

        Shape shape = null;

        switch (currentShape) {
            case RECTANGLE:
                shape = new Rectangle(x, y, w, h);
                break;

            case OVAL:
                shape = new java.awt.geom.Ellipse2D.Float(x, y, w, h);
                break;

            case LINE:
                shape = new java.awt.geom.Line2D.Float(startX, startY, endX, endY);
                break;

            default:
                return;
        }

        previewShape = new DrawShape(
                shape,
                currentColor,
                createStroke(),
                filled
        );
    }

    private Stroke createStroke() {
        if (dotted) {
            return new BasicStroke(
                    2,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10,
                    new float[]{5},
                    0
            );
        } else {
            return new BasicStroke(2);
        }
    }
//*****************************     Public Section *******************************// 

    public DrawingPanel() {
        setBackground(Color.WHITE);
        //*****************************  Mouse Press & Release *****************************// 
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                prevX = startX;
                prevY = startY;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentShape == ShapeType.FREE_HAND) {
                    return;
                }

                if (previewShape != null) {
                    shapes.add(previewShape);   // make shape permanent
                    previewShape = null;
                    repaint();
                }
            }
        });

        //********************************** Mouse Drag **********************************//
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                if (currentShape == ShapeType.FREE_HAND) {
                    Shape line = new java.awt.geom.Line2D.Float(prevX, prevY, endX, endY);

                    shapes.add(new DrawShape(
                            line,
                            currentColor,
                            createStroke(),
                            false
                    ));

                    prevX = endX;
                    prevY = endY;

                    repaint();
                    return;
                }

                createPreviewShape();
                repaint();
            }

        });
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setCurrentShape(ShapeType shapeType) {
        this.currentShape = shapeType;
    }

    public enum ShapeType { //shape class
        RECTANGLE, OVAL, LINE, FREE_HAND, ERASER
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void setDotted(boolean dotted) {
        this.dotted = dotted;
    }

//*****************************     protected Section *******************************//     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (DrawShape s : shapes) {
            g2.setColor(s.color);
            g2.setStroke(s.stroke);
            g2.draw(s.shape);
            if (s.filled && !(s.shape instanceof java.awt.geom.Line2D)) {
                g2.fill(s.shape);
            } else {
                g2.draw(s.shape);
            }
        }

        if (previewShape != null) {
            g2.setColor(previewShape.color);
            g2.setStroke(previewShape.stroke);

            if (previewShape.filled && !(previewShape.shape instanceof java.awt.geom.Line2D)) {
                g2.fill(previewShape.shape);
            } else {
                g2.draw(previewShape.shape);
            }
        }

    }
}
