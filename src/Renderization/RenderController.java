package Renderization;

import Basics.*;
import Window.WindowController;

import java.awt.*;
import java.util.ArrayList;

public class RenderController {
    public static float CR;
    public static ArrayList<Object2D> object2DS = new ArrayList<>();
    public static Dimension WindowSize = new Dimension(1920, 1080);

    public RenderController(boolean Inicialize_) {
        object2DS.clear();
        ArrayList<Object3D> Objects3DS = Start.Objects;
        for (Object3D object3D : Objects3DS) {

            //System.out.println(object3D.getFaces3DS().length);
            Color[] colors = new Color[object3D.getFaces3DS().length];
            Polygon[] polygons = new Polygon[object3D.Faces.length];
            Point2D[] point2DS = new Point2D[object3D.Points3DS.length];
            for (int o = 0; o < object3D.Points3DS.length; o++) {
                Point3D cam = Start.CamPosition;
                Point3D p1 = object3D.Points3DS[o];
                float P1Cr = CR(Math.abs(cam.getZ() - p1.getZ()));

                Point2D p1_ = new Point2D((p1.getX() * P1Cr), (p1.getY()) * P1Cr);
                point2DS[o] = p1_;
            }
            for (int i = 0; i < object3D.Faces.length; i++) {

                int[] intsPT = object3D.Faces[i].PointsInts;
                int[] xxsPts = new int[object3D.Faces[i].getPointsInts().length];
                int[] yysPts = new int[object3D.Faces[i].getPointsInts().length];
                int z = 0;
                for(int o : intsPT){
                    Point2D aa = TransformPR_PT(point2DS[o-1]);
                    xxsPts[z] = Math.round(aa.getX());
                    yysPts[z] = Math.round(aa.getY());
                    z++;
                }
                colors[i] = ShaderPhong.FunctionOFPhong(object3D.Faces[i]);
                polygons[i] = new Polygon(xxsPts,yysPts, object3D.Faces[i].getPointsInts().length);
            }


            object2DS.add(new Object2D(point2DS, colors,polygons));
        }
        new WindowController(Start.Version, 1000, Inicialize_);
    }

    public static Point2D TransformPR_PT(Point2D ponto) {
        double X_ = ((ponto.getX() * 200) + (WindowSize.getWidth() / 2));
        double Y_ = ((ponto.getY() * 200) + (WindowSize.getHeight() / 2));
        float Y = (float) (WindowSize.getHeight() - Y_);
        float X = (float) (WindowSize.getWidth() - X_);
        return new Point2D(X, Y);
    }

    public static float CR(float Z) {
        return Start.FOV / (Start.FOV + Z);
    }
}
