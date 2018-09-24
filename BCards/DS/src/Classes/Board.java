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
        }
        //if flag is true then player two will go first using method.
        else{
            this.turn(p2);
            this.turn(p1);
        }

    }

    public void instruct(Player p){
        System.out.println("It is " + p.getName() + "'s turn.");
        System.out.println("Type '?' to see available commands.");
        System.out.println("Type 'p' to see how much power you have.");
        System.out.println("Type 'h' to see your hand.");
        System.out.println("Type 'b' to see your board.");
        System.out.println("Type 'o' to see your opponent's board.");
        System.out.println("Type 'a' to use your cards to attack.");
        System.out.println("Type the card number to play that card.");
        System.out.println("Type 'x' to see your health.");
        System.out.println("Type 'z' to see your opponent's health.");
        System.out.println("Type 'end' to end your turn.\n");
    }

    public void attack(Card c){

    }

    public void turn(Player p){
        p.nextTurn();
        p.giveCards();

        System.out.println("It is " + p.getName() + "'s turn.");
        String userInput = "";
        instruct(p);
        while (!userInput.equals("end")) {
            userInput = scan.nextLine();
            switch (userInput) {
                case "?":
                    instruct(p);
                    break;
                case "p":
                    p.getPower();
                    break;
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
                case "x":
                    p.health(p);
                    break;
                case "z":
                    p.health(otherPlayer(p));
                    break;
                case "end":
                    break;
                case "a":
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

        while (game.getP1().lose() || game.getP2().lose()){
            game.turn();
        }
        if (game.getP1().lose()){
            System.out.println(game.getP2().getName() + " wins!");
        }
        else{
            System.out.println(game.getP1().getName() + " wins!");
        }
    }
}
