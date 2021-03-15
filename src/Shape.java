public abstract class Shape {
    ShapeType type;
    Point2D center;

    Shape(double x, double y,ShapeType shapeType){
        this.type=shapeType;
        center=new Point2D(x,y);
    }
    Shape(Point2D centerPoint,ShapeType shapeType){
        this.type=shapeType;
        this.center=centerPoint;
    }
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

    abstract double getMinX();
    abstract double getMaxX();
    abstract double getMinY();
    abstract double getMaxY();
    abstract boolean possibleIntersection(Shape otherShape);

    /**
     * @param rad Amount of radians to rotate point
     * @param origin The pivot that the point gets rotated around
     * @param point The point that should get rotated
     * @return A new Point2D with the coordinates for the rotated point
     */
    Point2D rotateAroundPoint(double rad,Point2D origin,Point2D point){
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double relX = point.getX()-origin.getX();
        double relY = point.getY()-origin.getY();
        double newX = relX*cos - relY*sin + origin.getX();
        double newY = relX*sin + relY*cos + origin.getY();
        //System.out.println("cos: " + cos + ", sin: " + sin + "\nNew point at: (" + newX + ","+newY+")");
        return new Point2D(newX,newY);
    }

}
