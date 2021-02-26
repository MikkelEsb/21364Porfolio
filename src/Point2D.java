// Point for storing 2D points
public class Point2D {
    private double x;
    private double y;
    Point2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    //Calculate the euclidian distance to another 2D point
    double distanceToPoint(Point2D other){
        return Math.sqrt(Math.pow(other.getX()-this.getX(),2)+Math.pow((other.getY()-this.getY()),2));
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
