import javax.swing.*;

public class GUI {
	

	public void mainWindow(){
		Runnable guiCreator = new Runnable() {
            public void run() {
                JFrame fenster = new JFrame("Tic Tac Toe");
                // Swing anweisen, das Programm zu beenden, wenn das Fenster
                // geschlossen wird
                fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Fügt den "Hallo Welt"-Text hinzu
                JLabel label = new JLabel("Hallo Welt");
                fenster.add(label);

                // Zeigt das Fenster an
                fenster.setSize(300, 200);
                fenster.setVisible(true);
            }
        };

        Runnable test = new Runnable(){public void run(){}};

        // Führe den obigen Quellcode im Event-Dispatch-Thread aus
        SwingUtilities.invokeLater(guiCreator);
	}

}