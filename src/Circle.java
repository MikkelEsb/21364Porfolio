public class Circle extends Shape{
    private double radius;
    Circle(int x, int y, double radius) {
        super(x, y,ShapeType.CIRCLE);
        this.radius=radius;
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference(){
        return 2*Math.PI*radius;
    }
    public boolean isPointInCircle(Point2D point){
        return point.distanceToPoint(this.getCenter())<=this.radius;
    }
}
