import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by myltik
 * Created on 8/27/13 2:47 PM
 */
public class DrawTool extends JPanel implements ActionListener, ItemListener, MouseListener, MouseMotionListener {

    private static enum Type {
        PENCIL, LINE, RECT, CIRCLE
    }

    protected final JMenuBar menu;

    private static final Color BG_COLOR = Color.WHITE;
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private int prevX = -1;
    private int prevY = -1;
    private int lastX = -1;
    private int lastY = -1;

    protected Type currentTool = Type.PENCIL;
    protected Color currentColor = DEFAULT_COLOR;
    protected int currentLineWidth = 1;

    private boolean currentlyPressed = false;

    public DrawTool(int width, int height) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMinimumSize(new Dimension(width, height));

        menu = new DrawToolMenu(this, this);

        setBackground(BG_COLOR);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * @return Menu object
     */
    public JMenuBar getMenu() {
        return menu;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        final String action = actionEvent.getActionCommand();

        if (DrawToolMenu.MENU_FILE_NEW.equals(action)) {
            createNew();
        } else if (DrawToolMenu.MENU_FILE_QUIT.equals(action)) {
            quit();
        } else if (DrawToolMenu.MENU_EDIT_CLEAR.equals(action)) {
            clearAll();
        } else if (DrawToolMenu.MENU_LINE_COLOR.equals(action)) {
            changeColor();
        } else if (DrawToolMenu.MENU_LINE_1px.equals(action)) {
            changeLine(1);
        } else if (DrawToolMenu.MENU_LINE_2px.equals(action)) {
            changeLine(2);
        } else if (DrawToolMenu.MENU_LINE_3px.equals(action)) {
            changeLine(3);
        } else if (DrawToolMenu.MENU_LINE_4px.equals(action)) {
            changeLine(4);
        } else if (DrawToolMenu.MENU_LINE_5px.equals(action)) {
            changeLine(5);
        } else if (DrawToolMenu.MENU_TOOL_PENCIL.equals(action)) {
            changeTool(Type.PENCIL);
        } else if (DrawToolMenu.MENU_TOOL_LINE.equals(action)) {
            changeTool(Type.LINE);
        } else if (DrawToolMenu.MENU_TOOL_RECT.equals(action)) {
            changeTool(Type.RECT);
        } else if (DrawToolMenu.MENU_TOOL_CIRCLE.equals(action)) {
            changeTool(Type.CIRCLE);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public synchronized void mousePressed(MouseEvent mouseEvent) {
        currentlyPressed = true;

        prevX = lastX;
        prevY = lastY;
        lastX = mouseEvent.getX();
        lastY = mouseEvent.getY();
    }

    @Override
    public synchronized void mouseReleased(MouseEvent mouseEvent) {
        currentlyPressed = false;

        prevX = lastX;
        prevY = lastY;
        lastX = mouseEvent.getX();
        lastY = mouseEvent.getY();

        final Graphics2D g = (Graphics2D)getGraphics();
        if (currentTool == Type.LINE) {
            g.drawLine(prevX, prevY, lastX, lastY);
        } else if (currentTool == Type.RECT) {
            int width = prevX > lastX ? prevX - lastX : lastX - prevX;
            int height = prevY > lastY ? prevY - lastY : lastY - prevY;
            g.drawRect(prevX<lastX?prevX:lastX, prevY<lastY?prevY:lastY, width, height);
        } else if (currentTool == Type.CIRCLE) {
            int width = prevX > lastX ? prevX - lastX : lastX - prevX;
            int height = prevY > lastY ? prevY - lastY : lastY - prevY;
            g.drawOval(prevX < lastX ? prevX : lastX, prevY < lastY ? prevY : lastY, width, height);
        }
    }

    @Override
    public synchronized void mouseDragged(MouseEvent mouseEvent) {
        if (currentlyPressed && currentTool == Type.PENCIL) {
            final Graphics g = getGraphics();

            prevX = lastX;
            prevY = lastY;
            lastX = mouseEvent.getX();
            lastY = mouseEvent.getY();

            g.drawLine(prevX, prevY, lastX, lastY);
            //int width = currentLineWidth>1?currentLineWidth:2;
            //g.fillOval(mouseEvent.getX(), mouseEvent.getY(), width, width);
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        getGraphics().setColor(currentColor);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    /**
     * Quit app
     */
    private synchronized void quit() {
        System.exit(0);
    }

    /**
     * Change current tool
     * @param tool
     */
    private synchronized void changeTool(Type tool) {
        currentTool = tool;
    }

    /**
     * Change line width
     * @param lineWidth
     */
    private synchronized void changeLine(int lineWidth) {
        currentLineWidth = lineWidth;
        // TODO Make it work
        ((Graphics2D)getGraphics()).setStroke(new BasicStroke(lineWidth));
    }

    /**
     * Change current color
     * Note: Not implemented in this version
     */
    private synchronized void changeColor() {
        // TODO Show color picker
        getGraphics().setColor(currentColor);
    }

    /**
     * Clear drawing field
     */
    private synchronized void clearAll() {
        repaint();
    }

    /**
     * Create new file
     * Note: just clear current field in this implementation
     */
    private synchronized void createNew() {
        clearAll();
    }
}
