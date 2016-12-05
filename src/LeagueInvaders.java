import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame frame;
	static final int width = 500;
	static final int height = 800;
	GamePanel gamepanel;

	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
	}

	LeagueInvaders() {
		frame = new JFrame();
		gamepanel = new GamePanel();
		setup();
	}
	
	void setup(){
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamepanel.startGame();
	}
}
