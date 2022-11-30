/*
 * Inventary is the items that an hero has already purchased but not equipped.
 */
package legendsofvalor.character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import legendsofvalor.item.*;

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

    public ArrayList<Potion> getAllPotions() {
        ArrayList<Potion> potions = new ArrayList<Potion>();
        for (InventoryItem item : items) {
            if (item.getItemType() == "Potion") {
                potions.add((Potion) item);
            }
        }
        return potions;
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
            re += String.format("%-5s", "[" + i + 1 + "]") + items.get(i).getInventoryBody() + "\n";
        }

        return re;

    }

    public String getWeaponString() {
        this.sortItems();
        String re = "";
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getItemType().equals("Weapon")) {
                Weapon curWeapon = (Weapon) items.get(i);
                if (re.length() == 0) {
                    String header = curWeapon.getWeaponHeader();
                    re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
                }
                re += String.format("%-5s", "[" + i + "]") + curWeapon.getWeaponBody() + "\n";
            }
        }
        if (re.length() == 0) {
            re = "No weapons in inventory";
        }
        return re;
    }

    public String getPotionString() {
        this.sortItems();
        String re = "";
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getItemType().equals("Potion")) {
                Potion curPotion = (Potion) items.get(i);
                if (re.length() == 0) {
                    String header = curPotion.getPotionHeader();
                    re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
                }
                re += String.format("%-5s", "[" + i + "]") + curPotion.getPotionBody() + "\n";
            }
        }
        if (re.length() == 0) {
            re = "No potion in inventory";
        }
        return re;
    }

    public String getArmorString() {
        this.sortItems();
        String re = "";
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getItemType().equals("Armor")) {
                Armor curArmor = (Armor) items.get(i);
                if (re.length() == 0) {
                    String header = curArmor.getArmorHeader();
                    re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
                }
                re += String.format("%-5s", "[" + i + "]") + curArmor.getArmorBody() + "\n";
            }
        }
        if (re.length() == 0) {
            re = "No armor in inventory";
        }
        return re;
    }

    public String getSpellString() {
        this.sortItems();
        String re = "";
        for (int i = 0; i < items.size(); ++i) {
            if (items.get(i).getItemType().equals("Spell")) {
                Spell curSpell = (Spell) items.get(i);
                if (re.length() == 0) {
                    String header = curSpell.getSpellHeader();
                    re += "     " + header + "\n" + "     " + String.join("", Collections.nCopies(header.length(), "-")) + "\n";
                }
                re += String.format("%-5s", "[" + i + "]") + curSpell.getSpellBody() + "\n";
            }
        }
        if (re.length() == 0) {
            re = "No spell in inventory";
        }
        return re;
    }

}
