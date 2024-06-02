package Basics;

import Function.BasicMovement;
import Renderization.ShaderPhong;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tests {

    public static void main(String[] args){

        //RotationTest();
        //Color  a = new Color(252.0f, 137.0f, 45.0f);
        Point3D p = MathFunction.VetorNormalizator(new Point3D(0,10000,0));
        System.out.println(p.getX() + " , " + p.getY() + " , " + p.getZ());
        //System.out.println(MathFunction.VetorModule(new Point3D(0,10000,0)));
    }
    public static void RotationTest(){
        Object3D objZ = new Object3D("ObjZ",new Point3D[]{ new Point3D(-0.5f,-0.29f,0), new Point3D(0.5f,-0.29f,0), new Point3D(0,0.57f,0)}, new Point3D(0,0,0),null);

        Face3D face = new Face3D(new Point3D[]{ new Point3D(0,-0.29f,-0.5f), new Point3D(0,-0.29f,0.5f), new Point3D(0,0.57f,0)}, null,null,new int[]{1,2,3} , null);
        Object3D objX = new Object3D("ObjX",new Point3D[]{ new Point3D(0,-0.29f,-0.5f), new Point3D(0,-0.29f,0.5f), new Point3D(0,0.57f,0)},  new Point3D(0,0,0), new Face3D[]{face});
        Object3D object3D = BasicMovement.Rotation.Rotate(objX,Axies.X_Axie,30);
        object3D = BasicMovement.Rotation.Rotate(object3D,Axies.X_Axie,30);
        object3D = BasicMovement.Rotation.Rotate(object3D,Axies.X_Axie,30);
        object3D = BasicMovement.Rotation.Rotate(object3D,Axies.X_Axie,30);
        System.out.println(object3D.Points3DS[0].getX() + "," + object3D.Points3DS[0].getY() + "," + object3D.Points3DS[0].getZ());
        System.out.println(object3D.Points3DS[1].getX() + "," + object3D.Points3DS[1].getY() + "," + object3D.Points3DS[1].getZ());
        System.out.println(object3D.Points3DS[2].getX() + "," + object3D.Points3DS[2].getY() + "," + object3D.Points3DS[2].getZ());

    }
}
