package paintapp;

import java.awt.*;

public class DrawShape {

    public Shape shape;
    public Color color;
    public Stroke stroke;
    public boolean filled;

    public DrawShape(Shape shape, Color color, Stroke stroke, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.stroke = stroke;
        this.filled = filled;
    }
}
