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
//    private List<Classes.Card> played;
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
        String a = "";
        int i = 0;
        while (i < this.cards.size()){
            Card b = this.cards.get(i);
            if (b.getType().equals("Creature")){
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

    public void playCard(int i){
        //give ability to choose between cards
        int size = this.cards.size();
        if (i == size || i < 0){
            System.out.println("Sorry you don't have a card with that number");
        }
        else{
            this.cards.get(i).setBoard();
            this.played.add(this.cards.get(i));
            this.cards.remove(i);
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

