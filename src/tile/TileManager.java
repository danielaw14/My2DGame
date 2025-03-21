/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;

/**
 *
 * @author 7dani
 */
public class TileManager 
{
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        
        getTileImage();
        loadMap("./src/maps/worldmap.txt");
    }
    
    public void getTileImage()
    {
        try
        {
            File f1 = new File("./src/tiles/Grass-1.png.png");
            File f2 = new File("./src/tiles/Brick-Gray-2.png.png");
            File f3 = new File("./src/tiles/Water-1.png.png");
            File f4 = new File("./src/tiles/Dirt-1.png.png");
            File f5 = new File("./src/tiles/Tree-1.png.png");
            File f6 = new File("./src/tiles/Sand-1.png.png");
            
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(f1);
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(f2);
            tile[1].collison = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(f3);
            tile[2].collison = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(f4);
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(f5);
            tile[4].collison = true;
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(f6);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void loadMap(String map1)
    {
        try
        {
            FileReader is = new FileReader(map1);
            BufferedReader reader = new BufferedReader(is);
            
            int col = 0;
            int row = 0;
            String line;
            
            while((line = reader.readLine()) != null && row < gp.maxWorldRow)
            {
                System.out.println("Line:"+row+"-"+line);
                //line = reader.readLine();
                String numbers[] = line.split(" ");
                for(col = 0; col < gp.maxWorldCol; col++)
                {
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                }
                row++;
            }
            reader.close();
        }
        catch(Exception e)
        {
          
        }
    }
    public void draw(Graphics2D g2)
    {
//        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tile[2].image, 96, 0, gp.tileSize, gp.tileSize, null);
        
        int worldCol = 0;
        int worldRow = 0;
        
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX 
                    && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX 
                    && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY 
                    && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            
            worldCol++;
            
            if(worldCol == gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
