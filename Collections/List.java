public interface List<T> extends Collections<T>{
    public T get(int index);
    public void add(int index, T elem);
    public T remove(int index);
}
