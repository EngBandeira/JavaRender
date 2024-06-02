package Basics;

public class Raycast3D
{
    public Point3D InitialPoint;
    public Point3D CollisionPoint;
    public Object3D CollisionObject;
    public float z;
    public Raycast3D(Point3D InitialPoint_,Point3D CollisionPoint_, Object3D CollisionObject_){
        InitialPoint = InitialPoint_;
        CollisionPoint = CollisionPoint_;
        CollisionObject = CollisionObject_;
    }
    public Point3D getInitialPoint(){
        return InitialPoint;
    }
    public Point3D getCollisionPoint(){
        return CollisionPoint;
    }
    public Object3D getCollisionObject(){
        return CollisionObject;
    }
}
