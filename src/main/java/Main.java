import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);                                                   //New Scanner
        System.out.println("What's the Height in meters?");
        double h = scn.nextDouble();                                                            //Height input
        System.out.println("What's the Length in meters?");
        double l = scn.nextDouble();                                                            //Length input
        System.out.println("How many coats do you want to apply?");
        int num = scn.nextInt();                                                                //Coats input
        System.out.println("The amount of paint required is: "+ litres(h,l, num) +" Litres");   //Final output (How many litres the user needs)
    }

    public static double litres(double h, double l, int coats){
        double litres = (wallSize(h,l)/12)*coats;                                               //Assuming 1 litre of paint covers 12 square meters
        return litres;
    }

    public static double wallSize(double h, double l){
        double size = h*l;                                                                      //Height multiplied by Length
        return size;
    }

}