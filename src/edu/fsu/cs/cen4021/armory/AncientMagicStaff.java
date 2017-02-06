package edu.fsu.cs.cen4021.armory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sumner on 2/6/2017.
 */
public class AncientMagicStaff extends BasicWeapon implements Weapon {

    AncientMagicStaff() {
        String filename = "conf/ancientstaff.obj";
        int mult;

        try {
            //file deserialization learned from stackoverflow.com
            List<Integer> calc = new ArrayList<Integer>();
            List<Integer> grablist;
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            grablist = (List<Integer>) ois.readObject();
            calc.clear();

            for(int i = 0; i < grablist.size(); i++) {
               mult = grablist.get(i) * grablist.get(i);
               calc.add(i,mult);
            }
            calc.remove(1);
            calc.remove(4);

            Collections.reverse(calc);

            DAMAGE = calc.get(0) + calc.get(2) + calc.get(6);

            ois.close();
            fis.close();
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
