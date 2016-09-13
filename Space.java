package monopoly;

public class Space {

    protected String name;
    protected int loc;
    protected int mortgage;
    protected int type;
    protected int rent;
    protected boolean owned, buyable;

    public Space() {
        this(null, 0, 0, false);
    }

    public Space(String n, int mort, int l, boolean buy) {
        name = n;
        loc = l;
        mortgage = mort;
        buyable = buy;
        rent = 0;
        type = 0;
    }

    public int getRent() {
        return rent;
    }

    public int getRent(int n) {
        return rent;
    }

    public int getRent(boolean b, int n) {
        return rent;
    }

    public int getType() {
        return type;
    }

    public int getLoc() {
        return loc;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return 0;
    }

    public int getMort() {
        return mortgage;
    }
    
    public String getColor() {
        return null;
    }
    
    public int getHouse(){
        return 0;
    }

    public void bought() {
        owned = true;
        System.out.println(name + " is bought.");
    }
    
    public void sold() {
        owned = false;
        System.out.println(name + " is sold.");
    }

    public boolean owned() {
        return owned;
    }

    public boolean buyable() {
        return buyable;
    }
    
    public void monopoly(){
        
    }

    public String toString() {
        return name + "\n";
    }
}
