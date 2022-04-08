package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ControlPanel extends JPanel implements Serializable {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn =new JButton("Load");
    JButton restBtn =new JButton("Deserialize");
    JButton saveBtn =new JButton("Save");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1, 4));
        add(exitBtn);
        add(loadBtn);
        add(restBtn);
        add(saveBtn);
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        restBtn.addActionListener(this::restGame);
        saveBtn.addActionListener(e -> {
            try {
                saveGame(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void saveGame(ActionEvent e) throws IOException {
        frame.canvas.saveImg();
    }
    private void loadGame(ActionEvent e) {
       // frame.dispose();
        try {
            FileOutputStream fileOut = new FileOutputStream("joc.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(frame.canvas);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in joc.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    private void restGame(ActionEvent m){
        MainFrame e=null;
        try {
            FileInputStream fileIn = new FileInputStream("joc.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (MainFrame) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
       e.add(e.configPanel,e.controlPanel);

    }

}

