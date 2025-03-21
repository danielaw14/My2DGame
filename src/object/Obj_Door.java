/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 7dani
 */
public class Obj_Door extends SuperObject 
{
    public Obj_Door()
    {
        name = "Door";
        try
        {
            File keyFile = new File("./src/objects/Door.png.png");
            image = ImageIO.read(keyFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
    public Obj_Door(String s)
    {
        if(s.equals("left"))
        {
            name = "Door";
            try
            {
                File keyFile = new File("./src/objects/Door-Side-Left.png.png");
                image = ImageIO.read(keyFile);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            collision = true;
        }
        if(s.equals("right"))
        {
            name = "Door";
            try
            {
                File keyFile = new File("./src/objects/Door-Side-Right.png.png");
                image = ImageIO.read(keyFile);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            collision = true;
        }
        
        if(s.equals("fence"))
        {
            name = "Fence";
            try
            {
                File keyFile = new File("./src/objects/Fence.png.png");
                image = ImageIO.read(keyFile);
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            collision = true;
        }
    }
    
}
