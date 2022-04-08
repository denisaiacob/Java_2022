package lab6;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    DrawingPanel canvas;
    JLabel label;
    JSpinner spinnerRows,spinnerCols;
    JButton createBtn = new JButton("Create");
    int rows=10, cols=10;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createBtn.addActionListener(this::createGame);

        add(label); //JPanel uses FlowLayout by default
        add(spinnerRows);
        add(spinnerCols);
        add(createBtn);
        spinnerCols.addChangeListener(this::addRows);
        spinnerCols.addChangeListener(this::addCols);
    }

    public void addRows(ChangeEvent e) {
          this.rows= (int) ((JSpinner)e.getSource()).getValue();
    }

    public void addCols(ChangeEvent e) {
        this.cols= (int) ((JSpinner)e.getSource()).getValue();
    }

    private void createGame(ActionEvent e) {
        frame.reinit();
    }
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

