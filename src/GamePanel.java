import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int menustate = 0;
	final int gamestate = 1;
	final int endstate = 2;
	int currentstate = menustate;

	GamePanel() {
		timer = new Timer(1000 / 60, this);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentstate == menustate){
			updateMenuState();
		}else if(currentstate == gamestate){
			updateGameState();
		}else if(currentstate == endstate){
			updateEndState();
		}

	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {

	}

	public void keyTyped(KeyEvent e) {
		System.out.println("key typed :)");
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed :(");
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("key released :p");
	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g) {

	}
}
