import java.lang.Math;

public class Rational extends Numeric{

    int a;
    int b;

    public Rational(double x){
        a =(int) Math.abs(x);
    }

}
