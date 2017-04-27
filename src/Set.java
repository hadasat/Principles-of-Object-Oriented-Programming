import java.lang.Iterable;

public interface Set extends Iterable{
	
	// Returns the number of elements in this set (its cardinality).
	public int  size();
	
	// Adds the specified element to this set if it is not already present.
	public Set insert(Element e);
	
	// Returns true if this set contains the specified element.
	public boolean contains(Set s); 
	
	// Removes the specified element from this set if it is present
	public Set remove(Element e);
		
	public Set union(Set s);
	
	public Set intersect(Set s);
	
	public Set power();

	public boolean member(Element e);
	
	public boolean deepExistence(Element e);
	
	public Set transformAdd(Numeric n);
	
	public Set transformMul(Numeric n);
}
