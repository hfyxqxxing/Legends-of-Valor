/*
 * This class is to record the weapon currently equipped by a hero
 */
package legendsofvalor.character;

import java.util.ArrayList;
import java.util.Collections;

import legendsofvalor.item.Weapon;
import legendsofvalor.utils.GameUtils;

public class EquippedWeaponList extends CharacterAttribute {
    private ArrayList<Weapon> weapons;

    public EquippedWeaponList() {
        this.weapons = new ArrayList<Weapon>();
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void add(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public void remove(Weapon weapon) {
        this.weapons.remove(weapon);
    }

    public void remove(int index) {
        this.weapons.remove(index);
    }

    public Weapon get(int index) {
        return this.weapons.get(index);
    }

    public int size() {
        return this.weapons.size();
    }

    public int getTotalHands() {
        int totalHands = 0;
        for (Weapon weapon : weapons) {
            totalHands += weapon.getHands();
        }
        return totalHands;
    }

    public int getTotalDamage() {
        int totalDamage = 0;
        for (Weapon weapon : weapons) {
            totalDamage += weapon.getDamage();
        }
        return totalDamage;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "No weapons equipped";
        }
        String header = weapons.get(0).getWeaponHeader();
        ArrayList<String> weaponBodyList = new ArrayList<String>();
        for (Weapon weapon : weapons) {
            weaponBodyList.add(weapon.getWeaponBody());
        }
        return GameUtils.getNiceTable(header, weaponBodyList);
    }
}
