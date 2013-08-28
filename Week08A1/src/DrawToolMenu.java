import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Created by myltik
 * Created on 8/27/13 2:47 PM
 */
public class DrawToolMenu extends JMenuBar {

    public final String MENU_FILE_NEW = "New";
    public final String MENU_FILE_SAVE = "Save";
    public final String MENU_FILE_SAVE_AS = "Save as...";
    public final String MENU_FILE_QUIT = "Quit";

    public final String MENU_EDIT_CLEAR = "Clear";

    public final String MENU_TOOL_PENCIL = "Pencil";
    public final String MENU_TOOL_CIRCLE = "Circle";
    public final String MENU_TOOL_RECT = "Rectangle";

    public final String MENU_LINE_COLOR = "Change color...";
    public final String MENU_LINE_1px = "1px";
    public final String MENU_LINE_2px = "2px";
    public final String MENU_LINE_3px = "3px";
    public final String MENU_LINE_4px = "4px";
    public final String MENU_LINE_5px = "5px";

    public DrawToolMenu(ActionListener actionListener, ItemListener itemListener) {
        // Build menu items
        buildMenu();

        // Add listeners for each menu item
        for (int i = 0; i < getMenuCount(); ++i) {
            for (Component cmp : getMenu(i).getComponents()) {
                if (cmp instanceof JMenuItem) {
                    if (actionListener != null) {
                        ((JMenuItem) cmp).addActionListener(actionListener);
                    }
                    if (itemListener != null) {
                        ((JMenuItem) cmp).addItemListener(itemListener);
                    }
                }
            }
        }
    }

    /**
     * Build menu
     */
    private void buildMenu() {
        JMenu menu = new JMenu("File");
        menu.add(new JMenuItem(MENU_FILE_NEW));
        menu.addSeparator();
        menu.add(new JMenuItem(MENU_FILE_SAVE));
        menu.add(new JMenuItem(MENU_FILE_SAVE_AS));
        menu.addSeparator();
        menu.add(new JMenuItem(MENU_FILE_QUIT));
        add(menu);

        menu = new JMenu("Edit");
        menu.add(new JMenuItem(MENU_EDIT_CLEAR));
        add(menu);

        menu = new JMenu("Tool");
        ButtonGroup group = new ButtonGroup();
        menu.add(radioButton(MENU_TOOL_PENCIL, group));
        menu.add(radioButton(MENU_TOOL_CIRCLE, group));
        menu.add(radioButton(MENU_TOOL_RECT, group));
        add(menu);

        menu = new JMenu("Line");
        group = new ButtonGroup();
        menu.add(new JMenuItem(MENU_LINE_COLOR));
        menu.addSeparator();
        menu.add(radioButton(MENU_LINE_1px, group));
        menu.add(radioButton(MENU_LINE_2px, group));
        menu.add(radioButton(MENU_LINE_3px, group));
        menu.add(radioButton(MENU_LINE_4px, group));
        menu.add(radioButton(MENU_LINE_5px, group));
        add(menu);
    }

    /**
     * Create radio button for specified name, add it to button's group and return instance of created radio button∂
     * @param menuItemTitle
     * @param group
     * @return Created radio button
     */
    private JRadioButtonMenuItem radioButton(String menuItemTitle, ButtonGroup group) {
        JRadioButtonMenuItem radioItem = new JRadioButtonMenuItem(menuItemTitle);
        group.add(radioItem);
        return radioItem;
    }
}
