package texting_designer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
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


public class Frame2 extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JToolBar jToolBar = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JTabbedPane jTabbedPane1 = new JTabbedPane();
    ImageIcon image1 = new ImageIcon(texting_designer.Frame2.class.getResource(
            "openFile.png"));
    ImageIcon image2 = new ImageIcon(texting_designer.Frame2.class.getResource(
            "closeFile.png"));
    ImageIcon image3 = new ImageIcon(texting_designer.Frame2.class.getResource(
            "help.png"));
    JMenuItem jMenuItem1 = new JMenuItem();
    JButton jButton4 = new JButton();
    JMenuItem jMenuItem2 = new JMenuItem();
    JButton jButton5 = new JButton();
    JMenuItem jMenuItem3 = new JMenuItem();

    public Frame2() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("TeXting Designer");
        jMenuFile.setText("File");
        jMenuFileExit.setText("Exit");
        jMenuFileExit.addActionListener(new Frame2_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("Help");
        jMenuHelpAbout.setText("About");
        jMenuHelpAbout.addActionListener(new
                                         Frame2_jMenuHelpAbout_ActionAdapter(this));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new Frame2_jMenuItem1_actionAdapter(this));
        jButton1.addActionListener(new Frame2_jButton1_actionAdapter(this));
        jButton2.addActionListener(new Frame2_jButton2_actionAdapter(this));
        jButton4.setIcon(null);
        jButton4.setText("Run");
        jButton4.addActionListener(new Frame2_jButton4_actionAdapter(this));
        jMenuItem2.setText("Open");
        jMenuItem2.addActionListener(new Frame2_jMenuItem2_actionAdapter(this));
        jButton5.setToolTipText("Save File as");
        jButton5.setText("Save as");
        jButton5.addActionListener(new Frame2_jButton5_actionAdapter(this));
        jMenuItem3.setText("Save as");
        jMenuItem3.addActionListener(new Frame2_jMenuItem3_actionAdapter(this));
        jMenuBar1.add(jMenuFile);
        jMenuFile.add(jMenuItem1);
        jMenuFile.add(jMenuItem3);
        jMenuFile.add(jMenuItem2);

        jMenuFile.addSeparator();
        jMenuFile.add(jMenuFileExit);
        jMenuBar1.add(jMenuHelp);
        jMenuHelp.add(jMenuHelpAbout);
        setJMenuBar(jMenuBar1);
        jButton1.setIcon(image1);
        jButton1.setToolTipText("Open File");
        jButton2.setIcon(image2);
        jButton2.setToolTipText("Close File");
        jButton3.setIcon(image3);
        jButton3.setToolTipText("Help");
        jToolBar.add(jButton1);
        jToolBar.add(jButton5);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);
        jToolBar.add(jButton4);
        contentPane.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        JScrollPane jScrollPane1 = (JScrollPane) jTabbedPane1.add("Noname",new JScrollPane());
        jScrollPane1.getViewport().add(new JEditorPane());
        jScrollPane1.getViewport().getComponent(0).setName("Noname");

        contentPane.add(jToolBar, BorderLayout.NORTH);
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        Frame2_AboutBox dlg = new Frame2_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }
/*
    * Novy tab
    */
    public void jMenuItem1_actionPerformed(ActionEvent e) {

        //JTabbedPane jTabbedPane1= (JTabbedPane) contentPane.add(new JTabbedPane());
        JScrollPane jScrollPane1 = (JScrollPane) jTabbedPane1.add("Noname",new JScrollPane());
jScrollPane1.getViewport().add(new JEditorPane());
        jScrollPane1.getViewport().getComponent(0).setName("Noname");

    /*JTabbedPane jTabbedPane1 = new JTabbedPane();
        JScrollPane jScrollPane1 = new JScrollPane();
        JEditorPane jEditorPane1 = new JEditorPane();

        contentPane.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        jTabbedPane1.add(jScrollPane1, "Noname");
        jScrollPane1.getViewport().add(jEditorPane1);*/
    }

/*
    *Open File
    */
    public void jButton1_actionPerformed(ActionEvent e) {
OpenFile file= new OpenFile();
        file.jFileChooser1.showOpenDialog(file);
        File fajl = file.jFileChooser1.getSelectedFile();
        //System.out.println(fajl.toString());
        try {
            String obsah = TextFile.read(fajl.toString());
            JScrollPane jScrollPane = null;
            try {
                jScrollPane = (JScrollPane) jTabbedPane1.getSelectedComponent();
                jScrollPane.setName(fajl.toString());
                JEditorPane jEditorPane1 = (JEditorPane) jScrollPane.getViewport().getComponent(0);
                jEditorPane1.setText(obsah);
                jEditorPane1.setName(fajl.toString());


            } catch (NullPointerException ex1) {
                JScrollPane jScrollPane1 = (JScrollPane) jTabbedPane1.add(fajl.toString(),new JScrollPane());
                jScrollPane1.getViewport().add(new JEditorPane("text/plain",obsah));
                jScrollPane1.getViewport().getComponent(0).setName(fajl.toString());
            }

            //System.out.println(obsah);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }
/*
    *Close File
    */

    public void jButton2_actionPerformed(ActionEvent e) {
        JScrollPane jScrollPane = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JEditorPane jEditorPane1 = (JEditorPane) jScrollPane.getViewport().getComponent(0);
        //String obsah = jEditorPane1.getText();
        jTabbedPane1.remove(jScrollPane);
    }

/*
 *   Run
 */
    public void jButton4_actionPerformed(ActionEvent e) {
        JScrollPane jScrollPane = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JEditorPane jEditorPane1 = (JEditorPane) jScrollPane.getViewport().getComponent(0);
        String obsah = jEditorPane1.getText();
        //System.out.println(jEditorPane1.getName());
        try {
            TextFile.write(jEditorPane1.getName(), obsah);
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
        Runtime runtime = Runtime.getRuntime();
        File cesta= new File(".");
        try {
            // pro Linux
          Process process = runtime.exec("xterm -e ./TeXting "+jEditorPane1.getName(),null,cesta);
 // Pro widle NT/XP
        //    Process process = runtime.exec("cmd.exe /k \"START TeXting.exe \""+jEditorPane1.getName(),null,cesta);
            //System.out.println("cmd.exe /e:1900 /k \"TeXting.exe tmp.txt\"");
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());

        }

    }

/*
 * Save as
 */
    public void jButton5_actionPerformed(ActionEvent e) {
        SaveFile file=new SaveFile();
        file.jFileChooser1.showSaveDialog(file);
        File fajl = file.jFileChooser1.getSelectedFile();
        JScrollPane jScrollPane = (JScrollPane) jTabbedPane1.getSelectedComponent();
        JEditorPane jEditorPane1 = (JEditorPane) jScrollPane.getViewport().getComponent(0);
        String obsah = jEditorPane1.getText();

        try {
            TextFile.write(fajl.toString(), obsah);
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
        jEditorPane1.setName(fajl.toString());

    }
}


class Frame2_jMenuItem3_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jMenuItem3_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton5_actionPerformed(e);
    }
}


class Frame2_jButton5_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jButton5_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {

        adaptee.jButton5_actionPerformed(e);
    }
}


class Frame2_jMenuItem2_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jMenuItem2_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class Frame2_jButton4_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jButton4_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton4_actionPerformed(e);
    }
}


class Frame2_jButton2_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jButton2_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton2_actionPerformed(e);
    }
}


class Frame2_jButton1_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jButton1_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }
}


class Frame2_jMenuItem1_actionAdapter implements ActionListener {
    private Frame2 adaptee;
    Frame2_jMenuItem1_actionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class Frame2_jMenuFileExit_ActionAdapter implements ActionListener {
    Frame2 adaptee;

    Frame2_jMenuFileExit_ActionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class Frame2_jMenuHelpAbout_ActionAdapter implements ActionListener {
    Frame2 adaptee;

    Frame2_jMenuHelpAbout_ActionAdapter(Frame2 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}
