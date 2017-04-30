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
	
	public Iterator iterator(){
		return data.iterator();
	}
	
	public boolean equals(Object other) {
    	if (!(other instanceof Set)) 
    		return false;
    	
    	Set otherSet = (Set) other;
    	if (size() != otherSet.size())
    		return false;

    	for(Object obj : otherSet)
    		if (!member((Element)obj))
    			return false;
    	return true;	
	}
	
	@Override
	public Set insert(Element e) {
		if (!member(e))
			data.add(e);
		return this;
	}

	@Override
	public boolean contains(Set s) {
		for (Object obj : s)
			if (!member((Element)obj))
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
		for(Object obj : this)
			if (!output.member((Element)(obj)))
					output.insert((Element)obj);
		return output;
	}
	
	@Override
	public Set intersect(Set s) {
		Set output = new SetAsLinkedList();
		for(Object obj: data)
			if(s.member((Element)obj))
				output.insert((Element)obj);
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

	public boolean member(Element e) {
		return data.contains(e);
	}

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