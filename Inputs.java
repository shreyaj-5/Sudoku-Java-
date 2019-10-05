import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Inputs extends javax.swing.JPanel {

    private SudokuUI board;
    private JPanel block;
    private JButton inputButton;
    private int numberOfInput;
    /** Creates new form Inputs */
    public Inputs(SudokuUI board, JPanel block, JButton inButton, int numberOfInput) {
        this.board = board;
        this.block = block;
        this.inputButton = inButton;
        this.numberOfInput = numberOfInput;
        initComponents();

        }
    private void initComponents() {

        one = new JButton();
        two = new JButton();
        three = new JButton();
        four = new JButton();
        five = new JButton();
        six = new JButton();
        seven = new JButton();
        eight = new JButton();
        nine = new JButton();

        setLayout(new GridLayout(3, 3));

        one.setBackground(new Color(255, 255, 255));
        one.setText("1");
        one.setIconTextGap(1);
        one.setSize(15, 15);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }

        });
        add(one);

        two.setBackground(new Color(255, 255, 255));
        two.setText("2");
        two.setIconTextGap(1);
        two.setSize(15, 15);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(two);

        three.setBackground(new Color(255, 255, 255));
        three.setText("3");
        three.setIconTextGap(1);
        three.setMargin(new Insets(2, 2, 2, 2));
        three.setSize(15, 15);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(three);

        four.setBackground(new Color(255, 255, 255));
        four.setText("4");
        four.setIconTextGap(1);
        four.setSize(15, 15);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(four);

        five.setBackground(new Color(255, 255, 255));
        five.setText("5");
        five.setIconTextGap(1);
        five.setSize(15, 15);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(five);

        six.setBackground(new Color(255, 255, 255));
        six.setText("6");
        six.setIconTextGap(1);
        six.setSize(15, 15);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(six);

        seven.setBackground(new Color(255, 255, 255));
        seven.setText("7");
        seven.setIconTextGap(1);
        seven.setSize(15, 15);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(seven);

        eight.setBackground(new Color(255, 255, 255));
        eight.setText("8");
        eight.setIconTextGap(1);
        eight.setSize(15, 15);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(eight);

        nine.setBackground(new Color(255, 255, 255));
        nine.setText("9");
        nine.setIconTextGap(1);
        nine.setSize(15, 15);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setAns(evt);
            }
        });
        add(nine);
    }                        

    private void setAns(ActionEvent evt){
        board.setInput(evt.getActionCommand(), block, inputButton);
    }


    // Variables declaration                  
    private JButton eight;
    private JButton five;
    private JButton four;
    private JButton nine;
    private JButton one;
    private JButton seven;
    private JButton six;
    private JButton three;
    private JButton two;
                    

}
