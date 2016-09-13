package monopoly;

import java.util.*;

public class Dice {
    int die1;
    int die2;
    int total;
    boolean doubleRoll;
    
    public Dice()
    {
        die1 = (int)(Math.random()*6);
        die2 = (int)(Math.random()*6);
        total = die1+die2;
        if(die1 == die2)
            doubleRoll = true;
        else
            doubleRoll = false;
    }
    private void roll()
    {
        die1 = 1;//(int)(Math.random()*6) + 1;
        die2 = 1;//(int)(Math.random()*6) + 1;
        total = die1+die2;
        System.out.println("Die 1: " + die1 + " Die 2: " + die2 + " Total: " + total);
        if(die1 == die2){
            doubleRoll = true;
            System.out.println("Doubles.");
        }
        else
            doubleRoll = false;
    }
    public int getRoll()
    {
        this.roll();
        return total;
    }
    public int getDie()
    {
        return total;
    }
    public boolean equal()
    {
        return doubleRoll;
    }
    public String toString()
    {
        return "Die 1: " + die1 + " Die 2: " + die2 + " Total: " + total;
    }
}
