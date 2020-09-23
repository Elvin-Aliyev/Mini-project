/** Miniprojekt
 *@ kurs objetkorienterad programmation 1
 *@ authors: Elvin Aliyev, Tolga Andic, Veronica Guizzardi */
import java.util.Scanner;

public class Counter {
    public static void main(String args[]){

        boolean running = true;
        Scanner input = new Scanner(System.in);

        while (running) {

            printMenu();
            String choice = input.nextLine();

            // The corresponding function will run after the user makes a choice
            if (choice.equals("1")) {
                sphere();
            } else if (choice.equals("2")) {
                cylinder();
            }else if (choice.equals("3")){
                fraction();
            }else if (choice.equals("4")){
                sum();
            }else if (choice.equals("5")){
                calcPoint();
            }else if (choice.equals("0")){
                running = false;
            }
            else {
                System.out.println("Invalid choice");
            }
        }
    }
    /**
     * Find out the volume of a sphere from the value of the radius
     *
     * @ Param radius is entered by the user, it can only be a positive integer otherwise the user is gonna be asked to enter a new input
     * @ Return volume as a double
     */
    //Function to find out the volume of a sphere
    public static void sphere(){
        System.out.println("Enter radius:");
        int radius = errorControl();
        double pie = 3.14285714286;
        double volume = (4/3)*pie*(radius*radius*radius);
        System.out.println("The volume of sphere is: "+ volume);
    }
    /**
     * Find out the volume of a cylinder from the values of the radius and height
     *
     * @ Param radius and height are entered by the user they can only be positives integers otherwise the user is gonna be asked to enter a new input
     * @ Return volume as a double
     */
    //Function to find out the volume of a cylinder
    public static void cylinder(){
        System.out.println("Enter the radius:");
        int radius = errorControl();
        System.out.println("Enter the height:");
        double height = errorControl();
        double pie = 3.14285714286;
        double volume=pie*(radius*radius)*height;
        System.out.println("The volume of cylinder is: "+volume);
    }
    /**
     * Simplify fractions from a chosen numerator and a chosen denominator
     *
     * @ Param numerator and denominator are entered by the user they can only be positives integers otherwise the user is gonna be asked to enter a new input
     * @ Return the fraction in the mixed form
     */
    //Function for simplify fractions
    public static void fraction(){
        System.out.println("Input the numerator");
        int numerator = errorControl();
        while (numerator == 0){
            System.out.println("Numerator can't be zero, write a new value");
            numerator = errorControl();
        }
        System.out.println("Input the denominator");
        int denominator = errorControl();
        while (denominator == 0){
            System.out.println("Denominator can't be zero, write a new value");
            denominator = errorControl();
        }
        int wholeNum;
        int fraction;
        String mixedNum;

        if (numerator > denominator){
            if (numerator % denominator == 0){
                wholeNum = (numerator / denominator);
                mixedNum = (wholeNum+"");
                System.out.println(mixedNum);
            }
            wholeNum = (numerator / denominator);
            fraction = (numerator % denominator);
            mixedNum = (wholeNum+" "+fraction+"/"+denominator);
            System.out.println(mixedNum);
        }else {
            mixedNum = (numerator+"/"+denominator);
            System.out.println(mixedNum);
        }
    }
    /**
     * Adds all integers between 1 and a chosen number bigger than 0
     *
     * @ Param number is entered by the user, it can only be an integer bigger than 0 otherwise the user is gonna be asked to enter a new input
     * @ Return the value of the sum of all numbers between 1 and the chosen number
     */
    //Function for sum
    public static void sum(){
        System.out.println("Write a number larger than 0");
        int maxNumber = errorControl();
        while (maxNumber == 0){
            System.out.println("Number must be larger than 0, write a new number");
            maxNumber = errorControl();
        }
        int sum = maxNumber;
        for (int i = 0; i < maxNumber; i++) {
            sum = sum + i;
        }
        System.out.println("The sum is: "+sum);
    }
    /**
     * Calculates the function value of y on the line with the follow calculation: y = kx + m
     *
     * @ Param k, x and m are entered by the user, they can only be positives integers otherwise the user is gonna be asked to enter a new input
     * @ Return the value of y
     */
    //Function for y=kx+m
    public static void calcPoint(){
        System.out.println("Input value for k");
        int k = errorControl();
        System.out.println("input value for x");
        int x = errorControl();
        System.out.println("input value for m");
        int m = errorControl();
        int y = (k*x)+m;
        System.out.println("y="+k+"*"+x+"+"+m);
        System.out.println("y="+y);
    }
    /**
     * Control errors and make sure that user enter a number
     * @ return the input if it is a positive integer
     * otherwise the use is gonna be asked to enter a new input
     */
    //Function for error control, make sure that user inputs a number
    public static int errorControl(){
        Scanner input = new Scanner(System.in);
        int answer = 0;
        boolean error = true;
        while (error) {
            if (input.hasNextInt()) {
                answer = input.nextInt();
                if (answer < 0){
                    System.out.println("The number can't be less than zero");
                }else {
                    error = false;
                }
            } else {
                System.out.println("Invalid input, make sure your input is a whole number");
                input.next();
            }
        }
        return answer;
    }
    /**
     * Print menu
     *
     * @ return the menu every time a function is complete and gonna ask user to choose one alternative or to quit
     */
    //Function to print menu
    public static void printMenu(){
        System.out.println("Choose one of these alternatives : " +
                "\n1. Volume of sphere" +
                "\n2. Volume of cylinder " +
                "\n3. Fraction" +
                "\n4. Sum" +
                "\n5. CalcPoint" +
                "\n0. Quit");
    }
}