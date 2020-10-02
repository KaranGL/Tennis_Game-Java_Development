import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private double xspeed, yspeed, xpoint, ypoint;
	
	public Ball(){
		xpoint=350;
		ypoint=250;
		xspeed=getRandomSpeed()*getRandomDirection();
		yspeed=getRandomSpeed()*getRandomDirection();
	}
	//PING PONG GAME
	//
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int)xpoint-10, (int)ypoint-10, 30, 30);
	}
	
	public double getRandomSpeed() {
		return (Math.random() * 3+2);
	}
	
	public int getRandomDirection() {
		int rand = (int)(Math.random() *2);
		if(rand==1) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public void move() {
		xpoint += xspeed;
		ypoint += yspeed;
		
		if(ypoint<10) {
			yspeed = -yspeed;
		}
		if(ypoint>490) {
			yspeed = -yspeed;
		}
	}
	
	public void checkPaddleCollision(paddles pad1,paddles pad2) {
		if(xpoint<=50) {
			if(ypoint >= pad1.getY() && ypoint<= pad1.getY() +80) {
				xspeed = -xspeed;
			}
		}
		else if(xpoint>=650) {
			if(ypoint >= pad2.getY() && ypoint<= pad2.getY() +80) {
				xspeed = -xspeed;
			}
		}
	}
	
	public int getX() {
		return (int)xpoint;
	}
	
	public int getY() {
		return (int)ypoint;
	}
}
