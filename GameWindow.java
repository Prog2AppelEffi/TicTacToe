import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

	private JFrame nameWindow;
	private TicTacToe game = new TicTacToe();

    private JLabel name1 = new JLabel("", JLabel.CENTER);
    private JLabel name2 = new JLabel("", JLabel.CENTER);
    private JLabel undecided = new JLabel("undecided", JLabel.CENTER);  
    private JLabel counterName1 = new JLabel("4", JLabel.CENTER);
    private JLabel counterName2 = new JLabel("2", JLabel.CENTER);
    private JLabel counterUndecided = new JLabel("5", JLabel.CENTER);
    private JButton resetButton = new JButton("reset stats");
    private JButton newGameButton = new JButton("new game");
    private JButton[] field = new JButton[9]; 

    private JPanel containerRight = new JPanel(new GridLayout(3,3,5,5));
    private JPanel containerLeft = new JPanel(new GridLayout(2,1,5,5));
    private JPanel containerInformation = new JPanel(new GridLayout(3,2,5,5));
    private JPanel containerButtons = new JPanel(new GridLayout(2,1,5,5));
    
    public GameWindow(String n1, String n2, JFrame nw){

        super("Tic Tac Toe");
        nameWindow = nw;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2,5,5));
        name1.setText(n1 + " wins");
        name2.setText(n2 + " wins");
        add(containerLeft);
        add(containerRight);

//==============================Rahmen setzen===============================================

        name1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        name2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        undecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));    
        counterName1.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        counterName2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        counterUndecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        containerRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        containerLeft.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

//==================================Spielfeld==============================================================

        for (int i = 0; i < field.length; i++) {
        	containerRight.add(field[i] = new JButton());
        	field[i].addActionListener(this);
        	field[i].setFont(new Font("",0,40));
        }

        resetButton.addActionListener(this);
        resetButton.setFont(new Font("",0,20));
        newGameButton.addActionListener(this);
		newGameButton.setFont(new Font("",0,20));

//==================================linkes Feld======================================================

        containerInformation.add(name1);
        containerInformation.add(counterName1);
        containerInformation.add(name2);
        containerInformation.add(counterName2);
        containerInformation.add(undecided);
        containerInformation.add(counterUndecided);

        containerButtons.add(resetButton);
        containerButtons.add(newGameButton);

        containerLeft.add(containerInformation);
        containerLeft.add(containerButtons);
        
    }

    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == resetButton){
    		counterName1.setText("0");
    		counterName2.setText("0");
    		counterUndecided.setText("0");
    	} else if(e.getSource() == newGameButton){
    		nameWindow.setVisible(true);
    		this.dispose();
    	} else {
    		for (int i = 0; i < field.length; i++) {
        		if(e.getSource() == field[i]){
		  			System.out.println("feld gedrückt " + i);
		  			game.setField(i);
		   			break;				
      			}
        	}
    	} 
    }

    private void resetGame(){
    	for (int i = 0; i < field.length; i++) {
        	field[i].setText("O");
        }
        System.out.println("reset game");
    }

//===========================================TicTacToe Logik===============================================

    private class TicTacToe{

    	private char player1 = 'X';
    	private char player2 = 'O';

		private char[][] field = {{' ', ' ', ' '},
								  {'x', ' ', ' '},
								  {'o', 'o', 'o'}};

		public boolean isFull(){
			boolean isFull = true;
			for (int i = 0; i < field.length; i++){
				for (int j = 0; j < field[i].length; j++) {
					if (field[i][j] == ' '){
						isFull = false;
					} 
				}
			}
			return isFull;
		}

		public boolean checkVertical(char player){
			return true;
		}

		public boolean checkHorizontal(char symbol){
			for (int i = 0; i < field.length ; i++) {
				System.out.println("==================================================================");
				int count = 0;
				for (int j = 0;j < field.length ; j++) {
					System.out.println("reihe " + i + ", spalte " + j + ", symbol " + field[i][j]);
					if(field[i][j] == symbol){
						count++;
						if(count == 3){
							return true;
						}
					}
				}
			}
			return false;
		}

		public boolean checkDiagonal(){
			return true;
		}

		public void setField(int fieldNumber){
			
		}
	}
}