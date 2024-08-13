import java.util.List;
import java.util.ArrayList;

public class LinkedListDeque61B<T> implements Deque61B<T>{

    public class Node{
        public T data;
        public Node pre;
        public Node next;

        public Node(T x, Node y,Node z){
               data=x;
               pre=y;
               next=z;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel=new Node(null,null,null);
        size=0;
    }

    @Override
    public void addFirst(T x) {
        if(x==null)
            return;

        if(sentinel.next==null){
            Node p=new Node(x,sentinel,sentinel);

            sentinel.next=p;
            sentinel.pre=p;
        }else{
            Node p=new Node(x,sentinel,sentinel.next);

            sentinel.next=p;
            sentinel.next.next.pre=p;
        }

        size++;
    }

    @Override
    public void addLast(T x) {
        if(x==null)
            return;

        if(sentinel.pre==null){
            Node p=new Node(x,sentinel,sentinel);

            sentinel.next=p;
            sentinel.pre=p;
        }else{
            Node p=new Node(x,sentinel.pre,sentinel);

            sentinel.pre=p;
            sentinel.pre.pre.next=p;
        }

        size++;
    }

    @Override
    public List<T> toList() {
        Node p=sentinel.next;

        if(p==null)
            return null;

        List<T> returnList=new ArrayList<>();

        do{
            returnList.add(p.data);
            p=p.next;
        }while(p!=sentinel);

        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == null || sentinel.pre == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(sentinel.next==null)
            return null;

        T returnValue=sentinel.next.data;

        sentinel.next=sentinel.next.next;
        sentinel.next.pre=sentinel;

        size--;

        return returnValue;
    }

    @Override
    public T removeLast() {
        if(sentinel.pre==null)
            return null;

        T returnValue=sentinel.pre.data;

        sentinel.pre=sentinel.pre.pre;
        sentinel.pre.next=sentinel;

        size--;

        return returnValue;
    }

    @Override
    public T get(int index) {
        if(index<0||index>=size)
            return null;

        Node p=sentinel.next;
        int i;

        for(i=0;i<index;i++)
            p=p.next;

        return p.data;
    }

    @Override
    public T getRecursive(int index) {
        if(index<0||index>=size)
            return null;

        return getRecursiveHelper(sentinel.next,index);
    }

    private T getRecursiveHelper(Node startNode,int index){
        T result;

        if(index!=0){
            result=getRecursiveHelper(startNode.next,index-1);
        }else{
            result=startNode.data;
        }

        return result;
    }
}
