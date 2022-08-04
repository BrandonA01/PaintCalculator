public class Triangle extends Shape{
    private final double height, length;

    public Triangle(double height, double length){
        this.height = height;
        this.length = length;
    }
    @Override
    public double area() {
        return (height*length)/2;
    }
}
