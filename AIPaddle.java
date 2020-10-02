import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements paddles{
	private double ypoint, yspeed;
	private boolean upspeed, downspeed;
	private int user, xpoint;
//	private final double GRAVITY = 0.94;
	Ball b;
	
	public AIPaddle(int user, Ball ball) {
		upspeed = false;
		downspeed = false;
		b = ball;
		ypoint = 210;
		yspeed = 0;
		if(user == 2) {
			xpoint = 20;
		}
		else {
			xpoint = 660;
		}
	}
	//PING PONG GAME
	//
	public void move() {
		// TODO Auto-generated method stub
		ypoint = b.getY()-40;
		
		if(ypoint<0) {
			ypoint=0;
		}
		if(ypoint>420) {
			ypoint=420;
		}
	}
	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		g.fillRect(xpoint, (int)ypoint, 20, 100);
	}

	public void setUpAccel(boolean input) {
		upspeed = input;
	}
	
	public void setDownAccel(boolean input) {
		downspeed = input;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int)ypoint;
	}

}
