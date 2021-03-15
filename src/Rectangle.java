public class Rectangle extends Shape{
    //We can define a rectangle by two opposite points.
    Point2D cornerA,cornerB;

    /**
     * @param pointA One corner of the rectangle
     * @param pointB Opposite corner of the rectangle
     */
    Rectangle(Point2D pointA, Point2D pointB) {
        super(new Point2D((pointA.getX()+pointB.getX())/2,(pointA.getY()+pointB.getY())/2), ShapeType.RECTANGLE);
        cornerA=pointA;
        cornerB=pointB;
    }
    double getArea(){
        return Math.abs(cornerA.getX()-cornerB.getX())*Math.abs(cornerA.getY()-cornerB.getY());
    }
    double getPerimeter(){
        return Math.abs(cornerA.getX()-cornerB.getX())*2+Math.abs(cornerA.getY()-cornerB.getY())*2;
    }

    @Override
    boolean containsPoint(Point2D p) {
        return false;
    }


    /**
     * @param radians amount of radians to rotate the square around it's center
     */
    @Override
    void rotate(double radians){

    }

    void translate(double deltaX, double deltaY){

    }

    double getMinX() {
        return 0;
    }

    double getMaxX() {
        return 0;
    }

    double getMinY() {
        return 0;
    }

    double getMaxY() {
        return 0;
    }

    @Override
    boolean possibleIntersection(Shape otherShape) {
        return false;
    }
}
