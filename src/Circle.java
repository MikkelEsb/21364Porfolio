public class Circle extends Shape{
    private double radius;

    /**
     * @param x X coordinate for the center of the circle
     * @param y Y coordinate for the center of the circle
     * @param radius Radius of the circle
     */
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

    double getMinX() {
        return this.getCenter().getX()-radius;
    }

    double getMaxX() {
        return this.getCenter().getX()+radius;
    }


    double getMinY() {
        return this.getCenter().getY()-radius;
    }
    double getMaxY() {
        return this.getCenter().getY()+radius;
    }

    boolean possibleIntersection(Shape otherShape) {

        return false;
    }

}
