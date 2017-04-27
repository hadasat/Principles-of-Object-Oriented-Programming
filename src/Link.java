
public class Link {
	
	private Object data; // represents the data of the link
	private Link next; // points to the next link
	
	public Link(Object data, Link next){
		this.data = data;
		this.next = next;
	}
	
	public Link(Object data){
		this(data, null);
	}
	
	// returns link's data 
	public Object getData(){
		return data;
	}
	
	// returns a pointer to the next link
	public Link getNext(){
		return next; 
	}
	
	// sets the pointer next to the given link
	public void setNext(Link next){
		this.next = next;
	}
	
	// sets the data to the given data and returns the old data
	public Object setData(Object data){
		Object tmp = this.data;
		this.data = data; 
		return tmp;
	}
	
	public String toString(){ 
		return data.toString();
	}
	
	// returns true if the link's data equals to other's data
	// either other is not a link or both values of data are not equal- returns false
	public boolean equals(Object other) {  
		if (other == null)
			return false;
		if (other instanceof Link)
			if (this.data.equals(((Link) other).data))
				return true;
		return false;
	}
}
