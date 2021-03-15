public abstract class Shape {
    ShapeType type;
    Point2D center;

    Shape(ShapeType shapeType){
        this.type=shapeType;
    }
    void setCenter(Point2D cent){
        center=cent;
    }
    ShapeType getType(){
        return this.type;
    }
    Point2D getCenter(){
        return this.center;
    }
    double getCenterDistance(Shape otherShape){
        return otherShape.center.distanceToPoint(this.center);
    }

    /**
     * @return the area of the shape as a double
     */
    abstract double getArea();

    /**
     * @return gets the perimeter of the shape
     */
    abstract double getPerimeter();

    /**
     * @param p A Point2D to test for
     * @return Boolean value if the point is inside shape
     */
    abstract boolean containsPoint(Point2D p);

    /**
     * @param radians Amount of radians to rotate the shape around it's own center
     */
    abstract void rotate(double radians);

    /**
     * @param deltaX change in X coordinate for the shape
     * @param deltaY change in Y coordinate for the shape
     */
    abstract void translate(double deltaX, double deltaY);



}
