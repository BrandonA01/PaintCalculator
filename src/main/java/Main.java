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
                diffShape(scn, numWalls);
            }
            else{
                rectangle(numWalls, scn);
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
            System.out.println("Area to paint: "+ (needsPainting - dontPaint) +" square meters");
        }
        else{
            System.out.println("You don't need any paint.");
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
    public static void diffShape(Scanner scn, int numWalls) {
        System.out.println("Which shape from the selection is the wall:\n1: Circle\n2: Triangle\nNote: Enter the number associated with the shape.");
        boolean bool = false;
        String wallShape = "";
        while (bool != true) {
            switch (scn.nextInt()) {
                case 1:
                    wallShape = "Circle";
                    bool = true;
                    break;
                case 2:
                    wallShape = "Triangle";
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the numbers associated with the shapes.");
            }
        }
        int numWallsDiff;
        while (5 > 1) {
            System.out.println("How many walls are this shape?");
            numWallsDiff = scn.nextInt();
            if (numWallsDiff > numWalls) {
                System.out.println("You aren't painting that many walls.");
            } else {
                break;
            }
        }
        numWalls -= numWallsDiff;
        for (int i = 0; i < numWallsDiff; i++) {
            if (wallShape.equals("Circle")) {
                System.out.println("What is the diameter of wall " + (i + 1) + " in meters?");
                Circle c = new Circle(scn.nextInt());
                needsPainting += c.area();
            } else {
                System.out.println("What is the height of wall " + (i + 1) + " in meters?");
                int heightWall = scn.nextInt();
                System.out.println("What is the Length of wall " + (i + 1) + " in meters?");
                int lengthWall = scn.nextInt();
                Triangle t = new Triangle(heightWall, lengthWall);
                needsPainting += t.area();
            }
        }
        System.out.println("Are there anymore walls that are not rectangular?   (Y/N)");
        if (inputCheck(scn.next()).equals("Y")) {
            diffShape(scn, numWalls);
        } else {
            rectangle(numWalls, scn);
        }
    }
    public static void rectangle(int numWalls, Scanner scn){
        for(int i = 0; i<numWalls; i++){
            System.out.println("What is the height of wall "+(i+1)+" in meters?");
            int heightWall = scn.nextInt();
            System.out.println("What is the Length of wall "+(i+1)+" in meters?");
            int lengthWall = scn.nextInt();
            Rectangle r = new Rectangle(heightWall, lengthWall);
            needsPainting += r.area();
        }
    }
}