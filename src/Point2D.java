// Point for storing 2D points
public class Point2D {
    private double x;
    private double y;
    Point2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    /**
     * @param other The other point to check the distance to
     * @return the distance as a double.
     */
    //Calculate the euclidean distance to another 2D point
    double distanceToPoint(Point2D other){
        return Math.sqrt(Math.pow(other.getX()-this.getX(),2)+Math.pow((other.getY()-this.getY()),2));
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    void translate(double dX,double dY){
        this.x+=dX;
        this.y+=dY;
    }
    void rotate(double rad,Point2D origin){
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double relX = this.getX()-origin.getX();
        double relY = this.getY()-origin.getY();
        this.x = relX*cos - relY*sin + origin.getX();
        this.y = relX*sin + relY*cos + origin.getY();
    }
    /**
     * @param rad Amount of radians to rotate point
     * @param origin The pivot that the point gets rotated around
     * @return A new Point2D with the coordinates for the rotated point
     */
    Point2D getRotatedPoint(double rad, Point2D origin){
        Point2D temp = new Point2D(this.x,this.y);
        temp.rotate(rad,origin);
        return temp;
    }


    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
