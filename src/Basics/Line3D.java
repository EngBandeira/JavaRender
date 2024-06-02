package Basics;

public class Line3D {
    public Point3D p1;
    public Point3D p2;
    public Line3D(Point3D P1, Point3D P2)
    {
        p1 = P1;
        p2 = P2;
    }
    public Point3D getP1(){
        return p1;
    }
    public Point3D getP2(){
        return p2;
    }
}
