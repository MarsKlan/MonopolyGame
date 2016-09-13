package monopoly;

import java.util.*;

public class Player {

    private String name;
    private int order, location, money, RROwned;
    private ArrayList<Space> ownedProperties;
    private int house, hotel;
    private int jailCard, jailRoll, jailAttempt;
    private boolean inJail, bothUtil, noMoney;

    public Player() {
        this(null);
    }

    public Player(String n) {
        name = n;
        location = 0;
        money = 1500;
        RROwned = 0;
        ownedProperties = new ArrayList<>();
        jailCard = 1;
        jailRoll = 0;
        inJail = false;
        bothUtil = false;
        noMoney = false;
    }

    public String getName() {
        return name;
    }

    public int getLoc() {
        return location;
    }

    public int getHouse() {
        return house;
    }

    public int getHotel() {
        return hotel;
    }

    public int getMoney() {
        return money;
    }

    public int getRR() {
        return RROwned;
    }

    public boolean getUtil() {
        return bothUtil;
    }

    public boolean getInJail() {
        return inJail;
    }

    public int getJailCard() {
        return jailCard;
    }

    public int getJailRoll() {
        return jailRoll;
    }

    public int getJailAttempt() {
        return jailAttempt;
    }

    public void jailAttemptSub() {
        jailAttempt--;
    }

    public boolean getNoMoney() {
        if (money > 0) {
            noMoney = true;
        }
        return noMoney;
    }

    public boolean getMonopoly(String c, int n) {
        int count = 0;
        boolean out = false;
        for (Space p : ownedProperties) {
            if (p.getType() == 1 && p.getColor().equals(c)) {
                count++;
            }
        }
        if (count == n) {
            out = true;
        } else {
            out = false;
        }
        return out;
    }

    public String printProperties() {
        String out = "";
        if (ownedProperties.size() > 0) {
            for (int x = 0; x < ownedProperties.size(); x++) {
                Space p = ownedProperties.get(x);
                if (x == 0) {
                    out = p.getName();
                } else {
                    out = p.getName() + ", " + out;
                }
            }
        } else {
            out = "You don't have any properties.";
        }
        return out;
    }

    public String printPropertiesHouse() {
        String out = "";
        for (int x = 0; x < ownedProperties.size(); x++) {
            Space p = ownedProperties.get(x);
            if (p.getType() == 1 && p.getHouse() < 4) {
                if (x == 0) {
                    out = p.getName();
                } else {
                    out = p.getName() + ", " + out;
                }
            }
        }
        return out;
    }

    public String printPropertiesHotel() {
        String out = "";
        for (int x = 0; x < ownedProperties.size(); x++) {
            Space p = ownedProperties.get(x);
            if (p.getType() == 1 && p.getHouse() == 4) {
                if (x == 0) {
                    out = p.getName();
                } else {
                    out = p.getName() + ", " + out;
                }
            }
        }
        return out;
    }

    public ArrayList<Space> getProperties() {
        return ownedProperties;
    }

    public ArrayList<Property> getPropertiesHouse() {
        ArrayList<Property> temp = new ArrayList<>();
        for (Space p : ownedProperties) {
            if (p.getType() == 1 && p.getHouse() < 4) {
                temp.add((Property) p);
            }
        }
        return temp;
    }

    public ArrayList<Property> getPropertiesHotel() {
        ArrayList<Property> temp = new ArrayList<>();
        for (Space p : ownedProperties) {
            if (p.getType() == 1 && p.getHouse() == 4) {
                temp.add((Property) p);
            }
        }
        return temp;
    }

    public void addMoney(Space p) {
        money += p.getRent();
        System.out.println(name + " now has $" + money);
    }

    public void subMoney(Space p) {
        money -= p.getRent();
        if (money < 0) {
            noMoney = true;
        }
        System.out.println(name + " now has $" + money);
    }

    public void addMoney(int m) {
        money += m;
        System.out.println(name + " now has $" + money);
    }

    public void subMoney(int m) {
        money -= m;
        System.out.println(name + " now has $" + money);
    }

    public void addProperty(Space p) {
        if (p.getType() == 2) {
            RROwned++;
        }
        ownedProperties.add(p);
        money -= p.getCost();
        System.out.println(name + " now has $" + money);
    }

    public void sellProperty(String n) {
        n.toLowerCase();
        Space p = null;
        for (Space temp : ownedProperties) {
            String s = temp.getName().replaceAll(" ", "").toLowerCase();
            if (n.equals(s)) {
                p = temp;
            }
        }
        ownedProperties.remove(p);
        money += p.getMort();
    }

    public void setLoc(int v) {
        if (location > v && inJail) {
            System.out.println(name + " passed Go, Collect $200!");
            money += 200;
        }
        location = v;
    }

    public void move(int v) {
        location += v;
        System.out.println(name + " moved " + v + " places.");
        if (location > 39) {
            location %= 39;
            System.out.println(name + " passed Go, Collect $200!");
            money += 200;
        }
    }

    public void addJailCard() {
        jailCard++;
    }

    public void jailRoll() {
        jailRoll++;
    }

    public void jailRollReset() {
        jailRoll = 0;
    }

    public void jailAttempt() {
        jailAttempt++;
    }

    public void jailAttemptReset() {
        jailAttempt = 0;
    }

    public void toJail() {
        System.out.println("Oh no, " + name + " is in Jail.");
        setLoc(10);
        inJail = true;
    }

    public void outJail() {
        inJail = false;
    }

    public boolean hasJailCard() {
        boolean out = false;
        if (jailCard > 0) {
            out = true;
        }
        return out;
    }

    public void useJailCard() {
        if (inJail && jailCard > 0) {
            jailCard--;
            inJail = false;
        }
    }

    public boolean hasMoney() {
        boolean out = false;
        if (money > 0 || ownedProperties.size() > 0) {
            out = true;
        }
        return out;
    }

    public String toString() {
        return "Player : " + name;
    }
}
