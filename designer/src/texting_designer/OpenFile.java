package texting_designer;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
public class OpenFile extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JFileChooser jFileChooser1 = new JFileChooser();


    public OpenFile() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(borderLayout1);
        jFileChooser1.setAcceptAllFileFilterUsed(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setTitle("Open script");
        this.getContentPane().add(jFileChooser1, java.awt.BorderLayout.CENTER);
        jFileChooser1.addActionListener(new
                                        OpenFile_jFileChooser1_actionAdapter(this));
        this.jFileChooser1.setCurrentDirectory(new File("."));
    }

    public void jFileChooser1_actionPerformed(ActionEvent e) {
        /*File fajl=jFileChooser1.getSelectedFile();
        System.out.println(fajl.toString());
        try {
            String obsah = TextFile.read(fajl.toString());
        } catch (IOException ex) {
            System.out.println("Error" + ex.getLocalizedMessage());
        }*/

    }
}


class OpenFile_jFileChooser1_actionAdapter implements ActionListener {
    private OpenFile adaptee;
    OpenFile_jFileChooser1_actionAdapter(OpenFile adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jFileChooser1_actionPerformed(e);
    }
}
