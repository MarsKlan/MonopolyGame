package monopoly;

public class Chance {

    String name;
    boolean move, money, nearest, ifOwnedDB, ifOwnedTN, payOthers, payHouse, outJail, mvBack, toJail;
    int val;
    int loc;

    public Chance() {
        this(null, false, true, false, false, false, false, false, false, false, false, 0, 0);
    }

    public Chance(String n, boolean mv, boolean mny, boolean near, boolean iODB,
            boolean iOTN, boolean pO, boolean pH, boolean oJ, boolean mvB, boolean tJ, int l, int v) {
        name = n;
        move = mv;
        money = mny;
        nearest = near;
        ifOwnedDB = iODB;
        ifOwnedTN = iOTN;
        payOthers = pO;
        payHouse = pH;
        outJail = oJ;
        mvBack = mvB;
        toJail = tJ;
        val = v;
        loc = l;
    }

    public int draw(Player p, int n) {
        System.out.println("Draw a Chance Card.\n" + name);
        int out = effect(p);
        return out;
    }

    public int effect(Player p) {
        int out = 0;
        if (outJail) {
            p.addJailCard();
        } else if (toJail) {
            p.toJail();
        } else if (move) {
            if (nearest) {
                if (ifOwnedDB) {
                    int pLoc = p.getLoc();
                    if(pLoc>=5){
                        p.setLoc(5);
                    }
                    if(pLoc>=15){
                        p.setLoc(15);
                    }
                    if(pLoc>=25){
                        p.setLoc(25);
                    }
                    if(pLoc>=35){
                        p.setLoc(35);
                    }
                    out = 1;
                } else if (ifOwnedTN) {
                    int pLoc = p.getLoc();
                    if(pLoc<=12){
                        p.setLoc(12);
                        out = 2;
                    }
                    else{
                        p.setLoc(28);
                        out = 2;
                    }
                }
            } else if (mvBack) {
                p.move(-3);
            } else {
                p.setLoc(loc);
            }
        } else if (money) {
            if (payOthers) {
                out = 3;
            } else if (payHouse) {
                p.addMoney(-1 * ((p.getHouse() * 25) + (p.getHotel() * 100)));
            } else {
                p.addMoney(val);
            }
        }
        return out;
    }
}
