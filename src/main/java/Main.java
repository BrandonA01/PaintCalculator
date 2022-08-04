import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);                                                   //New Scanner
        System.out.println("How many walls are you painting?"); //need to ask whether they are all rectangular.
        int numWalls = scn.nextInt();
        System.out.println("How many coats are you applying?");
        int coats = scn.nextInt();
        System.out.println("Are there any doors/windows/sockets/obstructions?   (Y/N)");
        boolean bool = false;
        while(bool == false){
            switch(scn.next().toUpperCase()) {
                case "Y":
                    System.out.println("Yes");
                    bool = true;
                    System.out.println("How many obstructions (doors/windows/sockets) are there?");
                    int obstructions = scn.nextInt();
                    for(int i = 0; i<=obstructions; i++){
                        System.out.println("What is the height of this obstruction in meters?");
                        int heightObst = scn.nextInt();
                        System.out.println("What is the Length of this obstruction in meters?");
                        int lengthObst = scn.nextInt();
                    }
                    break;
                case "N":
                    System.out.println("No");
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the inputs: (Y/N)");
            }
        }




        /*System.out.println("What's the Height in meters?");
        double h = scn.nextDouble();                                                            //Height input
        System.out.println("What's the Length in meters?");
        double l = scn.nextDouble();                                                            //Length input
        System.out.println("How many coats do you want to apply?");
        int num = scn.nextInt();                                                                //Coats input
        System.out.println("The amount of paint required is: "+ litres(h,l, num) +" Litres");*/   //Final output (How many litres the user needs)
    }
    public static double litres(double h, double l, int coats){
        double litres = (wallSizeRectangle(h,l)/12)*coats;                                               //Assuming 1 litre of paint covers 12 square meters
        return litres;
    }
    public static double wallSizeRectangle(double h, double l){
        double size = h*l;                                                                      //Height multiplied by Length
        return size;
    }
    public static double wallSizeCircle(double h, double l){
        double size;                                                                     //Height multiplied by Length
        return size;
    }public static double wallSizeTriangle(double h, double l){
        double size;                                                                     //Height multiplied by Length
        return size;
    }


}