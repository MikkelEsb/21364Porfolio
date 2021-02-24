// Point for storing 2D points
public class Point2D {
    private int x;
    private int y;
    Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    //Calculate the euclidian distance to another 2D point
    double distanceToPoint(Point2D other){
        return Math.sqrt((other.getX()-this.getX())^2+(other.getY()-this.y)^2);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
