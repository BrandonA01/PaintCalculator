import java.util.Scanner;

public class Main {
    static double litres;
    static double needsPainting = 0;
    static double dontPaint = 0;
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

            litres = ((needsPainting - dontPaint)/12D)*coats;

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
            String cheap = "";
            while (bool != true) {
                switch (scn.nextInt()) {
                    case 1:
                        brand = "Dulux";
                        d = new Dulux(new double[]{2.5, 5, 10}, new double[]{20, 32, 50});                       //https://www.diy.com/search?term=dulux+emulsion+paint
                        cheap = calcCheap(d);
                        bool = true;
                        break;
                    case 2:
                        brand = "Johnstones";
                        j = new Johnstones(new double[]{2.5, 5, 10}, new double[]{13, 20, 30});                 //https://www.argos.co.uk/search/johnstones/?clickOrigin=searchbar:search:term:johnstones
                        cheap = calcCheap(j);
                        bool = true;
                        break;
                    case 3:
                        brand = "Mylands";
                        m = new Mylands(new double[]{2.5, 5}, new double[]{55.50, 98});                             //https://www.paint-paper.co.uk/product-category/paint/mylands-paint/mylands-interior-finishes/marble-matt-emulsion/
                        cheap = calcCheap(m);
                        bool = true;
                        break;
                    case 4:
                        brand = "Crown Paints";
                        c = new CrownPaints(new double[]{2.5, 5, 10}, new double[]{16, 21, 32});                //https://www.wickes.co.uk/Crown-Matt-Emulsion-Paint---Brilliant-White---2-5L/p/266741?gclid=CjwKCAjw3K2XBhAzEiwAmmgrAuw4pkbu9HhnMV4ttw65v0pj_t3IS8dqKaOD9VZrZ7DyDW2VaAhJSxoCEacQAvD_BwE&gclsrc=aw.ds
                        cheap = calcCheap(c);
                        bool = true;
                        break;
                    default:
                        System.out.println("Please use the numbers associated with the brands.");
                }
            }
            System.out.println("Area to paint: "+ (needsPainting - dontPaint) +" square meters");
            System.out.println("Litres needed: "+ litres);                                                             //https://www.google.com/search?q=how+many+litres+of+paint+cover+a+square+metre&oq=how+many+litres+&aqs=chrome.0.69i59j69i57j0i20i263i433i512j0i512j0i433i512j0i20i263i512j0i433i512j0i512l3.3266j0j7&sourceid=chrome&ie=UTF-8
            System.out.println("The cheapest option would be: "+cheap);
        }
        else{
            System.out.println("You don't need any paint.");
        }
    }

    public static String calcCheap(PaintTub p){
        String cheapest = "";
        for(int i = 0; i<p.getLitres().length; i++){
            if(litres<p.getLitres()[i]){
                cheapest = "1x "+p.getLitres()[i]+"L (£"+p.getPrice()[i]+")";
                break;
            }
        }
        if (litres>p.getLitres()[p.getLitres().length-1]){
            int amt = (int) (litres/p.getLitres()[p.getLitres().length-1]);
            cheapest = amt+"x "+p.getLitres()[p.getLitres().length-1]+"L (£"+p.getPrice()[p.getPrice().length-1]*amt+")";
            double rem = litres%p.getLitres()[p.getLitres().length-1];
            for(int i = 0; i<p.getLitres().length; i++){
                if(rem<p.getLitres()[i]){
                    if(p.getLitres()[i]==p.getLitres()[p.getLitres().length-1]){
                        cheapest = (amt+1)+"x "+p.getLitres()[p.getLitres().length-1]+"L (£"+p.getPrice()[p.getPrice().length-1]*(amt+1)+")";
                    }
                    else{
                        cheapest += ", 1x "+p.getLitres()[i]+"L (£"+p.getPrice()[i]+")";
                    }
                    break;
                }
            }

        }
        return cheapest;
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