import java.util.Comparator;
import java.util.Iterator;

public class LinkedList implements List {

	private Link first;	// points to the first link
	private Link last; // points to the last link

	public LinkedList(){
		first = null;
		last = null;
	}

	// sorts the linked list according to comp's terms using Bubble Sort method
	public void sortBy(Comparator comp){
		nullCheck(comp);
		if (first != null){
			Link curLink = first; 
			while (curLink.getNext() != null){ // goes throw all of the links on this linked list
				Link secLink = curLink;
				while (secLink.getNext() != null){ // goes throw all of the links from curLink to the end if the linked list
					// checks if the data of the current link is "greater" the its next's data
					// if it does- datas will be swapped
					if (comp.compare(secLink.getData(), secLink.getNext().getData()) > 0){  
						Object tmp = secLink.getData();
						secLink.setData(secLink.getNext().getData());
						secLink.getNext().setData(tmp);
					}
					secLink = secLink.getNext();
				}
				curLink = curLink.getNext();
			}
		}
	}

	// return String represents list's data in form <'link1', 'link2'...>
	public String toString() {
		Link cur = first; // points to the current link
		String output = "<"; // sums all datas information
		Object tmpData = null; // points temporarily on the current link's data
		if (cur != null){
			tmpData = cur.getData();
			if (tmpData != null)
				output += cur.getData();
			cur = cur.getNext();
		}
		// goes throw all the links and adds their data to the outpur string
		while (cur != null){
			tmpData = cur.getData();
			if (tmpData != null)
				output += ", " + cur.getData();
			cur = cur.getNext();
		}
		output += ">";
		return output;
	}

	// return true if the list equals by its data to linked list other and in the same order
	// either it's not, other is not linked list or both list's size are different- returns false
	public boolean equals(Object other) {  
		nullCheck(other);
		if (!(other instanceof LinkedList) | ! (size() == ((LinkedList)other).size()))
			return false;
		Link curThis = first; // represents list's current link
		Link curOther = ((LinkedList)other).first; // represents other's current link
		while (curThis != null){
			if (!(curThis.getData().equals(curOther.getData())))
					return false;
			curThis = curThis.getNext();
			curOther = curOther.getNext();
		}
		return true;
	}

	// adds element to the list at place index if it's legal
	public void add(int index, Object element) {
		rangeCheck(index);
		nullCheck(element);
		if(index == 0) {
			first = new Link(element, first) ;
			if(last == null)
				last = first ;
		} 
		else {
			Link prev = null ;
			Link curr = first ;
			for(int i=0; i < index; i++) {
				prev = curr;
				curr = curr.getNext();
			}
			Link toAdd = new Link(element, curr);
			prev.setNext(toAdd);
			if(index == size())
				last = toAdd;
		}
	}

	// adds element to the list
	public void add(Object element) {
		nullCheck(element);
		if(isEmpty()){
			first = new Link(element);
			last = first;
		}
		else {
			Link newLast = new Link(element);
			last.setNext(newLast);
			last = newLast;
		}
	}

	// returns the size of the list by counting the number of links in it
	@Override
	public int size() {
		Link cur = first;
		int size = 0;
		while (cur != null){
			cur = cur.getNext();
			size++;
		}
		return size;
	}

	// returns true of element equals to the data of one of the links on the list
	// either it's not or element is null- returns false
	@Override
	public boolean contains(Object element) {
		if (element == null)
			return false;
		Link cur = first; // represents the current link
		while (cur != null){ // goes throw all the links on the list
			if (cur.getData().equals(element))
				return true;
			cur = cur.getNext();
		}
		return false;
	}

	// returns true if there are no links on the list, otherwise returns false
	@Override
	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}

	// returns the data of link placed on index "index", if "index" is on the range of 0-list's size 
	@Override
	public Object get(int index) {
		rangeCheck(index);
		Link cur = first;
		while (--index >= 0)
			cur = cur.getNext();
		return cur.getData();
	}

	// sets link at place "index"'s data to element and returns the old data 
	@Override
	public Object set(int index, Object element) {
		rangeCheck(index);
		nullCheck(element);
		Link curLink = getLink(index);
		Object obj = curLink.getData();
		curLink.setData(element);
		return obj;
	}

	public Iterator iterator() {
		return new LinkedListIterator(first);
	}

	// throws an exception if the given index is not in range
	private void rangeCheck(int index) {
		if(index < 0 || index >= size())
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
	}
		
	// throws an exception if the given element is null
	private void nullCheck(Object element){
		if (element == null)
			throw new NullPointerException();
	}
	
	// returns link number "index" 
	private Link getLink(int index) {
		rangeCheck(index);
		Link cur = first;
		while (--index >= 0)
			cur = cur.getNext();
		return cur;
	}

	@Override
	public boolean remove(Object element) {
		// TODO Auto-generated method stub
		return false;
	}
}
