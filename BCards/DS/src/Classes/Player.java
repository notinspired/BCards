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
    private int power;
    private int lifepoints;
//    private List<Classes.Card> played;
//    private List<Classes.Card> discard;


    public Player(String name) {
        this.name = name;
        this.turn = 0;
        this.cards = new ArrayList<Card>();
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
    public void playCard(){
        //print cards in string form for players
        //give ability to choose between cards
        //differentiate between player 1 and 2 for turns

    }

    public String getName() {
        return name;
    }
}

