import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

public class Tennnis extends Applet implements Runnable, KeyListener{
	private final int WIDTH_APPLET = 700, HEIGHT_APPLET = 500;
	private boolean gamehasStarted;
	Thread threading;
	HumanPaddle HPaddle;
	Ball the_ball;
	AIPaddle AIPaddle;
	Graphics graphics;
	Image jpg;
	//PING PONG GAME
	//
	public void init() {
		this.resize(WIDTH_APPLET, HEIGHT_APPLET);
		this.addKeyListener(this);
		the_ball = new Ball();
		HPaddle = new HumanPaddle(2);
		AIPaddle = new AIPaddle(2, the_ball);
		jpg = createImage(WIDTH_APPLET, HEIGHT_APPLET);
		graphics = jpg.getGraphics();
		threading = new Thread(this);
		threading.start();
	}
	
	public void gameFinished() {
		if(the_ball.getX()<-10 || the_ball.getX()>710) {
			graphics.setColor(Color.red);
			graphics.drawString("Game Over", 310, 250);
		}
	}
	
	public void paint(Graphics g) {
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, WIDTH_APPLET, HEIGHT_APPLET);
		gameFinished();
		HPaddle.draw(graphics);
		the_ball.draw(graphics);
		AIPaddle.draw(graphics);
		
		if(!gamehasStarted){
			graphics.setColor(Color.blue);
			graphics.drawString("THE TENNIS GAME", 300, 100);
			graphics.drawString("PRESS ENTER TO LOOSE", 280, 130);
		}
		
		g.drawImage(jpg,0, 0, this);
	}
	
	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			if(gamehasStarted) {
			HPaddle.move();
			the_ball.move();
			AIPaddle.move();
			the_ball.checkPaddleCollision(AIPaddle,HPaddle);
			}
			repaint();
			try {
			Thread.sleep(10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			HPaddle.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			HPaddle.setDownAccel(false);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			HPaddle.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			HPaddle.setDownAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gamehasStarted = true;			
		}
	}
}
