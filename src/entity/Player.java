/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;
import my2dgame.KeyHandler;

/**
 *Finished 1-3 of RyiSnow guide.
 * @author 7dani
 */
public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    
    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth / 2 - gp.tileSize/2;
        screenY = gp.screenHeight / 2- gp.tileSize/2;
        
        solidArea = new Rectangle();
        solidArea.x = 8;//full = 0
        solidArea.y = 16;//full = 0
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;//full = 48
        solidArea.height = 32;//full = 48
        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        worldX = gp.tileSize * 35;
        worldY = gp.tileSize * 5;
        speed = 3;
        direction = "down";
    }
    
    public void getPlayerImage()
    {
        try
        {
            File file1 = new File("./src/player/Up-1.png.png");
            File file2 = new File("./src/player/Up-2.png.png");
            File file3 = new File("./src/player/Down-1.png.png");
            File file4 = new File("./src/player/Down-2.png.png");
            File file5 = new File("./src/player/Left-1.png.png");
            File file6 = new File("./src/player/Left-2.png.png");
            File file7 = new File("./src/player/Right-1.png.png");
            File file8 = new File("./src/player/Right-2.png.png");
            
            up1 = ImageIO.read(file1);
            up2 = ImageIO.read(file2);
            down1 = ImageIO.read(file3);
            down2 = ImageIO.read(file4);
            left1 = ImageIO.read(file5);
            left2 = ImageIO.read(file6);
            right1 = ImageIO.read(file7);
            right2 = ImageIO.read(file8);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update()
    {
        if(keyH.upPressed||keyH.downPressed||keyH.leftPressed||keyH.rightPressed)
        {
            if (keyH.upPressed)
            {
                direction = "up";
                
            }
            else if (keyH.downPressed)
            {
                direction = "down";
                
            }
            else if (keyH.leftPressed)
            {
                direction = "left";
                
            }
            else if (keyH.rightPressed)
            {
                direction = "right";
                
            }
            
            //Check Tile Collision
            collisionOn = false;
            gp.cCheck.checkTile(this);
            
            //Check obj collision
            int objIndex = gp.cCheck.checkObject(this, true);
            pickUpObj(objIndex);
            //If collisionis false player can move
            if(!collisionOn)
            {
                switch(direction)
                {
                    case "up":
                    {
                        worldY -= speed;
                        break;
                    }
                    case "down":
                    {
                        worldY += speed;
                        break;
                    }
                    case "left":
                    {
                        worldX -= speed;
                        break;
                    }
                    case "right":
                    {
                        worldX += speed;
                        break;
                    }
                }
            }
            spriteCounter++;
            if(spriteCounter > 16)
            {
                if(spriteNumber == 1)
                {
                    spriteNumber = 2;
                }
                else if(spriteNumber == 2)
                {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void pickUpObj(int index)
    {
        if(index != 999)
        {
            String objectName = gp.obj[index].name;
            
            switch(objectName)
            {
                case "Key":
                {
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[index] = null;
                    gp.ui.showMessage("Key Acquired!");
                    break;
                }
                case "Door":
                {
                    if(hasKey > 0)
                    {
                        gp.playSE(3);
                        gp.obj[index] = null;
                        hasKey --;
                        gp.ui.showMessage("Door Unlocked!");
                    }
                    else
                    {
                        gp.ui.showMessage("Key Required!");
                    }
                    break;
                }
                case "Fence":
                {
                    if(hasKey > 0)
                    {
                        gp.playSE(3);
                        gp.obj[index] = null;
                        hasKey --;  
                    }
                    break;
                }
                case "Zooms":
                {
                    gp.playSE(2);
                    speed += 2;
                    gp.obj[index] = null;
                    gp.ui.showMessage("Gotta Go Fast!");
                    break;
                }
                case "Chest":
                {
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSE(4);
                    break;
                }
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        
        switch(direction)
        {
            case "up":
            {
                if(spriteNumber == 1)
                    image = up1;
                if(spriteNumber == 2)
                    image = up2;
                break;
            }
            case "down":
            {
                if(spriteNumber == 1)
                    image = down1;
                if(spriteNumber == 2)
                    image = down2;
                break;
            }
            case "left":
            {
                if(spriteNumber == 1)
                    image = left1;
                if(spriteNumber == 2)
                    image = left2;
                break;
            }
            case "right":
            {
                if(spriteNumber == 1)
                    image = right1;
                if(spriteNumber == 2)
                    image = right2;
                break;
            }
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
