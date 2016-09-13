package monopoly;

public class Station extends Space {

    private final int cost = 200;

    public Station() {
        this(null, 0);
    }

    public Station(String n, int l) {
        super(n, l, 100, true);
        type = 2;
    }

    public int getCost() {
        return cost;
    }

    public int getRent() {
        return 25;
    }

    public int getRent(int num) {
        int out = 0;
        switch (num) {
            case 1:
                out = 25;
                break;
            case 2:
                out = 50;
                break;
            case 3:
                out = 100;
                break;
            case 4:
                out = 200;
                break;
            default:
                out = 0;
                break;
        }
        return out;
    }

    public String toString() {
        return name + "\nCost: " + cost + "\nMortgage: " + mortgage;
    }
}
