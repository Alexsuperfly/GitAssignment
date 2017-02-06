package edu.fsu.cs.cen4021;

import edu.fsu.cs.cen4021.armory.Weapon;
import edu.fsu.cs.cen4021.armory.WeaponFactory;

/**
 * @author Javier
 */
public class RoleGame {

    public static void main(String[] args) {
        Weapon sword = WeaponFactory.getWeapon("sword");
        System.out.println("Sword has " + sword.hit() + " damage.");
        int armor = 20;
        System.out.println("Sword was able to do " + sword.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon arrow = WeaponFactory.getWeapon("arrow");
        System.out.println("Arrow has " + arrow.hit() + " damage.");
        System.out.println("Arrow was able to do " + arrow.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon axe = WeaponFactory.getWeapon("axe");
        System.out.println("Axe has " + axe.hit() + " damage.");
        System.out.println("Axe was able to do " + axe.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon staff = WeaponFactory.getWeapon("staff");
        System.out.println("Magic Staff has " + staff.hit() + " damage.");
        System.out.println("Magic Staff was able to do " + staff.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon chosenaxe = WeaponFactory.getWeapon("chosenaxe");
        System.out.println("The Chosen Axe has " + chosenaxe.hit() + " damage.");
        System.out.println("The Chosen Axe was able to do " + chosenaxe.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon ancientstaff = WeaponFactory.getWeapon("ancientstaff");
        System.out.println("Ancient Staff has " + ancientstaff.hit() + " damage.");
        System.out.println("Ancient Staff was able to do " + ancientstaff.hit(armor) + " damage due to an armor with " + armor + " points.");

        Weapon webarrow = WeaponFactory.getWeapon("webarrow");
        System.out.println("Web Virtual Arrow has " + webarrow.hit() + " damage.");
        System.out.println("Web Virtual Arrow was able to do " + webarrow.hit(armor) + " damage due to an armor with " + armor + " points.");

    }
}
