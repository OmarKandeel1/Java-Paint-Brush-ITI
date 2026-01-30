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

//*****************************     Public Section *******************************// 
    public DrawingPanel() {
        setBackground(Color.WHITE);
        
        
        
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    void setCurrentShape(ShapeType shapeType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public enum ShapeType { //shape class
        RECTANGLE, OVAL, LINE, FREE_HAND, ERASER
    }

//*****************************     protected Section *******************************//     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // drawing will come here later
    }
}
