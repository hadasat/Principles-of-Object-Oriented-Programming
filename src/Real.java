
public class Real implements Numeric{

    private double number;

    public Real(double x){
        number = x;
    }

    public double getNumber(){
        return number;
    }

    public void setNumber(double x){
        number = x;
    }
    public Numeric transformAdd(Numeric n){
        double x = n.getNumber() + getNumber();
        return new Real(x);
    }

    public Numeric transformMul(Numeric n){
        double x = n.getNumber() * getNumber();
        return new Real(x);
    }


}
