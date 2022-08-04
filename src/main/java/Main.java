import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int needsPainting = 0;
    static int dontPaint = 0;
    static int wallCounter = 1;
    static Dulux d;
    static Johnstones j;
    static Mylands m;
    static CrownPaints c;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);       //New Scanner
        System.out.println("How many walls are you painting?");
        int numWalls = scn.nextInt();
        if(numWalls>0){
            System.out.println("Are there any walls that are not rectangular?");
            if(inputCheck(scn).equals("Y")) {
                diffShape(scn, numWalls);
            }
            else{
                rectangle(numWalls, scn);
            }

            System.out.println("How many coats are you applying?");
            int coats = scn.nextInt();

            System.out.println("Are there any doors/windows/sockets/obstructions?");
            if(inputCheck(scn).equals("Y")){
                System.out.println("How many obstructions (doors/windows/sockets) are there?");
                int obstructions = scn.nextInt();
                for(int i = 0; i<obstructions; i++){
                    System.out.println("What is the height of obstruction "+(i+1)+" in meters?");
                    double heightObst = scn.nextDouble();
                    System.out.println("What is the Length of obstruction "+(i+1)+" in meters?");
                    double lengthObst = scn.nextDouble();
                    Rectangle obstr = new Rectangle(heightObst, lengthObst);
                    dontPaint += obstr.area();
                }
            };

            System.out.println("What brand of paint are you using?\n" +
                    "-----------------\n" +
                    "1: Dulux\n" +
                    "2: Johnstones\n" +
                    "3: Mylands\n" +
                    "4: Crown Paints\n" +
                    "-----------------\n" +
                    "Note: Enter the number associated with the brand.");

            boolean bool = false;
            String brand = "";
            while (bool != true) {
                switch (scn.nextInt()) {
                    case 1:
                        brand = "Dulux";
                        d = new Dulux(new double[]{2.5, 5, 10}, new double[]{20, 32, 50});                       //https://www.diy.com/search?term=dulux+emulsion+paint
                        bool = true;
                        break;
                    case 2:
                        brand = "Johnstones";
                        j = new Johnstones(new double[]{2.5, 5, 10}, new double[]{13, 20, 30});                 //https://www.argos.co.uk/search/johnstones/?clickOrigin=searchbar:search:term:johnstones
                        bool = true;
                        break;
                    case 3:
                        brand = "Mylands";
                    m = new Mylands(new double[]{2.5, 5}, new double[]{55.50, 98});                             //https://www.paint-paper.co.uk/product-category/paint/mylands-paint/mylands-interior-finishes/marble-matt-emulsion/
                        bool = true;
                        break;
                    case 4:
                        brand = "Crown Paints";
                        c = new CrownPaints(new double[]{2.5, 5, 10}, new double[]{16, 21, 32});                //https://www.wickes.co.uk/Crown-Matt-Emulsion-Paint---Brilliant-White---2-5L/p/266741?gclid=CjwKCAjw3K2XBhAzEiwAmmgrAuw4pkbu9HhnMV4ttw65v0pj_t3IS8dqKaOD9VZrZ7DyDW2VaAhJSxoCEacQAvD_BwE&gclsrc=aw.ds
                        bool = true;
                        break;
                    default:
                        System.out.println("Please use the numbers associated with the brands.");
                }
            }
            System.out.println("Area to paint: "+ (needsPainting - dontPaint) +" square meters");
            System.out.println("Litres: "+ (needsPainting - dontPaint)/12D);
            System.out.println("The cheapest option would be: ");
        }
        else{
            System.out.println("You don't need any paint.");
        }
    }

    public static String inputCheck(Scanner scn){
        boolean bool = false;
        String result = "";
        while(bool==false){
            result = scn.nextLine();
            switch(result.toUpperCase()) {
                case "Y", "N":
                    bool = true;
                    break;
                default:
                    System.out.println("Please use the inputs: (Y/N)");
            }
        }
        return result.toUpperCase();
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
        wallCounter += numWallsDiff;
        for (int i = 0; i < numWallsDiff; i++) {
            if (wallShape.equals("Circle")) {
                System.out.println("What is the diameter of wall " + (i + 1) + " in meters?");
                Circle c = new Circle(scn.nextDouble());
                needsPainting += c.area();
            } else {
                System.out.println("What is the height of wall " + (i + 1) + " in meters?");
                double heightWall = scn.nextDouble();
                System.out.println("What is the Length of wall " + (i + 1) + " in meters?");
                double lengthWall = scn.nextDouble();
                Triangle t = new Triangle(heightWall, lengthWall);
                needsPainting += t.area();
            }
        }
        System.out.println("Are there anymore walls that are not rectangular?");
        if (inputCheck(scn).equals("Y")) {
            diffShape(scn, numWalls);
        } else {
            rectangle(numWalls, scn);
        }
    }
    public static void rectangle(int numWalls, Scanner scn){
        for(int i = 0; i<numWalls; i++){
            System.out.println("What is the height of wall "+(i+1)+" in meters?");
            double heightWall = scn.nextDouble();
            System.out.println("What is the length of wall "+(i+1)+" in meters?");
            double lengthWall = scn.nextDouble();
            Rectangle r = new Rectangle(heightWall, lengthWall);
            needsPainting += r.area();
        }
    }
}