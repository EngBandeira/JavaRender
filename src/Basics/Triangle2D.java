package Basics;

import java.awt.*;

public class Triangle2D {
    public Point2D p1;
    public Point2D p2;
    public Point2D p3;
    public Color color;
    public Triangle2D(Point2D P1, Point2D P2, Point2D P3, Color Color)
    {
        p1 = P1;
        p2 = P2;
        p3 = P3;
        color = Color;
    }
    public Point2D getP1(){
        return p1;
    }
    public Point2D getP2(){
        return p2;
    }
    public Point2D getP3(){
        return p3;
    }
    public Color getColor(){
        return color;
    }
}
