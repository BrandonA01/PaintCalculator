public class Circle extends Shape{
    private double radius;

    public Circle(double diameter){
        this.radius = diameter/2;
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }
}