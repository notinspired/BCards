package Classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joshua Rosen on 7/13/2016.
 */
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
            this.turn(p1);
            this.turn(p2);
            this.flag = !this.flag;
        }
        //if flag is true then player two will go first using method.
        else{
            this.turn(p2);
            this.turn(p1);
            this.flag = !this.flag;
        }

    }
    //start by moving cards from hand to board
    //number input not working correctly
    public void turn(Player p){
        p.nextTurn();
        p.giveCards();

        System.out.println("It is " + p.getName() + "'s turn.");
        String userInput = "";

        while (!userInput.equals("end")) {
            System.out.println("Type 'h' to see your hand.");
            System.out.println("Type 'end' to end your turn.\n");
            userInput = scan.nextLine();
            switch (userInput) {
                case "h":
                    p.showCards();
                case "1":
                    System.out.println("1 typed");
                case "one":
                    p.playCard(0);
                case "two":
                    p.playCard(1);
                case "three":
                    p.playCard(2);
                case "four":
                    p.playCard(3);
                case "five":
                    p.playCard(4);
                case "six":
                    p.playCard(5);
                case "seven":
                    p.playCard(6);
                case "eight":
                    p.playCard(7);
                case "nine":
                    p.playCard(8);
                case "ten":
                    p.playCard(9);
                case "eleven":
                    p.playCard(10);
                case "b":
                    p.showBoard();
                case "end":
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

        //move cards from hand to board
        game.turn();

    }
}
