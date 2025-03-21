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
public class Obj_SleepingBag extends SuperObject
{
    public Obj_SleepingBag()
    {
        name = "SleepingBag";
        try
        {
            File keyFile = new File("./src/objects/SleepingBAg.png.png");
            image = ImageIO.read(keyFile);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
