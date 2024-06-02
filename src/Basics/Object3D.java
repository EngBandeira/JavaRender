package Basics;

public class Object3D
{
    public String Name;
    public Point3D[] Points3DS;
    public Point3D CentralPoint;
    public Face3D[] Faces;

    public Object3D(String Name_, Point3D[] Points3Ds, Point3D CentralPoint_, Face3D[] Faces_)
    {
        Name = Name_;
        Points3DS = Points3Ds;
        CentralPoint = CentralPoint_;
        Faces = Faces_;
    }
    public String getName(){return Name;}
    public Point3D[] getPoints3DS(){
        return Points3DS;
    }
    public Point3D getCentralPoint(){
        return CentralPoint;
    }
    public Face3D[] getFaces3DS(){return Faces;}

}
