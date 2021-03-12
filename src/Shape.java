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
    abstract double getArea();
    abstract double getPerimeter();
    abstract boolean containsPoint(Point2D p);

    /* Future methods
    void translateShape(double deltaX,double deltaY){

    }
    void rotateShape(double radians){

    }*/
}
