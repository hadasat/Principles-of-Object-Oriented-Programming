
public class Numeric implements Element{

	private int number;

	public Numeric(int x){
		number = x;
	}

	public int getNumber(){
		return number;
	}

	public void setNumber(int x){
		number = x;
	}

	public Numeric transformAdd(Numeric n)
	{
		int x = n.getNumber()+ getNumber();
		Numeric output = new Numeric(x);
		  return output;

	}
	
	public Numeric transformMul(Numeric n){
		int x = n.getNumber() * getNumber();
		Numeric output = new Numeric(x);
		return output;
	}
}
