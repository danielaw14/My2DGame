/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;

import entity.Player;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import object.SuperObject;
import tile.TileManager;
/**
 *
 * @author 7dani
 */
public class GamePanel extends JPanel implements Runnable
{
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48x48 tile size
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels aka 16 48x48 tiles
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels aka 12 48x48 tiles
    
    // World Settings;
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    
    //FPS
    int FPS = 60;
    
    //System
    public TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Sound music = new Sound();
    Sound SE = new Sound();
    public CollisionChecker cCheck = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    
    //Entity and Obj
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[11];
    
    
    
    //set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setUpGame()
    {
        aSetter.setObject();
        
        playMusic(0);
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    //game loop class
//    @Override
//    public void run()
//    {
//        //Sleep method
//        double drawInterval = 1000000000/FPS; // 0.0166667 sec
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        
//        
//        // game loop
//        while (gameThread != null)
//        {
//            //long currentTime = System.nanoTime();
//            //System.out.println("current time: " + currentTime);
//            
//            
//            
//            // 1 Update: update info such as character positions.
//            update();
//            
//            // 2 Draw: draw screen with updated info.
//            repaint();
//            
//            
//            
//            try
//            {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/ 1000000;
//                
//                if(remainingTime < 0)
//                {
//                    remainingTime = 0;
//                }
//                Thread.sleep((long) remainingTime);
//                
//                nextDrawTime += drawInterval;
//            }
//            catch(InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }
    
    @Override
    public void run()
    {
        //Sleep method
        double drawInterval = 1000000000/FPS; // 0.0166667 sec
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            
            delta+= (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if(timer >= 1000000000)
            {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update()
    {
        player.update();
    }
    
    public void paintComponent(Graphics g)
    {
        Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        
        //TILE
        tileM.draw(g2);
        
        //OBJECT
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(g2, this);
            }
        }
        
        //PLAYER
        player.draw(g2);
        
        //UI
        ui.draw(g2);
        
        g2.dispose();
    }
    
    public void playMusic(int i)
    {
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void stopMusic()
    {
        music.stop();
    }
    public void playSE(int i)
    {
        SE.setFile(i);
        SE.play();
    }
}
