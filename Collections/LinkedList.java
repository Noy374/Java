import java.util.Iterator;

public class LinkedList<T> implements List<T>{
    private LinkedListNode<T> head=null;
    private LinkedListNode<T> tail=null;
    private int size;
    private class LinkedListNode<T>{
        public LinkedListNode<T> next=null;
        public LinkedListNode<T> prev=null;
        public T info=null;
    }
    public LinkedList(){
        head=new LinkedListNode<>();
        tail=null;
    }
    @Override
    public boolean add(T elem) {
        if(tail==null) {
            head.info=elem;
            tail=head;
        }else{
            LinkedListNode<T>ptr=new LinkedListNode<>();
            ptr.info=elem;
            ptr.prev=tail;
            tail.next=ptr;
            tail=ptr;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(T elem) {
        LinkedListNode<T> ptr=head;
        while(ptr!=null ){
            if(ptr.info==elem)return true;
            ptr=ptr.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collections<T> c) {
        return false;
    }

    @Override
    public boolean remove(T elem) {
        LinkedListNode<T> ptr=head;
        while(ptr!=null ){
            if(ptr.info==elem) {
                if(ptr!=head && ptr!=tail){
                    LinkedListNode<T> tempPtr=ptr.next;
                    ptr.next.prev=ptr.prev;
                    ptr.prev.next=tempPtr;
                }else{
                    if(ptr==head){
                        head=head.next;
                        head.prev=null;
                    }else{
                        tail=tail.prev;
                        tail.next=null;
                    }
                }
                size--;
                return true;
            }
            ptr=ptr.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head=new LinkedListNode<>();
        tail=null;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it=new Iterator<T>() {
            LinkedListNode<T> ptr=head;

            @Override
            public boolean hasNext() {
                return ptr!=null;
            }

            @Override
            public T next() {
                T info=ptr.info;
                ptr=ptr.next;
                return info;
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
        return head.info==null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr=new Object[size];
        LinkedListNode<T> ptr=head;
        int i=0;
        while(ptr!=null ){
       arr[i++]=ptr.info;
            ptr=ptr.next;
        }
        return  arr;
    }

    @Override
    public T get(int index) {
        if(index-1>size)return null;
        LinkedListNode<T> ptr=head;
        for (int i=0;i<index-1;i++)ptr=ptr.next;

        return ptr.info;
    }

    @Override
    public void add(int index, T elem) {
        if(index-1<size) {
            LinkedListNode<T> ptr = head;
            for (int i = 0; i < index - 2; i++) ptr = ptr.next;
            LinkedListNode<T>tmp=ptr.next;
            ptr.next=new LinkedListNode<>();
            ptr.next.info=elem;
            ptr.next.prev=ptr;
            ptr.next.next=tmp;
            tmp.prev=ptr.next;
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public String toString() {
        LinkedListNode<T> ptr=head;
        StringBuilder str=new StringBuilder();
        while(ptr!=null ){
            str.append(ptr.info.toString()).append(" ");
            ptr=ptr.next;
        }
        return str.toString();
    }
}
