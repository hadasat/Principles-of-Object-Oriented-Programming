public class Rational implements Numeric{

    int a;
    int b;

    public Rational(int a, int b){
        this.a=a;
        setB(b);
    }

    public int getA(){return  a;}

    public int getB(){return  b;}

    public void setA(int a){this.a = a;}

    public void setB(int b){
        if(b == 0){ //0 is illegal input
            throw new IllegalArgumentException("0 is illegal, please define the number again");
        }
        else 
            this.b=b;
    }
    
    public double getNumber(){
        return a/b;
    }

    public boolean equals(Numeric other){
        return (other.getNumber() == getNumber());
    }

    public String toString(){
        String output;
        if(getB() == 1) {
            output =  a +"";

        }else {
            output = (getA() + "/" + getB());
        }
        return output;
    }

    public Numeric transformAdd(Numeric n){
        if(n instanceof Rational){
            //if both of the numbers are Rational add like Rational number
            int nA = ((Rational)n).getA() * getB();
            int nB = ((Rational)n).getB() ;
            int currentA = getA() * nB;
            int newA = nA + currentA;
            int newB= getB() * nB;
            return new Rational(newA,newB);
        }
        return n.transformAdd(this);
    }

    public Numeric transformMul(Numeric n) {
        if (n instanceof Rational) {
            //if both of the numbers are Rational multiplied like Rational number
            int newA = ((Rational) n).getA() * getA();
            int newB = ((Rational) n).getB() * getB();
            return new Rational(newA, newB);
        }
        return n.transformMul(this);
    }




}
