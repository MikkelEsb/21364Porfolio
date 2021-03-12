public class Circle extends Shape{
    private double radius;
    Circle(double x, double y, double radius) {
        super(x, y,ShapeType.CIRCLE);
        this.radius=radius;
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }



    public double getRadius() {
        return radius;
    }

    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    boolean containsPoint(Point2D point){
        return point.distanceToPoint(this.getCenter())<=this.radius;
    }

    void rotate(double radians){ //Doesn't make sense to rotate a circle ;)

    }
    void translate(double deltaX, double deltaY){

    }
}
