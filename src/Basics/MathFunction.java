package Basics;


public class MathFunction {
    public static Point3D EscalarOperatiosV_P(Point3D v1, float escalar, boolean Multiply) {
        if (Multiply) {
            return new Point3D(v1.getX() * escalar, v1.getY() * escalar, v1.getZ() * escalar);
        } else {
            return new Point3D(v1.getX() / escalar, v1.getY() * escalar, v1.getZ() * escalar);
        }
    }

    public static float ScalarProduct(Point3D v1, Point3D v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
    }

    public static Point3D PointOperate(Point3D p1, Point3D p2, boolean Sum) {
        if (Sum) {
            return new Point3D(p1.getX() + p2.getX(), p1.getY() + p2.getY(), p1.getZ() + p2.getZ());
        } else {
            return new Point3D(p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ());
        }
    }

    public static Point3D VetorMultiply(Point3D v1, Point3D v2) {
        float i = v1.getY() * v2.getZ() - v2.getY() * v1.getZ();
        float j = -1 * (v1.getX() * v2.getZ() - v2.getX() * v1.getZ());
        float k = v1.getX() * v2.getY() - v2.getX() * v1.getY();
        return new Point3D(i, j, k);
    }

    public static float VetorModule(Point3D v1) {
        return (float) Math.sqrt(v1.getX() * v1.getX() + v1.getY() * v1.getY() + v1.getZ() * v1.getZ());
    }

    public static Point3D VetorNormalizator(Point3D v1) {
        float vm = VetorModule(v1);
        return new Point3D(v1.getX() / vm, v1.getY() / vm, v1.getZ() / vm);
    }

}
