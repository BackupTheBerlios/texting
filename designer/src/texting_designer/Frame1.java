package texting_designer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
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
public class Frame1 extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JLabel statusBar = new JLabel();
    JTextArea jTextArea1 = new JTextArea();
    JMenu jMenuSkript = new JMenu();
    JMenuItem jMenuRun = new JMenuItem();

    public Frame1() {
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
        setTitle("TeXting Constructor");
        statusBar.setText(" ");
        jMenuFile.setText("File");
        jMenuFileExit.setText("Exit");
        jMenuFileExit.addActionListener(new Frame1_jMenuFileExit_ActionAdapter(this));
        jMenuSkript.setText("Skript");
        jMenuRun.setText("Spust");
        jMenuRun.addActionListener(new Frame1_jMenuRun_actionAdapter(this));
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenuSkript);
        jMenuFile.add(jMenuFileExit);
        setJMenuBar(jMenuBar1);
        contentPane.add(statusBar, BorderLayout.SOUTH);
        contentPane.add(jTextArea1, java.awt.BorderLayout.CENTER);
        jMenuSkript.add(jMenuRun);
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void jMenuRun_actionPerformed(ActionEvent e) {
        String s2=jTextArea1.getText();
        String s = new String();
        //System.out.println(s2);


            BufferedReader in4 = new BufferedReader(
            new StringReader(s2));
            PrintWriter out1 = null;
            try {
                out1 = new PrintWriter(
                        new BufferedWriter(new FileWriter("tmp.txt")));
            } catch (IOException ex1) {
                System.err.println("End of stream");
            }

            try {
                while ((s = in4.readLine()) != null) {
                    out1.println(s);
                }
            } catch (IOException ex2) {
                System.err.println("Chybka");
            }
            out1.close();



        Runtime runtime = Runtime.getRuntime();
        File cesta= new File(".");
        try {
            // pro Linux
//           Process process = runtime.exec("xterm -e wine TeXting.exe tmp.txt",null,cesta);
 // Pro widle NT/XP
            Process process = runtime.exec("cmd.exe /k \"START TeXting.exe tmp.txt\"",null,cesta);
            //System.out.println("cmd.exe /e:1900 /k \"TeXting.exe tmp.txt\"");
        } catch (IOException ex) {
            System.out.println("Error: "+ ex.getMessage());

        }
    }
}


class Frame1_jMenuFileExit_ActionAdapter implements ActionListener {
    Frame1 adaptee;

    Frame1_jMenuFileExit_ActionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class Frame1_jMenuRun_actionAdapter implements ActionListener {
    private Frame1 adaptee;
    Frame1_jMenuRun_actionAdapter(Frame1 adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuRun_actionPerformed(e);
    }
}
