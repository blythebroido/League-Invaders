import java.awt.Color;
import java.awt.Font;
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
	Font titleFont;
	Font titleFont2;
	Font titleFont3;
	Font endFont;
	Font endFont2;
	Font endFont3;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager();

	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		titleFont2 = new Font("Arial", Font.PLAIN, 25);
		titleFont3 = new Font("Arial", Font.PLAIN, 25);
		endFont = new Font("Arial", Font.PLAIN, 48);
		endFont2 = new Font("Arial", Font.PLAIN, 25);
		endFont3 = new Font("Arial", Font.PLAIN, 25);
		objectManager.addObject(rocketship);
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
		if(currentstate == menustate){
			drawMenuState(g);
		}else if(currentstate == gamestate){
			drawGameState(g);
		}else if(currentstate == endstate){
			drawEndState(g);
		}

	}

	public void keyTyped(KeyEvent e) {
		System.out.println("key typed :)");
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed :(");
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			currentstate = currentstate +1;
			if(currentstate > endstate){
				currentstate = menustate;
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rocketship.x+=rocketship.speed;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			rocketship.x-=rocketship.speed;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			rocketship.y-=rocketship.speed;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			rocketship.y+=rocketship.speed;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			objectManager.addObject(new Projectile(rocketship.x+18, rocketship.y, 10, 10));
		}
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("key released :p");
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.manageEnemies();
		objectManager.update();
		objectManager.checkCollision();
		if(!(rocketship.isAlive)){
			currentstate = endstate;
			objectManager.reset();
			rocketship = new Rocketship(225, 750, 50, 50);
			objectManager.addObject(rocketship);
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 200);
		g.setFont(titleFont2);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 120, 300);
		g.setFont(titleFont3);
		g.setColor(Color.YELLOW);
		g.drawString("Space = shoot; don't get hit by yellow", 50, 400);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(endFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 90, 100);
		g.setFont(endFont2);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + objectManager.getScore() + " aliens.", 140, 300);
		g.setFont(endFont3);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to restart", 85, 500);
	}
}
