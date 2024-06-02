package Window;

import Basics.*;
import Function.BasicMovement;
import Renderization.RenderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;

import static Renderization.RenderController.*;
import static Window.WindowController.ee;
import static Window.WindowController.window;


public class WindowController {
    public static JFrame window;
    public static JPanel render;
    public static int frame;
    public static JPanel adds;
    public static boolean ee;
    public static final int angle = 60;
    public WindowController(float Version, int Size, boolean Inicialize_) {

        if (!Inicialize_) {
            window.revalidate();
            window.repaint();

        } else {
            window = new JFrame("API: Version: " + Version);
            window.setSize(RenderController.WindowSize);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setLayout(null);
            window.setVisible(true);
            //region Screen
            JPanel screen = new RenderPanel();
            screen.setLayout(null);
            screen.setBackground(Color.GRAY);
            screen.setSize(window.getSize());
            //region Test System

            JPanel adds_ = new JPanel();
            adds_.setLayout(null);
            adds_.setBackground(Color.GRAY);
            adds_.setSize(window.getSize());
            screen.add(adds_);

            adds = adds_;
            //endregion
            window.add(screen);
            render = screen;
            //endregion
        }

    }
}

class RenderPanel extends JPanel {
    public void paint(Graphics g) {
        for (int z = 0; z < RenderController.object2DS.size(); z++) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;

            double[] Keys_ = new double[RenderController.object2DS.get(z).getColorRGBS().length];
            Polygon[] Result_ = new Polygon[RenderController.object2DS.get(z).getColorRGBS().length];
            Color[] Clr_ = new Color[RenderController.object2DS.get(z).getColorRGBS().length];
            for (int f = 0; f < Start.Objects.get(z).getFaces3DS().length; f++) {
                Face3D face3D = Start.Objects.get(z).getFaces3DS()[f];

                Point3D camPT = Start.CamPosition;
                double mediax = 0;
                double mediay = 0;
                double mediaz = 0;
                for(Point3D point3D : face3D.getPoints()){
                    mediax += point3D.getX();
                    mediay += point3D.getY();
                    mediaz += point3D.getZ();
                }
                mediax = mediax/face3D.getPoints().length;
                mediay = mediay/face3D.getPoints().length;
                mediaz = mediaz/face3D.getPoints().length;

                double distanceX = Math.abs(camPT.getX() - mediax);
                double distanceY = Math.abs(camPT.getY() - mediay);
                double distanceZ = Math.abs(camPT.getZ() - mediaz);

                double Distance =  Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2) + Math.pow(distanceZ, 2)) + (2*(f+1)) * 0.00002f;
                Random random = new Random();
                Keys_[f] = Distance +(random.nextFloat(0.0002f, 0.02f) * random.nextFloat(0.0002f, 0.02f))/random.nextFloat(0.0002f, 0.02f) * random.nextFloat(0.0002f, 0.02f);
                Result_[f] = RenderController.object2DS.get(z).getFaces2DS()[f];
                Clr_[f] = RenderController.object2DS.get(z).getColorRGBS()[f];
            }
            double[] Keys = new double[RenderController.object2DS.get(z).getColorRGBS().length];
            Polygon[] Result = new Polygon[RenderController.object2DS.get(z).getColorRGBS().length];
            Color[] Clr = new Color[RenderController.object2DS.get(z).getColorRGBS().length];
            for (int a = 0; a < Keys_.length; a++) {
                int index = 0;
                for (int vs = 0; vs < Keys_.length; vs++) {
                    if (Keys_[a] > Keys_[vs]) {
                        index++;
                    }
                    if(Keys_[a] == Keys_[vs] && !(a == vs)){
                        index++;
                        Random random = new Random();
                        Keys_[a] += (random.nextDouble(0.0000002f, 0.0002f) * random.nextDouble(0.0002,100));
                    }
                }
                Keys[index] = Keys_[a];
                Result[index] = Result_[a];
                Clr[index] = Clr_[a];
            }

            for (int c = 0; c < Keys.length; c++) {
                Random random = new Random();
                Color color = Clr[Keys.length-1-c];
                g2D.setColor(color);
                g2D.fillPolygon( Result[Keys.length-1-c]);
            }
            WindowController.frame++;

            Object3D object3D = BasicMovement.Rotation.Rotate(Start.Objects.get(z),Axies.X_Axie,1);
             object3D = BasicMovement.Rotation.Rotate(object3D,Axies.Y_Axie,1);
             object3D = BasicMovement.Rotation.Rotate(object3D,Axies.Z_Axie,1);
            Start.Objects.set(z,object3D);
        }
    }
}

