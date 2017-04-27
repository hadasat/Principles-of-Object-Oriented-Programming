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

	public Set insert(Element e) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(Set s) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set remove(Element e) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set union(Set s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set intersect(Set s) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set power() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean member(Element e) {
		return data.contains(e);
	}

	public boolean deepExistence(Element e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Set transformAdd(Numeric n) {
		Iterator iterator = data.iterator();
		while(iterator.hasNext()) {
		Element element = (Element) iterator.next();
		element.transformAdd(n);
	}
		return this;
}
	public Set transformMul(Numeric n) {
		Iterator iterator = data.iterator();
		while(iterator.hasNext()) {
			Element element = (Element) iterator.next();
			element.transformMul(n);
		}
		return this;
	}

	public String toString(){
		String output = "{";
		Iterator iterator =this.iterator();
		while (iterator.hasNext()){
			output = output+iterator.next().toString() + " , ";
		}
		output = output + "}";
		return output;
	}


}