
public interface Numeric extends Element{

	public double getNumber();

	public Numeric transformAdd(Numeric n);

	public Numeric transformMul(Numeric n);

	public boolean equals(Numeric other);

	public String toString();

}
