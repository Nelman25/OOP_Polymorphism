public class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return height * base /2;
    }
}