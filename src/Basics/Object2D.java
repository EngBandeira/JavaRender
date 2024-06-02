package Basics;

import java.awt.*;

public class Object2D {
    public Point2D[] points2DS;
    public Color[] colorRGBS;
    public Polygon[] faces2DS;
    public Object2D(Point2D[] points2DS_ , Color[] colorRGBS_, Polygon[] faces2DS_){
        points2DS = points2DS_;
        colorRGBS = colorRGBS_;
        faces2DS = faces2DS_;
    }
    public Color[] getColorRGBS(){return colorRGBS;}
    public Point2D[] getPoints2DS(){return  points2DS;}
    public Polygon[] getFaces2DS(){return  faces2DS;}


}
