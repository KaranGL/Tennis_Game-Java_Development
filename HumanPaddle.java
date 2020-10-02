import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements paddles{
	private double ypoint, yspeed;
	private boolean upspeed, downspeed;
	private int user, xpoint;
	private final double gravity = 0.94;
	
	public HumanPaddle(int user) {
		upspeed = false;
		downspeed = false;
		ypoint = 210;
		yspeed = 0;
		if(user == 1) {
			xpoint = 20;
		}
		else {
			xpoint = 660;
		}
	}
	//PING PONG GAME
	//
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(xpoint, (int)ypoint, 20, 100);
	}

	public void setUpAccel(boolean input) {
		upspeed = input;
	}
	
	public void setDownAccel(boolean input) {
		downspeed = input;
	}
	
	public void move() {
		// TODO Auto-generated method stub
		if(upspeed) {
			yspeed -= 2;
		}
		else if(downspeed) {
			yspeed += 2;
		}
		else if(!upspeed & !downspeed) {
			yspeed *= gravity;
		}
		
		if(yspeed>=5) {
			yspeed = 5;
		}
		else if(yspeed <= -5){
			yspeed = -5;
		}
		ypoint += yspeed;
		
		if(ypoint<0) {
			ypoint=0;
		}
		if(ypoint>420) {
			ypoint=420;
		}
	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int)ypoint;
	}

}
