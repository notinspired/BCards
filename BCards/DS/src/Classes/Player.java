package Classes;

import sun.font.CreatedFontTracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua Rosen on 1/14/2017.
 */
public class Player {
    private String name;
    private int turn;
    private List<Card> cards;
    private List<Card> played;
    private int power;
    private int lifepoints;
//    private List<Classes.Card> discard;


    public Player(String name) {
        this.name = name;
        this.turn = 0;
        this.cards = new ArrayList<Card>();
        this.played = new ArrayList<Card>();
        this.lifepoints = 15;
    }

    public void nextTurn(){
        this.turn++;
        this.power = this.turn;
    }




    public void giveCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        while (cards.size() < this.turn + 1){
            Card a = new Card(cards.size());
            cards.add(a);
        }
        this.cards = cards;
    }
    public void showCards(){
        if (this.cards.size()==0) {
            System.out.println(this.getName() + " has no cards!");
        }
        else {
            String a = "";
            int i = 0;
            while (i < this.cards.size()) {
                Card b = this.cards.get(i);
                if (b.getType().equals("Creature")) {
                    a = a + "Card " + (i + 1) + ": ";
                    a = a + "Creature: ";
                    a = a + "Cost " + Integer.toString((b.getCost())) + ", ";
                    a = a + "Health " + Integer.toString((b.getHealth())) + ", ";
                    a = a + "Attack " + Integer.toString((b.getAttack())) + " \n";
                }
                i++;
                //            else if(this.cards.get(i) instanceof Spell){
                //                Spell b = (Spell) this.cards.get(i);
                //            }
                //            else{
                //
                //            }
            }
            System.out.println(this.getName() + "'s cards: ");
            System.out.println(a);
        }
    }

    public void playCard(int i){
        int size = this.cards.size();
        if (i == size || i < 0){
            System.out.println("Sorry you don't have a card with that number");
        }
        else{
            if (this.cards.get(i).getCost()>this.power){
                System.out.println("That card costs too much to play!");
            }
            else{
                this.power = this.power - this.cards.get(i).getCost();
                this.cards.get(i).setBoard();
                this.played.add(this.cards.get(i));
                this.cards.remove(i);
            }
        }
    }
    public void showBoard(Player p){
        if (p.played.size()==0){
            System.out.println(p.getName() + "'s side of the board is currently empty");
        }
        else {
            String a = "";
            int i = 0;
            while (i < p.played.size()) {
                Card b = p.played.get(i);
                if (b.getType().equals("Creature")) {
                    a = a + "Played " + (i + 1) + ": ";
                    a = a + "Creature: ";
                    a = a + "Cost " + Integer.toString((b.getCost())) + ", ";
                    a = a + "Health " + Integer.toString((b.getHealth())) + ", ";
                    a = a + "Attack " + Integer.toString((b.getAttack())) + " \n";
                }
                i++;
                //            else if(this.cards.get(i) instanceof Spell){
                //                Spell b = (Spell) this.cards.get(i);
                //            }
                //            else{
                //
                //            }
            }
            System.out.println(p.getName() + "'s board: ");
            System.out.println(a);
        }
    }

    public void attack(){
        //we would need an input number and something to show that we are attacking.
        //if i could take the scanner into the attack function then i could have them
        //type a to get here and then.. display the board/card numbers and ask for the card in interest.
        //from here we could show them options from the opponents board
        //so we definitly need the scanner.
        //step 1 type a
            // check if they have cards on the board. if they do not break from the function.
        //step 2 type the card you want to use -
        // side note make this true: cards can only attack once per turn?
        //step 3 select target. need an option for attack opponent directly.
        // -- do this later, i believe if we want it we need both players as input to the function.
        //start with scanner.
    }

//    to make the code look sexy implement this
//    public String returnString(Card a){
//        if (a.getType().equals("Creature")){
//            a = a + "Played " + (i + 1) + ": ";
//            a = a + "Creature: ";
//            a = a + "Cost " + Integer.toString((b.getCost())) + ", ";
//            a = a + "Health " + Integer.toString((b.getHealth())) + ", ";
//            a = a + "Attack " + Integer.toString((b.getAttack())) + " \n";
//        }
//        i++;
////            else if(this.cards.get(i) instanceof Spell){
////                Spell b = (Spell) this.cards.get(i);
////            }
////            else{
////
////            }
//        return b;
//    }

    public String getName() {
        return name;
    }

    public void getPower(){
        System.out.println(this.getName() +" has " + this.power + " power.");
    }

    public void health(Player p){
        System.out.println(p.getName() + " has " + Integer.toString(p.lifepoints) + " lifepoints remaining.");
    }
    public boolean lose(){
        if (this.lifepoints > 0){
            return true;
        }
        else{
            return false;
        }
    }
}

