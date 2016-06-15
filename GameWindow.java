import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener{

	private JFrame nameWindow;

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

    private char playerTurn = 'X';
    private int score1 = 0;
    private int score2 = 0;
    
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
        setBorder();
        addComponents();
        setColor();

        for (int i = 0; i < field.length; i++) {
        	containerRight.add(field[i] = new JButton());
        	field[i].setBackground(Color.white);
        	field[i].setForeground(Color.black);
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
    		resetGame();
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
    	if(playerTurn == 'X'){
    		name1.setBackground(Color.white);
    		name2.setBackground(Color.gray);
    		playerTurn = 'O';
    	} else {
    		name1.setBackground(Color.gray);
    		name2.setBackground(Color.white);
    		playerTurn = 'X';
    	}
    }

    private void resetGame(){
    	counterName1.setText("0");
    	counterName2.setText("0");
    	counterUndecided.setText("0");
    	score1 = 0;
    	score2 = 0;
    	if(playerTurn == 'O'){
    		changeTurn();
    	}

    	for (int i = 0; i < field.length; i++) {
        	field[i].setText("");
        }
        System.out.println("reset game");
    }


	private boolean isFull(){
		for (int i = 0; i < field.length; i++) {
        	if(!field[i].getText().equals("")){
        		System.out.println("spielfeld voll");
        		return true;
        	}
        }
		return false;
	}

	public boolean checkVertical(){
		return true;
	}

	public boolean checkHorizontal(){
		return false;
	}

	public boolean checkDiagonal(){
		return true;
	}

	public void setField(int fieldNumber){
		if (field[fieldNumber].getText().equals("")){
			System.out.println("feld ist nicht voll " + field[fieldNumber].getText());
			field[fieldNumber].setText(playerTurn + "");
			changeTurn();
		}
	}
}