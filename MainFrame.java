import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class MainFrame extends JFrame {
    private MyLinkedList<SortState> list;
    private int[] array;

    private JTable mainTable;
    private JButton sortButton;
    private JButton openButton;
    private JButton saveButton;
    private JPanel mainPanel;

    public MainFrame() {
        super("Task 4");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        list = new MyLinkedList<>();
        JTableUtils.initJTableForArray(mainTable, 70, true, true, false, true);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileOpen = new JFileChooser();
                fileOpen.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("File(.txt)", "txt");
                fileOpen.addChoosableFileFilter(filter);
                int ret = fileOpen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileOpen.getSelectedFile();
                    String nameFile = file.getPath();
                    try {
                        array = WorkWithFile.fileToArrayInt(nameFile);
                        JTableUtils.writeArrayToJTable(mainTable, array);
                    } catch (NullPointerException | FileNotFoundException | NumberFormatException e ) {
                        JOptionPane.showMessageDialog(null, "Ошибка загрузки файла!", "Output", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               array = JTableUtils.readIntArrayFromJTable(mainTable);
               SelectionSort.sortSave(array,list);
               JTableUtils.writeArrayToJTable(mainTable,array);
               new Frame(array,list);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
