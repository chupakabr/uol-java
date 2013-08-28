import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Created by myltik
 * Created on 8/27/13 2:47 PM
 */
public class DrawToolMenu extends JMenuBar {

    public static final String MENU_FILE_NEW = "New";
    public static final String MENU_FILE_SAVE = "Save";
    public static final String MENU_FILE_SAVE_AS = "Save as...";
    public static final String MENU_FILE_QUIT = "Quit";

    public static final String MENU_EDIT_CLEAR = "Clear";

    public static final String MENU_TOOL_PENCIL = "Pencil";
    public static final String MENU_TOOL_LINE = "Line";
    public static final String MENU_TOOL_RECT = "Rectangle";
    public static final String MENU_TOOL_CIRCLE = "Circle";

    public static final String MENU_LINE_COLOR = "Change color...";
    public static final String MENU_LINE_1px = "1px";
    public static final String MENU_LINE_2px = "2px";
    public static final String MENU_LINE_3px = "3px";
    public static final String MENU_LINE_4px = "4px";
    public static final String MENU_LINE_5px = "5px";

    public DrawToolMenu(ActionListener actionListener, ItemListener itemListener) {
        // Build menu items
        buildMenu();

        // Add listeners for each menu item
        for (int i = 0; i < getMenuCount(); ++i) {
            JMenu menu = getMenu(i);
            for (int k = 0; k < menu.getItemCount(); ++k) {
                JMenuItem cmp = menu.getItem(k);
                if (cmp instanceof JMenuItem) {
                    if (actionListener != null) {
                        cmp.addActionListener(actionListener);
                    }
                    if (itemListener != null) {
                        cmp.addItemListener(itemListener);
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
        menu.add(menuItem(MENU_FILE_NEW, true));
        menu.addSeparator();
        menu.add(menuItem(MENU_FILE_SAVE, false));
        menu.add(menuItem(MENU_FILE_SAVE_AS, false));
        menu.addSeparator();
        menu.add(menuItem(MENU_FILE_QUIT, true));
        add(menu);

        menu = new JMenu("Edit");
        menu.add(menuItem(MENU_EDIT_CLEAR, true));
        add(menu);

        menu = new JMenu("Tool");
        ButtonGroup group = new ButtonGroup();
        menu.add(radioButton(MENU_TOOL_PENCIL, group, true));
        menu.add(radioButton(MENU_TOOL_LINE, group));
        menu.add(radioButton(MENU_TOOL_RECT, group));
        menu.add(radioButton(MENU_TOOL_CIRCLE, group));
        add(menu);

        menu = new JMenu("Line");
        group = new ButtonGroup();
        menu.add(menuItem(MENU_LINE_COLOR, false));
        menu.addSeparator();
        menu.add(radioButton(MENU_LINE_1px, group, true));
        menu.add(radioButton(MENU_LINE_2px, group));
        menu.add(radioButton(MENU_LINE_3px, group));
        menu.add(radioButton(MENU_LINE_4px, group));
        menu.add(radioButton(MENU_LINE_5px, group));
        add(menu);
    }

    /**
     * Create menu item
     * @param title
     * @param enabled
     * @return Created menu item
     */
    private JMenuItem menuItem(String title, boolean enabled) {
        JMenuItem item = new JMenuItem(title);
        item.setEnabled(enabled);
        return item;
    }

    /**
     * Create radio button for specified name, add it to button's group and return instance of created radio button
     * @param menuItemTitle
     * @param group
     * @param checked
     * @return Created radio button
     */
    private JRadioButtonMenuItem radioButton(String menuItemTitle, ButtonGroup group, boolean checked) {
        JRadioButtonMenuItem item = radioButton(menuItemTitle, group);
        item.setSelected(checked);
        return item;
    }

    /**
     * Create radio button for specified name, add it to button's group and return instance of created radio button
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
