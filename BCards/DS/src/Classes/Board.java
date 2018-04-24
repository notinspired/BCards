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
            System.out.println("Type 'b' to see your board.");
            System.out.println("Type 'o' to see your opponents board.");
            System.out.println("Type the card number to play that card.");
            System.out.println("Type 'end' to end your turn.\n");
            userInput = scan.nextLine();
            switch (userInput) {
                case "h":
                    p.showCards();
                    break;
                case "1":
                    p.playCard(0);
                    break;
                case "2":
                    p.playCard(1);
                    break;
                case "3":
                    p.playCard(2);
                    break;
                case "4":
                    p.playCard(3);
                    break;
                case "5":
                    p.playCard(4);
                    break;
                case "6":
                    p.playCard(5);
                    break;
                case "7":
                    p.playCard(6);
                    break;
                case "8":
                    p.playCard(7);
                    break;
                case "9":
                    p.playCard(8);
                    break;
                case "10":
                    p.playCard(9);
                    break;
                case "11":
                    p.playCard(10);
                    break;
                case "b":
                    p.showBoard(p);
                    break;
                case "o":
                    p.showBoard((otherPlayer(p)));
                    break;
                case "end":
                    break;
                default:
                    System.out.println("Command not recognized.\n");;
                    break;
            }
        }
    }

    private Player otherPlayer(Player p) {
        if (p.getName().equals(getP1().getName())){
            return getP2();
        }
        else{
            return getP1();
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
