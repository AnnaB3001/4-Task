import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;

public class Frame extends JFrame {
    private JButton nextButton;
    private JButton startButton;
    private JButton previousButton;
    private JTable mainTable;
    private JPanel mainPanel;
    private JTextField textFieldJ;
    private JTextField textFieldI;
    private int index;
    private JFrame frame;

    private boolean stopWatchIsWorking = false;
    private SortState sortState;
    private MyLinkedList<SortState> list;
    private Timer timer;
    private MyTimerTask task = new MyTimerTask();

    public Frame(int[] array, MyLinkedList<SortState> sortStates) {
        super("Task 4 Prev");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        frame = this;

        list = sortStates;
        index = 0;
        JTableUtils.initJTableForArray(mainTable, 70, true, true, false, false);
        JTableUtils.writeArrayToJTable(mainTable, sortStates.getFirstElement().getArray());
        sortState = sortStates.getFirstElement();
        textFieldI.setText(Integer.toString(sortState.getI()));
        textFieldJ.setText(Integer.toString(sortState.getJ()));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index++;
                try {
                    sortState = list.get(index);
                } catch (Exception e) {
                    index--;
                }
                JTableUtils.writeArrayToJTable(mainTable, sortState.getArray());
                textFieldI.setText(Integer.toString(sortState.getI()));
                textFieldJ.setText(Integer.toString(sortState.getJ()));
                frame.repaint();
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (stopWatchIsWorking) {
                    timer.cancel();
                    task.cancel();
                    //task = new MyTimerTask();
                    startButton.setText("Start");
                    stopWatchIsWorking = false;
                } else {
                    startButton.setText("Stop");
                    timer = new Timer();
                    task = new MyTimerTask();
                    timer.scheduleAtFixedRate(task,0,2000);
                    stopWatchIsWorking = true;
                }
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                index--;
                try {
                    sortState = list.get(index);
                } catch (Exception e) {
                    index++;
                }
                JTableUtils.writeArrayToJTable(mainTable, sortState.getArray());
                textFieldI.setText(Integer.toString(sortState.getI()));
                textFieldJ.setText(Integer.toString(sortState.getJ()));
                frame.repaint();
            }
        });
    }


    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (stopWatchIsWorking) {
                index++;
                try {
                    sortState = list.get(index);
                } catch (Exception e) {
                    startButton.setText("Start");
                    stopWatchIsWorking = false;
                }
                if (sortState != null) {
                    JTableUtils.writeArrayToJTable(mainTable, sortState.getArray());
                    textFieldI.setText(Integer.toString(sortState.getI()));
                    textFieldJ.setText(Integer.toString(sortState.getJ()));
                    frame.repaint();
                }
            }
        }
    }
}
