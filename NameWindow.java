import javax.swing.*;
import java.awt.*;

public class NameWindow extends JFrame{

	private String text = "<html><body><center>" +
							"Welcome to Tic Tac Toe.<BR>" +
							"Enter both players names and start the game." +
						  "</center></body></html>";
	private JLabel introducion = new JLabel(text, JLabel.CENTER);
	private JTextField inputName1 = new JTextField(1);
	private JTextField inputName2 = new JTextField(1);
	private JButton startButton = new JButton("start game");

	public NameWindow(){
		super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); 
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        
        JPanel container = new JPanel(new GridLayout(4,1,10,10));
        introducion:setFont(new Font("",0,15));
        inputName1.setFont(new Font("",0,30));
        inputName2.setFont(new Font("",0,30));
        startButton.setFont(new Font("",0,20));
        container.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        container.add(introducion);
        container.add(inputName1);
        container.add(inputName2);
        container.add(startButton);
        add(container);

	}
}