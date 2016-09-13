package monopoly;

public class Utility extends Space {

    private int cost;

    public Utility() {
        this(null, 0, 0, 0);
    }

    public Utility(String n, int c, int mort, int l) {
        super(n, mort, l, true);
        type = 3;
        cost = c;
    }

    public int getCost() {
        return cost;
    }

    public int getRent(boolean both, int roll) {
        int out = 0;
        if (both) {
            out = 10 * roll;
        } else {
            out = 4 * roll;
        }
        return out;
    }
}
