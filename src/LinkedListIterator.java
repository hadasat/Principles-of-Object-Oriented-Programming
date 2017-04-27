import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator implements Iterator {

private Link nextLink ;
	
	public LinkedListIterator(Link start) {
		nextLink = start ;
	}

	@Override
	public boolean hasNext() {
		return nextLink != null ;
	}

	// returns current link's data and move it's pointer to the next link if it exists
	@Override
	public Object next() {
		if(!hasNext())
			throw new NoSuchElementException();
		Object nextElement = nextLink.getData() ;
		nextLink = nextLink.getNext() ;
		return nextElement ;
	}
	
	@Override
	public void remove(){
		throw new UnsupportedOperationException();
	}
}