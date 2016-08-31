package nyc.c4q.Mila;

import java.util.Random;
import java.util.Scanner;
/**
 * Created by Millochka on 8/30/16.
 */
public class IceCreamService {

    public enum Flavor {
        CHOCOLATE,
        VANILLA,
        PURPLE,
        OREO,
        COFFEE;

        // Convenience method to take a String and return a valid Flavor, if there is one declared in our enum
        static Flavor fromString(String string) {
            Flavor[] flavors = Flavor.values();
            for (int i = 0; i < flavors.length; i++) {

                if (string.toUpperCase().equals(flavors[i].name())) {
                    return flavors[i];
                }
            }

            return null;
        }
    }

    public enum Topping {
        CHOCOLATE_CHIPS,
        BANANS,
        GAMMY_BEARS,
        NUTS;

        static String fromString(String string) {
            Topping[] topping = Topping.values();
            String temp = "";
            for (int i = 0; i < topping.length; i++) {
                if (topping[i].toString().indexOf('_') > -1) {
                    temp = topping[i].name().substring(0, topping[i].toString().indexOf('_')) + " "
                            + topping[i].name().substring(topping[i].toString().indexOf('_') + 1, topping[i].toString().length());


                } else {
                    temp = topping[i].name();
                }
                if (string.equalsIgnoreCase(temp)) {
                    return topping[i].name();
                }


            }
            return "";
        }


    }

    public static final int COST_ICE_CREAM = 233; // cents
    public static final int COST_PER_TOPPING = 33; // cents

    int numToppings;
    int totalCost = COST_ICE_CREAM; // cents

    Random random = new Random();

    String name;
    Flavor flavor;
    Scanner scanner = new Scanner(System.in);
    String topping;

    public static void main(String[] args) {
        IceCreamService iceCreamService = new IceCreamService();

        iceCreamService.requestName();
        iceCreamService.requestIceCreamFlavor();
        iceCreamService.requestTopping();
//        iceCreamService.requestTopping("bananas");
//        iceCreamService.requestTopping("gummy bears");
        iceCreamService.printConfirmation();
    }

    void requestIceCreamFlavor() {
        System.out.printf("Okay %s, which flavor of ice cream would you like?\n> ", name);
        flavor = Flavor.fromString(scanner.next());
        while (flavor == null) { // Keep looping until user has input a valid flavor
            // Show error message and display all flavors we have in stock
            System.out.printf("Hm... doesn't seem like we have that flavor. We currently have: ");
            Flavor[] flavors = Flavor.values();
            for (int i = 0; i < flavors.length; i++) {
                System.out.printf(flavors[i].name().toLowerCase());
                if (i < flavors.length - 1) {
                    System.out.printf(", ");
                } else {
                    System.out.print(".\n> ");
                }
            }
            // Request a new flavor

            flavor = Flavor.fromString(scanner.next());
        }
    }

    void requestName() {
        System.out.print("Welcome to our ice cream service! What's your name?\n> ");
        name = scanner.next();
    }

    void requestTopping() {
        boolean answerResult=true;
        while(answerResult) {
            System.out.printf("Okay %s, which toppings of ice cream would you like?\n> ", name);
            topping = Topping.fromString(scanner.next());
            if (validateTopping(topping)) {
                numToppings++;
                totalCost += COST_PER_TOPPING;
            }
            System.out.printf("Okay %s, would you like more toppings of ice cream ?\n> ", name);

            String answer = scanner.next().toLowerCase();
             answerResult = validateAnswer(answer);


        }

    }

    boolean validateAnswer(String input){

        while(true){
            switch (input) {

                case "yes":
                case "y":
                    return true;
                case "no":
                case "n":
                    return false;

                default: System.out.println("Oops, I am afraid I don't undertand your answer, please answer yes or no?");


            }
        }

    }

    boolean validateTopping(String topping) {
        while (topping == "") { // Keep looping until user has input a valid flavor
            // Show error message and display all flavors we have in stock
            System.out.printf("Hm... doesn't seem like we have that topping. We currently have: ");
            Topping[] toppings = Topping.values();
            for (int i = 0; i < toppings.length; i++) {
                System.out.printf(toppings[i].name().toLowerCase());
                if (i < toppings.length - 1) {
                    System.out.printf(", ");
                } else {
                    System.out.print(".\n> ");
                }
            }
            // Request a new flavor

            topping = Topping.fromString(scanner.next());
        }

        return true;
    }


//    void requestTopping() {
//
//        //Topping[] toppingArray = Topping.values();
//        for(Topping t:Topping.values()){
//        System.out.printf("Would you like %s?\n> ",t.toString() );
//        if (scanner.next().toLowerCase().equals("yes")) {
//            numToppings++;
//            totalCost += COST_PER_TOPPING;
//        }
//        }
//    }

    void printConfirmation() {
        System.out.println("Okay! A "
                + flavor.toString().toLowerCase()
                + " ice cream with "
                + numToppings
                + " toppings. Your total is $"
                + totalCost / 100d
                + " and your ice cream will arrive in "
                + (random.nextInt(60) + 1)
                + " minutes.");
    }
}
