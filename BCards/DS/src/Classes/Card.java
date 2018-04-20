package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Joshua Rosen on 3/14/2017.
 */
public class Card {
    private int cost;
    private String type;
    private boolean hand;
    private boolean board;
    private boolean discard;
    private int health;
    private int attack;
    private String status;


    public Card(int x){
        this.setCost(x);
        this.setType(x);
        this.setHand();
//      ff = r.nextInt(2)+0
//      if ff ==
//      else
//      when more than one card type is possible possibly increase probability of
//      creature spawn in initial rounds or not fuck it

    }

    //make set cost depend on something more than random
    public void setCost(int round) {
        Random r = new Random();
        this.cost = r.nextInt(round + 2);
    }

    public void setType(int round) {
        String type = "";
        Random r = new Random();
        //when spell is implemented
        if (0 == 0){
            type = "Creature";
            this.setHealth(round);
            this.setAttack(round);
        }
        this.type = type;

    }

    public void setHealth(int round) {
        Random r = new Random();
        this.health = r.nextInt(round + 2) + 1;

    }

    public void setAttack(int round) {
        Random r = new Random();
        this.attack = r.nextInt(round + 2);
    }


    public void setHand() {
        this.hand = true;
        this.board = false;
        this.discard = false;
    }

    public void setBoard() {
        this.board = true;
        this.hand = false;
        this.discard = false;
    }

    public void setDiscard() {
        this.discard = true;
        this.hand = false;
        this.board = false;
    }

    public void roundEnd(Card c){
        if (c.type.equals("Creature") && c.board == true) {
            if (this.health <= 0) {
                setDiscard();
            }
        }
    }


    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public String getStatus() {
        return status;
    }
}
