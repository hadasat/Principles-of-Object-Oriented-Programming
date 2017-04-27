import java.util.Iterator;

public class SetAsLinkedList implements Set {
	
	// fields
	private List data;
	
	// constructors
	public SetAsLinkedList() {
		 data = new LinkedList();
	}
	public SetAsLinkedList(Set other) {
		this();
		Iterator myIterator = other.iterator();
		while(myIterator.hasNext())
			data.add(myIterator.next());
		/*for (Object element : other)
			data.add(element);*/
	}
	
	public int size(){
		return data.size();
	}
	
	public boolean add(Object element){
		if(!contains(element)){
			data.add(element);
			return true;
		}
		return false;
	}
	
	public boolean contains(Object element){ 
		return data.contains(element);
	} 
	
	public boolean remove(Object element){
		return data.remove(element);
	}
	
	public boolean isEmpty(){ 
		return data.isEmpty();
	}
	
	public Iterator iterator(){
		return data.iterator();
	}
	
	public boolean equals(Object other) {
    	
    	if (!(other instanceof Set)) 
		return false;

    	Set otherSet = (Set) other;
    	if (size() != otherSet.size())
    		return false;

    	for(Object element : otherSet)
    		if (!contains(element))
    			return false;

    	return true;	
	}
	@Override
	public Set insert(Element e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean contains(Set s) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Set remove(Element e) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set union(Set s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set intersect(Set s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set power() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean member(Element e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deepExistence(Element e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Set transformAdd(Numeric n) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set transformMul(Numeric n) {
		// TODO Auto-generated method stub
		return null;
	}


}