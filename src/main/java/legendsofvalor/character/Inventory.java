/*
 * Inventary is the items that an hero has already purchased but not equipped.
 */
package legendsofvalor.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import legendsofvalor.item.*;
import legendsofvalor.utils.GameUtils;

class SortbyItemType implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b) {
        return a.getItemType().compareTo(b.getItemType());
    }
}

public class Inventory extends CharacterAttribute {
    private ArrayList<InventoryItem> items;

    public Inventory() {
        items = new ArrayList<InventoryItem>();
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }else {
            return false;
        }
    }

    public InventoryItem get(int index) {
        return items.get(index);
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public void addItem(InventoryItem item) {
        items.add(item);
    }

    public void removeItem(InventoryItem item) {
        items.remove(item);
    }

    public void clearItems() {
        items.clear();
    }

    public void sortItems() {
        Collections.sort(items, new SortbyItemType());
    }

    public ArrayList<Potion> getAllPotion() {
        ArrayList<Potion> potionList = new ArrayList<Potion>();
        for (InventoryItem item : items) {
            if (item.getItemType().equals("Potion")) {
                potionList.add((Potion) item);
            }
        }
        return potionList;
    }

    public ArrayList<Spell> getAllSpell() {
        ArrayList<Spell> spellList = new ArrayList<Spell>();
        for (InventoryItem item : items) {
            if (item.getItemType().equals("Spell")) {
                spellList.add((Spell) item);
            }
        }
        return spellList;
    }

    public ArrayList<Weapon> getAllWeapon() {
        ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
        for (InventoryItem item : items) {
            if (item.getItemType().equals("Weapon")) {
                weaponList.add((Weapon) item);
            }
        }
        return weaponList;
    }

    public ArrayList<Armor> getAllArmor() {
        ArrayList<Armor> armorList = new ArrayList<Armor>();
        for (InventoryItem item : items) {
            if (item.getItemType().equals("Armor")) {
                armorList.add((Armor) item);
            }
        }
        return armorList;
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "No items in inventory";
        }

        String re = "";

        this.sortItems();

        String lastItemType = "";

        // print out the items in each type
        for (int i = 0; i < items.size(); ++i) {
            if (!items.get(i).getItemType().equals(lastItemType)) {
                re += "\n";
                lastItemType = items.get(i).getItemType();
                String header = items.get(i).getInventoryHeader();
                re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";

            }
            re += String.format("%-5s", "[" + (i + 1) + "]") + items.get(i).getInventoryBody() + "\n";
        }

        return re;

    }

    public String getSpellString() {
        ArrayList<Spell> spellList = this.getAllSpell();
        if (spellList.size() == 0) {
            return "No spells in inventory";
        }
        String header = spellList.get(0).getSpellHeader();
        ArrayList<String> spellBodyList = new ArrayList<String>();
        for (Spell spell : spellList) {
            spellBodyList.add(spell.getSpellBody());
        }
        return GameUtils.getNiceTable(header, spellBodyList);
    }

    public String getWeaponString() {
        ArrayList<Weapon> weaponList = this.getAllWeapon();
        if (weaponList.size() == 0) {
            return "No weapons in inventory";
        }
        String header = weaponList.get(0).getWeaponHeader();
        ArrayList<String> weaponBodyList = new ArrayList<String>();
        for (Weapon weapon : weaponList) {
            weaponBodyList.add(weapon.getWeaponBody());
        }
        return GameUtils.getNiceTable(header, weaponBodyList);
    }

    public String getArmorString() {
        ArrayList<Armor> armorList = this.getAllArmor();
        if (armorList.size() == 0) {
            return "No armors in inventory";
        }
        String header = armorList.get(0).getArmorHeader();
        ArrayList<String> armorBodyList = new ArrayList<String>();
        for (Armor armor : armorList) {
            armorBodyList.add(armor.getArmorBody());
        }
        return GameUtils.getNiceTable(header, armorBodyList);
    }

    public String getPotionString() {
        ArrayList<Potion> potionList = this.getAllPotion();
        if (potionList.size() == 0) {
            return "No potions in inventory";
        }
        String header = potionList.get(0).getPotionHeader();
        ArrayList<String> potionBodyList = new ArrayList<String>();
        for (Potion potion : potionList) {
            potionBodyList.add(potion.getPotionBody());
        }
        return GameUtils.getNiceTable(header, potionBodyList);
    }


}
