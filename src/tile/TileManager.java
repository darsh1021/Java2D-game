package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	Tile[] tile;
	int mapTileNum[][];
	
	
        public TileManager (GamePanel gp) {
        	
        	this.gp= gp;
        	tile = new Tile[10];
        	mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        	//getTileImage();
        	loadMap();
        	
	} 
        public void  getTileImage() {
//        	
        	tile[0]= new Tile();
        	tile[0].image = new ImageIcon("Tiles/grass01.png").getImage();
//        	
//        
        	
        	
        }
        
        
        public void loadMap() {
        	InputStream is =  getClass().getResourceAsStream("/maps/mapping.txt");
        	BufferedReader br= new BufferedReader (new InputStreamReader (is));
        	
        	int col = 0;
        	int row = 0;
        	
        	while(col <gp.maxScreenCol && row < gp.maxScreenRow)
        	{
        		try {
					String line= br.readLine();
					
					while (col < gp.maxScreenCol) {
						
						String numbers[] = line.split("");
						
						int num = Integer.parseInt( numbers[col]);
						
						mapTileNum[col][row] = num;
						col++;
					}
					if(col == gp.maxScreenCol)
					{
						col = 0;
						row++;
					}
					
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        
        public void draw(Graphics2D g2) {
               
        	int  col=0;
        	int row= 0;
        	int x= 0;
        	int y= 0;
        	
        	while(col < gp.maxScreenCol && row<gp.maxScreenRow)
        	{  int tileNum = mapTileNum[col][row];
        		
        		g2.drawImage( tile[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
            	col++;
            	x += gp.tileSize;
            	if(col == gp.maxScreenCol) {
            		col=0; 
            		x=0;
            		row++;
            		y+= gp.tileSize;
            	}
        		
        	}
        	//g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
        	// g2.drawImage(tile[1].image,48,0,gp.tileSize,gp.tileSize,null);
        	// g2.drawImage(tile[2].image,96,0,gp.tileSize,gp.tileSize,null);
        	 
        }
}
