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
    abstract void rotate(double radians);
    abstract void translate(double deltaX, double deltaY);

    abstract double getMinX();
    abstract double getMaxX();
    abstract double getMinY();
    abstract double getMaxY();
    Point2D rotateAroundPoint(double rad,Point2D origin,Point2D point){
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double relX = point.getX()-origin.getX();
        double relY = point.getX()-origin.getY();
        double newX = relX*cos - relY*sin + origin.getX();
        double newY = relX*sin + relY*cos + origin.getY();
        return new Point2D(newX,newY);
    }

}
