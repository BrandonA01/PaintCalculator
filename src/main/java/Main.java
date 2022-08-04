import java.util.Scanner;

public class Main {
    int needsPainting = 0;
    static int dontPaint = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);                                                   //New Scanner
        System.out.println("How many walls are you painting?");                         //need to ask whether they are all rectangular.
        int numWalls = scn.nextInt();
        if(numWalls!=0){
            System.out.println("How many coats are you applying?");
            int coats = scn.nextInt();
            System.out.println("Are there any doors/windows/sockets/obstructions?   (Y/N)");
            if(inputCheck(scn).equals("Y")){
                System.out.println("How many obstructions (doors/windows/sockets) are there?");
                int obstructions = scn.nextInt();
                for(int i = 0; i<obstructions; i++){
                    System.out.println("What is the height of obstruction "+(i+1)+" in meters?");
                    int heightObst = scn.nextInt();
                    System.out.println("What is the Length of obstruction "+(i+1)+" in meters?");
                    int lengthObst = scn.nextInt();
                    Rectangle obstr = new Rectangle(heightObst, lengthObst);
                    dontPaint += obstr.area();
                }
            };
            System.out.println(dontPaint);
        }
        else{
            System.out.println("You do not need any paint.");
        }

        /*System.out.println("What's the Height in meters?");
        double h = scn.nextDouble();                                                            //Height input
        System.out.println("What's the Length in meters?");
        double l = scn.nextDouble();                                                            //Length input
        System.out.println("How many coats do you want to apply?");
        int num = scn.nextInt();                                                                //Coats input
        System.out.println("The amount of paint required is: "+ litres(h,l, num) +" Litres");*/   //Final output (How many litres the user needs)
    }

    public static String inputCheck(Scanner scn){
        boolean bool = false;
        while(!bool){
            switch(scn.next().toUpperCase()) {
                case "Y":
                    System.out.println("Yes");
                    bool = true;
                    break;
                case "N":
                    System.out.println("No");
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the inputs: (Y/N)");
            }
        }
        return scn.next().toUpperCase();
    }
    public static double litres(double h, double l, int coats){
        double litres = (rectangle(h,l)/12)*coats;                                               //Assuming 1 litre of paint covers 12 square meters
        return litres;
    }
    public static double rectangle(double h, double l){
        double size = h*l;                                                                      //Height multiplied by Length
        return size;
    }
    /*public static double circle(double h, double l){
        double size;                                                                     //Height multiplied by Length
        return size;
    }public static double triangle(double h, double l){
        double size;                                                                     //Height multiplied by Length
        return size;
    }*/


}