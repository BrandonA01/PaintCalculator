import java.util.Scanner;

public class Main {
    static int needsPainting = 0;
    static int dontPaint = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);                                                   //New Scanner
        System.out.println("How many walls are you painting?");                         //need to ask whether they are all rectangular.
        int numWalls = scn.nextInt();
        if(numWalls>0){
            System.out.println("Are there any walls that are not rectangular?   (Y/N)");
            if(inputCheck(scn.next()).equals("Y")) {
                diffShape(scn);
                System.out.println("How many walls are this shape?");
                if(scn.nextInt() > numWalls){
                    System.out.println("You aren't painting that many walls.");
                }
                else{

                }
            }
            else{
                for(int i = 0; i<numWalls; i++){
                    System.out.println("What is the height of wall "+(i+1)+" in meters?");
                    int heightObst = scn.nextInt();
                    System.out.println("What is the Length of wall "+(i+1)+" in meters?");
                    int lengthObst = scn.nextInt();
                    Rectangle recWall = new Rectangle(heightObst, lengthObst);
                    needsPainting += recWall.area();
                }
            }













            System.out.println("How many coats are you applying?");
            int coats = scn.nextInt();
            System.out.println("Are there any doors/windows/sockets/obstructions?   (Y/N)");
            if(inputCheck(scn.next()).equals("Y")){
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
            System.out.println("Amount Needed to paint: "+ needsPainting +" square meters");
        }
        else{
            System.out.println("You do not need any paint.");
        }
    }

    public static String inputCheck(String scn){
        boolean bool = false;
        while(bool!=true){
            switch(scn.toUpperCase()) {
                case "Y", "N":
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the inputs: (Y/N)");
            }
        }
        return scn.toUpperCase();
    }
    public static void diffShape(Scanner scn){
        System.out.println("Which shape from the selection is the wall:\n1: Circle\n2: Triangle\nNote: Enter the number associated with the shape.");
        boolean bool = false;
        while(bool!=true){
            switch(scn.nextInt()) {
                case 1:
                    //Circle
                    bool = true;
                    break;
                case 2:
                    //Triangle
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the numbers associated with the shapes.");
            }
        }
    }
}