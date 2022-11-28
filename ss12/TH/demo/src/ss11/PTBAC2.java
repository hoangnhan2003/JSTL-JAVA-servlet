package demo.src.ss11;

public class PTBAC2 {
    public static float getDelta(int a,int b,int c){
        return (b*b) - 4*a*c;
    }
    public static float[] getResult(int a,int b,int c){
        float []result = new float[2];
        result[0] = (float) ((-b + Math.sqrt(getDelta(a,b,c)))/(2*a));
        result[1] = (float) ((-b - Math.sqrt(getDelta(a,b,c)))/(2*a));
        return  result;
    }
}
