package Basics;

public class ColorRGBA {
    public float R;
    public float G;
    public float B;
    public float A;

    public ColorRGBA(float R_, float G_, float B_, float A_){
        R = R_;
        G = G_;
        B = B_;
        A = A_;
    }
    public float getR(){return  R;}
    public float getG(){return  G;}
    public float getB(){return  B;}
    public float getA(){return  A;}


    public static ColorRGBA ColorMultiply(boolean Multiply, ColorRGBA c1, ColorRGBA c2){
        if(Multiply){
            return new ColorRGBA(c1.getR() * c2.getR(), c1.getG() * c2.getG(), c1.getB() * c2.getB(), c1.getA() * c2.getA());
        }
        else {
            return new ColorRGBA(c2.getR() / c1.getR(), c2.getG() / c1.getG(), c2.getB() / c1.getB(), c2.getA()/ c1.getA());
        }
    }
    public static ColorRGBA ColorSum(boolean Sum, ColorRGBA c1, ColorRGBA c2){
        if(Sum){
            return new ColorRGBA(c1.getR() + c2.getR(), c1.getG() + c2.getG(), c1.getB() + c2.getB(), c1.getA() + c2.getA());
        }
        else {
            return new ColorRGBA(c2.getR() - c1.getR(), c2.getG() - c1.getG(), c2.getB() - c1.getB(), c2.getA() -c1.getA());
        }
    }
}
