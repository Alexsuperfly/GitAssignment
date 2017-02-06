package edu.fsu.cs.cen4021.armory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Sumner on 2/6/2017.
 */
public class WebVirtualArrow extends BasicWeapon implements Weapon {

    WebVirtualArrow() {

        //extrating html from a website found on stackoverflow
        String website = "http://ww2.cs.fsu.edu/~escobara/courses/cen4021.html";
        InputStream is;
        BufferedReader br;
        String line;
        URL url;

        try {
            url = new URL(website);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            //garbage java making me "initialize" line outside of the for loop
            line = br.readLine();
            for(int i = 0; i < 7; i++) {
                line = br.readLine();
            }

            //there would be a better way with pattern matching regexes i just didn't feel like it
            Scanner scanner = new Scanner(line.substring(4,line.length()));
            scanner.useDelimiter("<");
            DAMAGE = scanner.nextInt();

        }
        catch (MalformedURLException mue) {
            mue.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        if (armor <= 10)
            return DAMAGE;

        int damage = DAMAGE - armor + 10;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }
}
