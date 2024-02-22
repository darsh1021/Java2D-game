package main;

import javax.swing.JFrame;

public class Main 
{
     public static void main(String [] args)
     {  JFrame window= new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        
        GamePanel gamePanel=new GamePanel();
        window.add(gamePanel);
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.pack();
        
       gamePanel.startGameThread();//Thread added in game panel
       
       
     }
}