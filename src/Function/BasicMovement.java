package Function;

import Basics.*;

public abstract class BasicMovement {
    public class TranslatoryFunction extends BasicMovement {
        public static Object3D Sum(Object3D object3D, Point3D value) {
            Point3D[] InicialPoints = object3D.getPoints3DS();
            Point3D[] FinalPoints = new Point3D[InicialPoints.length];
            for (int i = 0; i < InicialPoints.length; i++) {
                FinalPoints[i] = new Point3D(InicialPoints[i].getX() + value.getX() + i * 0.0002f, InicialPoints[i].getY() + value.getY() + i * 0.0003f, InicialPoints[i].getZ() + value.getZ() + i * 0.0004f);
            }
            Face3D[] InitialFaces = object3D.getFaces3DS();

            Face3D[] FinalFaces = new Face3D[InitialFaces.length];
            for (int i = 0; i < InitialFaces.length; i++) {
                Point3D[] pts = new Point3D[InitialFaces[i].getPointsInts().length];
                for (int h = 0; h < InitialFaces[i].getPointsInts().length; h++) {
                    pts[h] = InitialFaces[i].getPoints()[InitialFaces[i].getPointsInts()[h]];
                }
                FinalFaces[i] = new Face3D(FinalPoints, InitialFaces[i].getTexturePoints(), InitialFaces[i].getNormalPoints(), InitialFaces[i].getPointsInts(), InitialFaces[i].getMaterial());
            }
            Point3D centrapt = new Point3D(object3D.CentralPoint.getX() + value.getX(), object3D.CentralPoint.getY() + value.getY(), object3D.CentralPoint.getZ() + value.getZ());
            return new Object3D(object3D.getName(), FinalPoints, centrapt, FinalFaces);
        }
    }

    public class Rotation extends BasicMovement {
        public static Object3D Rotate(Object3D object3D, Axies axie, int angle) {
            Point3D[] InicialPoints = object3D.getPoints3DS();
            Face3D[] InicialFaces = object3D.getFaces3DS();
            Point3D[] FinalPoints = new Point3D[InicialPoints.length];
            Face3D[] FinalFaces = new Face3D[InicialFaces.length];
            if (axie == Axies.X_Axie) {
                for (int i = 0; i < InicialPoints.length; i++) {
                    Point3D pt = rotateX(InicialPoints[i], object3D.CentralPoint, angle);
                    FinalPoints[i] = pt;
                }
            }
            if (axie == Axies.Y_Axie) {
                for (int i = 0; i < InicialPoints.length; i++) {
                    Point3D pt = rotateY(InicialPoints[i], object3D.CentralPoint, angle);
                    FinalPoints[i] = pt;
                }

            }
            if (axie == Axies.Z_Axie) {
                for (int i = 0; i < InicialPoints.length; i++) {
                    Point3D pt = rotateZ(InicialPoints[i], object3D.CentralPoint, angle);
                    FinalPoints[i] = pt;
                }

            }
            for (int i = 0; i < InicialFaces.length; i++) {
                Point3D[] pts = new Point3D[InicialFaces[i].getPoints().length];
                for (int c = 0; c < InicialFaces[i].getPoints().length; c++) {
                    pts[c] = FinalPoints[InicialFaces[i].getPointsInts()[c] - 1];

                }
                FinalFaces[i] = new Face3D(pts, InicialFaces[i].getTexturePoints(), InicialFaces[i].getNormalPoints(), InicialFaces[i].getPointsInts(), InicialFaces[i].getMaterial());
            }
            return new Object3D(object3D.getName(), FinalPoints, object3D.CentralPoint, FinalFaces);
        }

        public static Point3D rotateX(Point3D InicialPoint, Point3D CentralP, float Angle) {

            double angle = Math.toRadians(Angle);
            float y = InicialPoint.getY() - CentralP.getY();
            float z = InicialPoint.getZ() - CentralP.getZ();
            float Y_ = (float) ((y * Math.cos(angle)) - (z * Math.sin(angle)));
            float Z_ = (float) ((y * Math.sin(angle)) + (z * Math.cos(angle)));
            return new Point3D((float) (Math.round(InicialPoint.getX() * 10000.0) / 10000.0), (float) (Math.round(Y_ * 10000.0) / 10000.0), (float) (Math.round(Z_ * 10000.0) / 10000.0));
        }

        public static Point3D rotateY(Point3D InicialPoint, Point3D CentralP, float Angle) {

            double angle = Math.toRadians(Angle);
            float x = InicialPoint.getX() - CentralP.getX();
            float z = InicialPoint.getZ() - CentralP.getZ();
            float X_ = (float) ((x * Math.cos(angle) + z * Math.sin(angle)));
            float Z_ = (float) ((z * Math.cos(angle)) - (x * Math.sin(angle)));
            return new Point3D((float) (Math.round(X_ * 10000.0) / 10000.0), (float) (Math.round(InicialPoint.getY() * 10000.0) / 10000.0), (float) (Math.round(Z_ * 10000.0) / 10000.0));
        }

        public static Point3D rotateZ(Point3D InicialPoint, Point3D CentralP, float Angle) {

            double angle = Math.toRadians(Angle);
            float x = InicialPoint.getX() - CentralP.getX();
            float y = InicialPoint.getY() - CentralP.getY();
            double X_ = ((x * Math.cos(angle)) - (y * Math.sin(angle)));
            double Y_ = ((y * Math.cos(angle)) + (x * Math.sin(angle)));
            return new Point3D((float) (Math.round(X_ * 10000.0) / 10000.0), (float) (Math.round(Y_ * 10000.0) / 10000.0), (float) (Math.round(InicialPoint.getZ() * 10000.0) / 10000.0));
        }
    }
}
