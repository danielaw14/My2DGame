/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

/**
 *
 * @author 7dani
 */
public class UI 
{
    GamePanel gp;
    
    Font ariel_30, ariel_60;
    
    //BufferedImage keyImage;
    
    public boolean messageOn = false;
    public String message = "";
    public String message2 = "";
    public boolean gameFinished = false;
    int messageCounter = 0;
    //public boolean gameFinished = false;
    
    double playTime;
    DecimalFormat dForm = new DecimalFormat("#0.00");
    
    public UI(GamePanel gp)
    {
        this.gp = gp;
        ariel_30 = new Font("Ariel", Font.PLAIN, 30);
        ariel_60 = new Font("Ariel", Font.BOLD, 60);
        //Obj_Key key = new Obj_Key();
        //keyImage = key.image;
    }
    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }
    
    public void showMessage2(String text)
    {
        message2 = text;
    }
    public void draw(Graphics2D g2)
    {
        if(gameFinished)
        {
            g2.setColor(Color.white);
            g2.setFont(ariel_30);
            int x;
            int y;
            String text;
            int textLen;
            
            text = "You found the treasure";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);
          
            
            text = "Your Time is: " + dForm.format(playTime) + "!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(text, x, y);
            
            
            g2.setFont(ariel_60);
            g2.setColor(Color.yellow);
            
            text = "You Win!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            
            x = gp.screenWidth/2 - textLen/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            
            g2.drawString(text, x, y);
            
            gp.gameThread = null;
        }
        else
        {
            //playTime += (double)1/60;
            //Message
            g2.setFont(ariel_30);
            g2.setColor(Color.white);
            //g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
            g2.drawString("Keys: " + gp.player.hasKey, 25, 50);

            //Time
            playTime += (double)1/60;
            g2.drawString("Time: " + dForm.format(playTime), gp.tileSize*12, 50);
            
            //Message
            if(messageOn)
            {
                g2.drawString(message, gp.tileSize * 6, gp.tileSize * 5);

                messageCounter++;

                if(messageCounter > 120)
                {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
