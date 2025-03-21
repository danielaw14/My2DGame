/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;

import object.Obj_Chest;
import object.Obj_Door;
import object.Obj_Key;
import object.Obj_SleepingBag;
import object.Obj_Table;
import object.Obj_Zooms;

/**
 *
 * @author 7dani
 */
public class AssetSetter 
{
    GamePanel gp;
    
    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void setObject()
    {
        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 9 * gp.tileSize;
        gp.obj[0].worldY = 8 * gp.tileSize;
        
        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 47 * gp.tileSize;
        
        gp.obj[5] = new Obj_Key();
        gp.obj[5].worldX = 34 * gp.tileSize;
        gp.obj[5].worldY = 28 * gp.tileSize;
        
        gp.obj[2] = new Obj_Door();
        gp.obj[2].worldX = 7 * gp.tileSize;
        gp.obj[2].worldY = 25 * gp.tileSize;
        
        gp.obj[3] = new Obj_Chest();
        gp.obj[3].worldX = 3 * gp.tileSize;
        gp.obj[3].worldY = 39 * gp.tileSize;
        
        gp.obj[4] = new Obj_Door("left");
        gp.obj[4].worldX = 3 * gp.tileSize;
        gp.obj[4].worldY = 24 * gp.tileSize;
        
        gp.obj[6] = new Obj_Door("fence");
        gp.obj[6].worldX = 3 * gp.tileSize;
        gp.obj[6].worldY = 33 * gp.tileSize;
        
        
        gp.obj[7] = new Obj_Table("left");
        gp.obj[7].worldX = 5 * gp.tileSize;
        gp.obj[7].worldY = 24 * gp.tileSize;
        
        gp.obj[8] = new Obj_Table("right");
        gp.obj[8].worldX = 6 * gp.tileSize;
        gp.obj[8].worldY = 24 * gp.tileSize;
        
        gp.obj[9] = new Obj_SleepingBag();
        gp.obj[9].worldX = 4 * gp.tileSize;
        gp.obj[9].worldY = 22 * gp.tileSize;
        
        
        gp.obj[10] = new Obj_Zooms();
        gp.obj[10].worldX = 48 * gp.tileSize;
        gp.obj[10].worldY = 3 * gp.tileSize;
    }
}
