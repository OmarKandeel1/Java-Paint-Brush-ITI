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

