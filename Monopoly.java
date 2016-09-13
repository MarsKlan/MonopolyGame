package monopoly;

import java.util.*;
import java.io.*;

public class Monopoly {
    //Jail cards dont work, to jail comchest card doesnt end roll, community chest fees, comchest pay for street repairs
    //comchest advance go
    //
    //trading

    public static void main(String[] args) throws IOException {
        Dice die = new Dice();
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Scanner comChestScan = new Scanner(new File("CommunityChest.dat"));
        //ArrayLists for Board Spaces, Chance Cards, Community Chest Cards, and Players

        ArrayList<Space> board = new ArrayList<>();
        board.add(new Space("GO", 0, 0, false));
        board.add(new Property("Mediteranean Avenue", 60, "Brown", 2, 10, 30, 90, 160, 250, 50, 50, 30, 1));
        board.add(new Space("Community Chest", 0, 2, false));
        board.add(new Property("Baltic Avenue", 60, "Brown", 4, 20, 60, 180, 320, 450, 50, 50, 30, 3));
        board.add(new Space("Income Tax", 0, 4, false));
        board.add(new Station("Reading Railroad", 5));
        board.add(new Property("Oriental Avenue", 100, "Light Blue", 6, 30, 90, 270, 400, 550, 50, 50, 50, 6));
        board.add(new Space("Chance", 0, 7, false));
        board.add(new Property("Vermont Avenue", 100, "Light Blue", 6, 30, 90, 270, 400, 550, 50, 50, 50, 8));
        board.add(new Property("Connecticut Avenue", 100, "Light Blue", 12, 60, 180, 500, 700, 9005, 50, 50, 60, 9));
        board.add(new Space("Jail", 0, 10, false));
        board.add(new Property("St Charles Place", 140, "Pink", 10, 50, 150, 450, 625, 750, 100, 100, 70, 11));
        board.add(new Utility("Electric Company", 150, 75, 12));
        board.add(new Property("States Avenue", 140, "Pink", 10, 50, 150, 450, 625, 750, 100, 100, 70, 13));
        board.add(new Property("Virginia Avenue", 160, "Pink", 12, 60, 180, 500, 700, 900, 100, 100, 80, 14));
        board.add(new Station("Pennsylvania Railroad", 15));
        board.add(new Property("St James Place", 180, "Orange", 14, 70, 200, 550, 750, 950, 100, 100, 90, 16));
        board.add(new Property("Tennessee Avenue", 180, "Orange", 14, 70, 200, 550, 750, 950, 100, 100, 90, 17));
        board.add(new Space("Community Chest", 0, 18, false));
        board.add(new Property("New York Avenue", 200, "Orange", 16, 80, 220, 600, 800, 1000, 100, 100, 100, 19));
        board.add(new Space("Free Parking", 0, 20, false));
        board.add(new Property("Kentucky Avenue", 220, "Red", 18, 90, 250, 700, 875, 1050, 150, 150, 110, 21));
        board.add(new Space("Chance", 0, 22, false));
        board.add(new Property("Indiana Avenue", 220, "Red", 18, 90, 250, 700, 875, 1050, 150, 150, 110, 23));
        board.add(new Property("Illinois Avenue", 240, "Red", 20, 100, 300, 750, 925, 1100, 150, 150, 120, 24));
        board.add(new Station("B & O Railroad", 25));
        board.add(new Property("Atlantic Avenue", 260, "Yellow", 22, 110, 330, 800, 975, 1150, 150, 150, 130, 26));
        board.add(new Property("Ventnor Avenue", 260, "Yellow", 22, 110, 330, 800, 975, 1150, 150, 150, 130, 27));
        board.add(new Utility("Water Works", 150, 75, 28));
        board.add(new Property("Marvin Gardens", 280, "Yellow", 24, 120, 360, 850, 1025, 1200, 150, 150, 140, 29));
        board.add(new Space("Go To Jail", 0, 30, false));
        board.add(new Property("Pacific Avenue", 300, "Green", 26, 130, 390, 900, 1100, 1275, 200, 200, 150, 31));
        board.add(new Property("North Carolina Avenue", 300, "Green", 26, 130, 390, 900, 1100, 1275, 200, 200, 150, 32));
        board.add(new Space("Community Chest", 0, 33, false));
        board.add(new Property("Pennsylvania Avenue", 320, "Green", 28, 150, 450, 1000, 1200, 1400, 200, 200, 160, 34));
        board.add(new Station("Short Line", 35));
        board.add(new Space("Chance", 0, 36, false));
        board.add(new Property("Park Place", 350, "Blue", 35, 175, 500, 1100, 1300, 1500, 200, 200, 175, 37));
        board.add(new Space("Luxury Tax", 0, 38, false));
        board.add(new Property("Boardwalk", 400, "Blue", 50, 200, 600, 1400, 1700, 2000, 200, 200, 200, 39));


        ArrayList<Chance> chance = new ArrayList<>();
        chance.add(new Chance("Advance to Go", true, false, false, false, false, false, false, false, false, false, 0, 0));
        chance.add(new Chance("Advance to Illinois Avenue", false, false, false, false, false, true, false, false, false, false, 24, 0));
        chance.add(new Chance("Advance to St. Charles Place", true, false, false, false, false, false, false, false, false, false, 11, 0));
        chance.add(new Chance("Advance to Nearest Railroad - If owned, pay double.", true, false, true, true, false, false, false, false, false, false, 0, 0));
        chance.add(new Chance("Advance to Nearest Railroad - If owned, pay double.", true, false, true, true, false, false, false, false, false, false, 0, 0));
        chance.add(new Chance("Advance to Nearest Utility. If owned, pay owner ten times the dice. ", true, false, true, false, true, false, false, false, false, false, 0, 0));//fix
        chance.add(new Chance("Bank pays you dividend of $50 ", false, true, false, false, false, false, false, false, false, false, 0, 50));
        chance.add(new Chance("Get out of Jail Free ", false, false, false, false, false, false, false, true, false, false, 0, 0));
        chance.add(new Chance("Go Back 3 Spaces ", false, true, false, false, false, false, false, false, false, false, 0, 0));
        chance.add(new Chance("Go to Jail ", false, false, false, false, false, false, false, false, false, true, 0, 0));
        chance.add(new Chance("Make general repairs on all your property", false, true, false, false, false, false, false, false, false, false, 0, 0));
        chance.add(new Chance("Pay poor tax of $15 ", false, true, false, false, false, false, false, false, false, false, 0, 15));
        chance.add(new Chance("Take a trip to Reading Railroad ", true, false, false, false, false, false, false, false, false, false, 5, 0));
        chance.add(new Chance("Take a walk on the Boardwalk ", true, false, false, false, false, false, false, false, false, false, 0, 39));
        chance.add(new Chance("You have been elected Chairman of the Board – Pay each player $50 ", false, true, false, false, false, true, false, false, false, false, 0, 0));//fix
        chance.add(new Chance("Your loan matures - Collect $150", false, true, false, false, false, false, false, false, false, false, 0, 150));



        ArrayList<Comchest> comchest = new ArrayList<>();
        comchest.add(new Comchest("Advance to Go", true, false, false, false, false, 0));
        comchest.add(new Comchest("Bank Error in your Favor", false, false, false, false, false, 200));
        comchest.add(new Comchest("Bank Error in your Favor", false, false, false, false, false, 200));
        comchest.add(new Comchest("Doctors Fees", false, false, false, false, false, -50));
        comchest.add(new Comchest("Sell Stocks", false, false, false, false, false, 50));
        comchest.add(new Comchest("Get Out of Jail Free", false, false, true, false, false, 0));
        comchest.add(new Comchest("Go to Jail", false, true, false, false, false, 0));
        comchest.add(new Comchest("Grand Opera Opening", false, false, false, true, false, 50));
        comchest.add(new Comchest("Holiday Fund Matures", false, false, false, false, false, 100));
        comchest.add(new Comchest("Income Tax Refund", false, false, false, false, false, 20));
        comchest.add(new Comchest("Life Insurance Matures", false, false, false, false, false, 100));
        comchest.add(new Comchest("Pay Hospital Fees", false, false, false, false, false, -100));
        comchest.add(new Comchest("Pay School Fees", false, false, false, false, false, -150));
        comchest.add(new Comchest("Receive Consultancy Fee", false, false, false, false, false, 25));
        comchest.add(new Comchest("Pay for Street Repairs", false, false, false, true, true, 40));
        comchest.add(new Comchest("Won Second Place at Beauty Contest", false, false, false, false, false, 10));
        comchest.add(new Comchest("Inheritance", false, false, false, false, false, 100));

        Collections.shuffle(comchest);
        Collections.shuffle(chance);
        int comChestLoc = 0;
        int chanceLoc = 0;
        int freePark = 50;

        System.out.println("Welcome to Monopoly\n");
        System.out.println("How Many Players? ");
        int playerNum = 2;
        do {
            if (playerNum < 2) {
                System.out.println("Please enter a valid number.");
            }
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Please enter a number.");
            }
            playerNum = input.nextInt();
        } while (playerNum < 2);
        boolean[] playerCont = new boolean[playerNum];
        for (int n = 1; n <= playerNum; n++) {
            boolean repeatName = false;
            String name = "";
            do {
                System.out.println("Name of Player " + n);
                name = input.next();
                for (Player p : players) {
                    if (name.equals(p.getName())) {
                        repeatName = true;
                        System.out.println("Repeated Name, Please select a different name.");
                    } else {
                        repeatName = false;
                    }
                }
            } while (repeatName);
            players.add(new Player(name));
        }
        for (Player p : players) {
            System.out.println(p.toString());
        }
        System.out.println("Let's Play.\n");
        System.out.println("Roll - rolls the dice and moves the player.\n"
                + "Space - shows information of the property at the players location.\n"
                + "Properties - shows all the properties the player ownes.\n"
                + "Buy - buys the property at the players location\n"
                + "Buy House - allows you to buy a houses for your properties.\n"
                + "Buy Hotel - allows you to buy a hotel for your properties with four houses.\n"
                + "Money - tells the player how much money they have.\n"
                + "Pay - if you are in Jail, pay $50 to get out.\n"
                + "Done - ends the current players turn.\n"
                + "End Game - ends the game.\n\n");
        int cont = 0;
        int turn = 0;
        boolean end = true;
        do {//Begin game.
            cont = 0;
            if (turn > players.size() - 1) {
                turn = 0;
            }
            System.out.println("It is " + players.get(turn).getName() + "'s turn.\n"
                    + "Money: $" + players.get(turn).getMoney());
            boolean done = false;
            boolean rolled = false;
            boolean moved = false;
            int threeDouble = 0;
            do {//Begin Player turn.
                String action = input.nextLine().replaceAll(" ", "").toLowerCase();
                switch (action) {

                    case "roll":
                        moved = true;
                        if (rolled) {
                            System.out.println("You already rolled.");
                        } else {

                            if (players.get(turn).getInJail()) {
                                if (players.get(turn).getJailAttempt() >= 3) {
                                    System.out.println("You have attempted three times, "
                                            + "you must now Pay $50 to get out of Jail");
                                } else {
                                    die.getRoll();
                                    players.get(turn).jailAttempt();
                                    if (die.equal()) {
                                        players.get(turn).jailRoll();
                                        players.get(turn).jailAttemptSub();
                                    } else {
                                        System.out.println("Sorry, you are still in Jail.");
                                        rolled = true;
                                    }
                                    if (players.get(turn).getJailRoll() == 3) {
                                        players.get(turn).outJail();
                                        System.out.println("You are out of Jail.");
                                        players.get(turn).jailRollReset();
                                        rolled = true;
                                        break;
                                    }
                                }
                            } else {
                                players.get(turn).move(die.getRoll());
                                if (!die.equal()) {
                                    rolled = true;
                                } else {
                                    System.out.println("Roll again.");
                                    threeDouble++;
                                    if (threeDouble == 3) {
                                        players.get(turn).toJail();
                                        rolled = true;

                                    }
                                }
                                Space temp = board.get(players.get(turn).getLoc());
                                System.out.print(temp.getName());
                                int tp = temp.getType();
                                if (tp == 1) {
                                    System.out.println(" " + temp.getColor() + ".");
                                } else {
                                    System.out.println(".");
                                }
                                switch (tp) {
                                    case 0://standard spaces
                                        if (players.get(turn).getLoc() == 30) {//go to jail
                                            players.get(turn).toJail();
                                        } else if (players.get(turn).getLoc() == 2 || players.get(turn).getLoc() == 18
                                                || players.get(turn).getLoc() == 33) {//comunity chest
                                            int ccEffect = comchest.get(comChestLoc).draw(players.get(turn), players.size());
                                            if (players.get(turn).getInJail()) {
                                                rolled = true;
                                            }
                                            if (ccEffect > 0) {
                                                for (Player p : players) {
                                                    if (p != players.get(turn)) {
                                                        p.subMoney(50);
                                                    }
                                                }
                                            }
                                            if (comChestLoc > comchest.size()) {
                                                comChestLoc = 0;
                                            } else {
                                                comChestLoc++;
                                            }
                                        } else if (players.get(turn).getLoc() == 7 || players.get(turn).getLoc() == 22
                                                || players.get(turn).getLoc() == 36) {//chance
                                            int cEffect = chance.get(chanceLoc).draw(players.get(turn), players.size());
                                            switch (cEffect) {
                                                case 1:
                                                    if (board.get(players.get(turn).getLoc()).owned()) {
                                                        int rnt = temp.getRent(players.get(turn).getRR());
                                                        players.get(turn).subMoney(2 * rnt);
                                                        for (int owner = 0; owner < players.size(); owner++) {
                                                            for (Space prop : players.get(owner).getProperties()) {
                                                                if (prop == temp && players.get(owner) != players.get(turn)) {
                                                                    players.get(owner).addMoney(2 * rnt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    if (board.get(players.get(turn).getLoc()).owned()) {
                                                        int rnt = 10 * die.getDie();
                                                        players.get(turn).subMoney(rnt);
                                                        for (int owner = 0; owner < players.size(); owner++) {
                                                            for (Space prop : players.get(owner).getProperties()) {
                                                                if (prop == temp && players.get(owner) != players.get(turn)) {
                                                                    players.get(owner).addMoney(rnt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    for (Player p : players) {
                                                        if (p != players.get(turn)) {
                                                            p.subMoney(50);
                                                        }
                                                    }
                                            }
                                            if (chanceLoc > chance.size()) {
                                                chanceLoc = 0;
                                            } else {
                                                chanceLoc++;
                                            }
                                        } else if (players.get(turn).getLoc() == 4 || players.get(turn).getLoc() == 38) {
                                            System.out.println("Tax.");
                                            System.out.println("You pay $200.");
                                            players.get(turn).subMoney(200);

                                        } else if (players.get(turn).getLoc() == 20) {
                                            players.get(turn).addMoney(freePark);
                                            freePark = 50;
                                        }
                                        break;
                                    case 1://properties
                                        if (board.get(players.get(turn).getLoc()).owned()) {
                                            int rnt = temp.getRent();
                                            for (int owner = 0; owner < players.size(); owner++) {
                                                for (Space prop : players.get(owner).getProperties()) {
                                                    if (prop == temp && players.get(owner) != players.get(turn)) {
                                                        System.out.println(players.get(turn).getName() + " pays "
                                                                + rnt + " to " + players.get(owner).getName() + ".");
                                                        players.get(owner).addMoney(rnt);
                                                        players.get(turn).subMoney(rnt);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 2://train stations
                                        if (board.get(players.get(turn).getLoc()).owned()) {
                                            int rnt = temp.getRent(players.get(turn).getRR());
                                            players.get(turn).subMoney(rnt);
                                            for (int owner = 0; owner < players.size(); owner++) {
                                                for (Space prop : players.get(owner).getProperties()) {
                                                    if (prop == temp && players.get(owner) != players.get(turn)) {
                                                        players.get(owner).addMoney(rnt);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 3://utility
                                        if (board.get(players.get(turn).getLoc()).owned()) {
                                            int rnt = temp.getRent(players.get(turn).getUtil(), die.getDie());
                                            players.get(turn).subMoney(rnt);
                                            for (int owner = 0; owner < players.size(); owner++) {
                                                for (Space prop : players.get(owner).getProperties()) {
                                                    if (prop == temp && players.get(owner) != players.get(turn)) {
                                                        players.get(owner).addMoney(rnt);
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Error - space type");
                                        break;
                                }
                            }
                        }
                        break;
                    case "buyhouse":
                        if (players.get(turn).getPropertiesHouse().size() > 0) {
                            System.out.println("Which Property would you like to buy a house for?");
                            System.out.println(players.get(turn).printPropertiesHouse());
                            String prop = input.nextLine().replaceAll(" ", "").toLowerCase();
                            for (Property p : players.get(turn).getPropertiesHouse()) {
                                String name = p.getName().replaceAll(" ", "").toLowerCase();
                                if (name.equals(prop)) {
                                    System.out.println("Houses for " + p.getName() + " cost $" + p.getCostHouse());
                                    System.out.println("How many houses would you like to put on " + p.getName());
                                    while (!input.hasNextInt()) {
                                        input.next();
                                        System.out.println("Please enter a number.");
                                    }
                                    int num = input.nextInt();
                                    if (num > 4) {
                                        System.out.println("You can only have 4 houses on a property.");
                                    }
                                    p.buyHouse(num);
                                    players.get(turn).subMoney(num * p.getCostHouse());
                                }
                            }
                        } else {
                            System.out.println("You don't have any properties that can have houses.");
                        }
                        break;
                    case "buyhotel":
                        if (players.get(turn).getPropertiesHotel().size() > 0) {
                            System.out.println("Which Property would you like to buy a hotel for?");
                            System.out.println(players.get(turn).printPropertiesHotel());
                            String prop = input.nextLine().replaceAll(" ", "").toLowerCase();
                            for (Property p : players.get(turn).getPropertiesHotel()) {
                                String name = p.getName().replaceAll(" ", "").toLowerCase();
                                if (name.equals(prop)) {
                                    System.out.println("Hotels for " + p.getName() + " cost $" + p.getCostHotel());
                                    p.buyHotel();
                                    players.get(turn).subMoney(p.getCostHotel());
                                }
                            }
                        } else {
                            System.out.println("You don't have any properties that can have a hotel.");
                        }
                        break;
                    case "pay":
                        if (players.get(turn).hasJailCard()) {
                            System.out.println("You have a Get out of Jail Free Card, would you like to use it?");
                            String sure = input.nextLine().replaceAll(" ", "").toLowerCase();
                            if (sure.equals("yes")) {
                                players.get(turn).useJailCard();
                                rolled = true;
                                System.out.println("You are out of Jail.");
                                break;
                            }
                        }
                        if (players.get(turn).getInJail() && !rolled) {
                            players.get(turn).subMoney(50);
                            players.get(turn).outJail();
                            rolled = true;
                            System.out.println("You are out of Jail.");
                        } else if (players.get(turn).getInJail() && rolled) {
                            System.out.println("You must pay before you roll.");
                        } else {
                            System.out.println("You are not in Jail. You don't need to pay.");
                        }

                        break;
                    case "money":
                        System.out.println("$" + players.get(turn).getMoney());
                        break;
                    case "properties":
                        System.out.println(players.get(turn).printProperties());
                        break;
                    case "help":
                    case "?":
                        System.out.println("Roll - rolls the dice and moves the player.\n"
                                + "Space - shows information of the property at the players location.\n"
                                + "Properties - shows all the properties the player ownes.\n"
                                + "Buy - buys the property at the players location\n"
                                + "Buy House - allows you to buy a houses for your properties.\n"
                                + "Buy Hotel - allows you to buy a hotel for your properties with four houses.\n"
                                + "Money - tells the player how much money they have.\n"
                                + "Pay - if you are in Jail, pay $50 to get out.\n"
                                + "Done - ends the current players turn.\n"
                                + "End Game - ends the game.\n");
                        break;
                    case "done":
                        if (rolled) {
                            done = !done;
                            rolled = false;
                            moved = false;
                            players.get(turn).jailRollReset();
                            System.out.println();
                        } else {
                            System.out.println("You must roll on you turn.");
                        }
                        break;
                    case "endgame":
                        System.out.println("Are you sure?");
                        String sure = input.nextLine().replaceAll(" ", "").toLowerCase();
                        if (sure.equals("yes")) {
                            System.out.println("ENDING GAME");
                            done = true;
                            end = false;
                        } else {
                            System.out.println("Game Continues");
                        }
                        break;
                    case "space":
                        System.out.print(board.get(players.get(turn).getLoc()).toString());
                        break;
                    case "buy":
                        if (moved) {
                            if (board.get(players.get(turn).getLoc()).buyable()) {
                                //System.out.println("Buyable.");
                                if (!board.get(players.get(turn).getLoc()).owned()) {
                                    if (board.get(players.get(turn).getLoc()).getCost() <= players.get(turn).getMoney()) {
                                        players.get(turn).addProperty(board.get(players.get(turn).getLoc()));
                                        board.get(players.get(turn).getLoc()).bought();
                                        if (board.get(players.get(turn).getLoc()).getType() == 1) {
                                            String color = board.get(players.get(turn).getLoc()).getColor();
                                            int totalCol = 0;
                                            for (Space p : board) {
                                                if (p.getType() == 1 && p.getColor().equals(color)) {
                                                    totalCol++;
                                                }
                                            }
                                            if (players.get(turn).getMonopoly(color, totalCol)
                                                    && board.get(players.get(turn).getLoc()).getHouse() == 0) {
                                                board.get(players.get(turn).getLoc()).monopoly();
                                                System.out.println(players.get(turn).getName() + " now has a monopoly on "
                                                        + color + " spaces, they now have double rent.");
                                            }
                                        }
                                    } else {
                                        System.out.println("You don't have enough money to buy the property.");
                                    }
                                } else {
                                    System.out.println("The property is already owned.");
                                }
                            } else {
                                System.out.println("The property is unbuyable.");
                            }
                        } else {
                            System.out.println("You must roll before you buy.");
                        }

                        break;
                    default:
                        System.out.println("Please choose an action.");
                        //turn--;

                        break;
                }
            } while (!done);
            for (int c = 0; c < players.size(); c++) //check if there is only one person left with money.
            {
                playerCont[c] = players.get(c).hasMoney();
                if (playerCont[c]) {
                    cont++;
                }
            }
            turn++;
        } while (cont > 1 && end);
        for (int c = 0; c < players.size(); c++) // finds and prints the winner.
        {
            if (playerCont[c]) {
                System.out.println(players.get(c).getName() + " is the winner!");
            }
        }
    }
}
