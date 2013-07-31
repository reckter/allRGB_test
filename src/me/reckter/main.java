package me.reckter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mediacenter
 * Date: 13.07.13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class main {

    public static final int SIZE = 4096;

    public static int[][][] color;


    public static void main(String[] args) {
        color = new int[256][256][256];
        for(int r = 0; r < 256; r++) {
            for(int g = 0; g < 256; g++) {
                for(int b = 0; b < 256; b++) {
                    color[r][g][b] = 0;
                }
            }
        }

       /* if(args.length < 2) {
            Util.c_log("Usage: " + args[0] + " <image>");
            System.exit(-1);
        }

        */

        Util.c_log("reading " + args[0] + "...");

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(args[0]));
        } catch (IOException e) {
        }
        int[] result = new int[SIZE * SIZE * 4 + 1];

        img.getData().getPixels(0, 0, SIZE, SIZE, result);

        short k = 0;
        for(int i = 0; i < 20; i++){
            Util.c_log("" + result[i]);
        }
        for(int i = 0; i < SIZE * SIZE; i++) {

            color[result[4 * i + 0]][result[4 * i + 1]][result[4 * i + 2]]++;


            if((float) i / (float) (SIZE * SIZE) * 100 > k + 10) {
                k += 10;
                Util.c_log(k + "%");
            }
        }


        boolean isGood = true;
        for(int r = 0; r < 256; r++) {
            for(int g = 0; g < 256; g++) {
                for(int b = 0; b < 256; b++) {
                    if(color[r][g][b] != 1) {
                        Util.c_log("Color " + r + "," + g + "," + b + " is wrong! (there " + color[r][g][b] + " times)");
                        isGood = false;
                    }
                }
            }
        }
        if(isGood) {
            Util.c_log("This is an allRGB image! :D");
        }

        Util.c_log("finished.");
        //test
    }
}
