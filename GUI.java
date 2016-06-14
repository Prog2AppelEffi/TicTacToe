import javax.swing.*;
import java.awt.*;

public class GUI{

	public void mainWindow(){
		Runnable guiCreator = new Runnable() {
            public void run() {
 
                JFrame mainWindow = new JFrame("Tic Tac Toe");
                mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainWindow.setResizable(false);
				mainWindow.setLocationRelativeTo(null);  

                JLabel name1 = new JLabel("name1 win", JLabel.CENTER);
                JLabel name2 = new JLabel("name2 win", JLabel.CENTER);
                JLabel undecided = new JLabel("undecided", JLabel.CENTER);
                JLabel counter1 = new JLabel("1", JLabel.CENTER);
                JLabel counter2 = new JLabel("2", JLabel.CENTER);
                JLabel counter3 = new JLabel("6", JLabel.CENTER);
                JButton restButton = new JButton("reset game");
                JButton newNameButton = new JButton("new name");
                JButton field00 = new JButton("00");
                JButton field01 = new JButton("01");
                JButton field02 = new JButton("02");
                JButton field10 = new JButton("10");
                JButton field11 = new JButton("11");
                JButton field12 = new JButton("12");
                JButton field20 = new JButton("20");
                JButton field21 = new JButton("21");
                JButton field22 = new JButton("22");

                name1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                name2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                undecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
                counter1.setBorder(BorderFactory.createLineBorder(Color.black, 1));	
                counter2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                counter3.setBorder(BorderFactory.createLineBorder(Color.black, 1));

//==================================Spielfeld==============================================================

                JPanel containerField = new JPanel(new GridLayout(3,3,5,5));
			    containerField.add(field00);
			    containerField.add(field01);
			    containerField.add(field02);
			    containerField.add(field10);
			    containerField.add(field11);
			    containerField.add(field12);
			    containerField.add(field20);
			    containerField.add(field21);
			    containerField.add(field22);
			    //containerField.setBackground(Color.green);
			    containerField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			    //containerField.setPreferredSize(new Dimension(250,250));

//==================================linkes Feld======================================================

			    JPanel containerInformation = new JPanel(new GridLayout(3,2,5,5));
			    containerInformation.add(name1);
			    containerInformation.add(counter1);
			    containerInformation.add(name2);
			    containerInformation.add(counter2);
			    containerInformation.add(undecided);
			    containerInformation.add(counter3);
			    //containerInformation.setBackground(Color.red);
			    //containerInformation.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			    JPanel containerButtons = new JPanel(new GridLayout(2,1,5,5));
			    containerButtons.add(restButton);
			    containerButtons.add(newNameButton);
			    //containerButtons.setBackground(Color.yellow);
			    //containerButtons.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

			    JPanel containerLeft = new JPanel(new GridLayout(2,1,5,5));
			    containerLeft.add(containerInformation);
			    containerLeft.add(containerButtons);
			    containerLeft.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

//===================================Hauptfenster===================================================

                mainWindow.setLayout(new GridLayout(1,2,5,5));
                mainWindow.add(containerLeft);
                mainWindow.add(containerField);
                mainWindow.setSize(600, 300);
                mainWindow.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(guiCreator);
	}

}