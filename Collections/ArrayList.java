import java.util.Iterator;

public class ArrayList<T> implements List<T>{
    private int capacity=0;
    private int size=0;
    private Object[] arr;
    private void arrayExtension(){
        this.capacity*=2;
        Object[] newArr=new Object[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr=newArr;
    }
    public ArrayList() {
        this.capacity=100;
         arr=new Object[capacity];
    }
    public ArrayList(int capacity) {
        this.capacity=capacity;
        arr=new Object[capacity];
    }

    @Override
    public boolean add(T elem) {
        if (!(size < capacity * 0.8)) {
            arrayExtension();
        }
        arr[size]=elem;
        size++;
        return  true;
    }

    @Override
    public boolean contains(T elem) {
        for(Object el : arr){
            if (el==elem)return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collections<T> c) {
        for(T elem:c) add(elem);
        return true;
    }

    @Override
    public boolean remove(T elem) {
        for(int i=0;i<size;i++){
            if(arr[i]==elem){
                for(int j=i;j<size-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[size-1]=Integer.MIN_VALUE;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
     for (int i=0;i<size;i++)arr[i]=Integer.MIN_VALUE;
     size=0;
    }

    @Override
    public Iterator<T> iterator() {
Iterator<T> it=new Iterator<T>() {
    int i=0;
    @Override
    public boolean hasNext() {
        return i<size;
    }

    @Override
    public T next() {
        return (T)arr[i++];
    }
};
       return it;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr=new Object[capacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        return newArr;
    }

    @Override
    public T get(int index) {
        if (index>size) return null;
        return (T)arr[index-1];
    }

    @Override
    public void add(int index, T elem) {
        if (!(size < capacity * 0.8)) {
            arrayExtension();
        }
        for (int i=size;i>index-1;i--){
            arr[i]=arr[i-1];
        }
        arr[index]=elem;

        size++;
    }

    @Override
    public T remove(int index) {
        if (index-1>size) return null;
        T elem= (T) arr[index-1];
        for(int j=index-1;j<size-1;j++){
            arr[j]=arr[j+1];
        }
        arr[size]=Integer.MIN_VALUE;
        size--;
        return elem;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<size;i++){
            str.append(arr[i].toString());
            str.append(' ');
        }
        return str.toString();
    }
}
