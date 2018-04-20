package SI;

import com.sun.xml.internal.ws.api.model.ExceptionType;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Joshua Rosen on 1/17/2017.
 */
public class BaseUnits {

    private Double num;
    private String bu;
    private String pre;

    public BaseUnits(Scanner scan) {
        Boolean bool = false;
        String num = null;
        while (!numChecker(num)){
            System.out.print("Please input a desired number: ");
            num = scan.next();
        }
//        System.out.println(num);
        this.num = Double.parseDouble(num);
        System.out.print("Please input a base unit (m, kg, s, K): ");
        String bu = scan.next();
        while(!baseChecker(bu)) {
            System.out.println("Invalid base unit! (m, kg, s, K) ");
            System.out.print("Please input a valid base unit (m, kg, s, K): ");
            bu = scan.next();
        }
        this.bu = bu;
    }

    @Override
    public String toString() {
        if (this.pre!=null){
            return Double.toString(this.num) + this.pre + this.bu;
        }
        else{
            return Double.toString(this.num) + this.bu;
        }
    }


    public static boolean numChecker(String number){
        Boolean flag = false;
        if (number != null) {
            if (Pattern.matches("[a-zA-Z]+", number)== false){
                Integer num = Integer.parseInt(number);
                flag = true;
            }
        }
        else{
            flag = false;
        }

        return flag;
    }

    public static boolean baseChecker(String baseUnit){
        Boolean flag = false;
        if (baseUnit.equals("m")){
            flag = true;
        }
        else if (baseUnit.equals("m")){
            flag = true;
        }
        else if (baseUnit.equals("kg")){
            flag = true;
        }
        else if (baseUnit.equals("s")){
            flag = true;
        }
//        else if (baseUnit.equals("K")){
//            flag = true;
//        }
//        else if (baseUnit.equals("mol")){
//            flag = true;
//        }
        else {
            flag = false;
        }
        return flag;
    }


    public void setPre(String pre) {
        this.pre = pre;
        Double dd;
        switch (pre) {
            case "d":
                this.num = (this.num * .1);
                break;
            case "c":
                this.num  = (this.num * .01);
                break;
            case "m":
                this.num  = (this.num * .0001);
                break;
            case "u":
                this.num  = (this.num * .0000001);
                break;
            case "n":
                this.num  = (this.num * .0000000001);
                break;
            case "p":
                this.num  = (this.num * .0000000000001);
                break;
            case "f":
                this.num  = (this.num * .0000000000000001);
                break;
            case "k":
                this.num = this.num * 1000;
                break;
            case "M":
                this.num = this.num * 1000000;
                break;
            case "G":
                this.num = this.num * 1000000000;
                break;
//            case "T":
//                this.num = this.num*1000000000000;
//                break;
        }
    }

    public static void main(String[] args){
        System.out.println("Welcome to the SI Java program");
        Scanner scan = new Scanner(System.in);
        BaseUnits base = new BaseUnits(scan);
        System.out.println("You input a base of " + base.toString());
        Prefix pre = new Prefix(scan);
        base.setPre(pre.getIt());
        System.out.println("Your new value is " + base.toString());


//        System.out.println(bu);
    }
}
