import java.lang.Math;

public class Rational implements Numeric{

    int a;
    int b;

    public Rational(int a, int b){
        this.a=a;
        this.b=b;
    }
    
    public double getNumber(){
        return a/b;
    }

    public Numeric transformAdd(Numeric n){
        double x = n.getNumber() + getNumber();

        return new Rational();
    }

    public Numeric transformMul(Numeric n){}




}
