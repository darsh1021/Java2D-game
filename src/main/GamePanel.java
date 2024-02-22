package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable
{
	//Screen settings
	
	public final int originalTileSize =16;
	public int scale=3;
	public final int tileSize = originalTileSize * scale ;

	
	public int maxScreenCol =16;
	public int maxScreenRow =12;
	public int screenWidth  = tileSize * maxScreenCol ;
	public int screenHeight  = tileSize * maxScreenRow;
	
	
	int FPS=60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;  
	Player player= new Player(this,keyH);
	
	public GamePanel() {
		
		this .setPreferredSize(new Dimension (screenWidth,screenHeight));
		this .setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);//have the power of getting focus
		
	}
	
	
	public void startGameThread() {
		gameThread =new Thread(this);
		gameThread.start();
	}
		
		public void run()
		{
			while (gameThread != null)
			{long currentTime= System.nanoTime();
			double  drawInterval=100000000/FPS;
			double nextDrawTime =System.nanoTime()+drawInterval;
			
			
			try {
				double remainingTime = nextDrawTime-System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime <0)
				{
					remainingTime=0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime+=drawInterval;
				
				update();
				//System.out.println("GAme is running");
				repaint();
			}
			catch (InterruptedException e) {
				
			}
			}
		}
		
		public void update()
		{   
			player.update();
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2= (Graphics2D)g;
			
			
			tileM.draw(g2);
			player.draw(g2);
			
			g2.dispose();
		}
		
		
		
	
	
}
