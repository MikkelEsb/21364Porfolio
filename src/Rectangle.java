public class Rectangle extends Shape{
    //We can define a rectangle by two opposite points.
    Point2D cornerA,cornerB;
    //For rotation we will rotate the shape around it's center but save the rotation done for containsPoint calculation
    double rotation=0d;

    /**
     * @param pointA One corner of the rectangle
     * @param pointB Opposite corner of the rectangle
     */
    Rectangle(Point2D pointA, Point2D pointB) {
        super(ShapeType.RECTANGLE);
        this.setCenter(calculateCenter());
        cornerA=pointA;
        cornerB=pointB;
    }
    private Point2D calculateCenter(){
        return new Point2D((cornerA.getX()+cornerB.getX())/2,(cornerA.getY()+cornerB.getY())/2);
    }
    double getArea(){
        return Math.abs(cornerA.getX()-cornerB.getX())*Math.abs(cornerA.getY()-cornerB.getY());
    }
    double getPerimeter(){
        return Math.abs(cornerA.getX()-cornerB.getX())*2+Math.abs(cornerA.getY()-cornerB.getY())*2;
    }

    @Override
    boolean containsPoint(Point2D p) {
        Point2D tempPoint=p;
        if (rotation!=0){//Rotate point around center
            tempPoint=p.getRotatedPoint(-rotation,this.getCenter());
        }
        //tempPoint.getX()>=this.getMinX() && tempPoint.getX() <=

        return tempPoint.getX() >= this.getMinX() && tempPoint.getX() <= this.getMaxX() && tempPoint.getY() >= this.getMinY() && tempPoint.getY() <= this.getMaxY();
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
