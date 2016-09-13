package monopoly;

public class Comchest {

    String name;
    boolean go;
    boolean goToJail;
    boolean outJail;
    boolean perPlayer;
    boolean perHouse;
    int val;

    public Comchest() {
        this(null, false, false, false, false, false, 0);
    }

    public Comchest(String n, boolean g, boolean tj, boolean oj, boolean pP, boolean pH, int v) {
        name = n;
        go = g;
        goToJail = tj;
        outJail = oj;
        perPlayer = pP;
        perHouse = pH;
        val = v;
    }

    public int draw(Player p, int n) {
        System.out.println("Draw a Community Chest Card.\n" + name);
        int out = effect(p, n);
        return out;
    }

    private int effect(Player p, int n) {
        if (goToJail) {
            p.toJail();
        } else if (outJail) {
            p.addJailCard();
            System.out.println("You gained a get out of jail free card!");
        } else if (perPlayer) {
            p.addMoney(val * n-1);
            System.out.println("You gained $" + val + " from each player.");
            return 1;
        } else if (perHouse) {
            p.subMoney((40*p.getHouse())+(115*p.getHotel()));
        } else if(val>0){
            p.addMoney(val);
            System.out.println("You gained $" + val + ".");
        }
        return 0;
    }

    public String toString() {
        return name;
    }
}
