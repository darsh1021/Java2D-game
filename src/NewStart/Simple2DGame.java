package NewStart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Simple2DGame extends JFrame {

    private int playerX = 50;
    private int playerY = 50;
    private Image playerImage;

    public Simple2DGame() {
        setTitle("Simple 2D Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load player image
        try {
            playerImage = ImageIO.read(new File("boy_down_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set up a JPanel for drawing
        JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawPlayer(g);
            }
        };

        // Set up KeyListener for player movement
        gamePanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        gamePanel.setFocusable(true);

        // Set up a Timer for game loop
        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                gamePanel.repaint();
            }
        });
        timer.start();

        // Add the game panel to the frame
        add(gamePanel);

        // Make the frame visible
        setVisible(true);
    }

    private void drawPlayer(Graphics g) {
        if (playerImage != null) {
            g.drawImage(playerImage, playerX, playerY, 20, 20, null);
        } else {
            // Fallback to a rectangle if the image is not loaded
            g.setColor(Color.BLUE);
            g.fillRect(playerX, playerY, 20, 20);
        }
    }

    private void handleKeyPress(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                playerY -= 5;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 5;
                break;
            case KeyEvent.VK_LEFT:
                playerX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 5;
                break;
        }
    }

    private void updateGame() {
        // Perform game logic here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Simple2DGame();
            }
        });
    }
}
