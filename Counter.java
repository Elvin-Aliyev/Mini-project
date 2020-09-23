import java.util.Scanner;

public class Counter {
    public static void main(String args[]){

        boolean running = true;
        Scanner input = new Scanner(System.in);

        while (running) {

            printMenu();
            String choice = input.nextLine();

            // The corresponding function will run after making a choice
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
    //Function to find out the volume of a sphere
    public static void sphere(){
        System.out.println("Enter radius:");
        int radius = errorControl();
        double pie = 3.14285714286;
        double volume = (4/3)*pie*(radius*radius*radius);
        System.out.println("The volume of sphere is: "+ volume);
    }
    //Function to find out the volume of a cylinder
    public static void cylinder(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the radius:");
        int radius = errorControl();
        System.out.println("Enter the height:");
        double height = errorControl();
        double pie = 3.14285714286;
        double volume=pie*(radius*radius)*height;
        System.out.println("The volume of cylinder is: "+volume);
    }
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
    //Function for sum of all input numbers
    public static void sum(){
        Scanner input = new Scanner(System.in);
        System.out.println("Write a numbers, if you write zero the program ends");
        int number;
        int sum = 0;
        do {
            number = errorControl();
            sum += number;
            System.out.println("Next number or write zero to end program");
        }while (number != 0);
            System.out.println("Sum is: "+ sum);
    }
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
    //Function for error control, make sure that user inputs a number
    public static int errorControl(){
        Scanner input = new Scanner(System.in);
        int answer = 0;
        boolean error = true;
        while (error) {
            if (input.hasNextInt()) {
                answer = input.nextInt();
                error = false;
            } else {
                System.out.println("Invalid input, make sure your input is a whole number");
                input.next();
            }
        }
        return answer;
    }
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
