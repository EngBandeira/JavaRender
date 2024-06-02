package Basics;

import Points.PointsController;
import Renderization.RenderController;

import java.io.File;
import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;

//Array ints = {3,7,2,4,8,5}
// First = 3,7,2; Second = 4,8,5
class Task_ extends TimerTask {

    @Override
    public void run() {
        new RenderController(false);

    }

}

public class Start {
    public static final Point3D InitialCamPosition = new Point3D(0, 0, 2);
    public static Point3D CamPosition;
    public static final float FOV = 1;
    public static ArrayList<File> RawObjects = new ArrayList<>();
    public static ArrayList<Object3D> Objects = new ArrayList<>();
    public static ArrayList<Light.Integer> LightsINTs = new ArrayList<>();
    public static ArrayList<Light.Normal> Lights = new ArrayList<>();

    public static final float DiffuseFator = 10f;
    public final static float Version = 1.2f;

    public static void main(String[] args) {
        CamPosition = InitialCamPosition;
        RawObjects.add(new File("tche" +
                ".obj"));
        Light.Integer light1 = new Light.Integer(new int[]{0, 0, 3}, 13117460, 0.25f);
        LightsINTs.add(light1);
        new PointsController();
    }

    public static void Iniciar() {

        new RenderController(true);

        Timer timer = new Timer();
        TimerTask tassk = new Task_();
        timer.schedule(tassk, 50, 50);

    }
}

