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
public class Obj_Table extends SuperObject
{
    public Obj_Table()
    {
        name = "Table";
        try
        {
            File keyFile = new File("./src/objects/Table.png.png");
            image = ImageIO.read(keyFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        collision = true;
    }
    public Obj_Table(String s)
    {
        if(s.equals("left"))
        {
            name = "Table-Left";
            try
            {
                File keyFile = new File("./src/objects/Table-Left.png.png");
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
            name = "Table-Right";
            try
            {
                File keyFile = new File("./src/objects/Table-Right.png.png");
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
