# 🎨 Paint Brush – Java Swing Application

A **JFrame-based Paint application** built using Java Swing, allowing users to draw shapes, doodle freely, erase parts of drawings, undo actions, and clear the canvas.  
The application follows a clean object-oriented design and proper Swing painting principles.

---

## 📌 Features

### 🎨 Drawing Tools
- **Line**
- **Rectangle**
- **Oval**
- **Free Hand (Doodle)**

### 🖌️ Styling Options
- **Color Selection:** Red, Green, Blue
- **Filled Shapes:** Fill rectangles & ovals with selected color
- **Stroke Style:** Dotted / Solid stroke (toggle dashed line style)

### ❌ Editing Tools
- **Eraser Tool:** Erase specific parts of drawings (implemented as background-colored strokes)
- **Undo:** Undo the last drawing action
- **Clear All:** Remove all drawings from the canvas

---

## 🧠 Application Workflow

1. The user selects:
   - A color
   - A shape/tool
   - Optional styling options (Filled / Dotted)
2. The user draws using the mouse inside the drawing area.
3. Each drawing action is stored as an object.
4. The drawing panel redraws all stored shapes whenever `repaint()` occurs.
5. Undo and Clear operations manipulate the stored shape list.

**Design ensures:**
- Persistent drawings
- Proper repaint behavior
- Easy undo/redo extensibility

---

## 🗂️ Project Structure
<img width="386" height="369" alt="image" src="https://github.com/user-attachments/assets/4744b77d-0f28-428e-bcf7-d08ea11186f9" />



---

## 🧩 Class Responsibilities

**PaintApp**
- Creates the main window (`JFrame`)
- Builds the toolbar (buttons, checkboxes)
- Sends user selections (color, shape, options) to `DrawingPanel`

**DrawingPanel**
- Handles all mouse interactions
- Manages drawing logic
- Stores shapes in a list
- Repaints drawings using `paintComponent`
- Implements Free-hand drawing, Eraser, Undo, Clear All

**DrawShape**
- Represents one drawing action
- Stores:
  - Shape geometry
  - Color
  - Stroke style
  - Filled or outline state
- Enables undo and repaint consistency

---

## 🎯 Key Design Decisions

- Shapes are stored instead of drawing directly → prevents loss of drawings during repaint
- Eraser implemented as drawing background color → maintains undo support
- Each shape stores its own style → old drawings unaffected by new UI changes
- Free-hand drawing implemented using small line segments → smooth and responsive

---

## 🛠️ Technologies Used

- Java SE
- Java Swing
- AWT `Graphics2D`

---

## 🚀 How to Run

1. Open the project in **NetBeans / IntelliJ / Eclipse**
2. Make sure all files are in the same package: `paintapp`
3. Run `PaintApp.java`

---

## 👥 Authors

- **Omar Mamdouh Kandeel**
- **Reem Adel**
