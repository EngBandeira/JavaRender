package Renderization;

import Basics.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ShaderPhong {
    public static Color FunctionOFPhong(Face3D face3D) {
        ArrayList<Light.Normal> lights = Start.Lights;
        Point3D cam = Start.CamPosition;
        Point3D VetorNormal = MathFunction.VetorNormalizator(MathFunction.VetorMultiply(MathFunction.PointOperate(face3D.getPoints()[0], face3D.getPoints()[1], false), MathFunction.PointOperate(face3D.getPoints()[0], face3D.getPoints()[2], false)));
        float x = 0;
        float y = 0;
        float z = 0;

        for (Point3D p : face3D.getPoints()) {
            x += p.getX();
            y += p.getY();
            z += p.getZ();
        }
        Point3D point3D = new Point3D(x / face3D.getPoints().length, y / face3D.getPoints().length, z / face3D.getPoints().length);
        float DiffuseIntence = 0;
        float AmbientIntence = 0;

        Point3D VetorCam = MathFunction.VetorNormalizator(MathFunction.PointOperate(point3D, cam, false));
        for (Light.Normal light : lights) {
            AmbientIntence += light.getIntence();
            System.out.println(light.getPoint().getX() + " , " + point3D.getY() + " , " + point3D.getZ());
            Point3D Lm = MathFunction.VetorNormalizator(MathFunction.PointOperate(point3D, light.getPoint(), false));

            float difu = (light.getIntence() / MathFunction.VetorModule(MathFunction.PointOperate(point3D, light.getPoint(), false))) * MathFunction.ScalarProduct(Lm, VetorNormal);

            DiffuseIntence += difu;
        }

        Color FinalDiffuse = Iluminate(face3D.getMaterial().getKd(), DiffuseIntence * Start.DiffuseFator);
        Color FinalAmbient = Iluminate(face3D.getMaterial().getKa(), AmbientIntence);
        Color Final = ColorSum(FinalDiffuse, FinalAmbient);
        return Final;
    }

    public static Color ColorSum(Color color1, Color color2) {
        int R = color1.getRed() + color2.getRed();
        int G = color1.getGreen() + color2.getGreen();
        int B = color1.getBlue() + color2.getBlue();
        if (R > 255) {
            R = 255;
        } else if (R <= 0) {
            R = 0;
        }

        if (G > 255) {
            G = 255;
        } else if (G > 255) {
            G = 0;
        }

        if (B > 255) {
            B = 255;
        } else if (B > 255) {
            B = 0;
        }
        return new Color(R, G, B);
    }


    public static Color Iluminate(Color colorRGB, float fator) {
        float[] fators = new float[]{colorRGB.getRed(), colorRGB.getGreen(), colorRGB.getBlue()};
        double[] fatorsMAXs = new double[]{255 / fators[0], 255 / fators[1], 255 / fators[2]};

        if (fatorsMAXs[0] >= fator && fator >= 0) {
            return new Color((int) Math.floor(colorRGB.getRed() * fator), (int) Math.floor(colorRGB.getGreen() * fator), (int) Math.floor(colorRGB.getBlue() * fator));
        } else if (fatorsMAXs[0] <= fator && fator >= 0) {
            return new Color((int) Math.floor(colorRGB.getRed() * fatorsMAXs[0]), (int) Math.floor(colorRGB.getGreen() * fatorsMAXs[0]), (int) Math.floor(colorRGB.getBlue() * fatorsMAXs[0]));
        } else if (fator < 0) {
            return new Color(0, 0, 0);
        } else {
            return new Color(0, 0, 0);
        }
    }
}

