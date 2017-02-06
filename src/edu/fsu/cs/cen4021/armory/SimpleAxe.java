package edu.fsu.cs.cen4021.armory;

/**
 * Created by Sumner on 2/6/2017.
 */
public class SimpleAxe extends BasicWeapon implements Weapon {

    SimpleAxe() {
        super(60);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        int damage = DAMAGE;

        if (armor < 20)
            return damage;

        damage = DAMAGE - armor;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }
}
