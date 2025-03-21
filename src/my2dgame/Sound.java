/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my2dgame;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author 7dani
 */
public class Sound 
{
    Clip clip;
    URL soundURL[] = new URL[30];
    public Sound()
    {
        try
        {
            File s1 = new File("./src/objects/Background.wav");
            File s2 = new File("./src/objects/Coin.wav");
            File s3 = new File("./src/objects/PowerUp.wav");
            File s4 = new File("./src/objects/Door-Unlock.wav");
            File s5 = new File("./src/objects/fanfare.wav");
            soundURL[0] = s1.toURI().toURL();
            soundURL[1] = s2.toURI().toURL();
            soundURL[2] = s3.toURI().toURL();
            soundURL[3] = s4.toURI().toURL();
            soundURL[4] = s5.toURI().toURL();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //soundURL[0] = getClass().getResource("./src/sounds/Background.wav");
        //soundURL[1] = getClass().getResource("./src/objects/Coin.wav");
        //soundURL[2] = getClass().getResource("./src/objects/PowerUp.wav");
        //soundURL[3] = getClass().getResource("./src/objects/Door-Unlock.wav");
        //soundURL[4] = getClass().getResource("./src/objects/fanfare.wav");
    }
    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        }
        catch(Exception e)
        {
            
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
}
