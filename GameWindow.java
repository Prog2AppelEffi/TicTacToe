import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

	private JFrame nameWindow;

    private JLabel name1 = new JLabel("", JLabel.CENTER);
    private JLabel name2 = new JLabel("", JLabel.CENTER);
    private JLabel undecided = new JLabel("undecided", JLabel.CENTER);  
    private JLabel counterName1 = new JLabel("0 wins", JLabel.CENTER);
    private JLabel counterName2 = new JLabel("0 wins", JLabel.CENTER);
    private JLabel counterUndecided = new JLabel("0", JLabel.CENTER);
    private JButton resetButton = new JButton("reset stats");
    private JButton newGameButton = new JButton("new game");
    private JButton[] field = new JButton[9]; 

    private JPanel containerRight = new JPanel(new GridLayout(3,3,5,5));
    private JPanel containerLeft = new JPanel(new GridLayout(2,1,5,5));
    private JPanel containerInformation = new JPanel(new GridLayout(3,2,5,5));
    private JPanel containerButtons = new JPanel(new GridLayout(2,1,5,5));

    private String playerTurn = "X";
    private int score1 = 0;
    private int score2 = 0;
    private int scoreUndecided = 0;
    
    public GameWindow(String n1, String n2, JFrame nw){

        super("Tic Tac Toe");
        nameWindow = nw;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        setSize(600, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2,5,5));
        name1.setText(n1);
        name2.setText(n2);
        setBorder();
        addComponents();
        setColor();

        for (int i = 0; i < field.length; i++) {
        	containerRight.add(field[i] = new JButton());
        	field[i].setBackground(Color.white);
        	field[i].addActionListener(this);
        	field[i].setFont(new Font("",0,40));
        }
        resetButton.addActionListener(this);
        resetButton.setFont(new Font("",0,20));
        newGameButton.addActionListener(this);
		newGameButton.setFont(new Font("",0,20));
        
    }

    private void setColor(){
    	name1.setOpaque(true);
    	name1.setBackground(Color.gray);
    	name2.setOpaque(true);
    	name2.setBackground(Color.white);
    	undecided.setOpaque(true);
    	undecided.setBackground(Color.white);
    	counterName1.setOpaque(true);
    	counterName1.setBackground(Color.white);
    	counterName2.setOpaque(true);
    	counterName2.setBackground(Color.white);
    	counterUndecided.setOpaque(true);
    	counterUndecided.setBackground(Color.white);

    }

    private void addComponents(){
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
        add(containerLeft);
        add(containerRight);
    }

    private void setBorder(){
    	name1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        name2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        undecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));    
        counterName1.setBorder(BorderFactory.createLineBorder(Color.black, 1)); 
        counterName2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        counterUndecided.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        containerRight.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        containerLeft.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == resetButton){
    		resetScore();
    	} else if(e.getSource() == newGameButton){
    		nameWindow.setVisible(true);
    		this.dispose();
    	} else {
    		for (int i = 0; i < field.length; i++) {
        		if(e.getSource() == field[i]){
		  			setField(i);
		   			break;				
      			}
        	}
    	} 
    }

//===========================================TicTacToe Logik===============================================

    private void changeTurn(){
    	if(playerTurn.equals("X")){
    		name1.setBackground(Color.white);
    		name2.setBackground(Color.gray);
    		playerTurn = "O";
    	} else {
    		name1.setBackground(Color.gray);
    		name2.setBackground(Color.white);
    		playerTurn = "X";
    	}
    }

    private void resetScore(){
    	counterName1.setText("0");
    	counterName2.setText("0");
    	counterUndecided.setText("0");
    	score1 = 0;
    	score2 = 0;
    	scoreUndecided = 0;
    	if(playerTurn.equals("O")){
    		changeTurn();
    	}
    	for (int i = 0; i < field.length; i++) {
        	field[i].setText("");
        }
    }

    private void resetGame(){
    	if(playerTurn.equals("O")){
    		changeTurn();
    	}
    	for (int i = 0; i < field.length; i++) {
        	field[i].setText("");
        }
    }


	private boolean isFull(){
		for (int i = 0; i < field.length; i++) {
        	if(field[i].getText().equals("")){
        		return false;
        	}
        }
		return true;
	}

	private boolean checkWin(){
		if (checkVertical() || checkHorizontal() || checkDiagonal()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkVertical(){
		nextCol:
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				int index = col * 3 + row;
				if (!field[index].getText().equals(playerTurn)) {
					continue nextCol;
				}
			}
			return true;
		}
		return false;
	}

	private boolean checkHorizontal(){
		nextRow:
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				int index = row * 3 + col;
				if (!field[index].getText().equals(playerTurn)) {
					continue nextRow;
				}
			}
			return true;
		}
		return false;
	}

	private boolean checkDiagonal(){
		boolean field0 = field[0].getText().equals(playerTurn);
		boolean field2 = field[2].getText().equals(playerTurn);		
		boolean field4 = field[4].getText().equals(playerTurn);
		boolean field6 = field[6].getText().equals(playerTurn);
		boolean field8 = field[8].getText().equals(playerTurn);

		if(field0 && field4 && field8){
			return true;
		} 
		if(field2 && field4 && field6){
			return true;
		}
		return false;
	}

	private void setField(int fieldNumber){
		if (field[fieldNumber].getText().equals("")){
			field[fieldNumber].setText(playerTurn + "");
			if(checkWin()){
				if(playerTurn.equals("X")){
					score1++;
					counterName1.setText(score1 + " wins");
					resetGame();
				} else {
					score2++;
					counterName2.setText(score2 + " wins");
					resetGame();
				}
			} else if(isFull()){
				scoreUndecided++;
				counterUndecided.setText(scoreUndecided + "");
				resetGame();
			} else {
				changeTurn();
			}
		}
	}
}