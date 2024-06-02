package Basics;

import java.awt.*;

public class Triangle3D {
    public Point3D p1;
    public Point3D p2;
    public Point3D p3;
    public Color color;
    public Triangle3D(Point3D P1, Point3D P2, Point3D P3,Color Color)
    {
        p1 = P1;
        p2 = P2;
        p3 = P3;
        color = Color;
    }
    public Point3D getP1(){
        return p1;
    }
    public Point3D getP2(){
        return p2;
    }
    public Point3D getP3(){
        return p3;
    }
    public Color getColor(){
        return color;
    }
}
