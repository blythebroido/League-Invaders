import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	
	Rocketship(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 10;
	}
	
	void update(){
		super.update();
	}
	void draw(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
