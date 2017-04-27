public interface List extends Iterable {
   	public int size();
	public boolean isEmpty();
	public boolean contains(Object element);
	public Object set(int index, Object element);
	public Object get(int index);
	public void add(Object element);
	public void add(int index, Object element);
	public boolean remove(Object element);
}