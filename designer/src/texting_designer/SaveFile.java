package texting_designer;

import java.awt.*;

import javax.swing.*;
import java.io.File;

/**
 * <p>Title: TeXting Designer</p>
 *
 * <p>Description: IDE pro TeXting</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author Sef
 * @version 0.1
 */
public class SaveFile extends JDialog {
    JPanel panel1 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JFileChooser jFileChooser1 = new JFileChooser();

    public SaveFile(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jbInit();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public SaveFile() {
        this(new Frame(), "SaveFile", false);
    }

    private void jbInit() throws Exception {
        panel1.setLayout(borderLayout1);
        jFileChooser1.setDialogType(1);
        getContentPane().add(panel1);
        panel1.add(jFileChooser1, java.awt.BorderLayout.CENTER);
        this.jFileChooser1.setCurrentDirectory(new File("."));
    }
}
