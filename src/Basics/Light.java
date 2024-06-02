package Basics;

import java.awt.*;

public abstract class Light {
    public static class Integer extends Light{
        int[] point;
        int color;
        float Intence;
        public Integer(int[] point_,int Color_, float Intence_)
        {
            point = point_;
            color = Color_;
            Intence = Intence_;
        }
        public int[] getPoint(){return point;}
        public int getColor(){return color;}
        public float getIntence(){return Intence;}
    }
    public static class Normal extends Light{
        Point3D point;
        Color color;
        float Intence;
        public Normal(Point3D Point,Color Color_, float Intence_)
        {
            point = Point;
            color = Color_;
            Intence = Intence_;
        }
        public Point3D getPoint(){return point;}
        public Color getColor(){return color;}
        public float getIntence(){return Intence;}

    }
}
