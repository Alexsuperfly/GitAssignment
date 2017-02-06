package edu.fsu.cs.cen4021.armory;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sumner on 2/6/2017.
 */
public class AncientMagicStaff implements Weapon {

    int DAMAGE;

    AncientMagicStaff() {
        String filename = "ancientstaff.obj";
        List<Integer> calc;
        int mult;

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            calc = (List<Integer>) ois.readObject();

            for(int i = 0; i < calc.size(); i++) {
               mult = calc.get(i) * calc.get(i);
               calc.add(i,mult);
            }
            calc.remove(1);
            calc.remove(4);

            Collections.reverse(calc);

            DAMAGE = calc.get(0) + calc.get(2) + calc.get(6);

        }
        catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filename + "'");
        }
        catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("A ClassNotFoundException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        int less = armor / 4;
        armor = armor - less;

        int damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }
}
