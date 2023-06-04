
import java.util.Iterator;

public interface Collections<T> extends Iterable<T> {
    public boolean add(T elem);
    public boolean contains(T elem);
    public boolean addAll(Collections<T> c);
    public boolean remove(T elem);
    public void clear();
    public Iterator<T> iterator();
    public int size();
    public boolean isEmpty();
    Object[] toArray();
}
