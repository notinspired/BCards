package SI;

import java.util.Scanner;

/**
 * Created by Joshua Rosen on 1/17/2017.
 */
public class Prefix {

    private String it;

    public Prefix(Scanner scan) {
        System.out.println("Welcome to the Prefix Java program");

//        System.out.println(num);
        System.out.print("Please input a prefix (d, c, m, u, n): ");
        String pre = scan.next();
        while(!preChecker(pre)) {
            System.out.println("Invalid base unit! (d, c, m, u, n) ");
            System.out.print("Please input a prefix (d, c, m, u, n): ");
            pre = scan.next();
        }
        this.it = pre;
    }

    public boolean preChecker(String prefix){
        boolean flag = false;
        if (prefix!=null) {
            switch (prefix) {
                case "d":
                    flag = true;
                    break;
                case "c":
                    flag = true;
                    break;
                case "m":
                    flag = true;
                    break;
                case "u":
                    flag = true;
                    break;
                case "n":
                    flag = true;
                    break;
                case "p":
                    flag = true;
                    break;
                case "f":
                    flag = true;
                    break;
                case "k":
                    flag = true;
                    break;
                case "M":
                    flag = true;
                    break;
                case "G":
                    flag = true;
                    break;
//                case "T":
//                    too big so... ill do once i convert to scientific
//                    flag = true;
//                    break;
                default:
                    flag = false;
                    break;
            }
        }
        return flag;
    }





    public String getIt() {
        return it;
    }
}
