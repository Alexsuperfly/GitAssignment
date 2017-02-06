package edu.fsu.cs.cen4021.armory;

/**
 * Created by Sumner on 2/6/2017.
 */
public class SimpleArrow extends BasicWeapon implements Weapon {

    SimpleArrow() {
        super(70);
    }

    @Override
    public int hit() {
        return DAMAGE;
    }

    @Override
    public int hit(int armor) {
        if (armor <= 5)
            return DAMAGE;

        int damage = DAMAGE - armor + 5;
        if (damage < 0) {
            return 0;
        }
        return damage;
    }
}
