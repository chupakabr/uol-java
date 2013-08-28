import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by myltik
 * Created on 8/27/13 2:47 PM
 */
public class DrawTool extends JPanel implements ActionListener, ItemListener {

    private final int origWidth;
    private final int origHeight;

    public DrawTool(int width, int height) {
        this.origWidth = width;
        this.origHeight = height;


    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // TODO
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        // TODO
    }
}
