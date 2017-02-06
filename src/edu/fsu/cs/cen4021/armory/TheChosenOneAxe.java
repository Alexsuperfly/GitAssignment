package edu.fsu.cs.cen4021.armory;

import java.io.*;

/**
 * Created by Sumner on 2/6/2017.
 */
public class TheChosenOneAxe extends SimpleAxe implements Weapon {

    TheChosenOneAxe() {
        String filename = "conf/thechosenone.txt";
        String firstline = null;
        String secondline = null;
        String thirdline = null;
        int linenumber = 3;

        try {

            //file reading learned from stackoverflow.com
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            firstline = bufferedReader.readLine();
            secondline = bufferedReader.readLine();

            if (firstline.equals(secondline)) {
                while ((firstline = bufferedReader.readLine()).equals(secondline)) {
                    linenumber++;
                }
                DAMAGE = linenumber;
            }
            else if ((thirdline = bufferedReader.readLine()).equals(firstline)) {
                DAMAGE = 2;
            }
            else
                DAMAGE = 1;

            bufferedReader.close();
            fileReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filename + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

    }
}
