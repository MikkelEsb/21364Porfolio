public abstract class Shape {
    ShapeType type;
    Point2D center;

    Shape(int x, int y,ShapeType shapeType){
        this.type=shapeType;
        center=new Point2D(x,y);
    }
    Shape(Point2D centerPoint,ShapeType shapeType){
        this.center=centerPoint;
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
}
