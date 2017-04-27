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
		if(!contains(e))
			data.add(e);
		return this;
	}

	@Override
	public boolean contains(Set s) {
		for (Object obj : s)
			if(!data.contains(obj))
				return false;
		return true;
	}
	
	@Override
	public Set remove(Element e) {
		data.remove(e);
		return this;
	}
	
	@Override
	public Set union(Set s) {
		Set output = new SetAsLinkedList(s);
		for(Object obj : data)
			output.insert((Element)obj);
		return output;
	}
	
	@Override
	public Set intersect(Set s) {
		Set output = new SetAsLinkedList();
		for(Object e: data)
			if(s.member((Element)e))
				output.insert((Element)e);
		return output;
	}
	
	@Override
	public Set power() {
		return power(new SetAsLinkedList(this));
	}
	
	// aid method
	public Set power(Set s) {
		Set output = new SetAsLinkedList();
		if (s.size() == 0)
			return output;
		output.insert(s);
		output.insert(power(s.remove((Element)data.get(0))));
		return output;
	}
	
	@Override
	public boolean member(Element e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deepExistence(Element e) {
		Iterator iterator = this.iterator();
		while (iterator.hasNext()){
			Element element =(Element)iterator.next();
			if(element instanceof Set)
				if(deepExistence(e))
					return true;
			if(element.equals(e))
				return true;
		}
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