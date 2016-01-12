import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GUI {
    private JButton genButton;
    private JList list1;
    private JTextArea textArea1;
    private JComboBox comboBox1;
    private JPanel MainFrame;
    private JButton button1;

    private int count = 0;

    /*Set Classes*/
    private static String[] secondPeriod = {"Daniel", "Dalton", "Devin", "Ja\'Mesha", "Chelsea", "Hank", "Jacqui",
            "Matthew", "Nick", "Ben", "Chris", "Sean", "Chase", "Zeb",  "Jacob", "Noah", "Aaron", "Zack"};
    private static String[] thirdPeriod = {"Khalifa", "Matthew", "Blaine", "Kendall", "Cameron", "Danielle", "Spencer",
            "Kelton", "Daisy", "Landon", "Jacob", "Michael", "Alex", "Kaden", "Jessica", "Sarah", "Braxton", "Zack"};
    private static String[] sixthPeriod = {"Kevin", "Michael", "Korrigan", "Adan", "Cameron", "Vincent", "Kyle", "Andrew"};
    /*Set Classes*/

    private static String[] classes = {"2nd Period", "3rd Period", "6th Period"};

    public GUI() {

        textArea1.setText("Generated names will appear below\n");

        /*set list elements at startup*/
        switch (comboBox1.getSelectedIndex()) {
            case 0:
                list1.setListData(secondPeriod);
                break;
            case 1:
                list1.setListData(thirdPeriod);
                break;
            case 2:
                list1.setListData(sixthPeriod);
                break;
        }
        /*set list elements at startup*/

        genButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText(textArea1.getText() + "\n" + (++count) + ":\t" + getRandom(comboBox1.getSelectedIndex()));
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Generated names will appear below\n");
                count = 0;
                switch (comboBox1.getSelectedIndex()) {
                    case 0:
                        list1.setListData(secondPeriod);
                        break;
                    case 1:
                        list1.setListData(thirdPeriod);
                        break;
                    case 2:
                        list1.setListData(sixthPeriod);
                        break;
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("Generated names will appear below\n");
                count = 0;
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Random Student Picker");
        frame.setPreferredSize(new Dimension(640, 400));
        frame.setContentPane(new GUI().MainFrame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String getRandom(int n) {
        Random randomGenerator = new Random();
        String[] arr = {};

        switch (comboBox1.getSelectedIndex()) {
            case 0:
                arr = secondPeriod;
                break;
            case 1:
                arr = thirdPeriod;
                break;
            case 2:
                arr = sixthPeriod;
                break;
        }
        int index = randomGenerator.nextInt(arr.length);
        return arr[index];
    }

    private void createUIComponents() {
        comboBox1 = new JComboBox(classes);
    }
}