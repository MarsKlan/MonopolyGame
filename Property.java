package monopoly;

public class Property extends Space {

    private int cost;
    private String color;
    private int house;
    private int rent1, rent2, rent3, rent4, rentH;
    private int costH, costHT;
    boolean monopoly;

    public Property() {
        this(null, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Property(String n, int c, String col, int r, int r1, int r2, int r3, int r4, int rH, int cH, int cHT, int mort, int l) {
        super(n, l, mort, true);
        type = 1;
        cost = c;
        color = col;
        house = 0;
        rent = r;
        rent1 = r1;
        rent2 = r2;
        rent3 = r3;
        rent4 = r4;
        rentH = rH;
        costH = cH;
        costHT = cHT;
        owned = false;
        monopoly = false;
    }
    
    public void monopoly() {
        monopoly = true;
        rent = 2*rent;
    }
    
    public boolean getMonopoly() {
        return monopoly;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
    
    public int getHouse() {
        return house;
    }
    
    public int getCostHouse(){
        return costH;
    }
    
    public int getCostHotel(){
        return costHT;
    }

    public int getRent() {
        int out = 0;
        switch (house) {
            case 1:
                out = rent1;
                break;
            case 2:
                out = rent2;
                break;
            case 3:
                out = rent3;
                break;
            case 4:
                out = rent4;
                break;
            case 5:
                out = rentH;
                break;
            default:
                out = rent;
        }
        return out;
    }
    
    public void sold() {
        owned = false;
        System.out.println(name + " is sold.");
        if(monopoly){
            monopoly = false;
            rent = rent/2;
        }
    }
    
    public void buyHouse(){
        house++;
        System.out.println(name + " now has a house. Rent has increased to " + getRent());
    }
    
    public void buyHouse(int h){
        house += h;
        System.out.println(name + " now has a house. Rent has increased to " + getRent());
    }
    
    public void buyHotel(){
        house=5;
        System.out.println(name + " now has a hotel. Rent has increased to " + getRent());
    }

    public String toString() {
        return name + " " + color + "\nCost: $" + cost + "\nRent: $" + rent + "\nRent One House: $" + rent1
                + "\nRent Two Houses: $" + rent2 + "\nRent Three Houses: $" + rent3
                + "\nRent Four Houses: $" + rent4 + "\nRent Hotel: $" + rentH + "\nMonopoly Rent: $" + rent1 * 2
                + "\nMortgage: $" + mortgage + "\nHouse Cost: $" + costH + "\nHotel Cost: $" + costHT + "\n";
    }
}
