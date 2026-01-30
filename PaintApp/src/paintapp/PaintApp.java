package paintapp;

import javax.swing.*;
import java.awt.*;
import paintapp.DrawingPanel.ShapeType;

/**
 *
 * @author Omar Mamdouh Kandeel
 * @author Reem Adel
 */
public class PaintApp extends JFrame {
// hello from the other sideeee

    /**
     * @param args the command line arguments
     */
    public PaintApp() {
        setTitle("Paint Brush");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Toolbar (Top)
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(toolbar, BorderLayout.NORTH);
        toolbar.setSize(1000, 200);

        // Drawing Area (Center)
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        //***************************************** Button Section  *****************************************//
        JButton redBtn = new JButton("Red");
        JButton greenBtn = new JButton("Green");
        JButton blueBtn = new JButton("Blue");

        toolbar.add(redBtn);
        toolbar.add(greenBtn);
        toolbar.add(blueBtn);
        //  Style the Red Button
        redBtn.setBackground(Color.RED);
        redBtn.setForeground(Color.WHITE); // Make text white for better contrast
        redBtn.setBorderPainted(false);

        //Style the Green Button
        greenBtn.setBackground(Color.GREEN);
        greenBtn.setForeground(Color.BLACK); // Black text usually looks better on green
        greenBtn.setBorderPainted(false);

        //Style the Blue Button
        blueBtn.setBackground(Color.BLUE);
        blueBtn.setForeground(Color.WHITE);
        blueBtn.setBorderPainted(false);

        //The functionality of the buttons using ActionListner
        redBtn.addActionListener(e -> drawingPanel.setCurrentColor(Color.RED));
        greenBtn.addActionListener(e -> drawingPanel.setCurrentColor(Color.GREEN));
        blueBtn.addActionListener(e -> drawingPanel.setCurrentColor(Color.BLUE));
        //*******************************************************************************************//

        //***************************************** Shape Section  *****************************************//
        JButton rectBtn = new JButton("Rectangle");
        JButton ovalBtn = new JButton("Oval");
        JButton lineBtn = new JButton("Line");
        JButton freeBtn = new JButton("Free Hand");
        JButton eraserBtn = new JButton("Eraser");

        toolbar.add(rectBtn);
        toolbar.add(ovalBtn);
        toolbar.add(lineBtn);
        toolbar.add(freeBtn);
        toolbar.add(eraserBtn);

        rectBtn.addActionListener(e -> drawingPanel.setCurrentShape(ShapeType.RECTANGLE));
        ovalBtn.addActionListener(e -> drawingPanel.setCurrentShape(ShapeType.OVAL));
        lineBtn.addActionListener(e -> drawingPanel.setCurrentShape(ShapeType.LINE));
        freeBtn.addActionListener(e -> drawingPanel.setCurrentShape(ShapeType.FREE_HAND));
        eraserBtn.addActionListener(e -> drawingPanel.setCurrentShape(ShapeType.ERASER));

        //*******************************************************************************************//
        //***************************************** Filled Cheeck Box Section  ******************************************//
        JCheckBox filledCheck = new JCheckBox("Filled");
        toolbar.add(filledCheck);

        filledCheck.addActionListener(e
                -> drawingPanel.setFilled(filledCheck.isSelected())
        );

        //***************************************************************************************************************//
        //***************************************** Dotted Cheeck Box Section  ******************************************//
        JCheckBox dottedCheck = new JCheckBox("Dotted");
        toolbar.add(dottedCheck);

        dottedCheck.addActionListener(e
                -> drawingPanel.setDotted(dottedCheck.isSelected())
        );

        //***************************************************************************************************************// 
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(PaintApp::new);
    }

}
