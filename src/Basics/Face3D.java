package Basics;

public class Face3D
{
    public Point3D[] Points;
    public Point2D[] TPoints;
    public Point3D NPoints;
    public int[] PointsInts;
    public Material material;
    public Face3D(Point3D[] Points_,Point2D[] TPoints_,Point3D NPoints_, int[] PointsInts_, Material material_)
    {
        Points = Points_;
        TPoints = TPoints_;
        NPoints = NPoints_;
        PointsInts = PointsInts_;
        material = material_;
    }

    public Point3D[] getPoints(){
        return Points;
    }
    public Point2D[] getTexturePoints(){
        return TPoints;
    }
    public Point3D getNormalPoints(){
        return NPoints;
    }
    public int[] getPointsInts(){return PointsInts;}
    public Material getMaterial(){return material;}
}