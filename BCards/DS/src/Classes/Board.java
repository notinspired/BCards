package Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joshua Rosen on 7/13/2016.
 */
//
public class Board {
    private Scanner scan;
    private Player p1;
    private Player p2;
    private boolean flag;

    public Board() {
        this.scan = new Scanner(System.in);
        System.out.print("Classes.Player one name: ");
        String name1 = scan.nextLine();
        p1 = new Player(name1);

        System.out.print("Classes.Player two name ");
        String name2 = scan.nextLine();
        p2 = new Player(name2);


        this.flag = false; //randomize eventually to make who goes first random

    }

    public void turn(){

        //if flag is false then player one will go first using method.
        if (!flag){
            this.oneT();
            this.twoT();
            this.flag = true;
        }
        //if flag is true then player two will go first using method.
        else{
            this.twoT();
            this.oneT();
            this.flag = false;
        }

    }
    //start by moving cards from hand to board
    public void oneT(){
        p1.nextTurn();
        p1.giveCards();

        System.out.println("It is " + p1.getName() + "'s turn.");
        String userInput = "";

        while (!userInput.equals("end")) {
            System.out.println("Type 'h' to see your hand.");
            System.out.println("Type 'end' to end your turn.\n");
            userInput = scan.nextLine();
            switch (userInput) {
                case "h":
                    p1.showCards();
                case "end":
                    //ends turn
                    break;
                default:
                    System.out.println("Command not recognized.\n");;
            }
        }
    }

    public void twoT(){
        p2.nextTurn();
        p2.giveCards();

        System.out.println("It is " + p2.getName() + "'s turn.");
        String userInput = "";

        while (!userInput.equals("end")) {
            System.out.println("Type 'h' to see your hand.");
            System.out.println("Type 'end' to end your turn.\n");
            userInput = scan.nextLine();
            switch (userInput) {
                case "h":
                    p2.showCards();
                case "end":
                    //ends turn
                    break;
                default:
                    System.out.println("Command not recognized.\n");;
            }
        }
    }

    public Scanner getScan() {
        return scan;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public static void main(String[] args){
        Board game = new Board();
        Player p1 = game.getP1();
        Player p2 = game.getP2();

        game.turn();
    }
}
