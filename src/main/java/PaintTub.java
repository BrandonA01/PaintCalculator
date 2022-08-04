public abstract class PaintTub {
    private double[] litres;

    private double[] price;

    public PaintTub(double[] litres, double[] price){
        this.litres = litres;
        this.price = price;
    }

    public double[] getLitres() {
        return litres;
    }

    public void setLitres(double[] litres) {
        this.litres = litres;
    }

    public double[] getPrice() {
        return price;
    }

    public void setPrice(double[] price) {
        this.price = price;
    }
}
