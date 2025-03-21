

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 7dani
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MapGenerator 
{

    public static void main(String[] args) {
        int[][] map = generateMap(50, 50);
        saveMapToFile(map, "./src/maps/worldmap.txt");
        System.out.println("Map generated and saved to 'map.txt'");
    }

    private static int[][] generateMap(int width, int height) {
        int[][] map = new int[width][height];
        Random rand = new Random();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int randomNumber = rand.nextInt(100);

                if (randomNumber < 10) {
                    map[i][j] = 0; // Grass (30%)
                } else if (randomNumber < 100) {
                    map[i][j] = 4; // Tree (20%)
                } else if (randomNumber < 0) {
                    map[i][j] = 3; // Dirt (20%)
                } else if (randomNumber < 0) {
                    map[i][j] = 5; // Sand (20%)
                } else {
                    map[i][j] = 2; // Water (10%)
                }
            }
        }

        return map;
    }

    private static void saveMapToFile(int[][] map, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    writer.write(String.valueOf(map[i][j]));
                    if (j < map[i].length - 1) {
                        writer.write(" ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
