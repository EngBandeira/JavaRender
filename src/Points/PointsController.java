package Points;

import Basics.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PointsController {
    //Array ints = {3,7,2,4,8,5}
    // First = 3,7,2; Second = 4,8,5

    public PointsController() {
        int a = 0;
        for (File file : Start.RawObjects)
        {
            ArrayList<Point3D> points3DS = new ArrayList<>();
            ArrayList<Point2D> Tpoints = new ArrayList<>();
            ArrayList<Point3D> Npoints = new ArrayList<>();
            ArrayList<Face3D> faces3DS = new ArrayList<>();
            ArrayList<String> MaterialsNames = new ArrayList<>();
            HashMap<Face3D, String> FaceNameMaterials = new HashMap<>();
            HashMap<String, Material> Materials = new HashMap<>();

            String UltMaterialName = "";
            String name = "";
            try (BufferedReader brr = new BufferedReader(new FileReader(new File(file.getName().replaceFirst("obj", "mtl")))))
            {
                String line2;
                Material material = new Material(null,0,null,null,null,null,0,0,0,null,null,null,null);

                while ((line2 = brr.readLine()) != null)
                {
                    String nm ="";
                    if(line2.split(" ")[0].equals("newmtl")) {
                        material = new Material(null,0,null,null,null,null,0,0,0,null,null,null,null);
                        material.Name = line2.split(" ")[1];
                        MaterialsNames.add((line2.split(" ")[1]));
                        nm = (line2.split(" ")[1]);
                    }

                    switch (line2.split(" ")[0]){
                        case "Ns":

                            material.Ns = Float.parseFloat(line2.split(" ")[1]);
                            break;
                        case "Ka":
                            material.Ka = new Color(Float.parseFloat(line2.split(" ")[1]), Float.parseFloat(line2.split(" ")[2]),Float.parseFloat(line2.split(" ")[3]));
                            break;
                        case "Kd":
                            material.Kd = new Color(Float.parseFloat(line2.split(" ")[1]), Float.parseFloat(line2.split(" ")[2]),Float.parseFloat(line2.split(" ")[3]));
                            break;
                        case "Ks":
                            material.Ks = new Color(Float.parseFloat(line2.split(" ")[1]), Float.parseFloat(line2.split(" ")[2]),Float.parseFloat(line2.split(" ")[3]));
                            break;
                        case "Ke":
                            material.Ke = new Color(Float.parseFloat(line2.split(" ")[1]), Float.parseFloat(line2.split(" ")[2]),Float.parseFloat(line2.split(" ")[3]));
                            break;
                        case "Ni":
                            material.Ni = Float.parseFloat(line2.split(" ")[1]);
                            break;
                        case "map_Ka":
                            material.map_Ka  = new File(line2.split(" ")[1]);
                            break;
                        case "map_Kd":
                            material.map_Kd  = new File((line2.split(" ")[1]));
                            break;
                        case "map_Ks":
                            material.map_Ks  = new File((line2.split(" ")[1]));
                            break;
                        case "map_Bump":
                            material.map_Bump  = new File((line2.split(" ")[1]));
                            break;
                        case "illum":
                            material.Illum = Integer.parseInt(line2.split(" ")[1]);
                            break;

                    }
                    Materials.put(nm, material);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    switch (line.split(" ")[0]){
                        case "f":
                            String[] arrayssss = line.split(" ");
                            Point3D[] pts = new Point3D[arrayssss.length-1];
                            Point2D[] texturepts = new Point2D[arrayssss.length-1];
                            Point3D[] normalpts = new Point3D[arrayssss.length-1];
                            int[] ptsint = new int[arrayssss.length-1];
                            for(int i = 1; i< arrayssss.length; i++){
                                String[] arrays_ = arrayssss[i].split("/");
                                ptsint[i-1] = Integer.parseInt(arrays_[0]);
                                pts[i-1] = points3DS.get(Integer.parseInt(arrays_[0])-1);
                                texturepts[i-1] = Tpoints.get(Integer.parseInt(arrays_[1])-1);
                                normalpts[i-1] = Npoints.get(Integer.parseInt(arrays_[2])-1);
                            }
                            Face3D face3D =new Face3D(pts,texturepts,normalpts[0],ptsint,null);
                            faces3DS.add(face3D);
                            FaceNameMaterials.put(face3D, UltMaterialName);
                            break;
                        case "v" :
                            String[] arrays = line.split(" ");
                            points3DS.add(new Point3D(Float.parseFloat(arrays[1]),Float.parseFloat(arrays[2]), Float.parseFloat(arrays[3])));

                            break;
                        case "vn" :
                            String[] arrayss = line.split(" ");
                            Npoints.add(new Point3D(Float.parseFloat(arrayss[1]),Float.parseFloat(arrayss[2]), Float.parseFloat(arrayss[3])));
                            break;
                        case "vt" :
                            String[] arraysss = line.split(" ");
                            Tpoints.add(new Point2D(Float.parseFloat(arraysss[1]),Float.parseFloat(arraysss[2])));
                            break;
                        case "usemtl" :
                            UltMaterialName = line.split(" ")[1];

                            break;
                        case "o" :
                            name = line.split(" ")[1];
                            break;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }




            Point3D[] pts = new Point3D[points3DS.size()];
            Face3D[] fc = new Face3D[faces3DS.size()];
            a++;
            int i = 0;
            for(Point3D pt : points3DS){
                pts[i] = pt;
                i++;
            }
            i = 0;

            for(Face3D face3D : faces3DS){

                face3D.material  = Materials.get(FaceNameMaterials.get(face3D));
                fc[i] = face3D;
                i++;
            }
            Start.Objects.add(new Object3D("",pts , new Point3D(0,0,0),fc));
            Start.Iniciar();
        }
        for(Light.Integer light : Start.LightsINTs){
            System.out.println(light.getPoint()[0]  + " , " +light.getPoint()[1]  + " , " + light.getPoint()[2] );
            Start.Lights.add(new Light.Normal(new Point3D(light.getPoint()[0],light.getPoint()[1],light.getPoint()[2]),new Color(light.getColor()), light.getIntence()));
        }
    }
}
