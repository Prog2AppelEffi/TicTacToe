import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{

    private JLabel name1 = new JLabel("name1 win", JLabel.CENTER);
    private JLabel name2 = new JLabel("name2 win", JLabel.CENTER);
    private JLabel undecided = new JLabel("undecided", JLabel.CENTER);  
    private JLabel counter1 = new JLabel("1", JLabel.CENTER);
    private JLabel counter2 = new JLabel("2", JLabel.CENTER);
    private JLabel counter3 = new JLabel("6", JLabel.CENTER);
    private JButton restButton = new JButton("reset game");
    private JButton newNameButton = new JButton("new name");
    private JButton field00 = new JButton("00");
    private JButton field01 = new JButton("01");
    private JButton field02 = new JButton("02");
    private JButton field10 = new JButton("10");
    private JButton field11 = new JButton("11");
    private JButton field12 = new JButton("12");
    private JButton field20 = new JButton("20");
    private JButton field21 = new JButton("21");
    private JButton field22 = new JButton("22");

    private JPanel containerRight = new JPanel(new GridLayout(3,3,5,5));
    private JPanel containerLeft = new JPanel(new GridLayout(2,1,5,5));
    private JPanel containerInformation = new JPanel(new GridLayout(3,2,5,5));
    private JPanel containerButtons = new JPanel(new GridLayout(2,1,5,5));
    
    public MainWindow(String n1, String n2){

        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        setSize(600, 300);
        setVisible(true);
        setLayout(new GridLayout(1,2,5,5));
        name1.setText(n1);
        name2.setText(n2);
        add(containerLeft);
        add(containerRight);

//==============================Rahmen setzen===============================================

        name1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        name2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        undecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));    
        counter1.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        counter2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        counter3.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        containerRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        containerLeft.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

//==================================Spielfeld==============================================================

        containerRight.add(field00);
        containerRight.add(field01);
        containerRight.add(field02);
        containerRight.add(field10);
        containerRight.add(field11);
        containerRight.add(field12);
        containerRight.add(field20);
        containerRight.add(field21);
        containerRight.add(field22);
        
//==================================linkes Feld======================================================

        containerInformation.add(name1);
        containerInformation.add(counter1);
        containerInformation.add(name2);
        containerInformation.add(counter2);
        containerInformation.add(undecided);
        containerInformation.add(counter3);

        containerButtons.add(restButton);
        containerButtons.add(newNameButton);

        containerLeft.add(containerInformation);
        containerLeft.add(containerButtons);
                  
    }
}