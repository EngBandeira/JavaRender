package Basics;

import java.awt.*;
import java.io.File;

public class Material {
    public String Name;
    public float Ns;
    public Color Ka;
    public Color Kd;
    public Color Ks;
    public Color Ke;
    public float Ni;
    public float D;
    public float Illum;
    public File map_Bump;
    public File map_Kd;
    public File map_Ka;
    public File map_Ks;

    public Material(String Name_, float Ns_, Color Ka_, Color Kd_, Color Ks_, Color Ke_, float Ni_, float D_, float Ilum_, File map_Bump_, File map_Kd_, File map_Ka_, File map_Ks_)
    {
       Name = Name_;
       Ns = Ns_;
       Ka = Ka_;
       Kd = Kd_;
       Ks = Ks_;
       Ke = Ke_;
       Ni = Ni_;
       D = D_;
       Illum = Ilum_;
       map_Bump = map_Bump_;
       map_Kd = map_Kd_;
       map_Ka = map_Ka_;
       map_Ks = map_Ks_;
    }

    public String getName(){
        return Name;
    }
    public float getNs(){
        return Ns;
    }
    public Color getKa(){
        return Ka;
    }
    public Color getKd(){
        return Kd;
    }
    public Color getKs(){
        return Ks;
    }
    public Color getKe(){
        return Ke;
    }
    public float getNi(){
        return Ni;
    }
    public float getD(){
        return D;
    }
    public float getIllum(){
        return Illum;
    }
    public File getMap_Bump(){
        return map_Bump;
    }
    public File getMap_Kd(){
        return map_Kd;
    }
    public File getMap_Ka(){
        return map_Ka;
    }
    public File getMap_Ks(){
        return map_Ks;
    }

}
