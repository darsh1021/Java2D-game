package entity;



import java.awt.*;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player (GamePanel gp,KeyHandler keyH)
	{
		this.gp =gp;
		this.keyH= keyH;
		setDefaultValue();
		getPlayerImage();
	  
	}
	
	public void setDefaultValue() {
		x= 100;
		y= 100;
		speed = 1; 
		direction= "down";
		
	}
	
	public void getPlayerImage() {
		up1=new ImageIcon("Assets/boy_up_1.png").getImage();
		up2=new ImageIcon("Assets/boy_up_2.png").getImage();
		down1= new ImageIcon("Assets/boy_down_1.png").getImage();
		down2= new ImageIcon("Assets/boy_down_2.png").getImage();
		left1= new ImageIcon("Assets/boy_left_1.png").getImage();
		left2= new ImageIcon("Assets/boy_left_2.png").getImage();
		right1=new ImageIcon("Assets/boy_right_1.png").getImage();
		right2= new ImageIcon("Assets/boy_right_2.png").getImage();
	}
	
	public void update() {

		if(keyH.upPressed== true || keyH.downPressed== true||keyH.rightPressed== true ||keyH.leftPressed== true) {
		if(keyH.upPressed== true)
		{  direction = "up";
			y-=speed;
		}
		if(keyH.downPressed== true)
		{direction = "down";
			y+=speed;
		}
		if(keyH.rightPressed== true)
		{direction = "right";
			x+=speed;
		}
		if(keyH.leftPressed== true)
		{direction = "left";
		 x-=speed;
		}
		
		sprintCounter ++;
		if(sprintCounter >10){
			
			if(sprintNum==1) {
				sprintNum =2;
			}
			else if(sprintNum==2) {
				sprintNum =1;
			}
			sprintCounter = 0;
			
		}	
		}
		
	}
	public void draw(Graphics2D g2) {
		
	Image image= null;
		
		switch(direction) {
		
		 
		
		case "up":
			if(sprintNum==1) {
				image =up1;	
			}
			if(sprintNum==2) {
				image =up2;	
			}
			
			break;
		
		case "down":
			if(sprintNum==1) {
				image =down1;	
			}
			if(sprintNum==2) {
				image =down2;
			}
			
			break;
		
		case "right":
			if(sprintNum==1) {
				image =right1;
			}
			if(sprintNum==2) {
				image =right2;
			}
			
			break;
		
		case "left":
			if(sprintNum==1) {
				image =left1;			}
			if(sprintNum==2) {
				image =left2;
			}
		
			break;
			
		}
		
		
		g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
		
	}
	
	
	

}
